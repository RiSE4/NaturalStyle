package onmitsu.naturalstyle.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.Item;
import onmitsu.naturalstyle.init.NAchievements;
import onmitsu.naturalstyle.init.NBlocks;
import onmitsu.naturalstyle.init.NItems;

public class AchievementEvent {

    @SubscribeEvent
    public void CraftingItem(PlayerEvent.ItemCraftedEvent event)
    {
        Item result = event.crafting.getItem();

        if(result.equals(Item.getItemFromBlock(NBlocks.VILLAGER_MINCER)))
            event.player.triggerAchievement(NAchievements.CRAFT_MINCER);

        if(result.equals(NItems.AURORA_HAMMER))
            event.player.triggerAchievement(NAchievements.CRAFT_AURORA_HAMMER);

        if(result.equals(NItems.AURORA_HAT) || result.equals(NItems.AURORA_CHESTPLATE) || result.equals(NItems.AURORA_PANTS) || result.equals(NItems.AURORA_BOOTS))
            event.player.triggerAchievement(NAchievements.CRAFT_AURORA_ARMOR);

        if(result.equals(NItems.MONSTER_ENERGY))
            event.player.triggerAchievement(NAchievements.CRAFT_MONSTER);
    }

    @SubscribeEvent
    public void SmeltingItem(PlayerEvent.ItemSmeltedEvent event)
    {
        if(event.smelting.getItem().equals(NItems.BAKED_SUNFLOWER_SEED))
            event.player.triggerAchievement(NAchievements.SMELT_BAKED_SEED);

    }

    @SubscribeEvent
    public void MiningBlock(PlayerEvent.ItemPickupEvent event)
    {
        if(event.pickedUp.getEntityItem().getItem() == NItems.NATURAL_JEWEL && event.pickedUp.getEntityItem().getItemDamage() == 0)
            event.player.triggerAchievement(NAchievements.MINING_ESSENCE_ORE);

        if(event.pickedUp.getEntityItem().getItem() == NItems.NATURAL_JEWEL && event.pickedUp.getEntityItem().getItemDamage() == 3)
            event.player.triggerAchievement(NAchievements.MINING_AURORA_ORE);

        if(event.pickedUp.getEntityItem().getItem() == NItems.WIRELESS_HOE)
            event.player.triggerAchievement(NAchievements.EAT_HOE);
    }
}
