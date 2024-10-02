package onmitsu.naturalstyle.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashSet;
import java.util.Set;

public class CardboardUtil {

	private static Set<BlockInfo> cardboardBoxIgnore = new HashSet<BlockInfo>();

	public static boolean isBlockCompatible(Item item, int meta)
	{
		for(BlockInfo i : cardboardBoxIgnore)
		{
			if(i.block == Block.getBlockFromItem(item) && (i.meta == OreDictionary.WILDCARD_VALUE || i.meta == meta))
			{
				return false;
			}
		}

		return true;
	}

	public static class BlockInfo
	{
		public Block block;
		public int meta;

		public BlockInfo(Block block, int meta)
		{
			this.block = block;
			this.meta = meta;
		}

		public static BlockInfo get(ItemStack itemStack)
		{
			return new BlockInfo(Block.getBlockFromItem(itemStack.getItem()), itemStack.getItemDamage());
		}

		public boolean equals(Object obj)
		{
			return obj instanceof BlockInfo && ((BlockInfo)obj).block == block && ((BlockInfo)obj).meta == meta;
		}

		public int hashCode()
		{
			int code = 1;
			code = 31 * code + block.getUnlocalizedName().hashCode();
			code = 31 * code + meta;
			return code;
		}
	}

	public static class BlockData
	{
		public Block block;
		public int meta;
		public NBTTagCompound tileTag;

		public BlockData(Block b, int j, NBTTagCompound nbtTags)
		{
			block = b;
			meta = j;
			tileTag = nbtTags;
		}

		public BlockData() {}

		public void updateLocation(int x, int y, int z)
		{
			if(tileTag != null)
			{
				tileTag.setInteger("x", x);
				tileTag.setInteger("y", y);
				tileTag.setInteger("z", z);
			}
		}

		public NBTTagCompound write(NBTTagCompound nbtTags)
		{
			nbtTags.setInteger("id", Block.getIdFromBlock(block));
			nbtTags.setInteger("meta", meta);

			if(tileTag != null)
			{
				nbtTags.setTag("tileTag", tileTag);
			}

			return nbtTags;
		}

		public static BlockData read(NBTTagCompound nbtTags)
		{
			BlockData data = new BlockData();

			data.block = Block.getBlockById(nbtTags.getInteger("id"));
			data.meta = nbtTags.getInteger("meta");

			if(nbtTags.hasKey("tileTag"))
			{
				data.tileTag = nbtTags.getCompoundTag("tileTag");
			}

			return data;
		}
	}
}
