package onmitsu.naturalstyle.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TagHelper {

	private static final String DATA_TAG = "naturalstyle_tag";

	public static boolean getBoolean(ItemStack itemStack, String name)
	{
		setData(itemStack);
		return getData(itemStack).getBoolean(name);
	}

	public static void setBoolean(ItemStack itemStack, String name, boolean bool)
	{
		setData(itemStack);
		getData(itemStack).setBoolean(name, bool);
	}

	public static int getInt(ItemStack itemStack, String name)
	{
		setData(itemStack);
		return getData(itemStack).getInteger(name);
	}

	public static void setInt(ItemStack itemStack, String name, int i)
	{
		setData(itemStack);
		getData(itemStack).setInteger(name, i);
	}

	public static NBTTagCompound getData(ItemStack itemStack)
	{
		setData(itemStack);
		return itemStack.getTagCompound();
	}

	private static void setData(ItemStack itemStack)
	{
		if(itemStack.getTagCompound() == null)
			itemStack.setTagCompound(new NBTTagCompound());

		if(!itemStack.getTagCompound().hasKey(DATA_TAG))
			itemStack.getTagCompound().setTag(DATA_TAG, new NBTTagCompound());
	}

}
