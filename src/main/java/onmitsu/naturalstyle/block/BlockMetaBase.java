package onmitsu.naturalstyle.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockMetaBase extends BlockBase {

	private final String[] blockTypes = this.getTypeNames();

	@SideOnly(Side.CLIENT)
	protected IIcon[] iconTypes;

	BlockMetaBase(String name, Material material)
	{
		super(name, material);
	}

	@SideOnly(Side.CLIENT)
	public void getMetaBlocks(Item item, CreativeTabs tab, List<ItemStack> list)
	{
		for(int type = 0; type < blockTypes.length; ++type)
		{
			list.add(new ItemStack(this, 1, type));
		}
	}

	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}

	public abstract String[] getTypeNames();

	/**
	 * 破壊した際にドロップするアイテムの量を決める
	 */
	public abstract int quantityDropped(int meta, int fortune, Random random);

	/**
	 * 破壊した際にドロップするアイテムのメタ値を決める
	 */
	public abstract int damageDropped(int meta);


	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return this.iconTypes[meta];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		return this.iconTypes[meta];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iicon)
	{
		this.iconTypes = new IIcon[blockTypes.length];
		int count = 0;

		for(String name : blockTypes)
		{
			this.iconTypes[count++] = iicon.registerIcon(this.getTextureName() + "." + name);
		}
	}
}
