package net.mariarch.fromthebasics.entity;

import net.mariarch.fromthebasics.FromTheBasics;
import net.mariarch.fromthebasics.entity.custom.PigukrEntity;
import net.mariarch.fromthebasics.entity.custom.TigerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FromTheBasics.MOD_ID);

    public static final RegistryObject<EntityType<TigerEntity>> TIGER =
            ENTITY_TYPES.register("tiger",
                    () -> EntityType.Builder.of(TigerEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(FromTheBasics.MOD_ID, "tiger").toString()));

    public static final RegistryObject<EntityType<PigukrEntity>> PIGUKR =
            ENTITY_TYPES.register("pigukr",
                    () -> EntityType.Builder.of(PigukrEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(FromTheBasics.MOD_ID, "pigukr").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
