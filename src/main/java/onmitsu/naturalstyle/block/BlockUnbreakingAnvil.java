package onmitsu.naturalstyle.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockAnvil;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import onmitsu.naturalstyle.common.NaturalStyle;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.inventory.GuiHandler;
import onmitsu.naturalstyle.util.Helper;

import java.util.List;

public class BlockUnbreakingAnvil extends BlockAnvil {

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    public BlockUnbreakingAnvil(String name)
    {
        super();
        this.setBlockName(name);
        this.setCreativeTab(NaturalStyle.TAB_NATURALSTYLE);
        this.setBlockTextureName(Reference.RESOURCES_PATH + name);
        this.setStepSound(soundTypeAnvil);
        this.setHardness(5F);
        this.setResistance(18F);
        Helper.addBlock(this);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote) {
            Helper.openGui(player, GuiHandler.GUI_UNBREAKING_ANVIL, world, x, y, z);
        }
        return true;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return 35;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (this.anvilRenderSide == 3 && side == 1)
        {
            return this.iconTop;
        }
        else
        {
            return this.blockIcon;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.blockIcon = icon.registerIcon(this.getTextureName() + "_base");
        this.iconTop = icon.registerIcon(this.getTextureName() + "_top");
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
    }
}
