package net.mrscauthd.boss_tools.machines.machinetileentities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

import net.minecraft.block.BlockState;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public abstract class AbstractMachineTileEntity extends LockableLootTileEntity implements ISidedInventory, ITickableTileEntity {

	public static final String KEY_ACTIVATED = "activated";

	private PowerSystem powerSystem = null;
	private final LazyOptional<? extends IItemHandler>[] handlers;
	private NonNullList<ItemStack> stacks = null;

	private boolean processedInThisTick = false;

	public AbstractMachineTileEntity(TileEntityType<?> type) {
		super(type);

		this.powerSystem = this.createPowerSystem();
		this.handlers = SidedInvWrapper.create(this, Direction.values());
		this.stacks = NonNullList.<ItemStack>withSize(this.getInitialInventorySize(), ItemStack.EMPTY);
	}

	protected abstract int getInitialInventorySize();

	public int getPowerPerTick() {
		return this.getPowerSystem().getBasePowerPerTick();
	}

	public int getPowerForOperation() {
		return this.getPowerSystem().getBasePowerForOperation();
	}

	public boolean isPowerEnoughForOperation() {
		return this.getPowerSystem().getStored() >= this.getPowerPerTick() + this.getPowerForOperation();
	}

	@Override
	public void read(BlockState blockState, CompoundNBT compound) {
		super.read(blockState, compound);
		if (!this.checkLootAndRead(compound)) {
			this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		}
		ItemStackHelper.loadAllItems(compound, this.stacks);
		this.getPowerSystem().read(compound.getCompound("powerSystem"));
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.stacks);
		}
		compound.put("powerSystem", this.getPowerSystem().write());
		return compound;
	}

	@Override
	public int getSizeInventory() {
		return stacks.size();
	}

	@Override
	public boolean isEmpty() {
		return this.getItems().stream().allMatch(ItemStack::isEmpty);
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	protected void getSlotsForFace(Direction direction, List<Integer> slots) {
		this.getPowerSystem().getSlotsForFace(direction, slots);
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		List<Integer> slots = new ArrayList<>();
		this.getSlotsForFace(side, slots);
		return Ints.toArray(slots);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack stack, @Nullable Direction direction) {
		if (this.getPowerSystem().canInsertItem(direction, index, stack)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
		if (this.getPowerSystem().canExtractItem(direction, index, stack)) {
			return true;
		}
		return false;
	}

	public <T> LazyOptional<T> getCapabilityItemHandler(Capability<T> capability, @Nullable Direction facing) {

		if (facing != null) {
			return this.handlers[facing.ordinal()].cast();
		} else {
			return super.getCapability(capability, facing);
		}

	}

	public <T> LazyOptional<T> getCapabilityEnergy(Capability<T> capability, @Nullable Direction facing) {
		PowerSystem powerSystem = this.getPowerSystem();

		if (powerSystem instanceof PowerSystemEnergy) {
			PowerSystemEnergy powerSystemEnergy = (PowerSystemEnergy) powerSystem;

			if (powerSystemEnergy.canProvideCapability()) {
				IEnergyStorage energyStorage = powerSystemEnergy.getEnergyStorage();

				if (energyStorage != null) {
					return LazyOptional.of(() -> energyStorage).cast();
				}

			}

		}

		return null;
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {

		if (!this.removed) {
			if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				LazyOptional<T> optional = this.getCapabilityItemHandler(capability, facing);
				if (optional != null) {
					return optional;
				}
			} else if (capability == CapabilityEnergy.ENERGY) {
				LazyOptional<T> optional = this.getCapabilityEnergy(capability, facing);
				if (optional != null) {
					return optional;
				}
			}
		}

		return super.getCapability(capability, facing);
	}

	@Override
	public void remove() {
		super.remove();
		Arrays.stream(this.handlers).forEach(h -> h.invalidate());
	}

	@Override
	public void tick() {
		World world = this.getWorld();

		if (world.isRemote()) {
			return;
		}

		this.onTickProcessingPre();
		this.tickProcessing();
		this.onTickProcessingPost();

		this.updatePowerSystem();

		this.updateActivated();
		this.refreshBlockActivatedChanged();
	}

	protected void updatePowerSystem() {
		int eft = this.getPowerPerTick();
		PowerSystem powerSystem = this.getPowerSystem();

		if (eft > 0) {
			powerSystem.consume(eft);

			if (!this.isPowerEnoughForOperation()) {
				powerSystem.feed(true);
			}

		}

	}

	protected BooleanProperty getBlockActivatedProperty() {
		return BlockStateProperties.LIT;
	}

	protected void refreshBlockActivatedChanged() {
		BooleanProperty property = this.getBlockActivatedProperty();

		if (property == null) {
			return;
		}

		World world = this.getWorld();
		BlockPos pos = this.getPos();
		BlockState state = this.getBlockState();
		boolean activated = this.isActivated();

		if (state.get(property).booleanValue() != activated) {
			world.setBlockState(pos, state.with(property, activated), 3);
		}
	}

	protected void onTickProcessingPre() {
		this.processedInThisTick = false;
	}

	protected abstract void tickProcessing();

	protected void onTickProcessingPost() {

	}

	public boolean updateActivated() {
		this.setActivated(this.canActivated());
		return true;
	}

	protected boolean canActivated() {
		if (this.getPowerSystem() instanceof PowerSystemFuel) {
			return this.isPowerEnoughForOperation();
		} else {
			return this.processedInThisTick;
		}

	}

	protected abstract PowerSystem createPowerSystem();

	public final PowerSystem getPowerSystem() {
		return this.powerSystem;
	}

	public IItemHandlerModifiable getItemHandler() {
		return (IItemHandlerModifiable) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).resolve().get();
	}

	public boolean isActivated() {
		return this.getTileData().getBoolean(KEY_ACTIVATED);
	}

	public void setActivated(boolean activated) {
		if (this.isActivated() != activated) {
			this.getTileData().putBoolean(KEY_ACTIVATED, activated);
			this.markDirty();
		}
	}

	@Override
	public void markDirty() {
		super.markDirty();

		World world = this.getWorld();
		if (world instanceof ServerWorld) {
			ServerWorld serverWorld = (ServerWorld) world;
			serverWorld.getChunkProvider().markBlockChanged(this.getPos());
		}
	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.pos, 0, this.getUpdateTag());
	}

	@Override
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.read(this.getBlockState(), pkt.getNbtCompound());
	}

	protected boolean isProcessedInThisTick() {
		return processedInThisTick;
	}

	protected void setProcessedInThisTick() {
		this.processedInThisTick = true;
	}

	public abstract boolean isIngredientReady();

}
