package onmitsu.naturalstyle.item;

import java.util.HashSet;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import onmitsu.naturalstyle.common.NaturalStyle;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.util.Helper;
import onmitsu.naturalstyle.util.Lang;
import onmitsu.naturalstyle.util.TagHelper;

public class ItemHammer extends ItemTool {

	public ItemHammer(String name, ToolMaterial material)
	{
		super(2F, material, new HashSet<Block>());
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.RESOURCES_PATH + name);
		this.setCreativeTab(NaturalStyle.TAB_NATURALSTYLE);


		this.setHarvestLevel("pickaxe", material.getHarvestLevel());
		this.setHarvestLevel("shovel", material.getHarvestLevel());
		this.setHarvestLevel("axe", material.getHarvestLevel());

		Helper.addItem(this);
	}

	public void onUpdate(ItemStack itemStack, World world, Entity entity, int meta, boolean select)
	{
		if(entity.ticksExisted % 400 == 0 && itemStack.isItemDamaged())
		{
			itemStack.setItemDamage(itemStack.getItemDamage() - 1);
		}
	}

	public float getDigSpeed(ItemStack itemStack, Block block, int meta)
	{
		return block != Blocks.bedrock ? this.getEfficiency(itemStack) : 1F;
	}

	public boolean canHarvestBlock(Block block, ItemStack itemStack)
	{
		return block != Blocks.bedrock;
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(!world.isRemote && player.isSneaking())
		{
			this.toggleMode(itemStack);
			player.addChatComponentMessage(Lang.chat(Reference.CHAT_TOPIC + " " + Reference.CHAT_TRYSWITCh + " " + this.getModeName(itemStack)));
		}

		return itemStack;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean select)
	{
		if(GuiScreen.isShiftKeyDown())
		{
			list.add(Reference.INFO_FUNCTION_SWITCH);
			list.add(Reference.INFO_FUNCTION_REPAIR);
		}
		else
		{
			list.add(Reference.INFO_PRESS_SHIFT);
		}

		list.add(Reference.INFO_MODE_NOW + " " + this.getModeName(itemStack));
	}

	/* ===== HAMMER MODE ===== */

	private void toggleMode(ItemStack itemStack)
	{
		TagHelper.setInt(itemStack, "mode", this.getMode(itemStack) < 2 ? this.getMode(itemStack) + 1 : 0);
	}

	private int getMode(ItemStack itemStack)
	{
		return TagHelper.getInt(itemStack, "mode");
	}

	private String getModeName(ItemStack itemStack)
	{
		int mode = this.getMode(itemStack);

		switch(mode)
		{
			case 0 : return Reference.INFO_MODE_NORMAL;
			case 1 : return Reference.INFO_MODE_SLOW;
			case 2 : return Reference.INFO_MODE_FAST;
		}

		return null;
	}

	private int getEfficiency(ItemStack itemStack)
	{
		switch(this.getMode(itemStack))
		{
			case 0 : return 20;
			case 1 : return 8;
			case 2 : return 128;

		}

		return 0;
	}
}
