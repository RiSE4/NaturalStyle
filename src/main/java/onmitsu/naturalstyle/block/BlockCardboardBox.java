package onmitsu.naturalstyle.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import onmitsu.naturalstyle.init.NBlocks;
import onmitsu.naturalstyle.item.block.ItemBlockCardboardBox;
import onmitsu.naturalstyle.tileentity.TileEntityCardboardBox;
import onmitsu.naturalstyle.util.CardboardUtil.BlockData;

import java.util.Random;

public class BlockCardboardBox extends BlockTileBase {

	private static boolean testingPlace = false;

	@SideOnly(Side.CLIENT)
	private IIcon iconTop, iconSide, iconBottom;

	public BlockCardboardBox(String name)
	{
		super(name, Material.cloth);
		this.setGeneralProperty(soundTypeCloth, 0.5F, 1F);
		this.register(ItemBlockCardboardBox.class);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		this.iconTop = register.registerIcon(this.getTextureName() + "_top");
		this.iconSide = register.registerIcon(this.getTextureName() + "_side");
		this.iconBottom = register.registerIcon(this.getTextureName() + "_bottom");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if(side == 0)
		{
			return this.iconBottom;
		}
		else if(side == 1)
		{
			return this.iconTop;
		}
		else
		{
			return this.iconSide;
		}
	}

	public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
	{
		return testingPlace;
	}

	@Override
	public boolean onBlockRightClick(World world, int x, int y, int z, EntityPlayer entityplayer, int facing, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote && entityplayer.isSneaking())
		{
			ItemStack itemStack = new ItemStack(NBlocks.CARDBOARD_BOX);
			TileEntityCardboardBox tileEntity = (TileEntityCardboardBox)world.getTileEntity(x, y, z);

			if(tileEntity.storedData != null)
			{
				BlockData data = tileEntity.storedData;

				testingPlace = true;

				if(!data.block.canPlaceBlockAt(world, x, y, z))
				{
					testingPlace = false;
					return true;
				}

				testingPlace = false;

				if(data.block != null)
				{
					data.meta = data.block.onBlockPlaced(world, x, y, z, facing, hitX, hitY, hitZ, data.meta);
				}

				world.setBlock(x, y, z, data.block, data.meta, 3);

				if(data.tileTag != null && world.getTileEntity(x, y, z) != null)
				{
					data.updateLocation(x, y, z);
					world.getTileEntity(x, y, z).readFromNBT(data.tileTag);
				}

				if(data.block != null)
				{
					data.block.onBlockPlacedBy(world, x, y, z, entityplayer, new ItemStack(data.block, 1, data.meta));
					data.block.onPostBlockPlaced(world, x, y, z, data.meta);
				}

				float motion = 0.7F;
				double motionX = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;
				double motionY = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;
				double motionZ = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;

				EntityItem entityItem = new EntityItem(world, x + motionX, y + motionY, z + motionZ, itemStack);

				world.spawnEntityInWorld(entityItem);
			}
		}

		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityCardboardBox();
	}

    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player)
	{
		TileEntityCardboardBox tileEntity = (TileEntityCardboardBox)world.getTileEntity(x, y, z);

		ItemStack itemStack = new ItemStack(NBlocks.CARDBOARD_BOX, 1, world.getBlockMetadata(x, y, z));

		if(itemStack.getItemDamage() == 1)
		{
			if(tileEntity.storedData != null)
			{
				((ItemBlockCardboardBox)itemStack.getItem()).setBlockData(itemStack, tileEntity.storedData);
			}
		}

		return itemStack;
	}

	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest)
	{
		if(!player.capabilities.isCreativeMode && !world.isRemote && willHarvest)
		{
			float motion = 0.7F;
			double motionX = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;
			double motionY = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;
			double motionZ = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;

			EntityItem entityItem = new EntityItem(world, x + motionX, y + motionY, z + motionZ, getPickBlock(null, world, x, y, z, player));

			world.spawnEntityInWorld(entityItem);
		}

		return world.setBlockToAir(x, y, z);
	}

	public int quantityDropped(Random random)
	{
		return 0;
	}

	public Item getItemDropped(int i, Random random, int j)
	{
		return null;
	}
}
