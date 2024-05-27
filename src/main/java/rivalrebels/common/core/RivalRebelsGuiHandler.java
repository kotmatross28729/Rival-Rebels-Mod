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
package rivalrebels.common.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import rivalrebels.client.gui.GuiAntimatterBomb;
import rivalrebels.client.gui.GuiLaptop;
import rivalrebels.client.gui.GuiLoader;
import rivalrebels.client.gui.GuiNuclearBomb;
import rivalrebels.client.gui.GuiReactor;
import rivalrebels.client.gui.GuiTachyonBomb;
import rivalrebels.client.gui.GuiTheoreticalTsar;
import rivalrebels.client.gui.GuiTray;
import rivalrebels.client.gui.GuiTsar;
import rivalrebels.common.container.ContainerAntimatterBomb;
import rivalrebels.common.container.ContainerLaptop;
import rivalrebels.common.container.ContainerLoader;
import rivalrebels.common.container.ContainerNuclearBomb;
import rivalrebels.common.container.ContainerReactor;
import rivalrebels.common.container.ContainerReciever;
import rivalrebels.common.container.ContainerTachyonBomb;
import rivalrebels.common.container.ContainerTheoreticalTsar;
import rivalrebels.common.container.ContainerTsar;
import rivalrebels.common.tileentity.TileEntityAntimatterBomb;
import rivalrebels.common.tileentity.TileEntityLaptop;
import rivalrebels.common.tileentity.TileEntityLoader;
import rivalrebels.common.tileentity.TileEntityNuclearBomb;
import rivalrebels.common.tileentity.TileEntityReactor;
import rivalrebels.common.tileentity.TileEntityReciever;
import rivalrebels.common.tileentity.TileEntityTachyonBomb;
import rivalrebels.common.tileentity.TileEntityTheoreticalTsarBomba;
import rivalrebels.common.tileentity.TileEntityTsarBomba;
import cpw.mods.fml.common.network.IGuiHandler;

public class RivalRebelsGuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityTsarBomba)
		{
			return new ContainerTsar(player.inventory, (TileEntityTsarBomba) tileEntity);
		}
		if (tileEntity instanceof TileEntityAntimatterBomb)
		{
			return new ContainerAntimatterBomb(player.inventory, (TileEntityAntimatterBomb) tileEntity);
		}
		if (tileEntity instanceof TileEntityTachyonBomb)
		{
			return new ContainerTachyonBomb(player.inventory, (TileEntityTachyonBomb) tileEntity);
		}
		if (tileEntity instanceof TileEntityTheoreticalTsarBomba)
		{
			return new ContainerTheoreticalTsar(player.inventory, (TileEntityTheoreticalTsarBomba) tileEntity);
		}
		if (tileEntity instanceof TileEntityNuclearBomb)
		{
			return new ContainerNuclearBomb(player.inventory, (TileEntityNuclearBomb) tileEntity);
		}
		if (tileEntity instanceof TileEntityLoader)
		{
			return new ContainerLoader(player.inventory, (TileEntityLoader) tileEntity);
		}
		if (tileEntity instanceof TileEntityReactor)
		{
			return new ContainerReactor(player.inventory, (TileEntityReactor) tileEntity);
		}
		if (tileEntity instanceof TileEntityLaptop)
		{
			return new ContainerLaptop(player.inventory, (TileEntityLaptop) tileEntity);
		}
		if (tileEntity instanceof TileEntityReciever)
		{
			return new ContainerReciever(player.inventory, (TileEntityReciever) tileEntity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityTsarBomba)
		{
			return new GuiTsar(player.inventory, (TileEntityTsarBomba) tileEntity);
		}
		if (tileEntity instanceof TileEntityAntimatterBomb)
		{
			return new GuiAntimatterBomb(player.inventory, (TileEntityAntimatterBomb) tileEntity);
		}
		if (tileEntity instanceof TileEntityTachyonBomb)
		{
			return new GuiTachyonBomb(player.inventory, (TileEntityTachyonBomb) tileEntity);
		}
		if (tileEntity instanceof TileEntityTheoreticalTsarBomba)
		{
			return new GuiTheoreticalTsar(player.inventory, (TileEntityTheoreticalTsarBomba) tileEntity);
		}
		if (tileEntity instanceof TileEntityNuclearBomb)
		{
			return new GuiNuclearBomb(player.inventory, (TileEntityNuclearBomb) tileEntity);
		}
		if (tileEntity instanceof TileEntityLoader)
		{
			return new GuiLoader(player.inventory, (TileEntityLoader) tileEntity);
		}
		if (tileEntity instanceof TileEntityReactor)
		{
			return new GuiReactor(player.inventory, (TileEntityReactor) tileEntity);
		}
		if (tileEntity instanceof TileEntityLaptop)
		{
			return new GuiLaptop(player.inventory, (TileEntityLaptop) tileEntity);
		}
		if (tileEntity instanceof TileEntityReciever)
		{
			return new GuiTray(player.inventory, (TileEntityReciever) tileEntity);
		}
		return null;
	}
}
