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
package rivalrebels;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import rivalrebels.client.blockrenderer.SteelBlockRenderer;
import rivalrebels.client.gui.GuiClass;
import rivalrebels.client.gui.GuiFlameThrower;
import rivalrebels.client.gui.GuiNextBattle;
import rivalrebels.client.gui.GuiOmegaWin;
import rivalrebels.client.gui.GuiSigmaWin;
import rivalrebels.client.gui.GuiSpawn;
import rivalrebels.client.gui.GuiTesla;
import rivalrebels.client.renderentity.RenderAntimatterBomb;
import rivalrebels.client.renderentity.RenderAntimatterBombBlast;
import rivalrebels.client.renderentity.RenderB2Frag;
import rivalrebels.client.renderentity.RenderB2Spirit;
import rivalrebels.client.renderentity.RenderB83;
import rivalrebels.client.renderentity.RenderBlood;
import rivalrebels.client.renderentity.RenderBomb;
import rivalrebels.client.renderentity.RenderBullet;
import rivalrebels.client.renderentity.RenderCuchillo;
import rivalrebels.client.renderentity.RenderDebris;
import rivalrebels.client.renderentity.RenderFlame;
import rivalrebels.client.renderentity.RenderFlameBallGreen;
import rivalrebels.client.renderentity.RenderFlameBlue;
import rivalrebels.client.renderentity.RenderFlameRedBlue;
import rivalrebels.client.renderentity.RenderGasGrenade;
import rivalrebels.client.renderentity.RenderGoo;
import rivalrebels.client.renderentity.RenderGore;
import rivalrebels.client.renderentity.RenderHackB83;
import rivalrebels.client.renderentity.RenderHotPotato;
import rivalrebels.client.renderentity.RenderLaptop;
import rivalrebels.client.renderentity.RenderLaserBurst;
import rivalrebels.client.renderentity.RenderLaserLink;
import rivalrebels.client.renderentity.RenderLightningBolt2;
import rivalrebels.client.renderentity.RenderLightningLink;
import rivalrebels.client.renderentity.RenderNuclearBlast;
import rivalrebels.client.renderentity.RenderNuke;
import rivalrebels.client.renderentity.RenderPlasmoid;
import rivalrebels.client.renderentity.RenderRhodes;
import rivalrebels.client.renderentity.RenderRhodesHead;
import rivalrebels.client.renderentity.RenderRhodesLeftLowerArm;
import rivalrebels.client.renderentity.RenderRhodesLeftLowerLeg;
import rivalrebels.client.renderentity.RenderRhodesLeftUpperArm;
import rivalrebels.client.renderentity.RenderRhodesLeftUpperLeg;
import rivalrebels.client.renderentity.RenderRhodesRightLowerArm;
import rivalrebels.client.renderentity.RenderRhodesRightLowerLeg;
import rivalrebels.client.renderentity.RenderRhodesRightUpperArm;
import rivalrebels.client.renderentity.RenderRhodesRightUpperLeg;
import rivalrebels.client.renderentity.RenderRhodesTorso;
import rivalrebels.client.renderentity.RenderRocket;
import rivalrebels.client.renderentity.RenderRoddiskLeader;
import rivalrebels.client.renderentity.RenderRoddiskOfficer;
import rivalrebels.client.renderentity.RenderRoddiskRebel;
import rivalrebels.client.renderentity.RenderRoddiskRegular;
import rivalrebels.client.renderentity.RenderRoddiskRep;
import rivalrebels.client.renderentity.RenderSeeker;
import rivalrebels.client.renderentity.RenderSphereBlast;
import rivalrebels.client.renderentity.RenderTachyonBomb;
import rivalrebels.client.renderentity.RenderTachyonBombBlast;
import rivalrebels.client.renderentity.RenderTheoreticalTsar;
import rivalrebels.client.renderentity.RenderTheoreticalTsarBlast;
import rivalrebels.client.renderentity.RenderTsar;
import rivalrebels.client.renderentity.RenderTsarBlast;
import rivalrebels.client.tileentityrender.TileEntityAntimatterBombRenderer;
import rivalrebels.client.tileentityrender.TileEntityForceFieldNodeRenderer;
import rivalrebels.client.tileentityrender.TileEntityGoreRenderer;
import rivalrebels.client.tileentityrender.TileEntityJumpBlockRenderer;
import rivalrebels.client.tileentityrender.TileEntityLaptopRenderer;
import rivalrebels.client.tileentityrender.TileEntityLoaderRenderer;
import rivalrebels.client.tileentityrender.TileEntityMeltdownRenderer;
import rivalrebels.client.tileentityrender.TileEntityNuclearBombRenderer;
import rivalrebels.client.tileentityrender.TileEntityNukeCrateRenderer;
import rivalrebels.client.tileentityrender.TileEntityOmegaObjectiveRenderer;
import rivalrebels.client.tileentityrender.TileEntityPlasmaExplosionRenderer;
import rivalrebels.client.tileentityrender.TileEntityReactorRenderer;
import rivalrebels.client.tileentityrender.TileEntityRecieverRenderer;
import rivalrebels.client.tileentityrender.TileEntitySigmaObjectiveRenderer;
import rivalrebels.client.tileentityrender.TileEntityTachyonBombRenderer;
import rivalrebels.client.tileentityrender.TileEntityTheoreticalTsarBombaRenderer;
import rivalrebels.client.tileentityrender.TileEntityTsarBombaRenderer;
import rivalrebels.common.entity.EntityAntimatterBomb;
import rivalrebels.common.entity.EntityAntimatterBombBlast;
import rivalrebels.common.entity.EntityB2Frag;
import rivalrebels.common.entity.EntityB2Spirit;
import rivalrebels.common.entity.EntityB83;
import rivalrebels.common.entity.EntityB83NoShroom;
import rivalrebels.common.entity.EntityBlood;
import rivalrebels.common.entity.EntityBloodFX;
import rivalrebels.common.entity.EntityBomb;
import rivalrebels.common.entity.EntityCuchillo;
import rivalrebels.common.entity.EntityDebris;
import rivalrebels.common.entity.EntityFlameBall;
import rivalrebels.common.entity.EntityFlameBall1;
import rivalrebels.common.entity.EntityFlameBall2;
import rivalrebels.common.entity.EntityFlameBallGreen;
import rivalrebels.common.entity.EntityGasGrenade;
import rivalrebels.common.entity.EntityGoo;
import rivalrebels.common.entity.EntityGore;
import rivalrebels.common.entity.EntityHackB83;
import rivalrebels.common.entity.EntityHotPotato;
import rivalrebels.common.entity.EntityLaptop;
import rivalrebels.common.entity.EntityLaserBurst;
import rivalrebels.common.entity.EntityLaserLink;
import rivalrebels.common.entity.EntityLightningBolt2;
import rivalrebels.common.entity.EntityLightningLink;
import rivalrebels.common.entity.EntityNuclearBlast;
import rivalrebels.common.entity.EntityNuke;
import rivalrebels.common.entity.EntityPassiveFire;
import rivalrebels.common.entity.EntityPlasmoid;
import rivalrebels.common.entity.EntityPropulsionFX;
import rivalrebels.common.entity.EntityRhodes;
import rivalrebels.common.entity.EntityRhodesHead;
import rivalrebels.common.entity.EntityRhodesLeftLowerArm;
import rivalrebels.common.entity.EntityRhodesLeftLowerLeg;
import rivalrebels.common.entity.EntityRhodesLeftUpperArm;
import rivalrebels.common.entity.EntityRhodesLeftUpperLeg;
import rivalrebels.common.entity.EntityRhodesRightLowerArm;
import rivalrebels.common.entity.EntityRhodesRightLowerLeg;
import rivalrebels.common.entity.EntityRhodesRightUpperArm;
import rivalrebels.common.entity.EntityRhodesRightUpperLeg;
import rivalrebels.common.entity.EntityRhodesTorso;
import rivalrebels.common.entity.EntityRocket;
import rivalrebels.common.entity.EntityRoddiskLeader;
import rivalrebels.common.entity.EntityRoddiskOfficer;
import rivalrebels.common.entity.EntityRoddiskRebel;
import rivalrebels.common.entity.EntityRoddiskRegular;
import rivalrebels.common.entity.EntityRoddiskRep;
import rivalrebels.common.entity.EntitySeekB83;
import rivalrebels.common.entity.EntitySphereBlast;
import rivalrebels.common.entity.EntityTachyonBomb;
import rivalrebels.common.entity.EntityTachyonBombBlast;
import rivalrebels.common.entity.EntityTheoreticalTsar;
import rivalrebels.common.entity.EntityTheoreticalTsarBlast;
import rivalrebels.common.entity.EntityTsar;
import rivalrebels.common.entity.EntityTsarBlast;
import rivalrebels.common.tileentity.TileEntityAntimatterBomb;
import rivalrebels.common.tileentity.TileEntityForceFieldNode;
import rivalrebels.common.tileentity.TileEntityGore;
import rivalrebels.common.tileentity.TileEntityJumpBlock;
import rivalrebels.common.tileentity.TileEntityLaptop;
import rivalrebels.common.tileentity.TileEntityLoader;
import rivalrebels.common.tileentity.TileEntityMeltDown;
import rivalrebels.common.tileentity.TileEntityNuclearBomb;
import rivalrebels.common.tileentity.TileEntityNukeCrate;
import rivalrebels.common.tileentity.TileEntityOmegaObjective;
import rivalrebels.common.tileentity.TileEntityPlasmaExplosion;
import rivalrebels.common.tileentity.TileEntityReactor;
import rivalrebels.common.tileentity.TileEntityReciever;
import rivalrebels.common.tileentity.TileEntitySigmaObjective;
import rivalrebels.common.tileentity.TileEntityTachyonBomb;
import rivalrebels.common.tileentity.TileEntityTheoreticalTsarBomba;
import rivalrebels.common.tileentity.TileEntityTsarBomba;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{

	@SideOnly(Side.CLIENT)
	public static void registerRenderInformation()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNukeCrate.class, new TileEntityNukeCrateRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNuclearBomb.class, new TileEntityNuclearBombRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlasmaExplosion.class, new TileEntityPlasmaExplosionRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityReactor.class, new TileEntityReactorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJumpBlock.class, new TileEntityJumpBlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLoader.class, new TileEntityLoaderRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOmegaObjective.class, new TileEntityOmegaObjectiveRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySigmaObjective.class, new TileEntitySigmaObjectiveRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTsarBomba.class, new TileEntityTsarBombaRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityForceFieldNode.class, new TileEntityForceFieldNodeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGore.class, new TileEntityGoreRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLaptop.class, new TileEntityLaptopRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityReciever.class, new TileEntityRecieverRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMeltDown.class, new TileEntityMeltdownRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTheoreticalTsarBomba.class, new TileEntityTheoreticalTsarBombaRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAntimatterBomb.class, new TileEntityAntimatterBombRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTachyonBomb.class, new TileEntityTachyonBombRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityGasGrenade.class, new RenderGasGrenade());
		RenderingRegistry.registerEntityRenderingHandler(EntityPropulsionFX.class, new RenderBullet("fire"));
		RenderingRegistry.registerEntityRenderingHandler(EntityPassiveFire.class, new RenderBullet("fire"));
		RenderingRegistry.registerEntityRenderingHandler(EntityCuchillo.class, new RenderCuchillo());
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameBall.class, new RenderFlame());
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameBall1.class, new RenderFlameRedBlue());
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameBall2.class, new RenderFlameBlue());
		RenderingRegistry.registerEntityRenderingHandler(EntityRocket.class, new RenderRocket());
		RenderingRegistry.registerEntityRenderingHandler(EntityPlasmoid.class, new RenderPlasmoid());
		RenderingRegistry.registerEntityRenderingHandler(EntityLightningLink.class, new RenderLightningLink());
		RenderingRegistry.registerEntityRenderingHandler(EntityNuclearBlast.class, new RenderNuclearBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityLightningBolt2.class, new RenderLightningBolt2());
		RenderingRegistry.registerEntityRenderingHandler(EntityLaptop.class, new RenderLaptop());
		RenderingRegistry.registerEntityRenderingHandler(EntityRoddiskRegular.class, new RenderRoddiskRegular());
		RenderingRegistry.registerEntityRenderingHandler(EntityRoddiskRebel.class, new RenderRoddiskRebel());
		RenderingRegistry.registerEntityRenderingHandler(EntityRoddiskOfficer.class, new RenderRoddiskOfficer());
		RenderingRegistry.registerEntityRenderingHandler(EntityRoddiskLeader.class, new RenderRoddiskLeader());
		RenderingRegistry.registerEntityRenderingHandler(EntityTsarBlast.class, new RenderTsarBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityLaserLink.class, new RenderLaserLink());
		RenderingRegistry.registerEntityRenderingHandler(EntityGore.class, new RenderGore());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlood.class, new RenderBlood());
		RenderingRegistry.registerEntityRenderingHandler(EntityGoo.class, new RenderGoo());
		RenderingRegistry.registerEntityRenderingHandler(EntityLaserBurst.class, new RenderLaserBurst());
		RenderingRegistry.registerEntityRenderingHandler(EntityB83.class, new RenderB83());
		RenderingRegistry.registerEntityRenderingHandler(EntityB2Spirit.class, new RenderB2Spirit());
		RenderingRegistry.registerEntityRenderingHandler(EntityB2Frag.class, new RenderB2Frag());
		RenderingRegistry.registerEntityRenderingHandler(EntityDebris.class, new RenderDebris());
		RenderingRegistry.registerEntityRenderingHandler(EntityHackB83.class, new RenderHackB83());
		RenderingRegistry.registerEntityRenderingHandler(EntitySeekB83.class, new RenderSeeker());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodes.class, new RenderRhodes());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodesHead.class, new RenderRhodesHead());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodesTorso.class, new RenderRhodesTorso());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodesLeftUpperArm.class, new RenderRhodesLeftUpperArm());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodesRightUpperArm.class, new RenderRhodesRightUpperArm());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodesLeftLowerArm.class, new RenderRhodesLeftLowerArm());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodesRightLowerArm.class, new RenderRhodesRightLowerArm());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodesLeftUpperLeg.class, new RenderRhodesLeftUpperLeg());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodesRightUpperLeg.class, new RenderRhodesRightUpperLeg());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodesLeftLowerLeg.class, new RenderRhodesLeftLowerLeg());
		RenderingRegistry.registerEntityRenderingHandler(EntityRhodesRightLowerLeg.class, new RenderRhodesRightLowerLeg());
		RenderingRegistry.registerEntityRenderingHandler(EntityB83NoShroom.class, new RenderB83());
		RenderingRegistry.registerEntityRenderingHandler(EntitySphereBlast.class, new RenderSphereBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityNuke.class, new RenderNuke());
		RenderingRegistry.registerEntityRenderingHandler(EntityTsar.class, new RenderTsar());
		RenderingRegistry.registerEntityRenderingHandler(EntityRoddiskRep.class, new RenderRoddiskRep());
		RenderingRegistry.registerEntityRenderingHandler(EntityHotPotato.class, new RenderHotPotato());
		RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new RenderBomb());
		RenderingRegistry.registerEntityRenderingHandler(EntityTheoreticalTsar.class, new RenderTheoreticalTsar());
		RenderingRegistry.registerEntityRenderingHandler(EntityTheoreticalTsarBlast.class, new RenderTheoreticalTsarBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameBallGreen.class, new RenderFlameBallGreen());
		RenderingRegistry.registerEntityRenderingHandler(EntityAntimatterBomb.class, new RenderAntimatterBomb());
		RenderingRegistry.registerEntityRenderingHandler(EntityAntimatterBombBlast.class, new RenderAntimatterBombBlast());
		RenderingRegistry.registerEntityRenderingHandler(EntityTachyonBomb.class, new RenderTachyonBomb());
		RenderingRegistry.registerEntityRenderingHandler(EntityTachyonBombBlast.class, new RenderTachyonBombBlast());
		RenderingRegistry.registerBlockHandler(new SteelBlockRenderer());
	}

	@Override
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

	@Override
	public void closeGui()
	{
		Minecraft.getMinecraft().displayGuiScreen(null);
	}

	@Override
	public void nextBattle()
	{
		Minecraft.getMinecraft().displayGuiScreen(new GuiNextBattle());
	}

	@Override
	public void teamWin(boolean winner)
	{
		Minecraft.getMinecraft().displayGuiScreen(winner?new GuiOmegaWin():new GuiSigmaWin());
	}

	@Override
	public void guiClass()
	{
		Minecraft.getMinecraft().displayGuiScreen(new GuiClass(RivalRebels.round.rrplayerlist.getForName(Minecraft.getMinecraft().thePlayer.getCommandSenderName()).rrclass));
	}

	@Override
	public void guiSpawn()
	{
		Minecraft.getMinecraft().displayGuiScreen(new GuiSpawn(RivalRebels.round.rrplayerlist.getForName(Minecraft.getMinecraft().thePlayer.getCommandSenderName()).rrclass));
	}

	@Override
	public void flamethrowerGui(int i)
	{
		Minecraft.getMinecraft().displayGuiScreen(new GuiFlameThrower(i));
	}

	@Override
	public void teslaGui(int i)
	{
		Minecraft.getMinecraft().displayGuiScreen(new GuiTesla(i));
	}

	@Override
	public void spawnGore(World world, EntityGore g, boolean greenblood)
	{
		Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBloodFX(world, g, !greenblood));
	}

	@Override
	public boolean spacebar()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_SPACE) && Minecraft.getMinecraft().currentScreen == null;
	}
	@Override
	public boolean w()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_W) && Minecraft.getMinecraft().currentScreen == null;
	}
	@Override
	public boolean a()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_A) && Minecraft.getMinecraft().currentScreen == null;
	}
	@Override
	public boolean s()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_X) && Minecraft.getMinecraft().currentScreen == null;
	}
	@Override
	public boolean d()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_D) && Minecraft.getMinecraft().currentScreen == null;
	}
	@Override
	public boolean f()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_F) && Minecraft.getMinecraft().currentScreen == null;
	}
	boolean prevc = false;
	public boolean c()
	{
		boolean isdown = Keyboard.isKeyDown(Keyboard.KEY_C) && Minecraft.getMinecraft().currentScreen == null;
		boolean x = (prevc==false) && (isdown==true);
		prevc = isdown;
		return x;
	}
	boolean prevx = false;
	@Override
	public boolean x()
	{
		boolean isdown = Keyboard.isKeyDown(Keyboard.KEY_S) && Minecraft.getMinecraft().currentScreen == null;
		boolean x = (prevx==false) && (isdown==true);
		prevx = isdown;
		return x;
	}
	@Override
	public boolean z()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_Z) && Minecraft.getMinecraft().currentScreen == null;
	}
	public boolean g()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_G) && Minecraft.getMinecraft().currentScreen == null;
	}


	@Override
	public void setOverlay(EntityRhodes rhodes)
	{
		if (rhodes.rider == Minecraft.getMinecraft().thePlayer)
		{
			RivalRebels.rrro.counter = 10;
			RivalRebels.rrro.rhodes = rhodes;
		}
	}
}
