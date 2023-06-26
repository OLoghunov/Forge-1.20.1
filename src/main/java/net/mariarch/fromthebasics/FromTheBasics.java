package net.mariarch.fromthebasics;

import com.mojang.logging.LogUtils;
import net.mariarch.fromthebasics.block.ModBlocks;
import net.mariarch.fromthebasics.entity.ModEntities;
import net.mariarch.fromthebasics.entity.client.PigukrModel;
import net.mariarch.fromthebasics.entity.client.TigerRenderer;
import net.mariarch.fromthebasics.entity.client.PigukrRenderer;
import net.mariarch.fromthebasics.entity.custom.PigukrEntity;
import net.mariarch.fromthebasics.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(FromTheBasics.MOD_ID)
public class FromTheBasics {
    public static final String MOD_ID = "fromthebasics";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FromTheBasics() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CreativeTabInit.TABS.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.TIGER.get(), TigerRenderer::new);
            EntityRenderers.register(ModEntities.PIGUKR.get(), PigukrRenderer::new);
        }
    }
}
