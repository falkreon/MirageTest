package com.elytradev.miragetest.block;

import com.elytradev.miragetest.block.entity.TileEntityLampPulsing;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLampPulsing extends BlockLamp {

	public BlockLampPulsing() {
		super("pulsing");
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityLampPulsing();
	}
}
