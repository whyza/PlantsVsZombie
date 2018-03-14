package pers.Whyzaa.PlantsVsZobie.Plants;

import pers.Whyzaa.PlantsVsZobie.Config.PlantsType;
import pers.Whyzaa.PlantsVsZobie.Utils.GetImages;

public class QuanHuang extends Plants{
	public QuanHuang() {
		setColdSpeed(600);
		setT(0);
		setHP(5000);
		setMaxHP(5000);
		//setATK(25);
		setPlantstype(PlantsType.QUANHUANG);
		setSun(175);
		setGifImage(GetImages.GIFIMAGES.get("quanhuang.gif").getImage());
		setImage(GetImages.IMAGES.get("icewandou.png"));
		setChoicedImg(GetImages.IMAGES.get("icechoicewano.png"));
		setWeight(getGifImage().getWidth(null));
		setHeight(getGifImage().getHeight(null));
	}
}
