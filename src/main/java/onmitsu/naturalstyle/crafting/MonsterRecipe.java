package onmitsu.naturalstyle.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import onmitsu.naturalstyle.init.NItems;

public class MonsterRecipe {

	public static void load()
	{
		addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 0), new ItemStack(Items.apple));

		//ABSOLUTELY ZERO
		Item grapefruit = GameRegistry.findItem("harvestcraft", "grapefruitItem");
		if(grapefruit != null)
			addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 1), new ItemStack(grapefruit));
		else
			addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 1), new ItemStack(Items.fish));

		//KHAOS
		Item orange = GameRegistry.findItem("harvestcraft", "orangeItem");
		if(orange != null)
			addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 2), new ItemStack(orange));
		else
			addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 2), new ItemStack(Items.golden_apple, 1, 0));

		//CUBA LIBLE
		Item cherry = GameRegistry.findItem("harvestcraft", "cherryItem");
		if(cherry != null)
			addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 3), new ItemStack(cherry));
		else
			addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 3), new ItemStack(Items.milk_bucket));

		//PIPELINE PUNCH
		Item mango = GameRegistry.findItem("harvestcraft", "mangoItem");
		if(mango != null)
			addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 4), new ItemStack(mango));
		else
			addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 4), new ItemStack(Items.pumpkin_pie));

		//ULTRA
		Item gooseberry = GameRegistry.findItem("harvestcraft", "gooseberryItem");
		if(gooseberry != null)
			addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 5), new ItemStack(gooseberry));
		else
			addMonsterRecipe(new ItemStack(NItems.MONSTER_ENERGY, 1, 5), new ItemStack(Items.golden_carrot));

	}

	private static void addMonsterRecipe(ItemStack result, ItemStack material)
	{
		if(OreDictionary.getOres("ingotAluminium").size() > 0)
		{
			CraftHelper.addShapedOreRecipe(result, "EAE",
					"MPM",
					"MPM",
					'E', new ItemStack(NItems.NATURAL_JEWEL, 1, 0), 'A', "ingotAluminium",
					'M', material, 'P', new ItemStack(NItems.NATURAL_JEWEL, 1, 3));
		}
		else
		{
			GameRegistry.addRecipe(result, "EAE",
					"MPM",
					"MPM",
					'E', new ItemStack(NItems.NATURAL_JEWEL, 1, 0), 'A', Items.iron_ingot,
					'M', material, 'P', new ItemStack(NItems.NATURAL_JEWEL, 1, 3));
		}
	}
}
