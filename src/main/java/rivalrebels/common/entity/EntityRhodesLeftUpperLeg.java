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

import net.minecraft.world.World;

public class EntityRhodesLeftUpperLeg extends EntityRhodesPiece
{
	public EntityRhodesLeftUpperLeg(World w)
	{
		super(w);
	}

	public EntityRhodesLeftUpperLeg(World w, double x, double y, double z, float scale, int color)
	{
		super(w, x, y, z, scale, color);
		health = 600;
	}

	@Override
	public int getMaxAge()
	{
		return 700;
	}
}
