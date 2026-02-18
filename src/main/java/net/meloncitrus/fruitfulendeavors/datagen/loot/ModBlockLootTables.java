package net.meloncitrus.fruitfulendeavors.datagen.loot;

import net.meloncitrus.fruitfulendeavors.block.ModBlocks;
import net.meloncitrus.fruitfulendeavors.block.custom.TomatoCropBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
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

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 2)) // Originally 7
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 3))); // Originally 8
                // .or is optional btw, base it around what you'll actually need
                // OR USE IT FOR GREEN TOMATOES!!! :D
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}