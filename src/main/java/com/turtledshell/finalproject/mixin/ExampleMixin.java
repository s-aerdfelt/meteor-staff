package com.turtledshell.finalproject.mixin;

import com.turtledshell.finalproject.item.BlazeSword;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class ExampleMixin  {
	@Inject(at = @At("HEAD"), method = "applyDamage")
	private void applyDamage(ServerWorld world, DamageSource source, float amount, CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()V
		if (source.getAttacker() instanceof LivingEntity entity && entity.getStackInHand(Hand.MAIN_HAND).getItem() instanceof BlazeSword) {
			((LivingEntity)(Object)this).setFireTicks(30);
		}
	}
}