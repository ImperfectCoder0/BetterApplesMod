package com.luckgod.luckyitems.item;

import com.luckgod.luckyitems.LuckyItemsMod;
import com.luckgod.luckyitems.materials.ChargedToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;

import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item IRON_APPLE = registerItem("iron_apple", new IApple(new FabricItemSettings().food(IApple.IAppleFood)));
    public static final Item DIAMOND_APPLE = registerItem("diamond_apple", new DApple(new FabricItemSettings().food(DApple.DAppleFood)));
    public static final Item EMERALD_APPLE = registerItem("emerald_apple", new EApple(new FabricItemSettings().food(EApple.EAppleFood)));
    public static final Item CHARGED_PICKAXE_TIER_1 = registerItem("charged_pickaxe_t1", new ChargedPickaxeItem(1, ChargedToolMaterial.INSTANCE, new Item.Settings()));
    public static final Item CHARGED_PICKAXE_TIER_2 = registerItem("charged_pickaxe_t2", new ChargedPickaxeItem(2, ChargedToolMaterial.INSTANCE, new Item.Settings()));

    private static void addItemsToFoodsTabItemGroup(FabricItemGroupEntries entries){
        entries.add(IRON_APPLE);
        entries.add(DIAMOND_APPLE);
        entries.add(EMERALD_APPLE);
    }

    private static void addItemsToWeaponryItemGroup(FabricItemGroupEntries entries){
        entries.add(CHARGED_PICKAXE_TIER_1);
        entries.add(CHARGED_PICKAXE_TIER_2);
    }

    public static void registerModItems(){
        LuckyItemsMod.LOGGER.info("Mod items registered baby! " + LuckyItemsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodsTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToWeaponryItemGroup);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(LuckyItemsMod.MOD_ID, name), item);

    }
}
