package net.meloncitrus.fruitfulendeavors.datagen;

import net.meloncitrus.fruitfulendeavors.FruitfulEndeavorsMod;
import net.meloncitrus.fruitfulendeavors.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.EnumMap;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    private static final EnumMap<DyeColor, Block> TERRACOTTA_BY_COLOR =
            new EnumMap<>(DyeColor.class);

    static {
        TERRACOTTA_BY_COLOR.put(DyeColor.WHITE, Blocks.WHITE_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.ORANGE, Blocks.ORANGE_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.MAGENTA, Blocks.MAGENTA_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.YELLOW, Blocks.YELLOW_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.LIME, Blocks.LIME_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.PINK, Blocks.PINK_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.GRAY, Blocks.GRAY_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.CYAN, Blocks.CYAN_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.PURPLE, Blocks.PURPLE_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.BLUE, Blocks.BLUE_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.BROWN, Blocks.BROWN_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.GREEN, Blocks.GREEN_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.RED, Blocks.RED_TERRACOTTA);
        TERRACOTTA_BY_COLOR.put(DyeColor.BLACK, Blocks.BLACK_TERRACOTTA);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        for (DyeColor color : DyeColor.values()) {
            buildColorfulRecipe(color, pWriter);
        }
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.JACK_O_MELON.get())
                .requires(ModBlocks.CARVED_MELON.get())
                .requires(Blocks.TORCH)
                .unlockedBy(getHasName(ModBlocks.CARVED_MELON.get()), has(ModBlocks.CARVED_MELON.get()))
                .save(pWriter);
    }

    private void buildColorfulRecipe(DyeColor color, Consumer<FinishedRecipe> pWriter) {
        Block ingredient = TERRACOTTA_BY_COLOR.get(color);
        ItemLike tile = ModBlocks.TILES.get(color).get();
        ItemLike pattern = ModBlocks.PATTERNS.get(color).get();

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, tile, 4)
                .pattern(" # ")
                .pattern("# #")
                .pattern(" # ")
                .define('#', ingredient)
                .unlockedBy("has_terracotta", has(ingredient))
                .save(pWriter,
                        ResourceLocation.fromNamespaceAndPath(
                                FruitfulEndeavorsMod.MOD_ID,
                                color.getName() + "_tile"
                        ));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, pattern, 4)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .unlockedBy("has_terracotta", has(ingredient))
                .save(pWriter,
                        ResourceLocation.fromNamespaceAndPath(
                                FruitfulEndeavorsMod.MOD_ID,
                                color.getName() + "_pattern"
                        ));
    }
}