package net.meloncitrus.fruitfulendeavors.datagen;

import net.meloncitrus.fruitfulendeavors.FruitfulEndeavorsMod;
import net.meloncitrus.fruitfulendeavors.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FruitfulEndeavorsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        ModBlocks.TILES.values().forEach(block ->
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get())
        );

        ModBlocks.PATTERNS.values().forEach(block ->
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get())
        );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.MOMS_BLOCK.get());
    }
}