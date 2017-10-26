package com.elytradev.miragetest.block;

import com.elytradev.miragetest.block.entity.TileEntityLampNegative;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLampNegative extends BlockLamp {

	public BlockLampNegative() {
		super("negative");
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityLampNegative();
	}
}
