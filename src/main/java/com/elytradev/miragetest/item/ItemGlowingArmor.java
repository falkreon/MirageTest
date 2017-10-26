package com.elytradev.miragetest.item;

import com.elytradev.mirage.lighting.IColoredLight;
import com.elytradev.mirage.lighting.Light;
import com.elytradev.miragetest.MirageTest;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemGlowingArmor extends Item implements IColoredLight {
	private EntityEquipmentSlot slot;
	private Light light;
	
	
	public ItemGlowingArmor(String id, EntityEquipmentSlot slot, Light light) {
		this.setRegistryName(new ResourceLocation("miragetest:armor.glowing."+id));
		this.setUnlocalizedName("miragetest.armor.glowing."+id);
		this.setCreativeTab(MirageTest.TAB_MIRAGE);
		
		
		this.slot = slot;
		this.light = light;
	}
	
	@Override
	public boolean isValidArmor(ItemStack item, EntityEquipmentSlot slot, Entity entity) {
		return (slot==this.slot);
	}
	
	@Override
	public Light getColoredLight() {
		return light;
	}
	
}
