package pers.Whyzaa.PlantsVsZobie.Plants;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class PlantsBar {
	public static  ArrayList<Plants> PlantsBarList = new ArrayList<Plants>();
	

	public static ArrayList<Plants> getPlantsBarList() {
		return PlantsBarList;
	}

	public static void setPlantsBarList(ArrayList<Plants> plantsBarList) {
		PlantsBarList = plantsBarList;
	}

	public static Rectangle OnePlants = new Rectangle(103,12,50,72);
	public static Rectangle TwoPlants = new Rectangle(155,12,50,72);
	public static Rectangle ThreePlants = new Rectangle(207,12,50,72);
	public static Rectangle ForPlants = new Rectangle(259,12,50,72);
	public static Rectangle FivePlants = new Rectangle(312,12,50,72);
	public static Rectangle SixPlants = new Rectangle(364,12,50,72);
	public static Rectangle SevenPlants = new Rectangle(416,12,50,72);
	//public static Rectangle Other = new Rectangle(0, 100, 860, 645);
	

	//判断 玩家 点击的是那种植物
	public static Plants GetPlayerPlants(Rectangle r) {
		if(r == OnePlants && PlantsBarList.size()!=0) {
			return PlantsBarList.get(0);
		}else if(r == TwoPlants && PlantsBarList.size()!=0) {
			return PlantsBarList.get(1);
		}else if(r == ThreePlants && PlantsBarList.size()!=0) {
			return PlantsBarList.get(2);
		}else if(r == ForPlants && PlantsBarList.size()!=0) {
			return PlantsBarList.get(3);
		}else if(r == FivePlants && PlantsBarList.size()!=0) {
			return PlantsBarList.get(4);
		}else if(r == SixPlants && PlantsBarList.size()!=0) {
			return PlantsBarList.get(5);
		}else if(r == SevenPlants && PlantsBarList.size()!=0) {
			return PlantsBarList.get(6);
		}else {
			return null;
		}

	}
	public static Rectangle rect;
	public static Rectangle GetRect(MouseEvent e) {
		if(PlantsBar.OnePlants.contains(e.getPoint())) {
			rect = PlantsBar.OnePlants;
		}else if(PlantsBar.TwoPlants.contains(e.getPoint())) {
			rect = PlantsBar.TwoPlants;
		}else if(PlantsBar.ThreePlants.contains(e.getPoint())) {
			rect = PlantsBar.ThreePlants;
		}else if(PlantsBar.ForPlants.contains(e.getPoint())) {
			rect = PlantsBar.ForPlants;
		}else if(PlantsBar.FivePlants.contains(e.getPoint())) {
			rect = PlantsBar.FivePlants;
		}else if(PlantsBar.SixPlants.contains(e.getPoint())) {
			rect = PlantsBar.SixPlants;
		}else if(PlantsBar.SevenPlants.contains(e.getPoint())) {
			rect = PlantsBar.SevenPlants;
		}
		return rect;
		
	}

	
}
