package onmitsu.naturalstyle.inventory.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import onmitsu.naturalstyle.init.NItems;

public class SlotAuroraPocket extends Slot {

    public SlotAuroraPocket(IInventory inventory, int x, int y, int z)
    {
        super(inventory, x, y ,z);
    }

    //このアイテムは動かせない、つかめないようにする。
    @Override
    public boolean canTakeStack(EntityPlayer player)
    {
        return !(getHasStack() && getStack().getItem() == NItems.AURORA_POCKET);
    }
}
