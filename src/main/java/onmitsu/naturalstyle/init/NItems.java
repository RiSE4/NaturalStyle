package onmitsu.naturalstyle.init;

import net.minecraft.item.Item;
import onmitsu.naturalstyle.common.NaturalStyle;
import onmitsu.naturalstyle.item.*;

public class NItems {

    public static Item NATURAL_JEWEL;

    public static Item AURORA_SHOVEL;
    public static Item AURORA_PICKAXE;
    public static Item AURORA_AXE;
    public static Item AURORA_HAMMER;
    public static Item AURORA_HOE;

    public static Item AURORA_HAT;
    public static Item AURORA_CHESTPLATE;
    public static Item AURORA_PANTS;
    public static Item AURORA_BOOTS;

    public static Item CHARM;
    public static Item SENSU;
    public static Item MONSTER_ENERGY;
    public static Item BAKED_SUNFLOWER_SEED;

    public static Item MAPLE_DIAMOND_HAMMER;
    public static Item RECOVERY_HOE;
    public static Item WIRELESS_HOE;

    public static Item AURORA_POCKET;

    public static void load()
    {
        NATURAL_JEWEL = new ItemMetaBase("natural_jewel", new String[] { "essence_rought", "essence_fragment", "essence_sphere", "aurora", "mending_stone" }).register();
        AURORA_SHOVEL = new ItemAuroraShovel("aurora_shovel");
        AURORA_PICKAXE = new ItemAuroraPickaxe("aurora_pickaxe");
        AURORA_AXE = new ItemAuroraAxe("aurora_axe");
        AURORA_HAMMER = new ItemHammer("aurora_hammer", NaturalStyle.TOOL_AURORA);
        AURORA_HOE = new ItemAuroraHoe("aurora_hoe");

        AURORA_HAT = new ItemAuroraGear("aurora_hat", NaturalStyle.ARMOR_AURORA, 0).register();
        AURORA_CHESTPLATE = new ItemAuroraGear("aurora_chestplate", NaturalStyle.ARMOR_AURORA, 1).register();
        AURORA_PANTS = new ItemAuroraGear("aurora_pants", NaturalStyle.ARMOR_AURORA, 2).register();
        AURORA_BOOTS = new ItemAuroraGear("aurora_boots", NaturalStyle.ARMOR_AURORA, 3).register();

        CHARM = new ItemCharm("charm").register();
        SENSU = new ItemSensu("sensu");
        MONSTER_ENERGY = new ItemMonsterEnergy("monster_energy", new String[] { "normal", "absolutely_zero", "khaos", "cuba_libre", "pipeline_punch", "ultra" } ).register();
        BAKED_SUNFLOWER_SEED = new ItemFoodBase("baked_sunflower_seed", 6, 10F, false, 16).register();

        MAPLE_DIAMOND_HAMMER = new ItemHammer("maple_diamond_hammer", NaturalStyle.TOOL_MAPLE_DIAMOND);
        RECOVERY_HOE = new ItemRecoveryHoe("recovery_hoe").register();
        WIRELESS_HOE = new ItemWirelessHoe("wireless_hoe").register();

        AURORA_POCKET = new ItemAuroraPocket("aurora_pocket").register();
    }
}
