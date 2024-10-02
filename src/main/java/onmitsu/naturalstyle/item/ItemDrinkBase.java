package onmitsu.naturalstyle.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDrinkBase extends ItemBase {

	/** Default potion is 32*/
	private final int drinkSpeed;

	public ItemDrinkBase(String name, int speed)
	{
		super(name);
		this.drinkSpeed = speed;
	}

	public ItemDrinkBase(String name)
	{
		this(name, 16);
	}

	public int getMaxItemUseDuration(ItemStack itemStack)
	{
		return this.drinkSpeed;
	}

	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(!player.capabilities.isCreativeMode)
		{
			--itemStack.stackSize;
		}
		return itemStack;
	}

	public EnumAction getItemUseAction(ItemStack itemStack)
	{
		return EnumAction.drink;
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		return itemStack;
	}
}
