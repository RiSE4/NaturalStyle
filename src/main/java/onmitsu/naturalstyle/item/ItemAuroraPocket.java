package onmitsu.naturalstyle.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import onmitsu.naturalstyle.inventory.GuiHandler;
import onmitsu.naturalstyle.util.Helper;

public class ItemAuroraPocket extends ItemBase {

    public ItemAuroraPocket(String name)
    {
        super(name);
        this.setMaxStackSize(1);
        this.setRarity(EnumRarity.uncommon);
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        Helper.openGui(player, GuiHandler.GUI_AURORA_POCKET, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        return itemStack;
    }
}
