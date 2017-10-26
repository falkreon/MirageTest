package com.elytradev.miragetest.block;

import com.elytradev.miragetest.MirageTest;
import com.elytradev.miragetest.block.entity.TileEntityLampBasic;

import net.minecraft.block.BlockColored;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLamp extends BlockColored implements ITileEntityProvider {

	public BlockLamp(String name) {
		super(Material.GLASS);
		setRegistryName("miragetest:lamp."+name);
		setUnlocalizedName("miragetest.lamp."+name);
		setHardness(10.0f);
		setResistance(100.0f);
		setCreativeTab(MirageTest.TAB_MIRAGE);
		this.setDefaultState(getBlockState().getBaseState().withProperty(COLOR, EnumDyeColor.WHITE));
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityLampBasic();
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
	}
}
