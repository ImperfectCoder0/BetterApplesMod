package com.luckgod.luckyitems.mixin;



import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//
@Mixin(Entity.class)
public class EntityMixin  {
    @Inject( at = @At("HEAD"), method = "onStruckByLightning(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LightningEntity;)V")
    private void onStrikeByLightning(CallbackInfo ci) {
        System.out.println("Entity was struck by lightning");
        if (((Entity) (Object) this) instanceof ServerPlayerEntity){
            System.out.println("It was a player!");
        } else {
            System.out.println("It wasn't a player!");
        }
    }
}
