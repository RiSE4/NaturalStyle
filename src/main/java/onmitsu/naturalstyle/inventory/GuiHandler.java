package onmitsu.naturalstyle.inventory;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import onmitsu.naturalstyle.inventory.container.ContainerAuroraPocket;
import onmitsu.naturalstyle.inventory.container.ContainerUnbreakingAnvil;
import onmitsu.naturalstyle.inventory.gui.GuiAuroraPocket;
import onmitsu.naturalstyle.inventory.gui.GuiUnbreakingAnvil;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_UNBREAKING_ANVIL = 0;
    public static final int GUI_AURORA_POCKET = 1;
    public static final int GUI_WESTERN_DRAWERS = 2;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == GUI_UNBREAKING_ANVIL)
            return new ContainerUnbreakingAnvil(player.inventory, world, x, y, z, player);

        if(ID == GUI_AURORA_POCKET)
            return new ContainerAuroraPocket(player.inventory);

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == GUI_UNBREAKING_ANVIL)
            return new GuiUnbreakingAnvil(player.inventory, world, x, y, z);

        if(ID == GUI_AURORA_POCKET)
            return new GuiAuroraPocket(player.inventory);

        TileEntity tile = world.getTileEntity(x, y, z);

        if(tile != null)
        {

        }

        return null;
    }
}
