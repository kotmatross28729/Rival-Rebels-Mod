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
import rivalrebels.common.tileentity.TileEntityLaptop;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class LaptopButtonPacket implements IMessage
{
	int x;
	int y;
	int z;

	public LaptopButtonPacket()
	{

	}

	public LaptopButtonPacket(int X, int Y, int Z)
	{
		x = X;
		y = Y;
		z = Z;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
	}

	public static class Handler implements IMessageHandler<LaptopButtonPacket, IMessage>
	{
		@Override
		public IMessage onMessage(LaptopButtonPacket m, MessageContext ctx)
		{
			if (ctx.getServerHandler().playerEntity.getDistanceSq(m.x, m.y, m.z) < 100)
			{
				TileEntity te = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(m.x, m.y, m.z);
				if (te != null && te instanceof TileEntityLaptop)
				{
					((TileEntityLaptop)te).onGoButtonPressed();
				}
			}
			return null;
		}
	}
}
