package pers.Whyzaa.PlantsVsZobie.Utils;
import java.awt.Rectangle;
import java.io.File;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;

import pers.Whyzaa.PlantsVsZobie.Config.Config;
import pers.Whyzaa.PlantsVsZobie.Config.GameState;
import pers.Whyzaa.PlantsVsZobie.Config.PlantsType;
import pers.Whyzaa.PlantsVsZobie.DaoJu.DaoJu;
import pers.Whyzaa.PlantsVsZobie.DaoJu.DaoJuType;
import pers.Whyzaa.PlantsVsZobie.MainFrame.PlantsVSZobie;
import pers.Whyzaa.PlantsVsZobie.Plants.Bullet;
import pers.Whyzaa.PlantsVsZobie.Plants.BulletType;
import pers.Whyzaa.PlantsVsZobie.Plants.Plants;
import pers.Whyzaa.PlantsVsZobie.Plants.Sun;
import pers.Whyzaa.PlantsVsZobie.Plants.SunFlower;
import pers.Whyzaa.PlantsVsZobie.Zobie.Zombie;
import pers.Whyzaa.PlantsVsZobie.Zobie.ZombieType;

public class Factory {
	public static int cherryboom = 0;
	//×Óµ¯  Ì«Ñô   µÈ
	public static void CreatPlantsDaoJu(Plants p,GetPoint gpt) {
		Sun s = new Sun();
		p.Count();
		//System.out.println(isZombieChuXian(p));
		if((p.getPlantstype() == PlantsType.WANDOU || p.getPlantstype() == PlantsType.DOUBLEWANDOU) && (p.getT() >=200)  && (isZombieChuXian(p)==true)) {
			Bullet b = new Bullet();
			if(p.getAdatk() == 1) {
				b.setATK(15);
				b.setGifImage(GetImages.GIFIMAGES.get("PB10.gif").getImage());
			}else{
				b.setGifImage(GetImages.GIFIMAGES.get("PB01.gif").getImage());
				b.setATK(10);
			}
			b.setHeight(b.getGifImage().getHeight(null));
			b.setWeight(b.getGifImage().getWidth(null));
			b.setSpeed(5);
			b.setX(gpt.getX()+65);
			b.setY(gpt.getY()+3);
			b.setBulletType(BulletType.SINGLEWANDOU);
			
			p.getBulletsList().put(b,gpt);
			if(p.getPlantstype() == PlantsType.DOUBLEWANDOU && p.getAdspeed() == 1) {
				p.setT(150);
			}else if(p.getPlantstype() == PlantsType.WANDOU && p.getAdspeed() == 1){
				p.setT(100);
			}else if(p.getPlantstype() == PlantsType.DOUBLEWANDOU && p.getAdspeed() != 1) {
				p.setT(100);
			}else if(p.getPlantstype() == PlantsType.WANDOU && p.getAdspeed() != 1) {
				p.setT(0);
			}
			
		}else if(p.getPlantstype() == PlantsType.ICEWANDOU && (p.getT() >=200)  && (isZombieChuXian(p)==true)) {
			Bullet b = new Bullet();
			b.setGifImage(GetImages.GIFIMAGES.get("SnowPeashooterBullet.gif").getImage());
			b.setHeight(b.getGifImage().getHeight(null));
			b.setWeight(b.getGifImage().getWidth(null));
			b.setSpeed(5);
			b.setX(gpt.getX()+65);
			b.setY(gpt.getY()+3);
			b.setBulletType(BulletType.ICEWANDOU);
			b.setATK(10);
			p.getBulletsList().put(b,gpt);
			if(p.getAdspeed() == 1) {
				p.setT(100);
			}else {
				p.setT(0);
			}
			
		}else if(p.getPlantstype() == PlantsType.SUNFLOWER  && p.getT() >= 1000){
			s.setGifImage(GetImages.GIFIMAGES.get("Sun.gif").getImage());
			s.setHeight(s.getGifImage().getHeight(null));
			s.setWeight(s.getGifImage().getWidth(null));
			s.setX(gpt.getX());
			s.setY(gpt.getY());
			p.setT(0);
			SunFlower.FlowerSunList.put(s,gpt);
		}else if(p.getPlantstype() == PlantsType.QUANHUANG && (p.getT() >=200)  && (isZombieChuXian(p)==true)) {
			Bullet b = new Bullet();
			b.setGifImage(GetImages.GIFIMAGES.get("bulletqh.gif").getImage());
			b.setHeight(b.getGifImage().getHeight(null));
			b.setWeight(b.getGifImage().getWidth(null));
			b.setSpeed(5);
			b.setX(gpt.getX()+65);
			b.setY(gpt.getY()+3);
			b.setBulletType(BulletType.QH);
			b.setATK(15);
			p.getBulletsList().put(b,gpt);
			p.setT(0);
		}
		
	}
		public static void ZbMove() {
		for (int i = 0; i < LoadingPlants.LoadingZobieLists.size(); i++) {
			Zombie zb = LoadingPlants.LoadingZobieLists.get(i);
			if (!zb.isDeathing() && zb.getDie() != 1) {
				zb.MoveZombie();
			}
			Set<Entry<Plants, GetPoint>> entrySet = DrawPlantsInMap.PlantsMap.entrySet();
			for (Entry<Plants, GetPoint> entry : entrySet) {
				// System.out.println(entry.getKey().GetRectangle());
				if (zb.GetRectangle().intersects(entry.getKey().GetRectangle()) && entry.getKey().getPlantstype() != PlantsType.CHERRYBOOM) {
					zb.setX(entry.getKey().getX() + 35);
					if (zb.getZbType() == ZombieType.CAT) {
						zb.setGifImage(GetImages.GIFIMAGES.get("ConeheadZombieAttack.gif").getImage());
					} else if (zb.getZbType() == ZombieType.NORMAL) {
						zb.setGifImage(GetImages.GIFIMAGES.get("ZombieAttack.gif").getImage());
					}
							int hp = entry.getKey().getHP();
							hp -= zb.getZombieAtk();
							Zombie z = new Zombie();
							z.getEatzombie().put(entry.getKey(), zb);
							Set<Entry<Plants, Zombie>> entrySet2 = z.getEatzombie().entrySet();
							for (Entry<Plants, Zombie> entry2 : entrySet2) {

								if (entry2.getKey().getHP() <= 0) {
									DrawPlantsInMap.PlantsMap.remove(entry.getKey());
									System.out.println(entry2.getValue());
									if (entry2.getValue().getZbType() == ZombieType.CAT) {
										//System.out.println("CATCATCATCATCATCAT");
										zb.setGifImage(GetImages.GIFIMAGES.get("ConeheadZombie.gif").getImage());
										zb.setWeight(GetImages.GIFIMAGES.get("ConeheadZombie.gif").getIconWidth());
										zb.setHeight(GetImages.GIFIMAGES.get("ConeheadZombie.gif").getIconHeight());
									}else if(entry2.getValue().getZbType() == ZombieType.NORMAL){
										//System.out.println("NORMALNORMALNORMALNORMALNORMALNORMAL");
										zb.setGifImage(GetImages.GIFIMAGES.get("Zombie.gif").getImage());
										zb.setWeight(GetImages.GIFIMAGES.get("Zombie.gif").getIconWidth());
										zb.setHeight(GetImages.GIFIMAGES.get("Zombie.gif").getIconHeight());
									}
								} else {
									entry.getKey().setHP(hp);
								}
							}
					
				}
					
					Rectangle r = new Rectangle(PlantsVSZobie.boomX-100,PlantsVSZobie.boomY-100,200,200);
					if(zb.GetRectangle().intersects(r)  &&  entry.getKey().getPlantstype() == PlantsType.CHERRYBOOM) {
//						zb.setGifImage(GetImages.GIFIMAGES.get("BoomDie2.gif").getImage());
//						zb.setWeight(GetImages.GIFIMAGES.get("BoomDie2.gif").getIconWidth());
//						zb.setHeight(GetImages.GIFIMAGES.get("BoomDie2.gif").getIconHeight());
						cherryboom = 1;
						zb.setDie(1);
						zb.setDeathing(true);
						Timer t = new Timer();
						t.schedule(new TimerTask() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								LoadingPlants.LoadingZobieLists.remove(zb);
								
							}
						}, 1000);
					}
					
				}
			}
		}
		public static boolean isZombieChuXian(Plants p) {
			boolean f = false;
				for (int i = 0; i < LoadingPlants.LoadingZobieLists.size(); i++) {
					Zombie zb = LoadingPlants.LoadingZobieLists.get(i);					
					if((zb.getX()<= Config.WINDOWS_WEIGHT-20) && p.getX()<= zb.getX()  && p.getY() == (zb.getY()+zb.getHeight()/2)) {
						f = true;
					}
				}
				return f;
			}
		public  int ColdTime(Plants p,GameState gs) {
			int coldt = p.getColdSpeed();
				if(gs == GameState.GAMEING || gs == GameState.LEVEL1) {
					coldt++;	
					if(coldt>= Plants.GetColdTime(p) && coldt <= Plants.GetColdTime(p)+Plants.GetColdSpeed(p)) {
						p.setColdSpeed(coldt);
						return 6;
					}else if(coldt> Plants.GetColdTime(p)+Plants.GetColdSpeed(p) && coldt <= Plants.GetColdTime(p)+Plants.GetColdSpeed(p)*2) {
						p.setColdSpeed(coldt);
						return 5;
					}else if(coldt> Plants.GetColdTime(p)+Plants.GetColdSpeed(p)*2 && coldt <= Plants.GetColdTime(p)+Plants.GetColdSpeed(p)*3) {
						p.setColdSpeed(coldt);
						return 4;
					}else if(coldt> Plants.GetColdTime(p)+Plants.GetColdSpeed(p)*3 && coldt <= Plants.GetColdTime(p)+Plants.GetColdSpeed(p)*4) {
						p.setColdSpeed(coldt);
						return 3;
					}else if(coldt> Plants.GetColdTime(p)+Plants.GetColdSpeed(p)*4 && coldt <= Plants.GetColdTime(p)+Plants.GetColdSpeed(p)*5) {
						p.setColdSpeed(coldt);
						return 2;
					}else if(coldt> Plants.GetColdTime(p)+Plants.GetColdSpeed(p)*5 && coldt <= Plants.GetColdTime(p)+Plants.GetColdSpeed(p)*6) {
						p.setColdSpeed(coldt);
						return 1;
					}else {
						p.setColdSpeed(coldt);
						return 0;
					}
				}else {
					return -1;
				}		
		}
		
		
		public static void BulletAtkZombie(Zombie zb,Bullet b) {
			int hp = zb.getHP();
			//System.out.println(hp+"------"+b.getKey().getATK());
			Random r = new Random();
			hp -= b.getATK();
			int rr = r.nextInt(100);
			if(hp <=0) {
				if(rr >=0 &&rr <30 ) {
					DaoJu d = new DaoJu();
					d.setX(zb.getX()+60);
					d.setY(zb.getY()+60);
					d.setImage(GetImages.IMAGES.get("huixue.png"));
					d.setWeight(GetImages.IMAGES.get("huixue.png").getWidth());
					d.setHeight(GetImages.IMAGES.get("huixue.png").getHeight());
					d.setDt(DaoJuType.HUIXUE);
					DaoJu.DaoJuList.add(d);
				}else if(rr >=30 && rr <= 60) {
					DaoJu d = new DaoJu();
					d.setX(zb.getX()+60);
					d.setY(zb.getY()+60);
					d.setImage(GetImages.IMAGES.get("addatk.png"));
					d.setWeight(GetImages.IMAGES.get("addatk.png").getWidth());
					d.setHeight(GetImages.IMAGES.get("addatk.png").getHeight());
					d.setDt(DaoJuType.ADDATK);
					DaoJu.AddATkDaoJuList.add(d);
				}else {
					DaoJu d = new DaoJu();
					d.setX(zb.getX()+60);
					d.setY(zb.getY()+60);
					d.setImage(GetImages.IMAGES.get("addspeed.png"));
					d.setWeight(GetImages.IMAGES.get("addspeed.png").getWidth());
					d.setHeight(GetImages.IMAGES.get("addspeed.png").getHeight());
					d.setDt(DaoJuType.ADDSPEED);
					DaoJu.AddSpeedDaoJuList.add(d);
				}
				
				zb.setDeathing(true);
				zb.setZombieDie(GetImages.GIFIMAGES.get("ZombieDie.gif").getImage());
				zb.setWeight(GetImages.GIFIMAGES.get("ZombieDie.gif").getIconWidth());
				zb.setHeight(GetImages.GIFIMAGES.get("ZombieDie.gif").getIconHeight());
				new Thread(new Runnable() {
					
					@Override
					public void run() {
							try {
								Thread.sleep(1000);
								LoadingPlants.LoadingZobieLists.remove(zb);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}	
					}
				}).start();			
			}else {
				zb.setHP(hp);
			}
		}
		
//		
//		public static DaoJu CreatDaoJu() {
//			
//			return d;
//		}
}
