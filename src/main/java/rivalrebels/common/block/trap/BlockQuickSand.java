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
package rivalrebels.common.block.trap;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import rivalrebels.RivalRebels;
import rivalrebels.common.core.RivalRebelsSoundPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockQuickSand extends Block
{
	public BlockQuickSand()
	{
		super(Material.ground);
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		par5Entity.fallDistance = 0.0F;
		par5Entity.motionY = par5Entity.motionY * 0.005;
		if (par1World.rand.nextFloat() > 0.95) RivalRebelsSoundPlayer.playSound(par1World, 20, 0, par2, par3, par4, 0.2f);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		if (this == RivalRebels.quicksand)
		{
			return Blocks.grass.getBlockColor();
		}
		return 0xFFFFFF;
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Returns the color this block should be rendered. Used by leaves.
	 */
	public int getRenderColor(int par1)
	{
		if (this == RivalRebels.quicksand)
		{
			return Blocks.grass.getRenderColor(par1);
		}
		return 0xFFFFFF;
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
	 * when first determining what to render.
	 */
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		if (this == RivalRebels.quicksand)
		{
			return Blocks.grass.colorMultiplier(par1IBlockAccess, par2, par3, par4);
		}
		return 0xFFFFFF;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int i)
	{
		return null;
	}

	@Override
	public Item getItemDropped(int i, Random r, int j)
	{
		return Item.getItemFromBlock(RivalRebels.aquicksand);
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}

	@Override
	public final IIcon getIcon(IBlockAccess world, int x, int y, int z, int s)
	{
		if (this == RivalRebels.quicksand) return Blocks.grass.getIcon(world, x, y, z, s);
		Block[] n = new Block[6];
		n[0] = world.getBlock(x + 1, y, z);
		n[1] = world.getBlock(x - 1, y, z);
		n[2] = world.getBlock(x, y + 1, z);
		n[3] = world.getBlock(x, y - 1, z);
		n[4] = world.getBlock(x, y, z + 1);
		n[5] = world.getBlock(x, y, z - 1);

		int popularity1 = 0;
		int popularity2 = 0;
		Block mode = Blocks.sand;
		Block array_item = null;
		for (int i = 0; i < 6; i++)
		{
			array_item = n[i];
			if (array_item == null || !array_item.isOpaqueCube() || array_item == RivalRebels.landmine || array_item == RivalRebels.alandmine || array_item == RivalRebels.mario || array_item == RivalRebels.amario || array_item == RivalRebels.quicksand || array_item == RivalRebels.aquicksand) continue;
			for (int j = 0; j < n.length; j++)
			{
				if (array_item == n[j]) popularity1++;
				if (popularity1 >= popularity2)
				{
					mode = array_item;
					popularity2 = popularity1;
				}
			}
			popularity1 = 0;
		}
		return mode.getIcon(world, x, y, z, s);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		Block[] n = new Block[6];
		n[0] = world.getBlock(x + 1, y, z);
		n[1] = world.getBlock(x - 1, y, z);
		n[2] = world.getBlock(x, y + 1, z);
		n[3] = world.getBlock(x, y - 1, z);
		n[4] = world.getBlock(x, y, z + 1);
		n[5] = world.getBlock(x, y, z - 1);

		int popularity1 = 0;
		int popularity2 = 0;
		Block mode = Blocks.sand;
		Block array_item = null;
		for (int i = 0; i < 6; i++)
		{
			array_item = n[i];
			if (array_item == null || !array_item.isOpaqueCube() || array_item == RivalRebels.landmine || array_item == RivalRebels.alandmine || array_item == RivalRebels.mario || array_item == RivalRebels.amario || array_item == RivalRebels.quicksand || array_item == RivalRebels.aquicksand) continue;
			for (int j = 0; j < n.length; j++)
			{
				if (array_item == n[j]) popularity1++;
				if (popularity1 >= popularity2)
				{
					mode = array_item;
					popularity2 = popularity1;
				}
			}
			popularity1 = 0;
		}
		if (mode == Blocks.grass) world.setBlock(x, y, z, RivalRebels.quicksand);
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player)
    {
        return new ItemStack(RivalRebels.aquicksand);
    }

	@Override
	public final IIcon getIcon(int side, int meta)
	{
		if (this == RivalRebels.aquicksand)
		{
			return Blocks.sand.getIcon(side, meta);
		}
		else
		{
			return Blocks.grass.getIcon(side, meta);
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister iconregister)
	{

	}
}
