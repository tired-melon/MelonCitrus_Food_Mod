package net.meloncitrus.fruitfulendeavors.block;

import net.meloncitrus.fruitfulendeavors.FruitfulEndeavorsMod;
import net.meloncitrus.fruitfulendeavors.block.custom.CarvedMelonBlock;
import net.meloncitrus.fruitfulendeavors.block.custom.EquipableCarvedMelonBlock;
import net.meloncitrus.fruitfulendeavors.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.sql.Array;
import java.util.EnumMap;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FruitfulEndeavorsMod.MOD_ID);

    public static final RegistryObject<Block> CARVED_MELON = registerBlock("carved_melon",
            () -> new EquipableCarvedMelonBlock(BlockBehaviour.Properties.copy(Blocks.MELON).sound(SoundType.HARD_CROP)));

    public static final RegistryObject<Block> JACK_O_MELON = registerBlock("jack_o_melon",
            () -> new CarvedMelonBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN).sound(SoundType.HARD_CROP).mapColor(MapColor.COLOR_PINK)));

    public static final EnumMap<DyeColor, RegistryObject<Block>> TILES =
            new EnumMap<>(DyeColor.class);

    static {
        for (DyeColor color : DyeColor.values()) {
            TILES.put(color, registerBlock(
                    color.getName() + "_tile",
                    () -> new Block(
                            BlockBehaviour.Properties
                                    .copy(Blocks.TERRACOTTA)
                                    .mapColor(color)
                    )
            ));
        }
    }

    public static final EnumMap<DyeColor, RegistryObject<Block>> PATTERNS =
            new EnumMap<>(DyeColor.class);

    static {
        for (DyeColor color : DyeColor.values()) {
            PATTERNS.put(color, registerBlock(
                    color.getName() + "_pattern",
                    () -> new Block(
                            BlockBehaviour.Properties
                                    .copy(Blocks.TERRACOTTA)
                                    .sound(SoundType.DECORATED_POT)
                                    .mapColor(color)
                    )
            ));
        }
    }

    public static final RegistryObject<Block> BLUE_PATTERN = registerBlock("blue_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.BLUE)));

    public static final RegistryObject<Block> RED_PATTERN = registerBlock("red_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.RED)));

    public static final RegistryObject<Block> BROWN_PATTERN = registerBlock("brown_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.BROWN)));

    public static final RegistryObject<Block> GREEN_PATTERN = registerBlock("green_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.GREEN)));

    public static final RegistryObject<Block> LIGHT_BLUE_PATTERN = registerBlock("light_blue_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.LIGHT_BLUE)));

    public static final RegistryObject<Block> LIGHT_GRAY_PATTERN = registerBlock("light_gray_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.LIGHT_GRAY)));

    public static final RegistryObject<Block> ORANGE_PATTERN = registerBlock("orange_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.ORANGE)));

    public static final RegistryObject<Block> CYAN_PATTERN = registerBlock("cyan_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.CYAN)));

    public static final RegistryObject<Block> PINK_PATTERN = registerBlock("pink_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.PINK)));

    public static final RegistryObject<Block> WHITE_PATTERN = registerBlock("white_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.WHITE)));

    public static final RegistryObject<Block> YELLOW_PATTERN = registerBlock("yellow_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.YELLOW)));

    public static final RegistryObject<Block> LIME_PATTERN = registerBlock("lime_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.LIME)));

    public static final RegistryObject<Block> MAGENTA_PATTERN = registerBlock("magenta_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.MAGENTA)));

    public static final RegistryObject<Block> PURPLE_PATTERN = registerBlock("purple_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.PURPLE)));

    public static final RegistryObject<Block> GRAY_PATTERN = registerBlock("gray_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.GRAY)));

    public static final RegistryObject<Block> BLACK_PATTERN = registerBlock("black_pattern",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).mapColor(DyeColor.BLACK)));

    public static final RegistryObject<Block> BLUE_TILE = registerBlock("blue_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.BLUE)));

    public static final RegistryObject<Block> RED_TILE = registerBlock("red_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.RED)));

    public static final RegistryObject<Block> BROWN_TILE = registerBlock("brown_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.BROWN)));

    public static final RegistryObject<Block> GREEN_TILE = registerBlock("green_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.GREEN)));

    public static final RegistryObject<Block> LIGHT_BLUE_TILE = registerBlock("light_blue_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.LIGHT_BLUE)));

    public static final RegistryObject<Block> LIGHT_GRAY_TILE = registerBlock("light_gray_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.LIGHT_GRAY)));

    public static final RegistryObject<Block> ORANGE_TILE = registerBlock("orange_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.ORANGE)));

    public static final RegistryObject<Block> CYAN_TILE = registerBlock("cyan_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.CYAN)));

    public static final RegistryObject<Block> PINK_TILE = registerBlock("pink_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.PINK)));

    public static final RegistryObject<Block> WHITE_TILE = registerBlock("white_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.WHITE)));

    public static final RegistryObject<Block> YELLOW_TILE = registerBlock("yellow_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.YELLOW)));

    public static final RegistryObject<Block> LIME_TILE = registerBlock("lime_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.LIME)));

    public static final RegistryObject<Block> MAGENTA_TILE = registerBlock("magenta_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.MAGENTA)));

    public static final RegistryObject<Block> PURPLE_TILE = registerBlock("purple_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.PURPLE)));

    public static final RegistryObject<Block> GRAY_TILE = registerBlock("gray_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.GRAY)));

    public static final RegistryObject<Block> BLACK_TILE = registerBlock("black_tile",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.DECORATED_POT).mapColor(DyeColor.BLACK)));

    public static final RegistryObject<Block> MOMS_BLOCK = registerBlock("moms_block",
            () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA).sound(SoundType.AMETHYST)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}