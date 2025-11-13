package net.meloncitrus.meloncitrusmod.item;

import net.meloncitrus.meloncitrusmod.MelonCitrusMod;
import net.meloncitrus.meloncitrusmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MelonCitrusMod.MOD_ID);

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
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}