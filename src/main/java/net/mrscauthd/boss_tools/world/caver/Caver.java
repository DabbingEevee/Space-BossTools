package net.mrscauthd.boss_tools.world.caver;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.boss_tools.block.*;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.block.Block;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

@Mod.EventBusSubscriber(modid = "boss_tools", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Caver {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(() -> {
			try {
				//WorldCarver.CAVE
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CAVE, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CAVE, "field_222718_j"))
						//Moon
						.add(MoonStoneBlock.block.getDefaultState().getBlock())
						//Mars
						.add(MarsStoneBlock.block.getDefaultState().getBlock())
						//Mercury
						.add(MercurystoneBlock.block.getDefaultState().getBlock())
						//Venus
						.add(VenusStoneBlock.block.getDefaultState().getBlock()).build(), "field_222718_j");
				//WorldCarver.CANYON
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CANYON, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CANYON, "field_222718_j"))
						//Moon
						.add(MoonStoneBlock.block.getDefaultState().getBlock())
						//Mars
						.add(MarsStoneBlock.block.getDefaultState().getBlock())
						//Mercury
						.add(MercurystoneBlock.block.getDefaultState().getBlock())
						//venus
						.add(VenusStoneBlock.block.getDefaultState().getBlock()).build(), "field_222718_j");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
