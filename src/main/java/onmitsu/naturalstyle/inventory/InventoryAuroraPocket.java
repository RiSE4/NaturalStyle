package onmitsu.naturalstyle.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryAuroraPocket implements IInventory {

    private  final InventoryPlayer player;
    private final ItemStack currentItem;
    private final ItemStack[] items = new ItemStack[84];

    private String customName;

    public InventoryAuroraPocket(InventoryPlayer player)
    {
        this.player = player;
        currentItem = this.player.getCurrentItem();
    }

    @Override
    public int getSizeInventory()
    {
        return items.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return items[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int size)
    {
        if (this.items[slot] != null)
        {
            ItemStack itemstack;

            if (this.items[slot].stackSize <= size)
            {
                itemstack = this.items[slot];
                this.items[slot] = null;
            }
            else
            {
                itemstack = this.items[slot].splitStack(size);

                if (this.items[slot].stackSize == 0)
                {
                    this.items[slot] = null;
                }

            }
            this.markDirty();
            return itemstack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (this.items[slot] != null)
        {
            ItemStack itemstack = this.items[slot];
            this.items[slot] = null;
            return itemstack;
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        this.items[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
            itemStack.stackSize = this.getInventoryStackLimit();

        this.markDirty();
    }

    @Override
    public String getInventoryName()
    {
        return "container.aurora_pocket";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return this.customName != null && this.customName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty() {}

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return true;
    }

    @Override
    public void openInventory()
    {
        if (!currentItem.hasTagCompound())
        {
            currentItem.setTagCompound(new NBTTagCompound());
            currentItem.getTagCompound().setTag("Items", new NBTTagList());

            if (currentItem.getTagCompound().hasKey("CustomName", 8))
            {
                this.customName = currentItem.getTagCompound().getString("CustomName");
            }
        }

        NBTTagList tags = (NBTTagList) currentItem.getTagCompound().getTag("Items");

        for (int i = 0; i < tags.tagCount(); i++)
        {
            NBTTagCompound tagCompound = tags.getCompoundTagAt(i);
            int slot = tagCompound.getByte("Slot");

            if (slot >= 0 && slot < items.length)
            {
                items[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void closeInventory()
    {
        NBTTagList tagList = new NBTTagList();

        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null)
            {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte) i);
                items[i].writeToNBT(compound);
                tagList.appendTag(compound);
            }
        }

        ItemStack result = new ItemStack(currentItem.getItem(), 1);
        result.setTagCompound(new NBTTagCompound());
        result.getTagCompound().setTag("Items", tagList);

        if (this.hasCustomInventoryName())
        {
            result.getTagCompound().setString("CustomName", this.customName);
        }

        this.player.mainInventory[this.player.currentItem] = result;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        return true;
    }
}
