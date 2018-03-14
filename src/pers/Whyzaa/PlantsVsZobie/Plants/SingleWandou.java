package pers.Whyzaa.PlantsVsZobie.Plants;


import java.util.Date;
import java.util.Random;

import pers.Whyzaa.PlantsVsZobie.Config.PlantsType;
import pers.Whyzaa.PlantsVsZobie.Utils.GetImages;
import pers.Whyzaa.PlantsVsZobie.Utils.GetPoint;

public class SingleWandou extends Plants{
//	private ArrayList<Bullet> SingleBullet;
//	public ArrayList<Bullet> getSingleBullet() {
//		return SingleBullet;
//	}
//	public void setSingleBullet(ArrayList<Bullet> singleBullet) {
//		SingleBullet = singleBullet;
//	}
	Random r = new Random();
	public SingleWandou() {
		setColdSpeed(600);
		setT(0);
		setHP(8000);
		setMaxHP(8000);
		//setATK(25);
		setPlantstype(PlantsType.WANDOU);
		setSun(100);
		setGifImage(GetImages.GIFIMAGES.get("Peashooter.gif").getImage());
		setImage(GetImages.IMAGES.get("wandou.png"));
		setChoicedImg(GetImages.IMAGES.get("wandou_choiced1.png"));
		setWeight(getGifImage().getWidth(null));
		setHeight(getGifImage().getHeight(null));
	}
	
	
}
