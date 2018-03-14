package pers.Whyzaa.PlantsVsZobie.Plants;

import pers.Whyzaa.PlantsVsZobie.Config.PlantsType;
import pers.Whyzaa.PlantsVsZobie.Utils.GetImages;

public class JianGuo extends Plants{
	public JianGuo() {
		setColdSpeed(600);
		setT(0);
		setHP(40000);
		setMaxHP(40000);
		//setATK(25);
		setPlantstype(PlantsType.JIANGUO);
		setSun(50);
		setGifImage(GetImages.GIFIMAGES.get("WallNut.gif").getImage());
		setImage(GetImages.IMAGES.get("JianGuo1.png"));
		setChoicedImg(GetImages.IMAGES.get("ChoicedJG.png"));
		setWeight(getGifImage().getWidth(null));
		setHeight(getGifImage().getHeight(null));
	}
}
