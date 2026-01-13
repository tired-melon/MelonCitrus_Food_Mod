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


    public static final RegistryObject<CreativeModeTab> DECORATIVE_TAB = CREATIVE_MODE_TABS.register(
            "deco_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MOMS_BLOCK.get()))
                    .title(Component.translatable("creativetab.deco_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.CARVED_MELON.get());
                        output.accept(ModBlocks.JACK_O_MELON.get());

                        ModBlocks.TILES.values().forEach((val) -> output.accept(val.get()));
                        ModBlocks.PATTERNS.values().forEach((val) -> output.accept(val.get()));

                        output.accept(ModBlocks.MOMS_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}