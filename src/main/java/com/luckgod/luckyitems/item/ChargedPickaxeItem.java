package com.luckgod.luckyitems.item;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class ChargedPickaxeItem extends PickaxeItem {
    public int charge = 0;
    public int damageTaken = 0;
    public ChargedPickaxeItem(int charge, ToolMaterial material, Settings settings) {
        super(material, charge - 1, 0.5f*charge, settings);
        this.charge = charge;


    }



}

