package com.minecraftyjedi.fairlyuselessthings.init;

import java.util.ArrayList;
import java.util.List;

import com.minecraftyjedi.fairlyuselessthings.items.ItemBase;
import com.minecraftyjedi.fairlyuselessthings.items.armor.ArmorBase;
import com.minecraftyjedi.fairlyuselessthings.items.tools.ToolAxe;
import com.minecraftyjedi.fairlyuselessthings.items.tools.ToolPickaxe;
import com.minecraftyjedi.fairlyuselessthings.items.tools.ToolSword;
import com.minecraftyjedi.fairlyuselessthings.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	// Tool Materials
	public static final ToolMaterial MATERIAL_HALLOW = EnumHelper.addToolMaterial("material_hallow", 5, 5000, 30.0F,
			76.0F, 35);
	public static final ToolMaterial MATERIAL_CURSE = EnumHelper.addToolMaterial("material_curse", 5, 5000, 30.0F,
			91.0F, 0);

	// Armour Material
	public static final ArmorMaterial ARMOR_MATERIAL_HALLOW = EnumHelper.addArmorMaterial("armor_material_hallow",
			Reference.MOD_ID + ":hallow", 15, new int[] { 7, 14, 20, 7 }, 35, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			0.0F);
	public static final ArmorMaterial ARMOR_MATERIAL_CURSE = EnumHelper.addArmorMaterial("armor_material_curse",
			Reference.MOD_ID + ":curse", 15, new int[] { 8, 17, 24, 8 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);

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

	// Armor;
	public static final Item HALLOWED_CHESTPLATE = new ArmorBase("hallowed_chestplate", ARMOR_MATERIAL_HALLOW, 1,
			EntityEquipmentSlot.CHEST);
	public static final Item HALLOWED_LEGGINGS = new ArmorBase("hallowed_leggings", ARMOR_MATERIAL_HALLOW, 2,
			EntityEquipmentSlot.LEGS);
	public static final Item HALLOWED_BOOTS = new ArmorBase("hallowed_boots", ARMOR_MATERIAL_HALLOW, 1,
			EntityEquipmentSlot.FEET);
	public static final Item CURSED_CHESTPLATE = new ArmorBase("cursed_chestplate", ARMOR_MATERIAL_CURSE, 1,
			EntityEquipmentSlot.CHEST);
	public static final Item CURSED_LEGGINGS = new ArmorBase("cursed_leggings", ARMOR_MATERIAL_CURSE, 2,
			EntityEquipmentSlot.LEGS);
	public static final Item CURSED_BOOTS = new ArmorBase("cursed_boots", ARMOR_MATERIAL_CURSE, 1,
			EntityEquipmentSlot.FEET);
}
