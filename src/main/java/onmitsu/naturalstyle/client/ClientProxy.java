package onmitsu.naturalstyle.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import onmitsu.naturalstyle.client.model.ThinArmor;
import onmitsu.naturalstyle.client.render.RenderMincer;
import onmitsu.naturalstyle.common.CommonProxy;
import onmitsu.naturalstyle.entity.EntityPlow;
import onmitsu.naturalstyle.entity.EntityWind;
import onmitsu.naturalstyle.init.NItems;
import onmitsu.naturalstyle.tileentity.TileEntityMincer;
import onmitsu.naturalstyle.util.Helper;

public class ClientProxy extends CommonProxy {

	private static Render DUMMY_RENDER = new Render()
	{
		public void doRender(Entity entity, double x, double y, double z, float f1, float f2) {}

		protected ResourceLocation getEntityTexture(Entity entity)
		{
			return null;
		}
	};

	public static ModelBiped VEST = new ThinArmor(0.5F, 1);
	public static ModelBiped BOOTS = new ThinArmor(0.9F, 3);

	@Override
	public void registerRenders()
	{
		Helper.addTileEntityRenderer(TileEntityMincer.class, new RenderMincer());
		Helper.addForgeEvent(this);
		Helper.addEntityRenderer(EntityWind.class, DUMMY_RENDER);
		Helper.addEntityRenderer(EntityPlow.class, new RenderSnowball(NItems.NATURAL_JEWEL, 4));
	}

	@SubscribeEvent
	public void applyArmorModel(RenderPlayerEvent.SetArmorModel event)
	{
		ModelBiped model = event.renderer.modelBipedMain;

		switch(event.slot)
		{
		case 1:
			VEST.onGround = model.onGround;
			VEST.isRiding = model.isRiding;
			VEST.isChild = model.isChild;
			VEST.isSneak = model.isSneak;
			VEST.heldItemRight = model.heldItemRight;
			VEST.heldItemLeft = model.heldItemLeft;

		case 3:
			BOOTS.onGround = model.onGround;
			BOOTS.isRiding = model.isRiding;
			BOOTS.isChild = model.isChild;
			BOOTS.isSneak = model.isSneak;
			break;
		}
	}
}
