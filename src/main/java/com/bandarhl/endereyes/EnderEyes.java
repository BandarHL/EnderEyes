package com.bandarhl.endereyes;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class EnderEyes implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("EnderEyes");
	public static Enchantment enderEyesEnchantment = new EnderEyesEnchantment();

	public static boolean hasEnderEyesEnchantment(ItemStack item) {
		if (item.getItem() instanceof ArmorItem) {
			Map<Enchantment, Integer> itemEnchantments = EnchantmentHelper.get(item);
			return itemEnchantments.get(enderEyesEnchantment) != null;
		}
		return false;
	}
	@Override
	public void onInitialize() {
		Registry.register(Registries.ENCHANTMENT, new Identifier("endereyes", "ender_eyes"), enderEyesEnchantment);
	}
}
