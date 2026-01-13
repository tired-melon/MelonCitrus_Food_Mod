package net.meloncitrus.fruitfulendeavors.datagen.loot;

import net.meloncitrus.fruitfulendeavors.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables  extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());

    }

    @Override
    protected void generate() {
        ModBlocks.TILES.values().forEach((val) -> this.dropSelf(val.get()));
        ModBlocks.PATTERNS.values().forEach((val) -> this.dropSelf(val.get()));

        this.dropSelf(ModBlocks.MOMS_BLOCK.get());

        this.dropSelf(ModBlocks.CARVED_MELON.get());
        this.dropSelf(ModBlocks.JACK_O_MELON.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}