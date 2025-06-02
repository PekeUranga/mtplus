package me.peke.mtplus;

import net.minecraft.block.*;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Mtplus.MODID)
public class Mtplus {
    public static final String MODID = "mtplus";

    // Deferred Registers
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Missing Texture Blocks
    public static final RegistryObject<Block> missingtextureblock = BLOCKS.register("missingtextureblock",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> missingtexturestairs = BLOCKS.register("missingtexturestairs",
            () -> new StairsBlock(() -> missingtextureblock.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> missingtextureslab = BLOCKS.register("missingtextureslab",
            () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> missingtexturewall = BLOCKS.register("missingtexturewall",
            () -> new WallBlock(AbstractBlock.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));

    // Inverted Texture Blocks
    public static final RegistryObject<Block> invertedtextureblock = BLOCKS.register("invertedtextureblock",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> invertedtexturestairs = BLOCKS.register("invertedtexturestairs",
            () -> new StairsBlock(() -> invertedtextureblock.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> invertedtextureslab = BLOCKS.register("invertedtextureslab",
            () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));
    public static final RegistryObject<Block> invertedtexturewall = BLOCKS.register("invertedtexturewall",
            () -> new WallBlock(AbstractBlock.Properties.copy(Blocks.COAL_BLOCK).sound(SoundType.STONE)));

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
    public static final ItemGroup tab1 = new ItemGroup("missingtexture") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(missingtextureblockitem.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            items.add(new ItemStack(missingtextureblockitem.get()));
            items.add(new ItemStack(missingtexturestairsitem.get()));
            items.add(new ItemStack(missingtextureslabitem.get()));
            items.add(new ItemStack(missingtexturewallitem.get()));
            items.add(new ItemStack(invertedtextureblockitem.get()));
            items.add(new ItemStack(invertedtexturestairsitem.get()));
            items.add(new ItemStack(invertedtextureslabitem.get()));
            items.add(new ItemStack(invertedtexturewallitem.get()));
        }
    };

    public Mtplus() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
