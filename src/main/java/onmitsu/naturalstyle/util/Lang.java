package onmitsu.naturalstyle.util;

import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;

public class Lang {

	public static String localize(String text)
	{
		return StatCollector.translateToLocal(text);
	}

	public static ChatComponentTranslation chat(String text)
	{
		return chat(text, new Object[0]);
	}

	public static ChatComponentTranslation chat(String text, Object ... params)
	{
		return new ChatComponentTranslation(text, params);
	}

	public static String transYesNo(boolean b)
	{
		return localize(b ? "tooltip.yes" : "tooltip.no");
	}

}
