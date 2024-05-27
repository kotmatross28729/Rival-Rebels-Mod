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
import net.minecraft.client.Minecraft;
import rivalrebels.RivalRebels;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class GuiSpawnPacket implements IMessage
{
	@Override
	public void fromBytes(ByteBuf buf)
	{

	}

	@Override
	public void toBytes(ByteBuf buf)
	{

	}

	public static class Handler implements IMessageHandler<GuiSpawnPacket, IMessage>
	{
		@Override
		public IMessage onMessage(GuiSpawnPacket m, MessageContext ctx)
		{
			if (RivalRebels.round.rrplayerlist.getForName(Minecraft.getMinecraft().thePlayer.getCommandSenderName()).isreset) RivalRebels.proxy.guiClass();
			else RivalRebels.proxy.guiSpawn();
			return null;
		}
	}
}
