package onmitsu.naturalstyle.crafting;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftHelper {

	public static void deleteRecipe(ItemStack target)
	{
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

		List<IRecipe> removeList = new ArrayList<IRecipe>();

		for (IRecipe recipe : recipes)
		{
			if (recipe != null && recipe.getRecipeOutput() != null && recipe.getRecipeOutput().getItem() != null)
			{
				if (ItemStack.areItemStacksEqual(target, recipe.getRecipeOutput()))
				{
					removeList.add(recipe);
				}
			}
		}

		for (IRecipe remove : removeList)
		{
			recipes.remove(remove);
		}
	}

	static void addShapedOreRecipe(ItemStack itemStack, Object... params)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(itemStack, params));
	}

	public static void addShapelessOreRecipe(ItemStack itemStack, Object ... params)
	{
		GameRegistry.addRecipe(new ShapelessOreRecipe(itemStack, params));
	}
}
