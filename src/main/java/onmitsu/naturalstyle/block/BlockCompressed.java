package onmitsu.naturalstyle.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import onmitsu.naturalstyle.item.block.ItemBlockNaturalOre;

public class BlockCompressed extends BlockMetaBase {

	public BlockCompressed(String name)
	{
		super(name, Material.iron);
		this.setGeneralProperty(soundTypeStone, 4.5F, 12F);
		this.register(ItemBlockNaturalOre.class);
	}

	@Override
	public String[] getTypeNames()
	{
		return new String[] { "essence", "aurora" };
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		return 1;
	}

	@Override
	public int damageDropped(int meta)
	{
		switch(meta)
		{
		case 0:
			return 0;
		case 1:
			return 1;
		}

		return 0;
	}
}
