package net.meloncitrus.fruitfulendeavors.item;

import net.meloncitrus.fruitfulendeavors.FruitfulEndeavorsMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FruitfulEndeavorsMod.MOD_ID);

    public static final RegistryObject<Item> MILK_BOTTLE = ITEMS.register("milk_bottle",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}