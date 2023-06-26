package net.mariarch.fromthebasics.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mariarch.fromthebasics.FromTheBasics;
import net.mariarch.fromthebasics.entity.custom.PigukrEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PigukrRenderer extends GeoEntityRenderer<PigukrEntity> {
    public PigukrRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PigukrModel());
    }

    @Override
    public ResourceLocation getTextureLocation(PigukrEntity animatable) {
        return new ResourceLocation(FromTheBasics.MOD_ID, "textures/entity/pigukr.png");
    }

    @Override
    public void render(PigukrEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
