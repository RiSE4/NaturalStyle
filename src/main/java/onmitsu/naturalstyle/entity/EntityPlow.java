package onmitsu.naturalstyle.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPlow extends EntityThrowable {

    public EntityPlow(World world)
    {
        super(world);
    }

    public EntityPlow(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }

    public EntityPlow(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    protected void onImpact(MovingObjectPosition mop)
    {
        if(mop != null)
        {
            for(int x = mop.blockX - 1; x <= mop.blockX + 1; ++x)
            {
                for (int z = mop.blockZ - 1; z <= mop.blockZ + 1; z++)
                {
                    Block block = this.worldObj.getBlock(x, mop.blockY, z);

                    if(block == Blocks.grass || block == Blocks.dirt)
                    {
                        if(!this.worldObj.isRemote)
                        {
                            this.worldObj.setBlock(x, mop.blockY, z, Blocks.farmland);
                        }
                    }
                }
            }
        }
    }
}
