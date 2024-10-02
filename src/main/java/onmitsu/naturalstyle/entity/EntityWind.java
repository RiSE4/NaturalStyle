package onmitsu.naturalstyle.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityWind extends EntityThrowable {

	private int age;
	private int maxAge;

	public EntityWind(World world)
	{
		super(world);
		this.setSize(5F, 5F);
	}

	public EntityWind(World world, EntityLivingBase living)
	{
		super(world, living);
		this.yOffset = 1F;
		this.setSize(5F, 5F);
		this.maxAge = 5;
	}

	protected void onImpact(MovingObjectPosition pos)
	{
		if(pos.entityHit instanceof EntityLivingBase && pos.entityHit.ridingEntity == null && pos.entityHit.riddenByEntity == null)
		{
			pos.entityHit.motionX = this.motionX;
			pos.entityHit.motionY = this.motionY;
			pos.entityHit.motionZ = this.motionZ;
		}
	}

	public void onUpdate()
	{
		super.onUpdate();

		if(this.age++ > this.maxAge)
		{
			this.setDead();
		}

		if((this.age & 1) == 0)
		{
			this.func_145775_I();
		}
	}

	protected void func_145775_I()
	{
		int minX = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
		int minY = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
		int minZ = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
		int maxX = MathHelper.floor_double(this.boundingBox.maxX - 0.001D);
		int maxY = MathHelper.floor_double(this.boundingBox.maxY - 0.001D);
		int maxZ = MathHelper.floor_double(this.boundingBox.maxZ - 0.001D);

		if(this.worldObj.checkChunksExist(minX, minY, minZ, maxX, maxY, maxZ))
		{
			for(int x = minX; x <= maxX; ++x)
			{
				for(int y = minY; y <= maxY; ++y)
				{
					for(int z = minZ; z <= maxZ; ++z)
					{
						Block block = this.worldObj.getBlock(x, y, z);

						if(block != Blocks.air && this.isRemove(block))
						{
							this.removeLeaves(this.worldObj, x, y, z, block);
						}
					}
				}
			}
		}
	}

	private boolean isRemove(Block block)
	{
		Material mat = block.getMaterial();
		return mat == Material.leaves || mat == Material.vine || block instanceof BlockDoublePlant || block instanceof BlockFlower;
	}

	private void removeLeaves(World world, int x, int y, int z, Block block)
	{
		int meta = world.getBlockMetadata(x, y, z);

		block.dropBlockAsItem(world, x, y, z, meta, 0);
		world.setBlockToAir(x, y, z);
	}
}
