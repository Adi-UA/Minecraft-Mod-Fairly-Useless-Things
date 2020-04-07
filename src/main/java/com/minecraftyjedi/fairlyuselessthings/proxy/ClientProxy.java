package com.minecraftyjedi.fairlyuselessthings.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * This is the mod's ClientProxy.
 */
public class ClientProxy extends CommonProxy {

	/**
	 * Register models for the item sent. We only care about baking models on the
	 * client side.
	 */
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

}
