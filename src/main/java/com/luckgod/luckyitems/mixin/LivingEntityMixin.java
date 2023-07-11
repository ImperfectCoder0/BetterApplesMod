package com.luckgod.luckyitems.mixin;

import com.luckgod.luckyitems.materials.ChargedToolMaterial;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface LivingEntityMixin {

    @Accessor("lastDamageTime")
    long getLastDamageTaken();

    @Accessor("lastDamageSource")
    DamageSource getLastDamageSource();



}
