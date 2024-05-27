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
package rivalrebels.common.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import rivalrebels.RivalRebels;
import rivalrebels.common.core.RivalRebelsSoundPlayer;

public class EntityRhodesHead extends EntityRhodesPiece
{
	public EntityRhodesHead(World w)
	{
		super(w);
	}

	public EntityRhodesHead(World w, double x, double y, double z, float scale, int color)
	{
		super(w, x, y, z, scale, color);
		health = 700;
	}

	@Override
	public int getMaxAge()
	{
		return 3000;
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
        setBeenAttacked();
		if (!isDead && !worldObj.isRemote)
		{
			health -= par2;
			if (health <= 0)
			{
				setDead();
				worldObj.spawnEntityInWorld(new EntityItem(worldObj, posX, posY, posZ, new ItemStack(RivalRebels.nuclearelement, 4)));
				worldObj.spawnEntityInWorld(new EntityItem(worldObj, posX, posY, posZ, new ItemStack(RivalRebels.core3, 1)));
				worldObj.spawnEntityInWorld(new EntityItem(worldObj, posX, posY, posZ, new ItemStack(RivalRebels.einsten, 1)));
				if (rand.nextBoolean())
				{
					worldObj.spawnEntityInWorld(new EntityItem(worldObj, posX, posY, posZ, new ItemStack(RivalRebels.buildrhodes, 1)));
				}
				RivalRebelsSoundPlayer.playSound(this, 0, 0, 30, 1);
			}
		}

		return true;
	}
}
