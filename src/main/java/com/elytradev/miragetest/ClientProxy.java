package com.elytradev.miragetest;

import java.util.ArrayList;
import java.util.List;

import com.elytradev.miragetest.item.ItemBlockEquivalentState;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends Proxy {
	private static List<Item> itemsToRegister = new ArrayList<>();
	
	@Override
	public void preInit() {}
	
	@Override
	public void scheduleForModel(Item item) {
		itemsToRegister.add(item);
	}
	
	@SubscribeEvent
	public void onModelRegister(ModelRegistryEvent e) {
		for(Item item : itemsToRegister) {
			ResourceLocation loc = Item.REGISTRY.getNameForObject(item);
			NonNullList<ItemStack> variantList = NonNullList.create();
			item.getSubItems(item.getCreativeTab(), variantList);
			if (variantList.size()==1) {
				System.out.println("Registering SINGLE model variant for "+loc);
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(loc, "inventory"));
			} else {
				System.out.println("Registering "+variantList.size()+" model variants for "+loc);
				for(ItemStack variant : variantList) {
					if (item instanceof ItemBlockEquivalentState) {
						String state = ((ItemBlockEquivalentState) item).getStateStringForItem(variant);
						ModelLoader.setCustomModelResourceLocation(item, variant.getItemDamage(), new ModelResourceLocation(loc, state));
					} else {
						ModelLoader.setCustomModelResourceLocation(item, variant.getItemDamage(), new ModelResourceLocation(loc, "variant="+variant.getItemDamage()));
					}
				}
			}
		}
	}
}
