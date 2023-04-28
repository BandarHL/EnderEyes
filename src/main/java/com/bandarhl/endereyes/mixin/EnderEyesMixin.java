package com.bandarhl.endereyes.mixin;

import com.bandarhl.endereyes.EnderEyes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.UUID;

@Mixin(EndermanEntity.class)
public abstract class EnderEyesMixin extends HostileEntity {
	@Shadow public abstract void setAngryAt(@Nullable UUID angryAt);
	@Shadow public abstract void setTarget(@Nullable LivingEntity target);
	@Shadow public abstract boolean isAngry();

	protected EnderEyesMixin(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
		this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
	}

	@Inject(at = @At("RETURN"), method = "isPlayerStaring", cancellable = true)
	void isPlayerStaring(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
		if (EnderEyes.hasEnderEyesEnchantment(player.getInventory().getArmorStack(3)) && !this.isAngry()) {
			this.setTarget(null);
			this.setAngryAt(null);
			this.setAttacking(null);
			cir.setReturnValue(false);
		}
	}
}