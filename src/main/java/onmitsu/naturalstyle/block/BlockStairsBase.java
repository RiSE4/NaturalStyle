package onmitsu.naturalstyle.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.ItemBlock;
import onmitsu.naturalstyle.common.NaturalStyle;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.util.Helper;

public class BlockStairsBase extends BlockStairs {

    public BlockStairsBase(String name, Block block, int meta)
    {
        super(block, meta);
        this.setBlockName(name);
        this.setCreativeTab(NaturalStyle.TAB_NATURALSTYLE);
        this.setBlockTextureName(Reference.RESOURCES_PATH + name);
        setGeneralProperty(soundTypeStone, 3F, 5F);
    }

    public void setGeneralProperty(SoundType sound, float hardness, float resistance)
    {
        this.setStepSound(sound);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public BlockStairsBase register()
    {
        return this.register(ItemBlock.class);
    }

    public BlockStairsBase register(Class<? extends ItemBlock> cls)
    {
        Helper.addBlock(this, cls);
        return this;
    }
}
