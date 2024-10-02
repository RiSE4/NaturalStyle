package onmitsu.naturalstyle.init;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import onmitsu.naturalstyle.event.AchievementEvent;
import onmitsu.naturalstyle.util.Helper;

public class NAchievements {

    public static Achievement MINING_ESSENCE_ORE;
    public static Achievement MINING_AURORA_ORE;
    public static Achievement CRAFT_MINCER;
    public static Achievement CRAFT_AURORA_HAMMER;
    public static Achievement CRAFT_AURORA_ARMOR;
    public static Achievement SMELT_BAKED_SEED;
    public static Achievement CRAFT_MONSTER;
    public static Achievement EAT_HOE;

    public static void load()
    {
        MINING_ESSENCE_ORE = registerAchievement("mining_essence_ore", -2, -1, new ItemStack(NBlocks.NATURAL_ORE, 1, 0), null);
        MINING_AURORA_ORE = registerAchievement("mining_aurora_ore", -1, -1, new ItemStack(NBlocks.NATURAL_ORE, 1, 1), null);
        CRAFT_MINCER = registerAchievement("craft_mincer", 1, 2, new ItemStack(NBlocks.VILLAGER_MINCER), MINING_AURORA_ORE).setSpecial();
        CRAFT_AURORA_HAMMER = registerAchievement("craft_aurora_hammer", 2, 1, new ItemStack(NItems.AURORA_HAMMER), MINING_AURORA_ORE);
        CRAFT_AURORA_ARMOR = registerAchievement("craft_aurora_armor", 0, 3, new ItemStack(NItems.AURORA_HAT), MINING_AURORA_ORE);
        SMELT_BAKED_SEED = registerAchievement("smelt_baked_seed", 2, -2, new ItemStack(NItems.BAKED_SUNFLOWER_SEED), AchievementList.buildFurnace);
        CRAFT_MONSTER = registerAchievement("craft_monster", 4, -2, new ItemStack(NItems.MONSTER_ENERGY), null);
        EAT_HOE = registerAchievement("eat_hoe", 4, 2, new ItemStack(NItems.RECOVERY_HOE), null);

        Achievement[] list = new Achievement[] { MINING_ESSENCE_ORE, MINING_AURORA_ORE, CRAFT_MINCER, CRAFT_AURORA_HAMMER, CRAFT_AURORA_ARMOR, SMELT_BAKED_SEED, CRAFT_MONSTER, EAT_HOE };
        AchievementPage.registerAchievementPage(new AchievementPage("NaturalStyle", list));
        Helper.addFMLEvent(new AchievementEvent());
    }

    private static Achievement registerAchievement(String name, int posX, int posY, ItemStack iconStack, Achievement required)
    {
        return new Achievement("achievement.naturalstyle." + name, name, posX, posY, iconStack, required).registerStat();
    }
}
