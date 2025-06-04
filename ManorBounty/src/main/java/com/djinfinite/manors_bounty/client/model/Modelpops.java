package com.djinfinite.manors_bounty.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import org.jetbrains.annotations.NotNull;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelpops<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("manors_bounty", "modelpops"), "main");
	public final ModelPart Head;

	public Modelpops(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -9.25F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.55F)).texOffs(32, 28).addBox(-4.0F, -8.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.54F)).texOffs(32, 0)
						.addBox(-4.0F, -9.25F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(1.0F)).texOffs(2, 2).addBox(-0.5F, -2.25F, -4.15F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.75F, -9.25F, 3.5F, -0.9782F, 0.8455F, -0.4234F));
		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.75F, -9.25F, 3.5F, -0.9782F, -0.8455F, 0.4234F));
		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.75F, -9.25F, 0.0F, 0.9782F, -0.8455F, -0.4234F));
		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.75F, -9.25F, 0.0F, 0.9782F, 0.8455F, 0.4234F));
		PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-1.0F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)).mirror(false),
				PartPose.offsetAndRotation(5.5F, -8.75F, 2.75F, 0.0F, 0.0F, 0.6109F));
		PartDefinition cube_r6 = Head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 21).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)),
				PartPose.offsetAndRotation(-5.5F, -8.75F, 2.75F, 0.0F, 0.0F, -0.6109F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
