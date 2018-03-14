package pers.Whyzaa.PlantsVsZobie.Plants;

import pers.Whyzaa.PlantsVsZobie.Config.PlantsType;
import pers.Whyzaa.PlantsVsZobie.Utils.GetImages;

public class DoubleWanDou extends Plants{
	public DoubleWanDou() {
		setColdSpeed(600);
		setT(10);
		setHP(8000);
		setMaxHP(8000);
		setPlantstype(PlantsType.DOUBLEWANDOU);
		setSun(200);
		setGifImage(GetImages.GIFIMAGES.get("Repeater.gif").getImage());
		setImage(GetImages.IMAGES.get("DoubleWanDou.png"));
		setChoicedImg(GetImages.IMAGES.get("DoubleWanDouChoiced.png"));
		setWeight(getGifImage().getWidth(null));
		setHeight(getGifImage().getHeight(null));
	}
}
