package onmitsu.naturalstyle.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import onmitsu.naturalstyle.init.NItems;
import onmitsu.naturalstyle.item.ItemCharm;

public class CharmEvent {

	/* EXP DROP */
	@SubscribeEvent
	public void EntityDropEvent(LivingDropsEvent event)
	{
		EntityLivingBase entity = event.entityLiving;
		DamageSource damage = event.source;

		World world = entity.worldObj;
		double posX = entity.posX;
		double posY = entity.posY;
		double posZ = entity.posZ;

		if(!(entity instanceof EntityPlayer) && damage instanceof EntityDamageSource)
		{
			EntityDamageSource entityDamage = (EntityDamageSource)damage;
			Entity killer = entityDamage.getEntity();

			if(killer instanceof EntityPlayer)
			{
				Item charm = NItems.CHARM;
				EntityPlayer player = (EntityPlayer)killer;

				int expCount = 0;

				for(int i = 0; i < player.inventory.mainInventory.length; ++i)
				{
					ItemStack item = player.inventory.getStackInSlot(i);
					if(item != null && item.getItem() != null && item.getItem() == charm)
					{
						if(item.getItemDamage() == ItemCharm.CHARM_DROP)
						{
							++expCount;
						}
					}
				}

				if(expCount > 0)
				{
					int count = 14 * expCount;
					int exp = 2 * world.rand.nextInt(count);
					world.spawnEntityInWorld(new EntityXPOrb(world, posX, posY, posZ, exp));
				}
			}
		}
	}

	@SubscribeEvent
	public void LivingUpdateEvent(LivingUpdateEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;

			for(int i = 0; i < player.inventory.mainInventory.length; ++i)
			{
				ItemStack item = player.inventory.getStackInSlot(i);
				if(item != null && item.getItem() != null && item.getItem() == NItems.CHARM)
				{
					/* HEAL */
					if(item.getItemDamage() == ItemCharm.CHARM_HEAL)
					{
						if(event.entityLiving.ticksExisted % 5 == 0 && player.getHealth() < player.getMaxHealth())
							player.heal(1.3F);
					}
				}
			}
		}
	}
}
