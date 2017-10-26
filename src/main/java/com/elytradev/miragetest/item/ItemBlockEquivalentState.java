package com.elytradev.miragetest.item;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class ItemBlockEquivalentState extends ItemBlock {

	public ItemBlockEquivalentState(Block block) {
		super(block);
		this.setRegistryName(block.getRegistryName());
		this.setHasSubtypes(true);
	}

	@SuppressWarnings("deprecation")
	public IBlockState getStateForItem(ItemStack item) {
		return block.getStateFromMeta(item.getItemDamage());
	}
	
	public String getStateStringForItem(ItemStack item) {
		return toVanilla(getStateForItem(item));
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item) {
		String variantString = getStateStringForItem(item);
		if (variantString.startsWith("#")) variantString = variantString.substring(1);
		variantString = variantString.replace(",", ".");
		return this.getUnlocalizedName()+"."+variantString;
	}
	
	public static String toVanilla(IBlockState state) {
		StringBuilder result = new StringBuilder();
		Set<Entry<IProperty<?>, Comparable<?>>> entries = state.getProperties().entrySet();
		Iterator<Entry<IProperty<?>, Comparable<?>>> iter = entries.iterator();
		while(iter.hasNext()) {
			Entry<IProperty<?>, Comparable<?>> entry = iter.next();
			result.append(entry.getKey().getName());
			result.append('=');
			Comparable<?> value = entry.getValue();
			if (value instanceof IStringSerializable) {
				result.append(((IStringSerializable)value).getName());
			} else {
				result.append(entry.getValue().toString());
			}
			
			if (iter.hasNext()) result.append(',');
		}
		
		return result.toString();
	}
}
