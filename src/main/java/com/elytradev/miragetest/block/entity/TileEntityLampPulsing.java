package com.elytradev.miragetest.block.entity;

import com.elytradev.mirage.lighting.IColoredLight;
import com.elytradev.mirage.lighting.Light;
import com.elytradev.miragetest.block.BlockLamp;
import com.elytradev.miragetest.block.MirageTestBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityLampPulsing extends TileEntity implements IColoredLight, ITickable {
	public static final float TAU = (float)(Math.PI*2);
	public static final float SPEED = 0.03f;
	public float phase = 0.0f;
	
	public void onLoad() {
		this.phase = (float)Math.random()*TAU;
	}
	
	@Override
	public Light getColoredLight() {
		IBlockState state = world.getBlockState(getPos());
		if(state.getBlock()!=MirageTestBlocks.LAMP_PULSING) return null;
		
		EnumDyeColor dyeColor = state.getValue(BlockLamp.COLOR);
		return Light.builder()
				.pos(getPos())
				.color(dyeColor.getColorValue(), false)
				.intensity(1.0f)
				.radius(5f + (float)Math.sin(phase)*2f)
				.build();
	}

	@Override
	public void update() {
		phase+=SPEED;
		if (phase>TAU) phase-=TAU;
	}
}
