package net.mariarch.fromthebasics.event;

import net.mariarch.fromthebasics.FromTheBasics;
import net.mariarch.fromthebasics.entity.ModEntities;
import net.mariarch.fromthebasics.entity.custom.PigukrEntity;
import net.mariarch.fromthebasics.entity.custom.TigerEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FromTheBasics.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event)  {
        event.put(ModEntities.TIGER.get(), TigerEntity.setAttributes());
        event.put(ModEntities.PIGUKR.get(), PigukrEntity.setAttributes());
    }
}
