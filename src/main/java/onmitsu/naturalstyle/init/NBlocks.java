package onmitsu.naturalstyle.init;

import net.minecraft.block.Block;
import onmitsu.naturalstyle.block.*;
import onmitsu.naturalstyle.tileentity.TileEntityCardboardBox;
import onmitsu.naturalstyle.tileentity.TileEntityMincer;
import onmitsu.naturalstyle.util.Helper;

public class NBlocks {

    public static Block NATURAL_ORE;
    public static Block ORE_BLOCK;
    public static Block VILLAGER_MINCER;
    public static Block CARDBOARD_BOX;
    public static Block AMT_DECORATION_CONTAINER;
    public static Block UNBREAKING_ANVIL;
    public static Block BRICK_MIX;
    public static Block BRICK_BROWN;
    public static Block BRICK_COLOR;
    public static Block BRICK_DARK;
    public static Block BRICK_LIGHT;
    public static Block BRICK_STAIRS_MIX;
    public static Block BRICK_STAIRS_BROWN;
    public static Block BRICK_STAIRS_COLOR;
    public static Block BRICK_STAIRS_DARK;
    public static Block BRICK_STAIRS_LIGHT;

    public static Block ACTIVATOR;

    public static void load() {
        NATURAL_ORE = new BlockNaturalOre("natural_ore");
        ORE_BLOCK = new BlockCompressed("ore_block");
        VILLAGER_MINCER = new BlockMincer("mincer");
        Helper.addTileEntity(TileEntityMincer.class);
        CARDBOARD_BOX = new BlockCardboardBox("cardboard_box");
        Helper.addTileEntity(TileEntityCardboardBox.class);
        AMT_DECORATION_CONTAINER = new BlockDecoContainer("amt_decoration_container");
        UNBREAKING_ANVIL = new BlockUnbreakingAnvil("unbreaking_anvil");

        //DECO_BLOCK
        BRICK_MIX = new BlockDecoContainer("mix_brick");
        BRICK_BROWN = new BlockDecoContainer("brick_brown");
        BRICK_COLOR = new BlockDecoContainer("brick_color");
        BRICK_DARK = new BlockDecoContainer("brick_dark");
        BRICK_LIGHT = new BlockDecoContainer("brick_light");
        BRICK_STAIRS_MIX = new BlockStairsBase("brick_stairs_mix", BRICK_MIX, 0).register();
        BRICK_STAIRS_BROWN = new BlockStairsBase("brick_stairs_brown", BRICK_BROWN, 0).register();
        BRICK_STAIRS_COLOR = new BlockStairsBase("brick_stairs_color", BRICK_COLOR, 0).register();
        BRICK_STAIRS_DARK = new BlockStairsBase("brick_stairs_dark", BRICK_DARK, 0).register();
        BRICK_STAIRS_LIGHT = new BlockStairsBase("brick_stairs_light", BRICK_LIGHT, 0).register();

    }
}
