package net.mariarch.fromthebasics.entity.client;

import net.mariarch.fromthebasics.FromTheBasics;
import net.mariarch.fromthebasics.entity.custom.PigukrEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PigukrModel extends GeoModel<PigukrEntity> {

    @Override
    public ResourceLocation getModelResource(PigukrEntity animatable) {
        return new ResourceLocation(FromTheBasics.MOD_ID, "geo/pigukr.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PigukrEntity animatable) {
        return new ResourceLocation(FromTheBasics.MOD_ID, "textures/entity/pigukr.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PigukrEntity animatable) {
        return new ResourceLocation(FromTheBasics.MOD_ID, "animations/pigukr.animation.json");
    }

    @Override
    public void setCustomAnimations(PigukrEntity animatable, long instanceId, AnimationState<PigukrEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
