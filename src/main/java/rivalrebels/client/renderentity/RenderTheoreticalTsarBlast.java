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
package rivalrebels.client.renderentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import rivalrebels.RivalRebels;
import rivalrebels.client.model.ModelBlastSphere;
import rivalrebels.client.model.ModelTsarBlast;
import rivalrebels.common.entity.EntityTsarBlast;

public class RenderTheoreticalTsarBlast extends Render
{
	private ModelTsarBlast		model;
	private ModelBlastSphere	modelsphere;

	public RenderTheoreticalTsarBlast()
	{
		model = new ModelTsarBlast();
		modelsphere = new ModelBlastSphere();
	}

	@Override
	public void doRender(Entity var1, double x, double y, double z, float var8, float var9)
	{
		EntityTsarBlast tsar = (EntityTsarBlast) var1;
		tsar.time++;
		double radius = (((tsar.motionX * 10) - 1) * ((tsar.motionX * 10) - 1) * 2) + RivalRebels.tsarBombaStrength;
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		if (tsar.time < 60)
		{
			double elev = tsar.time / 5f;
			GL11.glTranslated(x, y + elev, z);
			modelsphere.renderModel(tsar.time * RivalRebels.shroomScale, 1, 1, 1, 1);
		}
		else if (tsar.time < 300 && radius - RivalRebels.tsarBombaStrength > 9)
		{
			double elev = (tsar.time - 60f) / 4f;
			GL11.glTranslated(x, y + elev, z);
			GL11.glScalef(RivalRebels.shroomScale,RivalRebels.shroomScale,RivalRebels.shroomScale);
			GL11.glPushMatrix();
			GL11.glRotatef((float) (elev * 2), 0, 1, 0);
			GL11.glRotatef((float) (elev * 3), 1, 0, 0);
			modelsphere.renderModel((float) elev, 1, 0.25f, 0, 1f);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glRotatef((float) (elev * -2), 0, 1, 0);
			GL11.glRotatef((float) (elev * 4), 0, 0, 1);
			modelsphere.renderModel((float) (elev - 0.2f), 1, 0.5f, 0, 1f);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glRotatef((float) (elev * -3), 1, 0, 0);
			GL11.glRotatef((float) (elev * 2), 0, 0, 1);
			modelsphere.renderModel((float) (elev - 0.4f), 1, 0, 0, 1f);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glRotatef((float) (elev * -1), 0, 1, 0);
			GL11.glRotatef((float) (elev * 3), 0, 0, 1);
			modelsphere.renderModel((float) (elev - 0.6f), 1, 1, 0, 1);
			GL11.glPopMatrix();
		}
		else
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.etblacktsar);
			GL11.glTranslated(x, y + 10 + ((tsar.motionX - 0.1d) * 14.14213562), z);
			GL11.glScalef(RivalRebels.shroomScale,RivalRebels.shroomScale,RivalRebels.shroomScale);
			GL11.glScalef((float) (radius * 0.116f), (float) (radius * 0.065f), (float) (radius * 0.116f));
			GL11.glScalef(0.8f, 0.8f, 0.8f);
			model.render();
		}
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}
}
