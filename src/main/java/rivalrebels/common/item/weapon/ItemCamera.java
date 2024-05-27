/*******************************************************************************
 * Copyright (c) 2012, 2016 Rodol Phito.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Mozilla Public License Version 2.0
 * which accompanies this distribution, and is available at
 * https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Rival Rebels Mod. All code, art, and design by Rodol Phito.
 *
 * http://RivalRebels.com/
 *******************************************************************************/
package rivalrebels.common.item.weapon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import rivalrebels.RivalRebels;

public class ItemCamera extends ItemArmor
{
	public ItemCamera()
	{
		super(ArmorMaterial.CHAIN, 0, 0);
		maxStackSize = 1;
		setCreativeTab(RivalRebels.rralltab);
	}

	float	zoom		= 30f;
	float 	fovset		= 0f;
	float	senset		= 0f;
	boolean prevheld = false;
	boolean bkey = false;
	public static boolean zoomed = false;
	@Override
	public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack)
	{
		if (world.isRemote)
		{
			if (entity == Minecraft.getMinecraft().thePlayer)
			{
				boolean key = Keyboard.isKeyDown(Keyboard.KEY_B) && Minecraft.getMinecraft().currentScreen == null;
				if (key != bkey && key) zoomed = !zoomed;
				bkey = key;
				if (zoomed)
				{
					if (!prevheld)
					{
						fovset = Minecraft.getMinecraft().gameSettings.fovSetting;
						senset = Minecraft.getMinecraft().gameSettings.mouseSensitivity;
						//Minecraft.getMinecraft().gameSettings.smoothCamera = true;
					}
					zoom += (Mouse.getEventDWheel() * 0.01f);
					if (zoom < 10) zoom = 10;
					if (zoom > 67) zoom = 67;
					Minecraft.getMinecraft().gameSettings.hideGUI = true;
					Minecraft.getMinecraft().gameSettings.fovSetting = zoom + (Minecraft.getMinecraft().gameSettings.fovSetting - zoom) * 0.85f;
					Minecraft.getMinecraft().gameSettings.mouseSensitivity = senset * MathHelper.sqrt_float(zoom) * 0.1f;
				}
				else
				{
					if (prevheld)
					{
						Minecraft.getMinecraft().gameSettings.fovSetting = fovset;
						Minecraft.getMinecraft().gameSettings.mouseSensitivity = senset;
						Minecraft.getMinecraft().gameSettings.hideGUI = false;
						//Minecraft.getMinecraft().gameSettings.smoothCamera = false;
					}
				}
				prevheld = zoomed;
			}
		}
	}

	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("RivalRebels:bi");
	}
}
