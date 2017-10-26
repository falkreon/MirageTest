package com.elytradev.miragetest;

import com.elytradev.miragetest.block.MirageTestBlocks;
import com.elytradev.miragetest.item.MirageTestItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=MirageTest.MODID, version=MirageTest.VERSION, name=MirageTest.NAME)
public class MirageTest {
	public static final String MODID = "miragetest";
	public static final String VERSION = "@VERSION@";
	public static final String NAME = "MirageTest";
	
	@Instance(MODID)
	public static MirageTest INSTANCE = null;
	
	@SidedProxy(clientSide="com.elytradev.miragetest.ClientProxy", serverSide="com.elytradev.miragetest.Proxy")
	public static Proxy PROXY = null;
	
	public static final CreativeTabs TAB_MIRAGE = new CreativeTabs("Mirage Test Items") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(MirageTestBlocks.LAMP_BASIC);
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(MirageTestBlocks.class);
		MinecraftForge.EVENT_BUS.register(MirageTestItems.class);
		MinecraftForge.EVENT_BUS.register(PROXY);
		PROXY.preInit();
	}
}
