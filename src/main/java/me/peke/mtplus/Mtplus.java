package me.peke.mtplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Mtplus implements ModInitializer {

    private static final String mod_id = "mtplus";

    public void onInitialize() {


        // missing texture
        Block missingtextureblock = Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod_id,"missingtextureblock"),
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block missingtexturestairs = Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod_id,"missingtexturestairs"),
                new StairBlock(missingtextureblock.defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block missingtextureslab = Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod_id,"missingtextureslab"),
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block missingtexturewall = Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod_id,"missingtexturewall"),
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Item missingtextureblockitem = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(mod_id,"missingtextureblockitem"),new BlockItem(missingtextureblock,new Item.Properties().rarity(Rarity.EPIC)));
        Item missingtexturestairsitem = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(mod_id,"missingtexturestairsitem"),new BlockItem(missingtexturestairs,new Item.Properties().rarity(Rarity.EPIC)));
        Item missingtextureslabitem = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(mod_id,"missingtextureslabitem"),new BlockItem(missingtextureslab,new Item.Properties().rarity(Rarity.EPIC)));
        Item missingtexturewallitem = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(mod_id,"missingtexturewallitem"),new BlockItem(missingtexturewall,new Item.Properties().rarity(Rarity.EPIC)));
        

        // inverted missing texture
        Block invertedtextureblock = Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod_id,"invertedtextureblock"),
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block invertedtexturestairs = Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod_id,"invertedtexturestairs"),
                new StairBlock(invertedtextureblock.defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block invertedtextureslab = Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod_id,"invertedtextureslab"),
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Block invertedtexturewall = Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(mod_id,"invertedtexturewall"),
                new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
        Item invertedtextureblockitem = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(mod_id,"invertedtextureblockitem"),new BlockItem(invertedtextureblock,new Item.Properties().rarity(Rarity.RARE)));
        Item invertedtexturestairsitem = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(mod_id,"invertedtexturestairsitem"),new BlockItem(invertedtexturestairs,new Item.Properties().rarity(Rarity.RARE)));
        Item invertedtextureslabitem = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(mod_id,"invertedtextureslabitem"),new BlockItem(invertedtextureslab,new Item.Properties().rarity(Rarity.RARE)));
        Item invertedtexturewallitem = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(mod_id,"invertedtexturewallitem"),new BlockItem(invertedtexturewall,new Item.Properties().rarity(Rarity.RARE)));


        // creative tab
        CreativeModeTab tab1 = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(mod_id,"tab1"),
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.missingtexture"))
                        .icon(()->new ItemStack(missingtextureblockitem))
                        .displayItems((parameters,output)->{
                            output.accept(missingtextureblockitem);
                            output.accept(missingtexturestairsitem);
                            output.accept(missingtextureslabitem);
                            output.accept(missingtexturewallitem);
                            output.accept(invertedtextureblockitem);
                            output.accept(invertedtexturestairsitem);
                            output.accept(invertedtextureslabitem);
                            output.accept(invertedtexturewallitem);
                        })
                        .build());
    }


}