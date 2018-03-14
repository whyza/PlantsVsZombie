package pers.Whyzaa.PlantsVsZobie.Plants;

import pers.Whyzaa.PlantsVsZobie.Config.PlantsType;
import pers.Whyzaa.PlantsVsZobie.Utils.GetImages;

public class IceWanDou extends Plants{
	public IceWanDou() {
		setColdSpeed(600);
		setT(0);
		setHP(7000);
		setMaxHP(7000);
		//setATK(25);
		setPlantstype(PlantsType.ICEWANDOU);
		setSun(175);
		setGifImage(GetImages.GIFIMAGES.get("SnowPea.gif").getImage());
		setImage(GetImages.IMAGES.get("icewandou.png"));
		setChoicedImg(GetImages.IMAGES.get("icechoicewano.png"));
		setWeight(getGifImage().getWidth(null));
		setHeight(getGifImage().getHeight(null));
	}
}
