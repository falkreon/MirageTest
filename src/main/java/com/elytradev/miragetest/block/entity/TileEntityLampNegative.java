package com.elytradev.miragetest.block.entity;

import com.elytradev.mirage.lighting.Light;
import com.elytradev.miragetest.block.BlockLamp;
import com.elytradev.miragetest.block.MirageTestBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;

public class TileEntityLampNegative extends TileEntityLampBasic {
	
	
	@Override
	public Light getColoredLight() {
		IBlockState state = world.getBlockState(getPos());
		if(state.getBlock()!=MirageTestBlocks.LAMP_NEGATIVE) return null;
		
		EnumDyeColor dyeColor = state.getValue(BlockLamp.COLOR);
		return Light.builder()
				.pos(getPos())
				.color(dyeColor.getColorValue(), false)
				.intensity(-1.0f)
				.radius(7f)
				.build();
	}
}
