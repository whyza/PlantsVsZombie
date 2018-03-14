package pers.Whyzaa.PlantsVsZobie.Plants;

import pers.Whyzaa.PlantsVsZobie.Config.PlantsType;
import pers.Whyzaa.PlantsVsZobie.Utils.GetImages;

public class CherryBoom extends Plants{
	public CherryBoom() {
		setGifImage(GetImages.GIFIMAGES.get("CherryBomb.gif").getImage());
		setImage(GetImages.IMAGES.get("cherryboom.png"));
		setWeight(getImage().getWidth(null));
		setHeight(getImage().getHeight(null));
		setColdSpeed(600);
		setT(0);
		//setATK(25);
		setPlantstype(PlantsType.CHERRYBOOM);
		setSun(150);
		setChoicedImg(GetImages.IMAGES.get("choicedcherryboom.png"));
	}
}
