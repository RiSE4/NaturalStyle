package onmitsu.naturalstyle.event;

import java.util.UUID;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import onmitsu.naturalstyle.init.NItems;

public class ArmorEvent {


	private static final UUID AuroraBootsSpeedBonusUUID = UUID.fromString("36A0FC05-50EB-460B-8961-615633A6D813");
	private static final AttributeModifier AuroraBootsSpeedBonus = (new AttributeModifier(AuroraBootsSpeedBonusUUID, "Aurora Boots Speed Bonus", 0.3D, 2)).setSaved(false);

	@SubscribeEvent
	public void armorRepair(LivingEvent.LivingUpdateEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;

			ItemStack hat = player.getCurrentArmor(3);
			ItemStack vest = player.getCurrentArmor(2);
			ItemStack pants = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);

			//HAT
			if(hat != null && hat.getItem() == NItems.AURORA_HAT)
			{
				if(event.entityLiving.ticksExisted % 1400 == 0 && hat.isItemDamaged())
				{
					hat.setItemDamage(hat.getItemDamage() - 1);
				}

				if(player.isInWater() && player.getAir() < 100)
				{
					player.setAir(player.getAir() + 200);
				}
			}

			//CHEST PLATE
			if(vest != null && vest.getItem() == NItems.AURORA_CHESTPLATE)
			{
				if(event.entityLiving.ticksExisted % 1400 == 0 && vest.isItemDamaged())
				{
					vest.setItemDamage(vest.getItemDamage() - 1);
				}

				if(player.getHealth() < 6)
				{
					player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20, 5));
					vest.setItemDamage(vest.getItemDamage() + 20);

					if(player.getHealth() == 20 && player.getActivePotionEffect(Potion.regeneration) !=null)
					{
						player.removePotionEffect(Potion.regeneration.id);
					}
				}
			}

			IAttributeInstance movement = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);

			if (movement.getModifier(AuroraBootsSpeedBonusUUID) != null)
			{
			movement.removeModifier(AuroraBootsSpeedBonus);
			}

			//PANTS
			if(pants != null && pants.getItem() == NItems.AURORA_PANTS)
			{
				if(event.entityLiving.ticksExisted % 1400 == 0 && pants.isItemDamaged())
				{
					pants.setItemDamage(pants.getItemDamage() - 1);
				}

				movement.applyModifier(AuroraBootsSpeedBonus);
			}

			//BOOTS
			if(boots != null && boots.getItem() == NItems.AURORA_BOOTS)
			{
				if(event.entityLiving.ticksExisted % 1400 == 0 && boots.isItemDamaged())
				{
					boots.setItemDamage(boots.getItemDamage() - 1);
				}

				player.stepHeight = 1.0111F;
			}
			else if(player.stepHeight == 1.0111F)
			{
				player.stepHeight = 0.5F;
			}
		}
	}

	@SubscribeEvent
	public void noFall(LivingFallEvent event)
	{
		ItemStack boots = event.entityLiving.getEquipmentInSlot(1);

		if(boots != null && boots.getItem() == NItems.AURORA_BOOTS)
		{
			event.distance = 0;
		}
	}
}
