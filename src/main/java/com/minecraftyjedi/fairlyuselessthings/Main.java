package com.minecraftyjedi.fairlyuselessthings;

import com.minecraftyjedi.fairlyuselessthings.proxy.CommonProxy;
import com.minecraftyjedi.fairlyuselessthings.util.Reference;
import com.minecraftyjedi.fairlyuselessthings.world.ModWorldGen;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This is the mod's main entry point. Another relevant entry point is the
 * RegistryHandler class. This class will only rarely need to be modified, if at
 * all.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	// Handlers for various stages of initialization.

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3); // Generates the mod's ores
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {

	}
}
