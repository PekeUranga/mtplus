package me.peke.mtplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;

public class Mtplus implements ModInitializer {

    private static final String mod_id = "mtplus";

    public void onInitialize() {
        // missing texture
        Block missingtextureblock = Registry.register(Registry.BLOCK, new ResourceLocation(mod_id,"missingtextureblock"),
                new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block missingtexturestairs = Registry.register(Registry.BLOCK, new ResourceLocation(mod_id,"missingtexturestairs"),
                new AccesibleStairBlock(missingtextureblock.defaultBlockState(),FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block missingtextureslab = Registry.register(Registry.BLOCK, new ResourceLocation(mod_id,"missingtextureslab"),
                new SlabBlock(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block missingtexturewall = Registry.register(Registry.BLOCK, new ResourceLocation(mod_id,"missingtexturewall"),
                new WallBlock(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Item missingtextureblockitem = Registry.register(Registry.ITEM, new ResourceLocation(mod_id,"missingtextureblockitem"),new BlockItem(missingtextureblock,new Item.Properties().rarity(Rarity.EPIC)));
        Item missingtexturestairsitem = Registry.register(Registry.ITEM, new ResourceLocation(mod_id,"missingtexturestairsitem"),new BlockItem(missingtexturestairs,new Item.Properties().rarity(Rarity.EPIC)));
        Item missingtextureslabitem = Registry.register(Registry.ITEM, new ResourceLocation(mod_id,"missingtextureslabitem"),new BlockItem(missingtextureslab,new Item.Properties().rarity(Rarity.EPIC)));
        Item missingtexturewallitem = Registry.register(Registry.ITEM, new ResourceLocation(mod_id,"missingtexturewallitem"),new BlockItem(missingtexturewall,new Item.Properties().rarity(Rarity.EPIC)));
        

        // inverted missing texture
        Block invertedtextureblock = Registry.register(Registry.BLOCK, new ResourceLocation(mod_id,"invertedtextureblock"),
                new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block invertedtexturestairs = Registry.register(Registry.BLOCK, new ResourceLocation(mod_id,"invertedtexturestairs"),
                new AccesibleStairBlock(invertedtextureblock.defaultBlockState(),FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block invertedtextureslab = Registry.register(Registry.BLOCK, new ResourceLocation(mod_id,"invertedtextureslab"),
                new SlabBlock(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block invertedtexturewall = Registry.register(Registry.BLOCK, new ResourceLocation(mod_id,"invertedtexturewall"),
                new WallBlock(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Item invertedtextureblockitem = Registry.register(Registry.ITEM, new ResourceLocation(mod_id,"invertedtextureblockitem"),new BlockItem(invertedtextureblock,new Item.Properties().rarity(Rarity.RARE)));
        Item invertedtexturestairsitem = Registry.register(Registry.ITEM, new ResourceLocation(mod_id,"invertedtexturestairsitem"),new BlockItem(invertedtexturestairs,new Item.Properties().rarity(Rarity.RARE)));
        Item invertedtextureslabitem = Registry.register(Registry.ITEM, new ResourceLocation(mod_id,"invertedtextureslabitem"),new BlockItem(invertedtextureslab,new Item.Properties().rarity(Rarity.RARE)));
        Item invertedtexturewallitem = Registry.register(Registry.ITEM, new ResourceLocation(mod_id,"invertedtexturewallitem"),new BlockItem(invertedtexturewall,new Item.Properties().rarity(Rarity.RARE)));

        CreativeModeTab tab1 = FabricItemGroupBuilder.create(
                        new ResourceLocation(mod_id, "missingtexture"))
                .icon(() -> new ItemStack(missingtextureblockitem))
                .appendItems(stacks -> {
                    stacks.add(new ItemStack(missingtextureblockitem));
                    stacks.add(new ItemStack(missingtexturestairsitem));
                    stacks.add(new ItemStack(missingtextureslabitem));
                    stacks.add(new ItemStack(missingtexturewallitem));
                    stacks.add(new ItemStack(invertedtextureblockitem));
                    stacks.add(new ItemStack(invertedtexturestairsitem));
                    stacks.add(new ItemStack(invertedtextureslabitem));
                    stacks.add(new ItemStack(invertedtexturewallitem));
                }).build();
    }
}