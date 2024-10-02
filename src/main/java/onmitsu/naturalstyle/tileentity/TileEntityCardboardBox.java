package onmitsu.naturalstyle.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import onmitsu.naturalstyle.util.CardboardUtil.BlockData;

public class TileEntityCardboardBox extends TileEntity
{
	public BlockData storedData;

	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);

		if(tag.hasKey("storedData"))
		{
			storedData = BlockData.read(tag.getCompoundTag("storedData"));
		}
	}

	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);

		if(storedData != null)
		{
			tag.setTag("storedData", storedData.write(new NBTTagCompound()));
		}
	}

	public boolean canUpdate()
	{
		return false;
	}
}