package me.peke.mtplus;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Mtplus.MODID)
public class Mtplus {

    public static final String MODID = "mtplus";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Deferred Registers
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Missing Texture Blocks
    public static final RegistryObject<Block> missingtextureblock = BLOCKS.register("missingtextureblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> missingtexturestairs = BLOCKS.register("missingtexturestairs",
            () -> new StairBlock(() -> missingtextureblock.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> missingtextureslab = BLOCKS.register("missingtextureslab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> missingtexturewall = BLOCKS.register("missingtexturewall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));

    // Inverted Texture Blocks
    public static final RegistryObject<Block> invertedtextureblock = BLOCKS.register("invertedtextureblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> invertedtexturestairs = BLOCKS.register("invertedtexturestairs",
            () -> new StairBlock(() -> invertedtextureblock.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> invertedtextureslab = BLOCKS.register("invertedtextureslab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> invertedtexturewall = BLOCKS.register("invertedtexturewall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));

    // Missing Texture Items
    public static final RegistryObject<Item> missingtextureblockitem = ITEMS.register("missingtextureblockitem",
            () -> new BlockItem(missingtextureblock.get(), new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> missingtexturestairsitem = ITEMS.register("missingtexturestairsitem",
            () -> new BlockItem(missingtexturestairs.get(), new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> missingtextureslabitem = ITEMS.register("missingtextureslabitem",
            () -> new BlockItem(missingtextureslab.get(), new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> missingtexturewallitem = ITEMS.register("missingtexturewallitem",
            () -> new BlockItem(missingtexturewall.get(), new Item.Properties().rarity(Rarity.EPIC)));

    // Inverted Texture Items
    public static final RegistryObject<Item> invertedtextureblockitem = ITEMS.register("invertedtextureblockitem",
            () -> new BlockItem(invertedtextureblock.get(), new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> invertedtexturestairsitem = ITEMS.register("invertedtexturestairsitem",
            () -> new BlockItem(invertedtexturestairs.get(), new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> invertedtextureslabitem = ITEMS.register("invertedtextureslabitem",
            () -> new BlockItem(invertedtextureslab.get(), new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> invertedtexturewallitem = ITEMS.register("invertedtexturewallitem",
            () -> new BlockItem(invertedtexturewall.get(), new Item.Properties().rarity(Rarity.RARE)));

    // Creative Tab
    public static final RegistryObject<CreativeModeTab> tab1 = CREATIVE_MODE_TABS.register("tab1", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.missingtexture"))
            .icon(() -> new ItemStack(missingtextureblockitem.get()))
            .displayItems((parameters, output) -> {
                output.accept(new ItemStack(missingtextureblockitem.get()));
                output.accept(new ItemStack(missingtexturestairsitem.get()));
                output.accept(new ItemStack(missingtextureslabitem.get()));
                output.accept(new ItemStack(missingtexturewallitem.get()));
                output.accept(new ItemStack(invertedtextureblockitem.get()));
                output.accept(new ItemStack(invertedtexturestairsitem.get()));
                output.accept(new ItemStack(invertedtextureslabitem.get()));
                output.accept(new ItemStack(invertedtexturewallitem.get()));
            })
            .build());

    public Mtplus() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
