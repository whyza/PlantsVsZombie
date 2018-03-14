package pers.Whyzaa.PlantsVsZobie.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map.Entry;

import pers.Whyzaa.PlantsVsZobie.Plants.Plants;


public class DrawPlantsInMap {
	public static ArrayList<Plants> PlantsLists = new ArrayList<>();
	
	//IdentityHashMap  Key值可以重复的map集合
	//public static  IdentityHashMap<Plants, GetPoint> PlantsMap = new IdentityHashMap<Plants, GetPoint>();
	public static  ConcurrentHashMap<Plants, GetPoint> PlantsMap = new ConcurrentHashMap<Plants, GetPoint>();
	public static ArrayList<Plants> getPlantsLists() {
		return PlantsLists;
	}
	public static void setPlantsLists(ArrayList<Plants> plantsLists) {
		PlantsLists = plantsLists;
	}
	
	public static void AcdMapCreatBullet() {
		Set<Entry<Plants, GetPoint>> entrySet=DrawPlantsInMap.PlantsMap.entrySet();
		for(Entry<Plants, GetPoint> entry: entrySet){
			Factory.CreatPlantsDaoJu(entry.getKey(),entry.getValue());
		} 
	}
	
	
	/**
	 * 判断区域是否种过植物
	 * @param getp
	 * @return
	 */
	public static boolean IsExitPlant(GetPoint getp) {
		Set<Entry<Plants, GetPoint>> entrySet=DrawPlantsInMap.PlantsMap.entrySet();
		boolean f = true;
		for(Entry<Plants, GetPoint> entry: entrySet){
			//System.out.println(entry.getValue().getX()+"--------------"+entry.getValue().getY());
			if((entry.getValue().getX() == getp.getX() && entry.getValue().getY() == getp.getY())) {
				f = false;
			}
		} 
		return f;
	}
	//static Graphics g;
//	public static void GEt() {
//		Set<Entry<Plants, GetPoint>> entrySet=DrawPlantsInMap.PlantsMap.entrySet();
//		for(Entry<Plants, GetPoint> entry: entrySet){
//			//System.out.println(entry.getValue().getX()+"====="+entry.getValue().getY());
//			if(entry.getKey().getPlantstype() == PlantsType.SUNFLOWER) {
//				SunFlower.drawSun(entry.getValue().getX(), entry.getValue().getY());
//			}else if(entry.getKey().getPlantstype() == PlantsType.WANDOU) {
//				
//			}
//		} 
//	}
//	
//	static int sflow = 0;
//	public static int GetPlantCount() {
//		Set<Entry<Plants, GetPoint>> entrySet=DrawPlantsInMap.PlantsMap.entrySet();
//		int f = 0;
//		for(Entry<Plants, GetPoint> entry: entrySet){
//			//System.out.println(entry.getValue().getX()+"====="+entry.getValue().getY());
//			if(entry.getKey().getPlantstype() == PlantsType.SUNFLOWER) {
//				 f = 1;
//				//System.out.println("12312321");
//				// System.out.println(entry.getKey().getDa()+"=======");
//			}else if(entry.getKey().getPlantstype() == PlantsType.WANDOU) {
//				f = 2;
//			}
//		} 
//		return f;
		
	

}
