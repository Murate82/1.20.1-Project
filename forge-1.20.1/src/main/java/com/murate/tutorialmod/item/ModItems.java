package com.murate.tutorialmod.item;

import com.murate.tutorialmod.Tutorialmod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=							//物品注册表
            DeferredRegister.create(ForgeRegistries.ITEMS, Tutorialmod.MOD_ID); //注册物品，模组ID

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            ()-> new Item(new Item.Properties()));
    public static  void register(IEventBus eventBus){ //总线，用于注册和处理
        ITEMS.register(eventBus);//将物品注册指定到总线中
    }
}