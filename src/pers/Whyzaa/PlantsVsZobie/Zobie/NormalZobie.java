package pers.Whyzaa.PlantsVsZobie.Zobie;

import java.awt.Image;

import pers.Whyzaa.PlantsVsZobie.Utils.GetImages;

public class NormalZobie extends Zombie{
	
	public NormalZobie(int X) {
		setGifImage(GetImages.GIFIMAGES.get("Zombie.gif").getImage());
		setHeight(getGifImage().getHeight(null));
		setWeight(getGifImage().getWidth(null));	
		setX(X);
		setY(RanSetY()-getHeight()/2);
		setHP(150);
		setMaxHP(150);
		setSpeed(80);
		setZombieAtk(8);
		setZbType(ZombieType.NORMAL);
	}
}
