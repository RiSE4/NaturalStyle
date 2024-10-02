package onmitsu.naturalstyle.crafting;

import buildcraft.BuildCraftBuilders;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftFactory;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import onmitsu.naturalstyle.init.ModStacks;
import onmitsu.naturalstyle.init.NBlocks;
import onmitsu.naturalstyle.init.NItems;

public class Recipes {

    public static void blockRecipe()
    {
        GameRegistry.addRecipe(new ItemStack(NItems.NATURAL_JEWEL, 1, 1), "XX", "XX", 'X', new ItemStack(NItems.NATURAL_JEWEL, 1, 0));

        GameRegistry.addRecipe(new ItemStack(NItems.NATURAL_JEWEL, 1, 2), "XX", "XX", 'X', new ItemStack(NItems.NATURAL_JEWEL, 1, 1));

        addCompressedRecipe(new ItemStack(NBlocks.ORE_BLOCK, 1, 0), new ItemStack(NItems.NATURAL_JEWEL, 9, 2));
        addCompressedRecipe(new ItemStack(NBlocks.ORE_BLOCK, 1, 1), new ItemStack(NItems.NATURAL_JEWEL, 9, 3));

        GameRegistry.addRecipe(new ItemStack(NBlocks.VILLAGER_MINCER, 2, 0),
                "DAD",
                "AQA",
                "DAD",
                'D', Items.diamond_sword, 'A', new ItemStack(NBlocks.ORE_BLOCK, 1, 1), 'Q', new ItemStack(NItems.NATURAL_JEWEL, 1, 4));

        GameRegistry.addRecipe(new ItemStack(NBlocks.CARDBOARD_BOX, 1, 0),
                "PSP",
                "PCP",
                "PPP",
                'P', Items.paper, 'C', Blocks.chest, 'S', Items.slime_ball);

        GameRegistry.addRecipe(new ItemStack(NBlocks.UNBREAKING_ANVIL, 1, 0),
                "III",
                "ISI",
                "AAA", 'I', Blocks.iron_block, 'S', new ItemStack(NItems.NATURAL_JEWEL, 1, 4), 'A', Blocks.anvil);

        GameRegistry.addRecipe(new ItemStack(NBlocks.BRICK_MIX, 1, 0),
                "CSC","SBS","CSC",'C', Blocks.cobblestone, 'S', Blocks.sandstone, 'B', Items.brick);
        GameRegistry.addRecipe(new ItemStack(NBlocks.BRICK_BROWN, 1, 0),
                " C ","CBC"," C ",'C', new ItemStack(Items.dye, 1, 3),'B', Blocks.brick_block);
        GameRegistry.addRecipe(new ItemStack(NBlocks.BRICK_COLOR, 1, 0),
                " C ","CBC"," C ",'C', new ItemStack(Items.dye, 1, 11),'B', Blocks.brick_block);
        GameRegistry.addRecipe(new ItemStack(NBlocks.BRICK_DARK, 1, 0),
                " S ","CBC"," S ",'C', new ItemStack(Blocks.stone_slab,1,0), 'S', Blocks.stonebrick, 'B', Blocks.brick_block);
        GameRegistry.addRecipe(new ItemStack(NBlocks.BRICK_LIGHT, 1, 0),
                " S ","CBC"," S ",'C', new ItemStack(Blocks.stone_slab,1,0), 'S', Blocks.sandstone, 'B', Blocks.brick_block);

        GameRegistry.addRecipe(new ItemStack(NBlocks.BRICK_STAIRS_MIX, 1, 0),
                "  S"," SS","SSS",'S', NBlocks.BRICK_MIX);
        GameRegistry.addRecipe(new ItemStack(NBlocks.BRICK_STAIRS_BROWN, 1, 0),
                "  S"," SS","SSS",'S', NBlocks.BRICK_BROWN);
        GameRegistry.addRecipe(new ItemStack(NBlocks.BRICK_STAIRS_COLOR, 1, 0),
                "  S"," SS","SSS",'S', NBlocks.BRICK_COLOR);
        GameRegistry.addRecipe(new ItemStack(NBlocks.BRICK_STAIRS_DARK, 1, 0),
                "  S"," SS","SSS",'S', NBlocks.BRICK_DARK);
        GameRegistry.addRecipe(new ItemStack(NBlocks.BRICK_STAIRS_LIGHT, 1, 0),
                "  S"," SS","SSS",'S', NBlocks.BRICK_LIGHT);

    }

    public static void itemRecipe()
    {
        GameRegistry.addRecipe(new ItemStack(NItems.NATURAL_JEWEL, 1, 4), "SDS",
                "ACA",
                "SMS",
                'S', new ItemStack(NItems.NATURAL_JEWEL, 1, 2), 'D', Items.diamond, 'A', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'C', new ItemStack(NItems.CHARM, 1, 0), 'M', Items.emerald);

        GameRegistry.addRecipe(new ItemStack(NItems.CHARM, 1, 0), "LAL",
                "IEI",
                "LAL",
                'L', Items.leather, 'A', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'I', Items.iron_ingot, 'E', new ItemStack(NItems.NATURAL_JEWEL, 1, 2));

        GameRegistry.addRecipe(new ItemStack(NItems.CHARM, 1, 1), "#K#",
                "ACA",
                "#P#",
                '#', Items.ender_eye, 'A', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'K', Items.nether_star, 'C', new ItemStack(NItems.CHARM, 1, 0), 'P', Items.clock);

        GameRegistry.addRecipe(new ItemStack(NItems.CHARM, 1, 2), "#K#",
                "ACA",
                "#P#",
                '#', Items.ghast_tear, 'A', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'K', Items.nether_star, 'C', new ItemStack(NItems.CHARM, 1, 0), 'P', Items.clock);

        GameRegistry.addRecipe(new ItemStack(NItems.CHARM, 1, 3), "#K#",
                "ACA",
                "#P#",
                '#', Items.diamond, 'A', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'K', Items.nether_star, 'C', new ItemStack(NItems.CHARM, 1, 0), 'P', Items.clock);

        GameRegistry.addRecipe(new ItemStack(NItems.AURORA_PICKAXE), "TTT",
                " # ",
                " S ",
                'T', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'S', Items.stick, '#', new ItemStack(NItems.NATURAL_JEWEL, 1, 4));

        GameRegistry.addRecipe(new ItemStack(NItems.AURORA_SHOVEL),
                "T", "#", "S", 'T', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'S', Items.stick, '#', new ItemStack(NItems.NATURAL_JEWEL, 1, 4));

        GameRegistry.addRecipe(new ItemStack(NItems.AURORA_AXE), "TT",
                "T#",
                " S",
                'T', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'S', Items.stick, '#', new ItemStack(NItems.NATURAL_JEWEL, 1, 4));

        GameRegistry.addRecipe(new ItemStack(NItems.AURORA_HOE), "TT",
                " #",
                " S",
                'T', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'S', Items.stick, '#', new ItemStack(NItems.NATURAL_JEWEL, 1, 4));

        GameRegistry.addRecipe(new ItemStack(NItems.AURORA_HAMMER), "APK",
                " S ",
                " S ",
                'S', Items.stick, 'A', NItems.AURORA_AXE, 'P', NItems.AURORA_SHOVEL, 'K', NItems.AURORA_PICKAXE);

        GameRegistry.addRecipe(new ItemStack(NItems.AURORA_HAT), " # ",
                "ISI",
                "#R#",
                '#', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'S', new ItemStack(NItems.NATURAL_JEWEL, 1, 2), 'R', new ItemStack(NItems.NATURAL_JEWEL, 1, 4), 'I', Items.iron_ingot);

        GameRegistry.addRecipe(new ItemStack(NItems.AURORA_CHESTPLATE), "# #",
                "IRI",
                "#S#",
                '#', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'S', new ItemStack(NItems.NATURAL_JEWEL, 1, 2), 'R', new ItemStack(NItems.NATURAL_JEWEL, 1, 4), 'I', Items.iron_ingot);

        GameRegistry.addRecipe(new ItemStack(NItems.AURORA_PANTS), "SRS",
                "#I#",
                "# #",
                '#', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'S', new ItemStack(NItems.NATURAL_JEWEL, 1, 2), 'R', new ItemStack(NItems.NATURAL_JEWEL, 1, 4), 'I', Items.iron_ingot);

        GameRegistry.addRecipe(new ItemStack(NItems.AURORA_BOOTS), "#S#",
                "#R#",
                "I I",
                '#', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'S', new ItemStack(NItems.NATURAL_JEWEL, 1, 2), 'R', new ItemStack(NItems.NATURAL_JEWEL, 1, 4), 'I', Items.iron_ingot);

        GameRegistry.addRecipe(new ItemStack(NItems.RECOVERY_HOE, 1, 0),
                "TT",
                " S",
                " S", 'S', Items.stick, 'T', new ItemStack(NItems.NATURAL_JEWEL, 1, 0));

        GameRegistry.addRecipe(new ItemStack(NItems.AURORA_POCKET, 1, 0), "EAE",
                "SCS",
                "AGA",
                'S', Items.string, 'A', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'G', Items.gold_ingot, 'E', new ItemStack(NItems.NATURAL_JEWEL, 1, 2), 'C', Blocks.chest);


        //NORMAL RECIPE
        GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather), 0.4F);
        GameRegistry.addRecipe(new ItemStack(Blocks.dirt, 1, 0), "##", "##", '#', Blocks.cobblestone);
        GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 1, 0), "##", "##", '#', Blocks.dirt);
        GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 1, 0), "##", "##", '#', Blocks.leaves);
        GameRegistry.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 1, 0), "##", "##", '#', Blocks.leaves2);

    }

    private static void addCompressedRecipe(ItemStack block, ItemStack item)
    {
        GameRegistry.addRecipe(block, "XXX", "XXX", "XXX", 'X', item);

        GameRegistry.addShapelessRecipe(item, block);
    }

    public static void postRecipe()
    {
        CraftHelper.deleteRecipe(new ItemStack(BuildCraftBuilders.quarryBlock));

        GameRegistry.addRecipe(new ItemStack(BuildCraftBuilders.quarryBlock, 1, 0),
                "DND",
                "ECE",
                "DPD",
                'D', BuildCraftCore.diamondGearItem, 'N', Items.nether_star, 'E', new ItemStack(BuildCraftCore.engineBlock, 1, 2), 'C', BuildCraftFactory.miningWellBlock, 'P', Items.diamond_pickaxe);

        if (ModStacks.IC2_STEEL_INGOT != null)
            GameRegistry.addSmelting(Items.iron_ingot, ModStacks.IC2_STEEL_INGOT, 0.8F);

        if (Loader.isModLoaded("BambooMod"))
        {
            CraftHelper.addShapedOreRecipe(new ItemStack(NItems.SENSU), "PPP",
                    "PNP",
                    "TTT",
                    'P', Items.paper, 'N', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'T', "bamboo");
        }
        else
            {
            GameRegistry.addRecipe(new ItemStack(NItems.SENSU), "PPP",
                    "PNP",
                    "TTT",
                    'P', Items.paper, 'N', new ItemStack(NItems.NATURAL_JEWEL, 1, 3), 'T', Items.stick);
        }

        Item seed = GameRegistry.findItem("mod_ecru_MapleTree", "SunFlowerSeed");
        if (seed != null)
            GameRegistry.addSmelting(seed, new ItemStack(NItems.BAKED_SUNFLOWER_SEED), 0.4F);
        else
            GameRegistry.addSmelting(new ItemStack(Blocks.double_plant, 1, 0), new ItemStack(NItems.BAKED_SUNFLOWER_SEED), 0.5F);

        Block con = GameRegistry.findBlock("DCsAppleMilk", "defeatedcrow.Charcoalcontainer");
        if (con != null)
            GameRegistry.addRecipe(new ItemStack(NBlocks.AMT_DECORATION_CONTAINER, 1, 0), "XPX", 'X', Items.iron_ingot, 'P', con);
        else
            GameRegistry.addShapelessRecipe(new ItemStack(NBlocks.AMT_DECORATION_CONTAINER, 1, 0), Blocks.bedrock);

        if (ModStacks.MAPLE_AXE != null && ModStacks.MAPLE_SHOVEL != null && ModStacks.MAPLE_PICKAXE != null)
        {
            GameRegistry.addRecipe(new ItemStack(NItems.MAPLE_DIAMOND_HAMMER), "APK",
                    " S ",
                    " S ",
                    'S', Items.stick, 'A', ModStacks.MAPLE_AXE, 'P', ModStacks.MAPLE_SHOVEL, 'K', ModStacks.MAPLE_PICKAXE);
        }
    }
}
