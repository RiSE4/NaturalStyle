package onmitsu.naturalstyle.init;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModStacks {

	public static ItemStack IC2_STEEL_INGOT;
	public static ItemStack MT_SUNFLOWER_SEED;

	public static ItemStack MAPLE_PICKAXE;
	public static ItemStack MAPLE_SHOVEL;
	public static ItemStack MAPLE_AXE;


	public static void loadFromMod()
	{
		if(Loader.isModLoaded("IC2"))
		{
			Item item = GameRegistry.findItem("IC2", "itemIngot");

			if(item != null)
			{
				IC2_STEEL_INGOT = new ItemStack(item, 1, 3);
			}
		}

		if(Loader.isModLoaded("mod_ecru_MapleTree"))
		{
			Item seed = GameRegistry.findItem("mod_ecru_MapleTree", "SunFlowerSeed");

			if(seed != null)
			{
				MT_SUNFLOWER_SEED = new ItemStack(seed, 1, 0);
			}
		}

		if(Loader.isModLoaded("mod_ecru_MapleTree"))
		{
			Item seed = GameRegistry.findItem("mod_ecru_MapleTree", "PickaxeMapleDiamond");

			if(seed != null)
			{
				MAPLE_PICKAXE = new ItemStack(seed, 1, 0);
			}
		}

		if(Loader.isModLoaded("mod_ecru_MapleTree"))
		{
			Item seed = GameRegistry.findItem("mod_ecru_MapleTree", "ShovelMapleDiamond");

			if(seed != null)
			{
				MAPLE_SHOVEL = new ItemStack(seed, 1, 0);
			}
		}

		if(Loader.isModLoaded("mod_ecru_MapleTree"))
		{
			Item seed = GameRegistry.findItem("mod_ecru_MapleTree", "AxeMapleDiamond");

			if(seed != null)
			{
				MAPLE_AXE = new ItemStack(seed, 1, 0);
			}
		}
	}
}
