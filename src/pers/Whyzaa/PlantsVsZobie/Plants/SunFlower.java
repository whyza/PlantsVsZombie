package pers.Whyzaa.PlantsVsZobie.Plants;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import pers.Whyzaa.PlantsVsZobie.Config.PlantsType;
import pers.Whyzaa.PlantsVsZobie.Utils.GetImages;
import pers.Whyzaa.PlantsVsZobie.Utils.GetPoint;

public class SunFlower extends Plants{
	//public static ArrayList<GetPoint> FlowerSunList = new ArrayList<GetPoint>();
	public static ConcurrentHashMap<Sun,GetPoint> FlowerSunList = new ConcurrentHashMap<Sun,GetPoint>();
	public SunFlower() {
		//System.out.println(new Date().getSeconds()+"---------------------");
		setColdSpeed(200);
		setHP(4000);
		setT(0);
		setPlantstype(PlantsType.SUNFLOWER);
		setSun(50);
		setMaxHP(4000);
		setGifImage(GetImages.GIFIMAGES.get("SunFlower.gif").getImage());
		setImage(GetImages.IMAGES.get("sunflower.png"));
		setChoicedImg(GetImages.IMAGES.get("choicedsunflower.png"));
		setWeight(getGifImage().getWidth(null));
		setHeight(getGifImage().getHeight(null));
	}
	public static boolean isEixt(GetPoint p) {
		boolean f = false;
		for (int i = 0; i < FlowerSunList.size(); i++) {
			if(FlowerSunList.get(i).getX() == p.getX() && FlowerSunList.get(i).getY() == p.getY()) {
				f = true;
			}
		}
		return f;
	}
	
	public static Rectangle GetRect(GetPoint p) {
		Rectangle rect = new Rectangle(p.getX(), p.getY(), 60, 60);
		
		return rect;
	}
	
	public static void drawSun(int x, int y) {
		GetPoint p = new GetPoint(x+10, y-20);
		if (!isEixt(p)) {
			//FlowerSunList.add(p);
		}
		System.out.println("FlowerSunList" + FlowerSunList.size());
	}
}

