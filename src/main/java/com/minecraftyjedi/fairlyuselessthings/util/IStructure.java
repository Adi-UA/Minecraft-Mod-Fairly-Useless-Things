package com.minecraftyjedi.fairlyuselessthings.util;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.common.FMLCommonHandler;

public interface IStructure {

	public static final WorldServer WORLD_SERVER = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(0);
	public static final PlacementSettings SETTINGS = (new PlacementSettings()).setChunk(null).setIgnoreEntities(false)
			.setIgnoreStructureBlock(false).setMirror(Mirror.NONE).setRotation(Rotation.NONE);
}
