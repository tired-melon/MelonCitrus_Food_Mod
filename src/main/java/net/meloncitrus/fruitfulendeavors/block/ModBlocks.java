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
import java.util.EnumMap;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FruitfulEndeavorsMod.MOD_ID);

    public static final RegistryObject<Block> CARVED_MELON = registerBlock("carved_melon",
            () -> new EquipableCarvedMelonBlock(BlockBehaviour.Properties.copy(Blocks.MELON).sound(SoundType.HARD_CROP)));

    public static final RegistryObject<Block> JACK_O_MELON = registerBlock("jack_o_melon",
            () -> new CarvedMelonBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN).sound(SoundType.HARD_CROP).mapColor(MapColor.COLOR_PINK)));

    public static final EnumMap<DyeColor, RegistryObject<Block>> PATTERNS =
            new EnumMap<>(DyeColor.class);

    public static final EnumMap<DyeColor, RegistryObject<Block>> TILES =
            new EnumMap<>(DyeColor.class);


    static {
        for (DyeColor color : DyeColor.values()) {
            PATTERNS.put(color, registerBlock(
                    color.getName() + "_pattern",
                    () -> new Block(
                            BlockBehaviour.Properties
                                    .copy(Blocks.TERRACOTTA)
                                    .mapColor(color)
                    )
            ));
        }
    }

    static {
        for (DyeColor color : DyeColor.values()) {
            TILES.put(color, registerBlock(
                    color.getName() + "_tile",
                    () -> new Block(
                            BlockBehaviour.Properties
                                    .copy(Blocks.TERRACOTTA)
                                    .sound(SoundType.DECORATED_POT)
                                    .mapColor(color)
                    )
            ));
        }
    }

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