package com.luckgod.luckyitems.effect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.profiler.Profiler;

public class ChargedEffect  extends StatusEffect {


    public ChargedEffect() {
        super(
                StatusEffectCategory.BENEFICIAL, // whether beneficial or harmful for entities
                0xEFEFEF); // color in RGB
    }

    // This method is called every tick to check whether it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity affectedEntity, int amplifier) {

        if (affectedEntity.getWorld() instanceof ServerWorld world) {
        boolean bl = world.isRaining();
        Profiler profiler = world.getProfiler();
        profiler.push("thunder");
        BlockPos blockPos;
        if (bl && world.isThundering() && world.random.nextInt(255/(amplifier+1)) == 0) {
            blockPos = affectedEntity.getBlockPos();
            if (world.hasRain(blockPos)) {


                LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(world);
                if (lightningEntity != null) {
                    lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos));
                    world.spawnEntity(lightningEntity);
                }
            }
        }
        }


        }



}