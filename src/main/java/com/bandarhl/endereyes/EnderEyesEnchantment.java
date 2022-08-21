package com.bandarhl.endereyes;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnderEyesEnchantment extends Enchantment {
    public EnderEyesEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[] {EquipmentSlot.HEAD});
    }

    @Override
    public int getMinPower(int level) {
        return level * 25;
    }
    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 50;
    }
    @Override
    public boolean isTreasure() {
        return true;
    }
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
