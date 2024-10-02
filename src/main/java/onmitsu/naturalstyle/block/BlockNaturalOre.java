package onmitsu.naturalstyle.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import onmitsu.naturalstyle.init.NItems;
import onmitsu.naturalstyle.item.block.ItemBlockNaturalOre;

public class BlockNaturalOre extends BlockMetaBase {

	public BlockNaturalOre(String name)
	{
		super(name, Material.rock);
		this.setGeneralProperty(soundTypeStone, 3.0F, 5.0F);
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
		return meta == 0 ? 4 + random.nextInt(7) : 1;
	}

	@Override
	public int damageDropped(int meta)
	{
		switch(meta)
		{
		case 0:
			return 0;
		case 1:
			return 3;
		}

		return 0;
	}

	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return NItems.NATURAL_JEWEL;
	}

	public int getExpDrop(IBlockAccess world, int meta, int fortune)
	{
		Random random = new Random();

		if(this.getItemDropped(meta, random, fortune) != Item.getItemFromBlock(this))
		{
			int exp = 0;

			switch(meta)
			{
			case 0:
				exp = MathHelper.getRandomIntegerInRange(random, 2, 5);
				return exp;

			case 1:
				exp = MathHelper.getRandomIntegerInRange(random, 3, 7);
				return exp;
			}

			return exp;
		}

		return 0;
	}

	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, random, fortune))
		{
			int j = random.nextInt(fortune + 2) - 1;

			if (j < 0)
			{
				j = 0;
			}

			return this.quantityDropped(random) * (j + 1);
		}
		else
		{
			return this.quantityDropped(random);
		}
	}
}
