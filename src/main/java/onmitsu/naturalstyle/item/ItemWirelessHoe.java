package onmitsu.naturalstyle.item;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.entity.EntityPlow;
import onmitsu.naturalstyle.util.Lang;

import java.util.List;

public class ItemWirelessHoe extends ItemBase {

    public ItemWirelessHoe(String name)
    {
        super(name);
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
        this.setNoRepair();
        this.setFull3D();
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(player.capabilities.isCreativeMode)
        {
            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if(!world.isRemote)
            {
                world.spawnEntityInWorld(new EntityPlow(world, player));
            }

            return itemStack;
        }
        else
        {
            itemStack.damageItem(1, player);
            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if(!world.isRemote)
            {
                world.spawnEntityInWorld(new EntityPlow(world, player));
            }

            return itemStack;
        }
    }

    public void addInfo(ItemStack itemStack, EntityPlayer player, List<String> list, boolean select)
    {
        if(GuiScreen.isShiftKeyDown())
        {
            list.add(Lang.localize("info.function.plow"));
            list.add(Lang.localize("info.desc.plow"));
        }
        else
        {
            list.add(Reference.INFO_PRESS_SHIFT);
        }

        list.add(Lang.localize("info.wirelesshoe"));
    }
}
