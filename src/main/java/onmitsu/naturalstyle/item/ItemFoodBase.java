package onmitsu.naturalstyle.item;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import onmitsu.naturalstyle.common.NaturalStyle;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.util.Helper;

public class ItemFoodBase extends ItemFood {

	/** Default food is 32*/
	private final int eatSpeed;

	public ItemFoodBase(String name, int hunger, float hidden, boolean canWolfEat, int speed)
	{
		super(hunger, hidden, canWolfEat);
		this.eatSpeed = speed;
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.RESOURCES_PATH + name);
		this.setCreativeTab(NaturalStyle.TAB_NATURALSTYLE);
	}

	public ItemFoodBase(String name, int hunger, float hidden)
	{
		this(name, hunger, hidden ,false, 16);
	}

	public int getMaxItemUseDuration(ItemStack itemStack)
	{
		return this.eatSpeed;
	}

	public ItemFoodBase register()
	{
		Helper.addItem(this);
		return this;
	}
}
