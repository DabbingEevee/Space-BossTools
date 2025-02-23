package net.mrscauthd.boss_tools.entity.renderer;

import net.mrscauthd.boss_tools.entity.RocketTier1Entity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RocketTier1Renderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RocketTier1Entity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelRocketTier1(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("boss_tools:textures/rockettier1newnew.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.3
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class ModelRocketTier1 extends EntityModel<Entity> {
		private final ModelRenderer Rocket;

		public ModelRocketTier1() {
			textureWidth = 512;
			textureHeight = 256;
			Rocket = new ModelRenderer(this);
			Rocket.setRotationPoint(0.0F, 23.0F, 0.0F);
			Rocket.setTextureOffset(43, 17).addBox(14.0F, -8.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -8.0F, -15.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-15.0F, -8.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -8.0F, 14.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(273, 90).addBox(4.0F, -31.0F, -8.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(273, 90).addBox(-7.0F, -31.0F, -8.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(85, 46).addBox(3.0F, -31.0F, -8.1F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(86, 47).addBox(-4.0F, -31.0F, -8.1F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(87, 52).addBox(-3.0F, -31.0F, -8.1F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(89, 52).addBox(-3.0F, -25.0F, -8.1F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(274, 82).addBox(-7.0F, -39.0F, -8.0F, 14.0F, 8.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(276, 135).addBox(-7.0F, -24.0F, -8.0F, 14.0F, 19.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(279, 120).addBox(-7.0F, -39.0F, 7.0F, 14.0F, 34.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(276, 107).addBox(-8.0F, -39.0F, -7.0F, 1.0F, 34.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(307, 78).addBox(-8.0F, -40.0F, -8.0F, 1.0F, 35.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(307, 78).addBox(-8.0F, -40.0F, 7.0F, 1.0F, 35.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(37, 23).addBox(-7.0F, -40.0F, 7.0F, 14.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(37, 23).addBox(-7.0F, -40.0F, -8.0F, 14.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(29, 17).addBox(-8.0F, -40.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(29, 17).addBox(7.0F, -40.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(307, 78).addBox(7.0F, -40.0F, 7.0F, 1.0F, 35.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(307, 78).addBox(7.0F, -37.0F, -8.0F, 1.0F, 32.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(307, 78).addBox(7.0F, -40.0F, -8.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(12.0F, -10.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(13.0F, -10.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -10.0F, -13.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -10.0F, -14.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-14.0F, -10.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-13.0F, -10.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -10.0F, 13.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -10.0F, 12.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(10.0F, -12.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(11.0F, -12.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -12.0F, -11.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -12.0F, -12.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-12.0F, -12.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-11.0F, -12.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -12.0F, 10.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -12.0F, 11.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(15.0F, -8.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -8.0F, -16.0F, 2.0F, 8.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-16.0F, -8.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -8.0F, 15.0F, 2.0F, 8.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(16.0F, -13.0F, -1.0F, 1.0F, 15.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -13.0F, -17.0F, 2.0F, 15.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-17.0F, -13.0F, -1.0F, 1.0F, 15.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -13.0F, 16.0F, 2.0F, 15.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(8.0F, -13.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(9.0F, -13.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -13.0F, -9.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -13.0F, -10.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-9.0F, -13.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-10.0F, -13.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -13.0F, 9.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -13.0F, 8.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(277, 106).addBox(7.0F, -39.0F, -7.0F, 1.0F, 34.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(33, 87).addBox(4.0F, -41.0F, -7.0F, 2.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(33, 87).addBox(6.0F, -41.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
			Rocket.setTextureOffset(33, 87).addBox(-7.0F, -41.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-7.0F, -41.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(6.0F, -41.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(5.0F, -42.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(5.0F, -43.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(4.0F, -45.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(4.0F, -44.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(4.0F, -45.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(4.0F, -44.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-5.0F, -45.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-4.0F, -47.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-3.0F, -49.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-3.0F, -48.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(2.0F, -49.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(2.0F, -48.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-3.0F, -49.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-2.0F, -50.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-2.0F, -51.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-2.0F, -50.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-2.0F, -51.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(1.0F, -50.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(1.0F, -51.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(1.0F, -50.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(1.0F, -51.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-3.0F, -48.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(2.0F, -49.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(2.0F, -48.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-4.0F, -46.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-4.0F, -47.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-4.0F, -46.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(3.0F, -47.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(3.0F, -46.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(3.0F, -47.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(3.0F, -46.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-5.0F, -44.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-5.0F, -45.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-5.0F, -44.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-6.0F, -42.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-6.0F, -43.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(5.0F, -42.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(5.0F, -43.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-6.0F, -42.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-6.0F, -43.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-7.0F, -41.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(6.0F, -41.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(31, 17).addBox(4.0F, -5.0F, -8.0F, 4.0F, 1.0F, 16.0F, 0.0F, false);
			Rocket.setTextureOffset(31, 17).addBox(3.0F, -40.0F, -7.0F, 4.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 5).addBox(-1.0F, -68.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(500, 146).addBox(-1.0F, -66.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(-1.0F, -50.0F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(-1.0F, -51.0F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(-2.0F, -50.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(-2.0F, -51.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(1.0F, -50.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(1.0F, -51.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-3.0F, -49.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-3.0F, -48.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-2.0F, -49.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-2.0F, -48.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-2.0F, -49.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-2.0F, -48.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(-3.0F, -47.0F, -4.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(-3.0F, -46.0F, -4.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(3.0F, -47.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(3.0F, -46.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(-4.0F, -47.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(-4.0F, -46.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(-4.0F, -45.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(-4.0F, -44.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(-5.0F, -45.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(-5.0F, -44.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(4.0F, -45.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(4.0F, -44.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(-5.0F, -42.0F, -6.0F, 10.0F, 1.0F, 12.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(-5.0F, -43.0F, -6.0F, 10.0F, 1.0F, 12.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(-6.0F, -42.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(-6.0F, -43.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(5.0F, -42.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(5.0F, -43.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(66, 94).addBox(-6.0F, -41.0F, -7.0F, 10.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(444, 32).addBox(-7.0F, -5.0F, -6.0F, 11.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(30, 14).addBox(-7.0F, -40.0F, -7.0F, 10.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-7.0F, -5.0F, -8.0F, 11.0F, 1.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(27, 15).addBox(-8.0F, -5.0F, -8.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);
			Rocket.setTextureOffset(33, 23).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(30, 23).addBox(-3.0F, -3.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(14, 2).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 0.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(33, 29).addBox(-4.0F, -2.0F, 3.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(37, 26).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(45, 20).addBox(3.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(37, 20).addBox(-4.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(34, 17).addBox(2.0F, -3.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(39, 26).addBox(-2.0F, -3.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(40, 11).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(34, 30).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(32, 16).addBox(-5.0F, -1.0F, 4.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(34, 23).addBox(4.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(34, 17).addBox(-5.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
			Rocket.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity en, float f, float f1, float f2, float f3, float f4) {
			RocketTier1Entity.CustomEntity e = (RocketTier1Entity.CustomEntity) en;
			this.Rocket.rotateAngleY = f3 / (180F / (float) Math.PI);
			// this.Rocket.rotateAngleX = f4 / (180F / (float) Math.PI);
			// Animation1
			this.Rocket.rotateAngleZ = f2 / (180F / (float) Math.PI);
			if (e instanceof LivingEntity) {
				this.Rocket.rotateAngleZ = (float) e.ay;
			}
			// Animation2
			this.Rocket.rotateAngleX = f2 / (180F / (float) Math.PI);
			if (e instanceof LivingEntity) {
				this.Rocket.rotateAngleX = (float) e.ap;
			}
		}
	}
}
