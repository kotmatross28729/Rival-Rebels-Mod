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
package rivalrebels.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import rivalrebels.RivalRebels;

public class ItemRodHydrogen extends ItemRod
{
	public ItemRodHydrogen()
	{
		super();
		maxStackSize = 1;
		power = 250000;
		this.setMaxDamage(32);
		setCreativeTab(RivalRebels.rralltab);
	}

	@Override
	public boolean isItemTool(ItemStack is)
	{
		return true;
	}

	@Override
	public boolean isDamageable()
	{
		return true;
	}

	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("RivalRebels:au");
	}
}
