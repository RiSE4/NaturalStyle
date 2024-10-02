package onmitsu.naturalstyle.item;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.entity.EntityWind;

import java.util.List;

public class ItemSensu extends ItemBase {

	public ItemSensu(String name)
	{
		super(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(200);
		this.register();
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		itemStack.damageItem(1, player);
		EntityWind wind = new EntityWind(world, player);
		world.spawnEntityInWorld(wind);
		return itemStack;
	}

	public void onUpdate(ItemStack itemStack, World world, Entity entity, int meta, boolean select)
	{
		if(entity.ticksExisted % 400 == 0 && itemStack.isItemDamaged())
		{
			itemStack.setItemDamage(itemStack.getItemDamage() - 1);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean select)
	{
		if(GuiScreen.isShiftKeyDown())
		{
//			list.add(Reference.INFO_FUNCTION_SWITCH);
			list.add(Reference.INFO_FUNCTION_REPAIR);
		}
		else
		{
			list.add(Reference.INFO_PRESS_SHIFT);
		}
	}
}
