package net.mariarch.fromthebasics;

import net.mariarch.fromthebasics.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = FromTheBasics.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, FromTheBasics.MOD_ID);

    public static final List<Supplier<? extends ItemLike>> MOD_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> EXAMLPLE_TAB = TABS.register("fromthebasics",
            () -> new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 1)
                    .title(Component.translatable("itemGroup.fromthebasics_tab"))
                    .icon(ModItems.ZIRCON.get()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                            MOD_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
                    .build()
    );

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        MOD_TAB_ITEMS.add(itemLike);
        return itemLike;
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModItems.ZIRCON);
        }

        if (event.getTab() == EXAMLPLE_TAB.get()) {
            event.accept(Items.CACTUS);
        }
    }
}
