package onmitsu.naturalstyle.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.util.Helper;

import java.util.List;

public class ItemMonsterEnergy extends ItemDrinkBase {

	private final String[] itemTypes;
	private final String unname;

	@SideOnly(Side.CLIENT)
	private IIcon[] iconTypes;

	public ItemMonsterEnergy(String name, final String[] itemTypes)
	{
		super(name);
		this.itemTypes = itemTypes;
		this.unname = name;
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@SideOnly(Side.CLIENT)
	public void getMetaItems(Item item, CreativeTabs tab, List<ItemStack> list)
	{
		for(int type = 0; type < this.itemTypes.length; ++type)
		{
			list.add(new ItemStack(item, 1, type));
		}
	}

	public String getUnlocalizedName(ItemStack itemStack)
	{
		int type = Helper.getUseMeta(itemStack.getItemDamage(), this.itemTypes.length);
		return super.getUnlocalizedName() + "." + this.itemTypes[type];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta)
	{
		int type = Helper.getUseMeta(meta, this.itemTypes.length);
		return this.iconTypes[type];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iicon)
	{
		this.iconTypes = new IIcon[this.itemTypes.length];

		for(int i = 0; i < this.itemTypes.length; ++i)
		{
			this.iconTypes[i] = iicon.registerIcon(Reference.RESOURCES_PATH + this.unname + "/" + this.itemTypes[i]);
		}
	}

	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
	{
		player.getFoodStats().addStats(16, 50F);
		return super.onEaten(itemStack, world, player);
	}
}
