package onmitsu.naturalstyle.client.model;

import net.minecraft.client.model.ModelBiped;

public class ThinArmor extends ModelBiped {

	public ThinArmor(float size, int slot)
	{
		super(size, 0, 64, 32);

		if(slot != 0)
		{
			this.bipedHead.isHidden = true;
			this.bipedHeadwear.isHidden = true;
		}

		if(slot != 1)
		{
			this.bipedBody.isHidden = true;
			this.bipedRightArm.isHidden = true;
			this.bipedLeftArm.isHidden = true;
		}

		if(slot != 2 && slot != 3)
		{
			this.bipedRightLeg.isHidden = true;
			this.bipedLeftLeg.isHidden = true;
		}
	}
}
