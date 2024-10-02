package onmitsu.naturalstyle.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import onmitsu.naturalstyle.common.Reference;
import onmitsu.naturalstyle.inventory.container.ContainerAuroraPocket;
import onmitsu.naturalstyle.util.Lang;
import org.lwjgl.opengl.GL11;

public class GuiAuroraPocket extends GuiContainer {

    private static final ResourceLocation texture = new ResourceLocation(Reference.RESOURCES_PATH + "textures/gui/aurora_pocket.png");

    public GuiAuroraPocket(InventoryPlayer player)
    {
        super(new ContainerAuroraPocket(player));
        this.xSize = 230;
        this.ySize = 240;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int z)
    {
        this.fontRendererObj.drawString(Lang.localize("container.aurora_pocket"), 8, 7, 4210752);
        this.fontRendererObj.drawString(Lang.localize("container.inventory"), 34, this.ySize - 95 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int a, int b)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
