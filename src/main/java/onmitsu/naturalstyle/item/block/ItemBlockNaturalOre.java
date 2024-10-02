package onmitsu.naturalstyle.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockNaturalOre extends ItemBlockBase {

	public ItemBlockNaturalOre(Block block)
	{
		super(block);
	}

	@Override
	public String[] getTypeNames()
	{
		return new String[] { "essence", "aurora" };
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		String name = "";

		switch(itemStack.getItemDamage())
		{
		case 0:
			name = "essence";
			break;
		case 1:
			name = "aurora";
			break;
		}

		return super.getUnlocalizedName() + "." + name;
	}
}
