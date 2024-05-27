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

public class ADSClosePacket implements IMessage
{
	int x;
	int y;
	int z;
	boolean mobs;
	boolean chip;
	boolean player;
	int range;

	public ADSClosePacket()
	{

	}

	public ADSClosePacket(int X, int Y, int Z, boolean m, boolean c, boolean p, int r)
	{
		x = X;
		y = Y;
		z = Z;
		mobs = m;
		chip = c;
		player = p;
		range = r;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		mobs = buf.readBoolean();
		chip = buf.readBoolean();
		player = buf.readBoolean();
		range = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);

		buf.writeBoolean(mobs);
		buf.writeBoolean(chip);
		buf.writeBoolean(player);
		buf.writeInt(range);
	}

	public static class Handler implements IMessageHandler<ADSClosePacket, IMessage>
	{
		@Override
		public IMessage onMessage(ADSClosePacket m, MessageContext ctx)
		{
			TileEntity te = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(m.x, m.y, m.z);
			if (te instanceof TileEntityReciever && ctx.getServerHandler().playerEntity.getDistanceSq(m.x, m.y, m.z) < 100)
			{
				TileEntityReciever ter = (TileEntityReciever) te;
				ter.kMobs = m.mobs;
				ter.kTeam = m.chip;
				ter.kPlayers = m.player;
				ter.yawLimit = m.range;
			}
			return null;
		}
	}
}
