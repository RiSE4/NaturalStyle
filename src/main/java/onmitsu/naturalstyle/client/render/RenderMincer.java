package onmitsu.naturalstyle.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.tileentity.TileEntity;
import onmitsu.naturalstyle.tileentity.TileEntityMincer;

public class RenderMincer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f)
	{
		this.renderMincer((TileEntityMincer) tile, x, y, z, f);
	}

	private void renderMincer(TileEntityMincer tile, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y, (float) z + 0.5F);
		func_98144_a(tile, x, y, z, f);
		GL11.glPopMatrix();
	}

	private void func_98144_a(TileEntityMincer tile, double x, double y, double z, float f)
	{

		EntityVillager entity = tile.getVillager();

		float time = (float) tile.getRunTime();

		if(time <= 20F)
		{
			time = 0F;
		}

		if(entity != null)
		{
			float val;

			if(time < 20F)
			{
				val = time * time;
			}
			else
			{
				val = (float) Math.sin((float) time) * 360F;
			}

			GL11.glTranslatef(0.0F, 0.4F, 0.0F);

			if(entity.deathTime == 0)
			{
				GL11.glRotatef(val, 0.0F, 1.0F, 0.0F);
			}

			GL11.glTranslatef(0.0F, -time / 80.0F, 0.0F);
			entity.setLocationAndAngles(x, y, z, 0F, 0F);
			RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, f);
		}
	}

}
