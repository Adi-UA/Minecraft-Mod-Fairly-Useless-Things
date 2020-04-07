package com.minecraftyjedi.fairlyuselessthings.util.handlers;

import com.minecraftyjedi.fairlyuselessthings.init.ModBlocks;
import com.minecraftyjedi.fairlyuselessthings.init.ModItems;
import com.minecraftyjedi.fairlyuselessthings.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * This class uses the Forge EVENT_BUS to initialize the mod items, blocks and
 * models (client side). All the register methods cycle through the necessary
 * static arrays, so they DO NOT need to be modified. This class probably
 * doesn't need to be changed unless we want to handle some other event from the
 * EVENT_BUS.
 *
 */
@EventBusSubscriber
public class RegistryHandler {

	/**
	 * Registers the mod's items into Minecraft.
	 */
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {

		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}

	/**
	 * Registers the mod's blocks into Minecraft.
	 */
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {

		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}

	/**
	 * Registers the mod's block and item models into Minecraft. This is called on
	 * the client side.
	 */
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {

		for (Item item : ModItems.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel) item).registerModels();

			}
		}

		for (Block block : ModBlocks.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel) block).registerModels();

			}
		}

	}

}
