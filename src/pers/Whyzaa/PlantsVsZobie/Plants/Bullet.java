package pers.Whyzaa.PlantsVsZobie.Plants;

import java.awt.Image;
import java.awt.Rectangle;

import pers.Whyzaa.PlantsVsZobie.Config.Config;

public class Bullet extends GameModel{
	
	// GifImage  image ATK  bulletType
	private boolean playmusic;
	public boolean isPlaymusic() {
		return playmusic;
	}

	public void setPlaymusic(boolean playmusic) {
		this.playmusic = playmusic;
	}

	private int index;
	private int maxindex;
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getMaxindex() {
		return maxindex;
	}

	public void setMaxindex(int maxindex) {
		this.maxindex = maxindex;
	}

	private int ATK;
	private BulletType bulletType;

	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public BulletType getBulletType() {
		return bulletType;
	}

	public void setBulletType(BulletType bulletType) {
		this.bulletType = bulletType;
	}
	//ÅÐ¶ÏÊÇ·ñÒÆ³ý½ç
	public boolean MoveBullet() {
		boolean f = true;
		int x = getX() + getSpeed();
		//System.out.println(Config.WINDOWS_WEIGHT-getWeight()+"============"+x);
		if(x > Config.WINDOWS_WEIGHT-getWeight()-5) {
			f = false;
		}else {
			setX(x);
		}
		return f;
	}
	
	public Rectangle GetRectangle() {
		Rectangle r = new Rectangle(getX(),getY(), getWeight(), getHeight());
		return r;
	}
	
}
