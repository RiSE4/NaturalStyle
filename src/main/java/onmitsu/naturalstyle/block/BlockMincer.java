package onmitsu.naturalstyle.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import onmitsu.naturalstyle.tileentity.TileEntityMincer;

public class BlockMincer extends BlockTileBase {

	@SideOnly(Side.CLIENT)
	private IIcon top, side, bottom;

	public BlockMincer(String name)
	{
		super(name, Material.iron);
		this.setGeneralProperty(soundTypeMetal, 4F, 80F);
		this.setTickRandomly(true);
		this.register();
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iicon)
	{
		this.top = iicon.registerIcon(this.getTextureName() + "_top");
		this.side = iicon.registerIcon(this.getTextureName() + "_side");
		this.bottom = iicon.registerIcon(this.getTextureName() + "_bottom");
	}

	public IIcon getIcon(int side, int meta)
	{
		return side == 1 ? this.top : side == 0 ? this.bottom : this.side;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int k)
	{
		return new TileEntityMincer();
	}

	public int tickRate(World world)
	{
		return 30;
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		TileEntity tile = world.getTileEntity(x, y, z);

		if(tile instanceof TileEntityMincer && entity.posY > (double) y)
		{
			TileEntityMincer mincer = (TileEntityMincer) tile;

			if (mincer.getVillager() == null && entity instanceof EntityVillager)
			{
				entity.posX = (double) x;
				entity.posY = (double) y + 1;
				entity.posZ = (double) z;
				mincer.setVillager((EntityVillager) entity);
			}
		}
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		TileEntity tile = world.getTileEntity(x, y, z);

		if(tile instanceof TileEntityMincer)
		{
			TileEntityMincer mincer = (TileEntityMincer) tile;

			if(mincer.getVillager() != null && mincer.getRunTime() > 5 && random.nextInt(2) == 0)
			{
				double dPosX = (double)(float) x + random.nextFloat();
				double dPosY = (double) y + 2.0D;
				double dPosZ = (double)(float) z + random.nextFloat();
				world.spawnParticle("lava", dPosX, dPosY, dPosZ, 0D, 0D, 0D);
			}
		}

		double aPosX = (double)((float) x + random.nextFloat());
		double aPosY = (double) y - 1.05D;
		double aPosZ = (double)((float) z + random.nextFloat());

		if(world.getBlock(x, y - 1, z) == this)
		 {
			world.spawnParticle("dripLava", aPosX, aPosY, aPosZ, 0D, 0D, 0D);
		 }
	}


}
