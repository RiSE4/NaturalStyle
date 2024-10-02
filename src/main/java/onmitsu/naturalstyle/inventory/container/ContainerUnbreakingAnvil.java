package onmitsu.naturalstyle.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.world.World;

public class ContainerUnbreakingAnvil extends ContainerRepair {

    private int posX;
    private int posY;
    private int posZ;

    public ContainerUnbreakingAnvil(InventoryPlayer invPlayer, World world, int x, int y, int z, EntityPlayer player) {
        super(invPlayer, world, x, y, z, player);
        this.posX = x;
        this.posY = y;
        this.posZ = z;
    }

    public boolean canInteractWith(EntityPlayer player)
    {
        return player.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }
}
