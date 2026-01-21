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
        blockWithItem(ModBlocks.MOMS_BLOCK);

        ModBlocks.TILES.values().forEach(this::blockWithItem);
        ModBlocks.PATTERNS.values().forEach(this::blockWithItem);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}