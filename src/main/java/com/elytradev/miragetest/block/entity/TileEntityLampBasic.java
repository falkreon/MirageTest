package com.elytradev.miragetest.block.entity;

import com.elytradev.mirage.lighting.IColoredLight;
import com.elytradev.mirage.lighting.Light;
import com.elytradev.miragetest.block.BlockLamp;
import com.elytradev.miragetest.block.MirageTestBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLampBasic extends TileEntity implements IColoredLight {

	@Override
	public Light getColoredLight() {
		IBlockState state = world.getBlockState(getPos());
		if(state.getBlock()!=MirageTestBlocks.LAMP_BASIC) return null;
		
		EnumDyeColor dyeColor = state.getValue(BlockLamp.COLOR);
		return Light.builder()
				.pos(getPos())
				.color(dyeColor.getColorValue(), false)
				.intensity(1.0f)
				.radius(7f)
				.build();
	}

}
