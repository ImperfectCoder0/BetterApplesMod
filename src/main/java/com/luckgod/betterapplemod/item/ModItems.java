package com.luckgod.betterapplemod.item;

import com.luckgod.betterapplemod.BetterApplesMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;

import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item IRON_APPLE = registerItem("iron_apple", new IApple(new FabricItemSettings().food(IApple.IAppleFood)));
    public static final Item DIAMOND_APPLE = registerItem("diamond_apple", new DApple(new FabricItemSettings().food(DApple.DAppleFood)));
    public static final Item EMERALD_APPLE = registerItem("emerald_apple", new EApple(new FabricItemSettings().food(EApple.EAppleFood)));

    private static void addItemsToFoodsTabItemGroup(FabricItemGroupEntries entries){
        entries.add(IRON_APPLE);
        entries.add(DIAMOND_APPLE);
        entries.add(EMERALD_APPLE);
    }

    public static void registerModItems(){
        BetterApplesMod.LOGGER.info("Mod items registered baby! " + BetterApplesMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodsTabItemGroup);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(BetterApplesMod.MOD_ID, name), item);

    }
}
