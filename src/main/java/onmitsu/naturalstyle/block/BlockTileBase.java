package onmitsu.naturalstyle.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockTileBase extends BlockBase implements ITileEntityProvider {

	public BlockTileBase(String name, Material material)
	{
		super(name, material);
		this.isBlockContainer = true;
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	{
		super.breakBlock(world, x, y, z, block, meta);
		world.removeTileEntity(x, y, z);
	}

	public boolean onBlockEventReceived(World world, int x, int y, int z, int eventID, int eventData)
	{
		super.onBlockEventReceived(world, x, y, z, eventID, eventData);
		TileEntity tile = world.getTileEntity(x, y, z);
		return tile != null && tile.receiveClientEvent(eventID, eventData);
	}
}
