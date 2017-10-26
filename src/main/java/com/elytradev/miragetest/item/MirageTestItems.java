package com.elytradev.miragetest.item;

import java.util.ArrayList;
import java.util.List;

import com.elytradev.mirage.lighting.Light;
import com.elytradev.miragetest.MirageTest;

import net.minecraft.block.Block;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class MirageTestItems {
	private static List<Block> blocksToRegister = new ArrayList<>();
	
	public static ItemGlowingArmor SHINING_SHOES;

	public static void scheduleForItem(Block b) {
		blocksToRegister.add(b);
	}
	
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> r = event.getRegistry();
		
		for(Block b : blocksToRegister) {
			item(r, new ItemBlockEquivalentState(b));
		}
		
		SHINING_SHOES = item(r, new ItemGlowingArmor(
			"shiningshoes",
			EntityEquipmentSlot.FEET,
			Light.builder()
				.color(0xFFFFFF, false)
				.intensity(1.0f)
				.radius(4.0f)
				.build()
			));
	}
	
	private static <T extends Item> T item(IForgeRegistry<Item> registry, T t) {
		registry.register(t);
		MirageTest.PROXY.scheduleForModel(t);
		return t;
	}
}
