package net.meloncitrus.fruitfulendeavors.item;

import net.meloncitrus.fruitfulendeavors.FruitfulEndeavorsMod;
import net.meloncitrus.fruitfulendeavors.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FruitfulEndeavorsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INGREDIENT_TAB = CREATIVE_MODE_TABS.register(
            "ingredient_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MILK_BOTTLE.get()))
                    .title(Component.translatable("creativetab.ingredient_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                       output.accept(ModItems.MILK_BOTTLE.get());
                    })
                    .build());


    public static final RegistryObject<CreativeModeTab> CROP_TAB = CREATIVE_MODE_TABS.register(
            "deco_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.BLUE_GLAZED_TERRACOTTA))
                    .title(Component.translatable("creativetab.deco_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.CARVED_MELON.get());
                        output.accept(ModBlocks.JACK_O_MELON.get());

                        output.accept(ModBlocks.BLUE_PATTERN.get());
                        output.accept(ModBlocks.BLACK_PATTERN.get());
                        output.accept(ModBlocks.BROWN_PATTERN.get());
                        output.accept(ModBlocks.CYAN_PATTERN.get());
                        output.accept(ModBlocks.GRAY_PATTERN.get());
                        output.accept(ModBlocks.GREEN_PATTERN.get());
                        output.accept(ModBlocks.LIGHT_BLUE_PATTERN.get());
                        output.accept(ModBlocks.LIGHT_GRAY_PATTERN.get());
                        output.accept(ModBlocks.LIME_PATTERN.get());
                        output.accept(ModBlocks.MAGENTA_PATTERN.get());
                        output.accept(ModBlocks.ORANGE_PATTERN.get());
                        output.accept(ModBlocks.PINK_PATTERN.get());
                        output.accept(ModBlocks.PURPLE_PATTERN.get());
                        output.accept(ModBlocks.RED_PATTERN.get());
                        output.accept(ModBlocks.WHITE_PATTERN.get());
                        output.accept(ModBlocks.YELLOW_PATTERN.get());

                        output.accept(ModBlocks.BLUE_TILE.get());
                        output.accept(ModBlocks.BLACK_TILE.get());
                        output.accept(ModBlocks.BROWN_TILE.get());
                        output.accept(ModBlocks.CYAN_TILE.get());
                        output.accept(ModBlocks.GRAY_TILE.get());
                        output.accept(ModBlocks.GREEN_TILE.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TILE.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TILE.get());
                        output.accept(ModBlocks.LIME_TILE.get());
                        output.accept(ModBlocks.MAGENTA_TILE.get());
                        output.accept(ModBlocks.ORANGE_TILE.get());
                        output.accept(ModBlocks.PINK_TILE.get());
                        output.accept(ModBlocks.PURPLE_TILE.get());
                        output.accept(ModBlocks.RED_TILE.get());
                        output.accept(ModBlocks.WHITE_TILE.get());
                        output.accept(ModBlocks.YELLOW_TILE.get());

                        output.accept(ModBlocks.MOMS_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}