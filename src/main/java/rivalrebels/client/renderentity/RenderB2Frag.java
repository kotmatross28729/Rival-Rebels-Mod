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

import rivalrebels.client.objfileloader.ModelFromObj;
import rivalrebels.RivalRebels;
import rivalrebels.common.entity.EntityB2Frag;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderB2Frag extends Render
{
	ModelFromObj md1;
	ModelFromObj	md2;

	public RenderB2Frag()
	{
		try
		{
			md1 = ModelFromObj.readObjFile("f.obj");
			md1.scale(3, 3, 3);
			md2 = ModelFromObj.readObjFile("g.obj");
			md2.scale(3, 3, 3);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void renderB2Frag(EntityB2Frag b2spirit, double x, double y, double z, float par8, float par9)
	{
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glRotatef(b2spirit.rotationYaw, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(b2spirit.rotationPitch, 0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(RivalRebels.etb2spirit);
		GL11.glDisable(GL11.GL_CULL_FACE);
		if (b2spirit.type == 0) md1.render();
		if (b2spirit.type == 1) md2.render();
		GL11.glPopMatrix();
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then handing it off to a worker function which does the actual work. In all
	 * probabilty, the class Render is generic (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1, double d2, float f, float f1). But JAD is pre
	 * 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		renderB2Frag((EntityB2Frag) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}
}
