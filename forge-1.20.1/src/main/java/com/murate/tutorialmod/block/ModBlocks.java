package com.murate.tutorialmod.block;

import com.murate.tutorialmod.Tutorialmod;
import com.murate.tutorialmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =                        //方块注册表
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tutorialmod.MOD_ID);//注册方块，模组ID

public static  final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
        ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));//新建方块并赋予方块放置的声音也可以对其修改



    //注册方块并返回对象
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T>block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    //破坏掉落物获取掉落物本身
    private  static <T extends Block> RegistryObject<Item> registerBlockItem(String name,RegistryObject<T> block){
        return ModItems.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
    }
    public static void register(IEventBus eventBus) { //总线，用于注册和处理
        BLOCKS.register(eventBus);//将方块注册指定到总线中
    }
}
