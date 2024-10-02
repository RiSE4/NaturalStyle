package onmitsu.naturalstyle.crafting;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class TFLogChanger {

	public static ItemStack TFLOG_OAK;
	public static ItemStack TFLOG_CANOPY;
	public static ItemStack TFLOG_MANGROVE;
	public static ItemStack TFLOG_DARKWOOD;

	public static ItemStack AM2_OAK;
	public static ItemStack AM2_SPRUCE;
	public static ItemStack AM2_BIRCH;

	public static void load()
	{
		if(Loader.isModLoaded("TwilightForest"))
		{
			Block log = GameRegistry.findBlock("TwilightForest", "tile.TFLog");

			if(log != null)
			{
				TFLOG_OAK = new ItemStack(log, 1, 0);
				TFLOG_CANOPY = new ItemStack(log, 1, 1);
				TFLOG_MANGROVE = new ItemStack(log, 1, 2);
				TFLOG_DARKWOOD = new ItemStack(log, 1, 3);
			}
		}

		if(Loader.isModLoaded("DCsAppleMilk"))
		{
			Block box = GameRegistry.findBlock("DCsAppleMilk", "defeatedcrow.WoodBox");

			if(box != null)
			{
				AM2_OAK = new ItemStack(box, 1, 0);
				AM2_SPRUCE = new ItemStack(box, 1, 1);
				AM2_BIRCH = new ItemStack(box, 1, 2);
			}
		}

		if(TFLOG_OAK != null && AM2_OAK != null)
			addBoxRecipe(TFLOG_OAK, AM2_OAK);

		if(TFLOG_CANOPY != null && AM2_SPRUCE != null)
			addBoxRecipe(TFLOG_CANOPY, AM2_SPRUCE);

		if(TFLOG_DARKWOOD != null && AM2_SPRUCE != null)
			addBoxRecipe(TFLOG_DARKWOOD, AM2_SPRUCE);

		if(TFLOG_MANGROVE != null && AM2_BIRCH != null)
			addBoxRecipe(TFLOG_MANGROVE, AM2_BIRCH);
	}

	private static void addBoxRecipe(ItemStack log, ItemStack output)
	{
		GameRegistry.addRecipe(output, "###", "###", "###",
				'#', log);
	}
}
