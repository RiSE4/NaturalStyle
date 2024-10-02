package onmitsu.naturalstyle.inventory.container;

import invtweaks.api.container.ChestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import onmitsu.naturalstyle.init.NItems;
import onmitsu.naturalstyle.inventory.InventoryAuroraPocket;
import onmitsu.naturalstyle.inventory.slot.SlotAuroraPocket;

@ChestContainer(isLargeChest = true)
public class ContainerAuroraPocket extends Container {

    private final InventoryAuroraPocket pocket;

    public ContainerAuroraPocket(InventoryPlayer player)
    {
        pocket = new InventoryAuroraPocket(player);
        pocket.openInventory();

        for (int j = 0; j < 7; ++j)
        {
            for (int k = 0; k < 12; ++k)
            {
                this.addSlotToContainer(new Slot(pocket, k + j * 12, 8 + k * 18, 18 + j * 18));
            }
        }

        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotAuroraPocket(player, k + j * 9 + 9, 35 + k * 18, 158 + j * 18));
            }
        }

        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new SlotAuroraPocket(player, j, 35 + j * 18, 216));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int size)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(size);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (size < this.pocket.getSizeInventory())
            {
                if (!this.mergeItemStack(itemstack1, this.pocket.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            //シフトクリック時に、このアイテムだったら動かさない。
            else if (slot.getStack() != null && slot.getStack().getItem() == NItems.AURORA_POCKET)
            {
                return null;
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.pocket.getSizeInventory(), false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
                {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        this.pocket.closeInventory();
    }
}