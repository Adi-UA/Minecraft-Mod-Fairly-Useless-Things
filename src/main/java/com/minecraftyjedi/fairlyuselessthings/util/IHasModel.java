package com.minecraftyjedi.fairlyuselessthings.util;

/**
 * Classes that plan to register models should implement this interface. Look at
 * the BlockBase and ItemBase classes to see how this method is overridden if
 * you need to override it in a class of your own.
 */
public interface IHasModel {

	public void registerModels();
}
