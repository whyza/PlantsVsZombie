package pers.Whyzaa.PlantsVsZobie.Zobie;

import pers.Whyzaa.PlantsVsZobie.Utils.GetImages;

public class CatZombie extends Zombie{
	public CatZombie(int X) {
		setGifImage(GetImages.GIFIMAGES.get("ConeheadZombie.gif").getImage());
		setHeight(getGifImage().getHeight(null));
		setWeight(getGifImage().getWidth(null));	
		setX(X);
		setY(RanSetY()-getHeight()/2);
		setHP(300);
		setMaxHP(300);
		setSpeed(100);
		setZombieAtk(10);
		setZbType(ZombieType.CAT);
		//setDeathing(false);
	}
}
