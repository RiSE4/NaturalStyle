package onmitsu.naturalstyle.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import onmitsu.naturalstyle.common.NaturalStyle;
import onmitsu.naturalstyle.init.NBlocks;

import java.util.List;
import java.util.Random;

public class TileEntityMincer extends TileEntity {

	private Random random = new Random();

	private EntityVillager villager = null;
	private int runTime;
	private int damageCount;

	public void setVillager(EntityVillager villager)
	{
		this.villager = villager;
	}

	public EntityVillager getVillager()
	{
		return this.villager;
	}

	public int getRunTime()
	{
		return this.runTime;
	}

	public void updateEntity()
	{
		super.updateEntity();
		if (this.worldObj.getBlock(this.xCoord, this.yCoord - 1, this.zCoord) == NBlocks.VILLAGER_MINCER)
		{
			if (this.getVillager() != null)
			{
				this.runTime += 1;
				if (this.getVillager().deathTime > 0)
				{
					this.villager.setDead();
					this.villager = null;
				}
			}
			else
			{
				this.villager = getOnVillagerWalking();
				this.runTime = 0;
				this.damageCount = 0;
			}

			if (this.runTime > 20)
			{
				startMince();
			}
		}
		else
		{
			this.villager = null;
			this.runTime = 0;
			this.damageCount = 0;
		}
	}

	@SuppressWarnings("unchecked")
	private EntityVillager getOnVillagerWalking()
	{
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)this.xCoord , (double)this.yCoord , (double)this.zCoord, (double)this.xCoord , (double)(this.yCoord  + 1), (double)this.zCoord).expand(1.5D, 1.0D, 1.5D);
		List<EntityVillager> list = this.worldObj.getEntitiesWithinAABB(EntityVillager.class, aabb);

		for (EntityVillager entityVillager : list) {

			if (entityVillager != null) {
				return entityVillager;
			}
		}
		return null;
	}

	private void startMince()
	{
		++this.damageCount;

		if(this.damageCount == 5 && this.villager != null)
		{
			if(!this.worldObj.isRemote)
			{
				EntityItem meat = new EntityItem(this.worldObj, (double)this.xCoord, (double)this.yCoord - 1.5D, (double)this.zCoord, new ItemStack(Items.rotten_flesh));
				EntityItem em = new EntityItem(this.worldObj, (double)this.xCoord, (double)this.yCoord - 1.5D, (double)this.zCoord, new ItemStack(Items.emerald));

				if(this.random.nextInt(7) == 0)
					this.worldObj.spawnEntityInWorld(em);

				if(this.random.nextInt(2) == 0)
					this.worldObj.spawnEntityInWorld(meat);

				this.villager.attackEntityFrom(NaturalStyle.inMincer, 2.0F);
				this.damageCount = 0;
			}
		}
	}
}
