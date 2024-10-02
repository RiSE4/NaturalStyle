package onmitsu.naturalstyle.item;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.init.NItems;
import onmitsu.naturalstyle.util.Lang;

import java.util.List;

public class ItemRecoveryHoe extends ItemBase {

    public ItemRecoveryHoe(String name)
    {
        super(name);
        this.setMaxStackSize(1);
    }

    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 2;
    }

    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        --itemStack.stackSize;

        if(!world.isRemote)
        {
            EntityItem hoe = new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(NItems.WIRELESS_HOE));
            world.spawnEntityInWorld(hoe);
        }

        return itemStack;
    }

    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.eat;
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    public void addInfo(ItemStack itemStack, EntityPlayer player, List<String> list, boolean select)
    {
        list.add(Lang.localize("info.recovery_hoe"));
    }
}
