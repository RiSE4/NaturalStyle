package onmitsu.naturalstyle.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public abstract class ItemBlockBase extends ItemBlock {

	private final Block metaBlock;
	private final String[] type = this.getTypeNames();

	ItemBlockBase(Block block)
	{
		super(block);
		this.metaBlock = block;
		this.setHasSubtypes(true);
	}

	public int getMetadata(int meta)
	{
		return meta;
	}

	public IIcon getIconFromDamage(int meta)
	{
		return metaBlock.getIcon(this.type.length - 1, meta);
	}

	public abstract String[] getTypeNames();

	public abstract String getUnlocalizedName(ItemStack itemStack);

}
