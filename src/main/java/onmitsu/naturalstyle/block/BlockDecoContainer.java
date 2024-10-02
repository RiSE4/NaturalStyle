package onmitsu.naturalstyle.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockDecoContainer extends BlockBase {

    private boolean isSlab;

    public BlockDecoContainer(String name)
    {
        super(name, Material.rock);
        this.setGeneralProperty(soundTypeStone, 3F, 5F);
        this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
        this.register();
    }

    public Item getItemDropped(int meta, Random random, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int damageDropped(int meta)
    {
        return meta & 3;
    }

    public boolean func_149730_j()
    {
        return !this.isSlab;
    }

    public boolean isOpaqueCube()
    {
        return !this.isSlab;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase,
                                ItemStack par6ItemStack) {
        int next = par6ItemStack.getItemDamage();

        if (entityLivingBase.isSneaking()) {
            next = next | 4;
        }

        world.setBlockMetadataWithNotify(x, y, z, next, 3);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if ((meta & 4) == 4)
        {
            this.isSlab = true;
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }
        else
        {
            this.isSlab = false;
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

}
