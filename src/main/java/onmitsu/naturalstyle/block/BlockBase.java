package onmitsu.naturalstyle.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import onmitsu.naturalstyle.common.NaturalStyle;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.util.Helper;

import java.util.List;

public class BlockBase extends Block {

	BlockBase(String name, Material material)
	{
		super(material);
		this.setBlockName(name);
		this.setCreativeTab(NaturalStyle.TAB_NATURALSTYLE);
		this.setBlockTextureName(Reference.RESOURCES_PATH + name);
	}

	void setGeneralProperty(SoundType sound, float hardness, float resistance)
	{
		this.setStepSound(sound);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}

	public BlockBase register()
	{
		return this.register(ItemBlock.class);
	}

	public BlockBase register(Class<? extends ItemBlock> cls)
	{
		Helper.addBlock(this, cls);
		return this;
	}

	/**
	 * 0,  DOWN <br>
	 * 1,  UP <br>
	 * 2,  NORTH <br>
	 * 3,  SOUTH <br>
	 * 4,  WEST <br>
	 * 5,  EAST
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return this.blockIcon;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Deprecated
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		this.getMetaBlocks(item, tab, list);
	}

	/** getSubBlocks ==> */
	public void getMetaBlocks(Item item, CreativeTabs tab, List<ItemStack> list)
	{
		list.add(new ItemStack(item, 1, 0));
	}

	@Deprecated
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		return this.onBlockRightClick(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	/** onBlockActivated ==> */
	public boolean onBlockRightClick(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		return false;
	}

}
