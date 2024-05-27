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
package rivalrebels.common.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import rivalrebels.common.tileentity.TileEntityReciever;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ADSWeaponPacket implements IMessage
{
	int x;
	int y;
	int z;
	int wep;

	public ADSWeaponPacket()
	{

	}

	public ADSWeaponPacket(int X, int Y, int Z, int w)
	{
		x = X;
		y = Y;
		z = Z;
		wep = w;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		wep = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeInt(wep);
	}

	public static class Handler implements IMessageHandler<ADSWeaponPacket, IMessage>
	{
		@Override
		public IMessage onMessage(ADSWeaponPacket m, MessageContext ctx)
		{
			TileEntity te = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(m.x, m.y, m.z);
			if (te instanceof TileEntityReciever)
			{
				TileEntityReciever ter = (TileEntityReciever) te;
				if (ter.hasWepReqs())
				{
					ter.setWep(m.wep);
				}
			}
			return null;
		}
	}
}
