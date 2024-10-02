package onmitsu.naturalstyle.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import onmitsu.naturalstyle.util.Lang;

public class ItemCharm extends ItemMetaBase {

	public static final int CHARM_NONE = 0;
	public static final int CHARM_TELEPORT = 1;
	public static final int CHARM_HEAL = 2;
	public static final int CHARM_DROP = 3;

	public ItemCharm(String name)
	{
		super(name, new String[] { "none", "teleport", "heal", "drop" });
		this.setMaxStackSize(1);
		this.setRarity(EnumRarity.uncommon);
	}

	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(itemStack.getItemDamage() == CHARM_TELEPORT)
		{
			if(player instanceof EntityPlayerMP)
			{
				if(player.dimension != 0)
				{
					player.travelToDimension(0);
				}

				ChunkCoordinates c = player.getBedLocation(player.dimension);

				if(c != null)
				{
					c = EntityPlayer.verifyRespawnCoordinates(player.worldObj, c, player.isSpawnForced(player.dimension));
				}
				else
				{
					c = player.worldObj.provider.getRandomizedSpawnPoint();
				}

				player.setPositionAndUpdate((double)c.posX + 0.5D, (double)c.posY + 0.1D, (double)c.posZ + 0.5D);
			}
		}

		return itemStack;
	}

	public int getMaxItemUseDuration(ItemStack itemStack)
	{
		return 16;
	}

	public EnumAction getItemUseAction(ItemStack itemStack)
	{
		return EnumAction.block;
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if(itemStack.getItemDamage() == CHARM_TELEPORT)
			player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		return itemStack;
	}

	public void addInfo(ItemStack itemStack, EntityPlayer player, List<String> list, boolean select)
	{
		list.add(Lang.localize("iteminfo." + this.getUnlocalizedName(itemStack).substring(5)));
	}

}
