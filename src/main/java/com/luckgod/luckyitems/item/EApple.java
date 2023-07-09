package com.luckgod.luckyitems.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Objects;

public class EApple extends Item{

    public static final FoodComponent EAppleFood = (new FoodComponent.Builder()).hunger(4).saturationModifier(9.6f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 80, 2), 1F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 0), 1F).build();
    public EApple(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (this.isFood()) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (user.canConsume(Objects.requireNonNull(this.getFoodComponent()).isAlwaysEdible())) {
                user.setCurrentHand(hand);
                return TypedActionResult.consume(itemStack);
            }
            return TypedActionResult.fail(itemStack);
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

}
