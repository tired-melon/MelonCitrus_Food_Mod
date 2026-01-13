package net.meloncitrus.fruitfulendeavors.datagen;

import net.meloncitrus.fruitfulendeavors.FruitfulEndeavorsMod;
import net.meloncitrus.fruitfulendeavors.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FruitfulEndeavorsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        /*
        blockWithItem(ModBlocks.BLUE_PATTERN);
        blockWithItem(ModBlocks.BLACK_PATTERN);
        blockWithItem(ModBlocks.BROWN_PATTERN);
        blockWithItem(ModBlocks.CYAN_PATTERN);
        blockWithItem(ModBlocks.GRAY_PATTERN);
        blockWithItem(ModBlocks.GREEN_PATTERN);
        blockWithItem(ModBlocks.LIGHT_BLUE_PATTERN);
        blockWithItem(ModBlocks.LIGHT_GRAY_PATTERN);
        blockWithItem(ModBlocks.LIME_PATTERN);
        blockWithItem(ModBlocks.MAGENTA_PATTERN);
        blockWithItem(ModBlocks.ORANGE_PATTERN);
        blockWithItem(ModBlocks.PINK_PATTERN);
        blockWithItem(ModBlocks.PURPLE_PATTERN);
        blockWithItem(ModBlocks.RED_PATTERN);
        blockWithItem(ModBlocks.WHITE_PATTERN);
        blockWithItem(ModBlocks.YELLOW_PATTERN);

        blockWithItem(ModBlocks.BLUE_TILE);
        blockWithItem(ModBlocks.BLACK_TILE);
        blockWithItem(ModBlocks.BROWN_TILE);
        blockWithItem(ModBlocks.CYAN_TILE);
        blockWithItem(ModBlocks.GRAY_TILE);
        blockWithItem(ModBlocks.GREEN_TILE);
        blockWithItem(ModBlocks.LIGHT_BLUE_TILE);
        blockWithItem(ModBlocks.LIGHT_GRAY_TILE);
        blockWithItem(ModBlocks.LIME_TILE);
        blockWithItem(ModBlocks.MAGENTA_TILE);
        blockWithItem(ModBlocks.ORANGE_TILE);
        blockWithItem(ModBlocks.PINK_TILE);
        blockWithItem(ModBlocks.PURPLE_TILE);
        blockWithItem(ModBlocks.RED_TILE);
        blockWithItem(ModBlocks.WHITE_TILE);
        blockWithItem(ModBlocks.YELLOW_TILE);
        */

        blockWithItem(ModBlocks.MOMS_BLOCK);

        ModBlocks.TILES.values().forEach(this::blockWithItem);
        ModBlocks.PATTERNS.values().forEach(this::blockWithItem);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}