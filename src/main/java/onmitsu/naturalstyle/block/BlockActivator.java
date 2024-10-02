package onmitsu.naturalstyle.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockActivator extends BlockTileBase {

    @SideOnly(Side.CLIENT)
    private IIcon iconTop, iconSide, iconBottom, iconFront;

    public BlockActivator()
    {
        super("activator", Material.rock);
        this.setGeneralProperty(soundTypeStone, 5F, 20F);
    }

    /**
     * 0,  DOWN <br>
     * 1,  UP <br>
     * 2,  NORTH <br>
     * 3,  SOUTH <br>
     * 4,  WEST <br>
     * 5,  EAST
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if(side == 0)
            return iconBottom;
        if(side == 1)
            return iconTop;
        if(side == 2)
            return iconFront;
        else
            return iconSide;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
}
