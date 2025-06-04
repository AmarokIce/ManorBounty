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
public class Modelchristmas_muffler<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("manors_bounty", "modelchristmas_muffler"), "main");
	public final ModelPart Body;
	public final ModelPart Left_arm;
	public final ModelPart Right_arm;

	public Modelchristmas_muffler(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Left_arm = root.getChild("Left_arm");
		this.Right_arm = root.getChild("Right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -1.0F, -6.25F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.0F, 3.0F, -5.25F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 16)
						.addBox(0.0F, 9.0F, -4.75F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 7).addBox(-3.0F, 3.0F, -4.75F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 16)
						.addBox(-3.0F, 7.0F, -4.25F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Left_arm = partdefinition.addOrReplaceChild("Left_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Right_arm = partdefinition.addOrReplaceChild("Right_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
