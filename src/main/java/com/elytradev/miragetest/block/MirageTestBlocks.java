package com.elytradev.miragetest.block;

import com.elytradev.miragetest.block.entity.TileEntityLampBasic;
import com.elytradev.miragetest.block.entity.TileEntityLampNegative;
import com.elytradev.miragetest.block.entity.TileEntityLampPulsing;
import com.elytradev.miragetest.item.MirageTestItems;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class MirageTestBlocks {
	public static BlockLamp LAMP_BASIC;
	public static BlockLamp LAMP_PULSING;
	public static BlockLamp LAMP_NEGATIVE;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> r = event.getRegistry();
		
		LAMP_BASIC = block(r, new BlockLamp("basic"));
		LAMP_PULSING = block(r, new BlockLampPulsing());
		LAMP_NEGATIVE = block(r, new BlockLampNegative());
		
		GameRegistry.registerTileEntity(TileEntityLampBasic.class, "miragetest:lamp.basic");
		GameRegistry.registerTileEntity(TileEntityLampPulsing.class, "miragetest:lamp.pulsing");
		GameRegistry.registerTileEntity(TileEntityLampNegative.class, "miragetest:lamp.negative");
	}
	
	private static <T extends Block> T block(IForgeRegistry<Block> registry, T t) {
		registry.register(t);
		MirageTestItems.scheduleForItem(t);
		return t;
	}
}
