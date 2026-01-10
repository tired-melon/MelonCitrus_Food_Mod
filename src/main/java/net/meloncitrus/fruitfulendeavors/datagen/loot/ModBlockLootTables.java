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
    public ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        for(RegistryObject<Block>block : ModBlocks.BLOCKS.getEntries()) { // Adding Color Blocks
            if (block.toString().contains("_TILE") || block.toString().contains("_PATTERN")) {
                this.dropSelf(block.get());
            }
        }
        this.dropSelf(ModBlocks.MOMS_BLOCK.get());

        this.dropSelf(ModBlocks.CARVED_MELON.get());
        this.dropSelf(ModBlocks.JACK_O_MELON.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}