package net.mariarch.fromthebasics.item;

import net.mariarch.fromthebasics.CreativeTabInit;
import net.mariarch.fromthebasics.FromTheBasics;
import net.mariarch.fromthebasics.block.ModBlocks;
import net.mariarch.fromthebasics.entity.ModEntities;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.mariarch.fromthebasics.CreativeTabInit.addToTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FromTheBasics.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = addToTab(ITEMS.register("zircon",
            () -> new Item(new Item.Properties()
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .nutrition(5)
                            .saturationMod(0.2f)
                            .effect(()-> new MobEffectInstance(MobEffects.ABSORPTION, 200, 2), 1f)
                            .build())
                    .rarity(Rarity.EPIC)
            )));

    public static final RegistryObject<Item> TIGER_SPAWN_EGG = addToTab(ITEMS.register("tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TIGER, 0x0D57E36, 0x100D00,
                    new Item.Properties())));

    public static final RegistryObject<BlockItem> Z_BLOCK_ITEM = addToTab(ITEMS.register("zvblock",
            () -> new BlockItem(ModBlocks.Z_BLOCK.get(), new Item.Properties()
                    .rarity(Rarity.UNCOMMON))
    ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
