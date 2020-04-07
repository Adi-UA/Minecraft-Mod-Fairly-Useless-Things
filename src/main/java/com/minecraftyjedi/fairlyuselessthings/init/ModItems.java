package com.minecraftyjedi.fairlyuselessthings.init;

import java.util.ArrayList;
import java.util.List;

import com.minecraftyjedi.fairlyuselessthings.items.ItemBase;
import com.minecraftyjedi.fairlyuselessthings.items.tools.ToolAxe;
import com.minecraftyjedi.fairlyuselessthings.items.tools.ToolPickaxe;
import com.minecraftyjedi.fairlyuselessthings.items.tools.ToolSword;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	// Defining materials to make the tools out of.
	public static final ToolMaterial MATERIAL_HALLOW = EnumHelper.addToolMaterial("material_hallow", 5, 5000, 30.0F,
			76.0F, 35);
	public static final ToolMaterial MATERIAL_CURSE = EnumHelper.addToolMaterial("material_curse", 5, 5000, 30.0F,
			91.0F, 0);

	// Shards are obtained from ore blocks.
	public static final Item HALLOW_SHARD = new ItemBase("hallow_shard");
	public static final Item CURSE_SHARD = new ItemBase("curse_shard");

	// Swords
	public static final ItemSword HALLOWED_SWORD = new ToolSword("hallowed_sword", MATERIAL_HALLOW);
	public static final ItemSword CURSED_SWORD = new ToolSword("cursed_sword", MATERIAL_CURSE);

	// Pickaxes
	public static final ItemPickaxe HALLOWED_PICKAXE = new ToolPickaxe("hallowed_pickaxe", MATERIAL_HALLOW);
	public static final ItemPickaxe CURSED_PICKAXE = new ToolPickaxe("cursed_pickaxe", MATERIAL_CURSE);

	// Axes
	public static final ItemAxe HALLOWED_AXE = new ToolAxe("hallowed_axe", MATERIAL_HALLOW);
	public static final ItemAxe CURSED_AXE = new ToolAxe("cursed_axe", MATERIAL_CURSE);
}
