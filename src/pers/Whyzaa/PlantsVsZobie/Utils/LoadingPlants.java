package pers.Whyzaa.PlantsVsZobie.Utils;

import java.awt.Event;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import pers.Whyzaa.PlantsVsZobie.Config.Config;
import pers.Whyzaa.PlantsVsZobie.Config.GameState;
import pers.Whyzaa.PlantsVsZobie.MainFrame.PlantsVSZobie;
import pers.Whyzaa.PlantsVsZobie.Plants.CherryBoom;
import pers.Whyzaa.PlantsVsZobie.Plants.DoubleWanDou;
import pers.Whyzaa.PlantsVsZobie.Plants.IceWanDou;
import pers.Whyzaa.PlantsVsZobie.Plants.JianGuo;
import pers.Whyzaa.PlantsVsZobie.Plants.Plants;
import pers.Whyzaa.PlantsVsZobie.Plants.PlantsBar;
import pers.Whyzaa.PlantsVsZobie.Plants.QuanHuang;
import pers.Whyzaa.PlantsVsZobie.Plants.SingleWandou;
import pers.Whyzaa.PlantsVsZobie.Plants.SunFlower;
import pers.Whyzaa.PlantsVsZobie.Zobie.CatZombie;
import pers.Whyzaa.PlantsVsZobie.Zobie.NormalZobie;
import pers.Whyzaa.PlantsVsZobie.Zobie.Zombie;

public class LoadingPlants {
	
	public static ArrayList<Plants> PlantsList = new ArrayList<Plants>();
	public static ArrayList<Zombie> LoadingZobieLists = new ArrayList<Zombie>();
	public static ArrayList<Zombie> ZobieLists = new ArrayList<Zombie>();
	public static ArrayList<Plants> PlayerGetPlantsLists = new ArrayList<Plants>();
	public static int zombiesize;
	static {

		SingleWandou singlewandou = new SingleWandou();
	//	PlantsList.add(new DoubleWanDou());
		PlantsList.add(new SunFlower());
		PlantsList.add(singlewandou);
		PlantsList.add(new DoubleWanDou());	
		PlantsList.add(new IceWanDou());	
		PlantsList.add(new CherryBoom());	
		PlantsList.add(new QuanHuang());	
		PlantsList.add(new JianGuo());	
	}
	public static void CreatZombie(){
		
		if(PlantsVSZobie.gs == GameState.LEVEL1) {
			LoadingZobieLists.add(new CatZombie(Config. WINDOWS_WEIGHT + 10));
			LoadingZobieLists.add(new NormalZobie(Config.WINDOWS_WEIGHT + 0));
			LoadingZobieLists.add(new NormalZobie(Config.WINDOWS_WEIGHT + 220));
			LoadingZobieLists.add(new NormalZobie(Config.WINDOWS_WEIGHT + 260));
			LoadingZobieLists.add(new NormalZobie(Config. WINDOWS_WEIGHT+280));
			LoadingZobieLists.add(new NormalZobie(Config. WINDOWS_WEIGHT+360));
			LoadingZobieLists.add(new CatZombie(Config. WINDOWS_WEIGHT + 400));
			LoadingZobieLists.add(new NormalZobie(Config. WINDOWS_WEIGHT+450));
			LoadingZobieLists.add(new NormalZobie(Config. WINDOWS_WEIGHT+520));
			LoadingZobieLists.add(new NormalZobie(Config. WINDOWS_WEIGHT+530));
			LoadingZobieLists.add(new NormalZobie(Config. WINDOWS_WEIGHT+600));
			LoadingZobieLists.add(new NormalZobie(Config. WINDOWS_WEIGHT+670));
			LoadingZobieLists.add(new NormalZobie(Config. WINDOWS_WEIGHT+700));
			zombiesize = 13;
		}else if(PlantsVSZobie.gs == GameState.LEVEL2) {
			LoadingZobieLists.add(new NormalZobie(Config. WINDOWS_WEIGHT+200));
			LoadingZobieLists.add(new NormalZobie(Config. WINDOWS_WEIGHT+200));
		}
		
	}
	
	public static void PlayerGetPlants() {
		//PlayerGetPlantsLists.add();
	}

	 int n = 0;
	 
	 public static Rectangle sunflowerRect = new Rectangle(310,163,55,80);
	 public static Rectangle wandouRect = new Rectangle(375,163,55,80);
	 public static Rectangle DoubleWaRect = new Rectangle(440,163,55,80);
	 public static Rectangle icewandou = new Rectangle(505,163,55,80);
	 public static Rectangle cherryboom = new Rectangle(570,163,55,80);
	 public static Rectangle quanhuang = new Rectangle(635,163,55,80);
	 public static Rectangle jianguo = new Rectangle(700,163,55,80);
	/**
	 * 当玩家 点击某植物时  切换成灰色图片
	 * @param r
	 * @param e
	 * @return
	 */
	public int GetPlantsInt(Rectangle r,MouseEvent e) {

		if(sunflowerRect.contains(e.getPoint())) {
			n = 0;
		}else if(wandouRect.contains(e.getPoint())) {
			n = 1;
		}else if(DoubleWaRect.contains(e.getPoint())) {
			n = 2;
		}else if(icewandou.contains(e.getPoint())) {
			n = 3;
		}else if(cherryboom.contains(e.getPoint())) {
			n = 4;
		}else if(quanhuang.contains(e.getPoint())) {
			n = 5;
		}else if(jianguo.contains(e.getPoint())) {
			n = 6;
		}
		return n;
	}
	static LoadingPlants l = new LoadingPlants();
	public static  void ChoicedPlants(int i,Rectangle r ,Plants p,MouseEvent e) {
		if(r.contains(e.getPoint())) {	
			SoundUtils.Play(GetImages.AUDIO.get("card.wav"), false, GameState.CHOICEPLANTS);
			if(!PlantsBar.PlantsBarList.contains(p)) {
				PlantsBar.PlantsBarList.add(p);
				//System.out.println(p);
				LoadingPlants.PlantsList.get(l.GetPlantsInt(r, e)).setChoiced(true);
				i = 1;
			}
			if(i == 0) {
				PlantsBar.PlantsBarList.remove(p);
				//System.out.println(p);
				LoadingPlants.PlantsList.get(l.GetPlantsInt(r, e)).setChoiced(false);					
			}
			//System.out.println(i);
		}
	}
	
	
	int m = 0;
	public int  ChocedGuanQia(MouseEvent e) {
		 Rectangle Level1 = new Rectangle(258,141,77,30);
		 Rectangle Level2 = new Rectangle(357,141,77,30);
		 Rectangle Level3 = new Rectangle(456,141,77,30);
		 Rectangle Level4 = new Rectangle(555,141,77,30);
		 Rectangle Level5 = new Rectangle(654,141,77,30);	 		 
		 if(Level1.contains(e.getPoint())) {
			 m = 1;
		 }else if(Level2.contains(e.getPoint())) {
			 m = 2;
		 }else if(Level3.contains(e.getPoint())) {
			 m = 3;
		 }else if(Level4.contains(e.getPoint())) {
			 m = 4;
		 }else if(Level5.contains(e.getPoint())) {
			 m = 5;
		 }
		 return m;
	}
}
