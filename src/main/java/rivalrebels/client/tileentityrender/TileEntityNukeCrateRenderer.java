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
package rivalrebels.client.tileentityrender;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import rivalrebels.RivalRebels;
import rivalrebels.client.model.ModelNukeCrate;
import rivalrebels.common.tileentity.TileEntityNukeCrate;

public class TileEntityNukeCrateRenderer extends TileEntitySpecialRenderer
{
	private ModelNukeCrate	model;

	public TileEntityNukeCrateRenderer()
	{
		model = new ModelNukeCrate();
	}

	public void renderAModelAt(TileEntityNukeCrate tile, double d, double d1, double d2, float f)
	{
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 0.5F, (float) d2 + 0.5F);
		int metadata = tile.getBlockMetadata();
		if (metadata == 0)
		{
			GL11.glRotatef(180, 1, 0, 0);
		}

		if (metadata == 2)
		{
			GL11.glRotatef(-90, 1, 0, 0);
		}

		if (metadata == 3)
		{
			GL11.glRotatef(90, 1, 0, 0);
		}

		if (metadata == 4)
		{
			GL11.glRotatef(90, 0, 0, 1);
		}

		if (metadata == 5)
		{
			GL11.glRotatef(-90, 0, 0, 1);
		}
		if (tile.getWorldObj().getBlock(tile.xCoord, tile.yCoord, tile.zCoord) == RivalRebels.nukeCrateBottom) Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.btnukebottom);
		if (tile.getWorldObj().getBlock(tile.xCoord, tile.yCoord, tile.zCoord) == RivalRebels.nukeCrateTop) Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.btnuketop);
		model.renderModelA();
		Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.btcrate);
		model.renderModelB();
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
	{
		renderAModelAt((TileEntityNukeCrate) tileentity, d, d1, d2, f);
	}
}
