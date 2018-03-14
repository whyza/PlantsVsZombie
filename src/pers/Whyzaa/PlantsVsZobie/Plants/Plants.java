package pers.Whyzaa.PlantsVsZobie.Plants;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import pers.Whyzaa.PlantsVsZobie.Config.PlantsType;
import pers.Whyzaa.PlantsVsZobie.Utils.GetPoint;

public class Plants extends GameModel{

	// BulletsList   ChoicedImg   GifImg img Sun HP
	private  int ColdSpeed;
	public  int getColdSpeed() {
		return ColdSpeed;
	}
	public  void setColdSpeed(int coldSpeed) {
		ColdSpeed = coldSpeed;
	}
	private boolean iscold;

	public boolean isIscold() {
		return iscold;
	}
	public void setIscold(boolean iscold) {
		this.iscold = iscold;
	}
	public static int GetColdTime(Plants p) {
		int n = 0;
		if(p.getPlantstype() == PlantsType.SUNFLOWER) {
			n = 100;
		}else if(p.getPlantstype() == PlantsType.DOUBLEWANDOU || p.getPlantstype() == PlantsType.WANDOU) {
			n = 600;
		}else if(p.getPlantstype() == PlantsType.CHERRYBOOM) {
			n = 600;
		}
		return n;
	}
	
	public static int GetColdSpeed(Plants p) {
		int n = 0;
		if(p.getPlantstype() == PlantsType.SUNFLOWER) {
			n = 300;
		}else if(p.getPlantstype() == PlantsType.DOUBLEWANDOU || p.getPlantstype() == PlantsType.WANDOU) {
			n = 400;
		}else if(p.getPlantstype() == PlantsType.ICEWANDOU) {
			n = 600;
		}else if(p.getPlantstype() == PlantsType.CHERRYBOOM) {
			n = 2500;
		}else if(p.getPlantstype() == PlantsType.JIANGUO) {
			n = 2100;
		}
		return n;
	}
	private int adatk;
	private int adspeed;
	public int getAdspeed() {
		return adspeed;
	}
	public void setAdspeed(int adspeed) {
		this.adspeed = adspeed;
	}
	private int adindex;
	public int getAdindex() {
		return adindex;
	}
	public void setAdindex(int adindex) {
		this.adindex = adindex;
	}
	public int getAdatk() {
		return adatk;
	}
	public void setAdatk(int adatk) {
		this.adatk = adatk;
	}

	private PlantsType plantstype;
	private int Sun;
	private Image ChoicedImg;
	private boolean isChoiced;

	public static ConcurrentHashMap<Bullet,GetPoint> BulletsList = new ConcurrentHashMap<Bullet,GetPoint>();
	
	public ConcurrentHashMap<Bullet, GetPoint> getBulletsList() {
		return BulletsList;
	}
	public void setBulletsList(ConcurrentHashMap<Bullet, GetPoint> bulletsList) {
		BulletsList = bulletsList;
	}
	
	
	public Image getChoicedImg() {
		return ChoicedImg;
	}
	public void setChoicedImg(Image choicedImg) {
		ChoicedImg = choicedImg;
	}


	
	public boolean isChoiced() {
		return isChoiced;
	}
	public void setChoiced(boolean isChoiced) {
		this.isChoiced = isChoiced;
	}
	
	public int getSun() {
		return Sun;
	}
	public void setSun(int sun) {
		Sun = sun;
	}
	public PlantsType getPlantstype() {
		return plantstype;
	}
	public void setPlantstype(PlantsType plantstype) {
		this.plantstype = plantstype;
	}	
	
	public Rectangle GetRectangle() {
		Rectangle r = new Rectangle(getX(),getY(), getWeight(), getHeight());
		return r;
	}
}
