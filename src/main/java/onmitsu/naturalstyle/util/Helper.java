package onmitsu.naturalstyle.util;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import onmitsu.naturalstyle.common.NaturalStyle;

public class Helper {

	public static Block addBlock(Block block)
	{
		return addBlock(block, ItemBlock.class);
	}

	public static Block addBlock(Block block, Class<? extends ItemBlock> ib)
	{
		return GameRegistry.registerBlock(block, ib, block.getUnlocalizedName().substring(5));
	}

	public static void addItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}

	public static void addForgeEvent(Object event)
	{
		MinecraftForge.EVENT_BUS.register(event);
	}

	public static void addFMLEvent(Object event)
	{
		FMLCommonHandler.instance().bus().register(event);
	}

	public static void addWorldGenerator(IWorldGenerator gen, int id)
	{
		GameRegistry.registerWorldGenerator(gen, id);
	}

	public static int getUseMeta(int meta, int length)
	{
		return MathHelper.clamp_int(meta, 0, length - 1);
	}

	public static void playSound(World world, double x, double y, double z, String soundName, float volume, float pitch)
	{
		world.playSoundEffect(x, y, z, soundName, volume, pitch);
	}

	public static ToolMaterial addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability)
	{
		return EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
	}

	public static ArmorMaterial addArmorMaterial(String name, int durability, int[] reductionAmounts, int enchantability, ItemStack repairItem)
	{
		ArmorMaterial am = EnumHelper.addArmorMaterial(name, durability, reductionAmounts, enchantability);
		am.customCraftingMaterial = repairItem.getItem();
		return am;
	}

	public static void openGui(EntityPlayer player, int ID, World world, int x, int y, int z)
	{
		player.openGui(NaturalStyle.instance, ID, world, x, y, z);
	}

	public static void addEntityRenderer(Class<? extends Entity> entity, Render renderer)
	{
		RenderingRegistry.registerEntityRenderingHandler(entity, renderer);
	}

	public static void addTileEntityRenderer(Class<? extends TileEntity> tile, TileEntitySpecialRenderer renderer)
	{
		ClientRegistry.bindTileEntitySpecialRenderer(tile, renderer);
	}

	/**
	 * ワールドに存在する宝箱からドロップするアイテムを追加します。
	 * @param category 宝箱のカテゴリ
	 * @param itemStack ドロップするアイテムスタック
	 * @param probability 出る確率
	 * @param maximum 最大量
	 * @param minimum 最低量
	 */
	public static void addChestGen(String category, ItemStack itemStack, int probability, int maximum, int minimum)
	{
		ChestGenHooks.addItem(category, new WeightedRandomChestContent(itemStack, probability, maximum, minimum));
	}

	public static void addTileEntity(Class<? extends TileEntity> tile)
	{
		GameRegistry.registerTileEntity(tile, tile.getName());
	}

	public static void addEntity(Class<? extends Entity> entityClass, String name, int id, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(entityClass, name, id, NaturalStyle.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}

	public static boolean isPlayerFake(EntityPlayer player)
	{
		if(player.worldObj == null)
		{
			return true;
		}
		else if(player.worldObj.isRemote)
		{
			return false;
		}
		else if(player.getClass() == EntityPlayerMP.class)
		{
			return false;
		}
		else
		{
			return !MinecraftServer.getServer().getConfigurationManager().playerEntityList.contains(player);
		}
	}

	public static boolean isPlayerFake(EntityPlayerMP player)
	{
		if(player.getClass() != EntityPlayerMP.class)
		{
			return true;
		}
		else if(player.playerNetServerHandler == null)
		{
			return true;
		}
		else
		{
			try
			{
				player.getPlayerIP().length();
				player.playerNetServerHandler.netManager.getSocketAddress().toString();
			}
			catch(Exception var2)
			{
				return true;
			}

			return !MinecraftServer.getServer().getConfigurationManager().playerEntityList.contains(player);
		}
	}
}
