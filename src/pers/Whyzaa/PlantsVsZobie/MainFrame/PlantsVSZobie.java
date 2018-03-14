package pers.Whyzaa.PlantsVsZobie.MainFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import pers.Whyzaa.PlantsVsZobie.Config.Config;
import pers.Whyzaa.PlantsVsZobie.Config.GameState;
import pers.Whyzaa.PlantsVsZobie.Config.PlantsType;
import pers.Whyzaa.PlantsVsZobie.DaoJu.DaoJu;
import pers.Whyzaa.PlantsVsZobie.Plants.Bullet;
import pers.Whyzaa.PlantsVsZobie.Plants.BulletType;
import pers.Whyzaa.PlantsVsZobie.Plants.CherryBoom;
import pers.Whyzaa.PlantsVsZobie.Plants.DoubleWanDou;
import pers.Whyzaa.PlantsVsZobie.Plants.IceWanDou;
import pers.Whyzaa.PlantsVsZobie.Plants.JianGuo;
import pers.Whyzaa.PlantsVsZobie.Plants.Plants;
import pers.Whyzaa.PlantsVsZobie.Plants.PlantsBar;
import pers.Whyzaa.PlantsVsZobie.Plants.QuanHuang;
import pers.Whyzaa.PlantsVsZobie.Plants.SingleWandou;
import pers.Whyzaa.PlantsVsZobie.Plants.Sun;
import pers.Whyzaa.PlantsVsZobie.Plants.SunFlower;
import pers.Whyzaa.PlantsVsZobie.Utils.DrawPlantsInMap;
import pers.Whyzaa.PlantsVsZobie.Utils.Factory;
import pers.Whyzaa.PlantsVsZobie.Utils.GetImages;
import pers.Whyzaa.PlantsVsZobie.Utils.GetPoint;
import pers.Whyzaa.PlantsVsZobie.Utils.LoadingPlants;
import pers.Whyzaa.PlantsVsZobie.Utils.SoundUtils;
import pers.Whyzaa.PlantsVsZobie.Zobie.NormalZobie;
import pers.Whyzaa.PlantsVsZobie.Zobie.Zombie;

public class PlantsVSZobie extends JFrame implements Runnable {
	public static GameState gs = GameState.WELCOME;
	private static int  HxdjIndex,LevelIndex,DaoJuIndex,PointerUP,StartBtnIndex,SunIndex,MxmsStartIndex, TuJianIndex, comeBackY,MoveMapLeftIndex, TipsIndex,bgIndex, CaoWeight, CarWeight = 0;
	private static double TuWeight = 0;
	private int ChanZiIndex = 0;
	private static int SunXXX,SunYYY,SjSunIndex = 0;
	Rectangle TuJianRec = new Rectangle(Config.WINDOWS_WEIGHT / 5 * 4, Config.WINDOWS_HEIGHT / 5 * 4,GetImages.IMAGES.get("TuJian.png").getWidth(), GetImages.IMAGES.get("TuJian.png").getHeight());
	private HB hb;
	private int AddAtkIndex,AddSpeedIndex =0 ;
	private int lastZombieX,lastZombieY = 0;
	private int AddATKDaoJuIndex,ADDSPEEDDaoJuIndex = 0;
	private DaoJu d;
	private static int SunY,SunX,SjSunY= 0;
	private SunFlower sunflower = new SunFlower();
	private SingleWandou singlewandou = new SingleWandou();
	private DoubleWanDou doublewan = new DoubleWanDou();
	private IceWanDou icewandou = new IceWanDou();
	private CherryBoom cherryboom = new CherryBoom();
	private QuanHuang qh = new QuanHuang();
	private JianGuo jg = new JianGuo();
	private Cursor handCursor ;
	private Cursor JianTouCursor;
	private int MouseX,MouseY = 0;
	private int x,y=0;
	private int MouseIndex = 0;
	private int djX,djY;
	public static int boomX,prepare,twoprepare;
	public static int boomY;
	//File choiced = new File(".\\src\\mp3\\choiced.wav");
	File winer = new File(".\\src\\mp3\\winer.wav");
	File dian = new File(".\\src\\mp3\\dian.wav");
	File jizhong = new File(".\\src\\mp3\\jizhong.wav");
	File come = new File(".\\src\\mp3\\zombiecome.wav");
	File action = new File(".\\src\\mp3\\action.wav");
	File paint = new File(".\\src\\mp3\\paint.wav");
	File gaming = new File(".\\src\\mp3\\gaming.wav");
	File button = new File(".\\src\\mp3\\button.wav");
	private String image;
	private Rectangle PlayerChoicedPlantRect;
	static GetPoint p ;
	int ZobieX = 0;
	MouseEvent e;
	int SunYY,SunXX = 0;
	private int atkindex = 0;
	ArrayList<GetPoint> point;
	private int buindex,bulletAtk,JianIndex;
	private int HuiXueDaoJuIndex;
	private int bX,bY;
	public PlantsVSZobie() {
		setTitle("植物大战僵尸");
		setSize(Config.WINDOWS_WEIGHT, Config.WINDOWS_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		handCursor =Cursor.getPredefinedCursor(Cursor.HAND_CURSOR); 
		JianTouCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
		hb = new HB();
		Container c = getContentPane();
		c.add(hb);
		MouseAda m = new MouseAda();
		c.addMouseMotionListener(m);
		c.addMouseListener(m);
		c.setFocusable(true);
		setVisible(true);
		setResizable(false);	
	}

	class HB extends JPanel {

		
		@Override
		protected void paintComponent(Graphics g) {
			if(gs == GameState.WELCOME) {
				DrawWelcomeBG(g);
			}else if(gs == GameState.WELCOMETWO) {
				DrawWelcomeTwoBG(g);
				DrawComeBack(g);
			}else if(gs == GameState.XUNGUAN) {
				DrawXuanGuan(g);
			}else if(gs == GameState.TUJIAN) {
				//植物 僵尸图鉴
				DrawTuJian(g);
			}else if(gs == GameState.MAPMOVERIGHT) {
				DrawRightZombie(g);
				//地图背景移动
				DrawMoveMapRight(g);
			}else if(gs == GameState.MAPMOVELEFT) {
				//背景地图左移
				DrawMoveMapLeft(g);
			}else if(gs == GameState.MOVECAOANDCAR) {
				//移动草地和车
				DrawMoveCaoAndCar(g);
				DrawPlantsLan(g);
			}else if(gs == GameState.CHOICEPLANTS) {
				//选择植物
				DrawPlantsBack(g);
				//选择植物
				DrawPlantsLan(g);
				
			}else if(gs == GameState.LEVEL1) {
				//System.out.println("----------------------");
				//游戏开始
				DrawGaming(g);
				//画plants集合中的 植物 由玩家选定
				DrawPlantsLan(g);
				//每隔15秒产生一个阳光
				DrawSun(g);
				//玩家选择植物 植物跟随鼠标移动
				DrawPlayerPlants(g);
				//将玩家选择的植物画入地图中
				DrawPlantsInMap(g);
				//删除植物
				DrawDelectPlants(g);
				//移动太阳
				DrawSunMove(g);
				DrawSunflowerSun(g);
				//子弹
				DrawBullet(g);
				//僵尸
				DrawZobie(g);
				//击杀zombie爆道具
				DrawZombieDaoJu(g);
				//收集阳光
				DrawShouJiSun(g);
				//
				DrawGetPlants(g);
			}else if(gs == GameState.WIN) {
				DrawDaoJu(g);
			}else if(gs == GameState.GAMEOVER) {
				DrawGameOver(g);
			}
		}
		
		
		private void DrawZombieDaoJu(Graphics g) {
			// TODO Auto-generated method stub
			for (int i = 0; i <DaoJu.DaoJuList.size(); i++) {
				DaoJu d = DaoJu.DaoJuList.get(i);
				g.drawImage(d.getImage(),d.getX(),d.getY(),this);
			}
			for (int i = 0; i < DaoJu.AddATkDaoJuList.size(); i++) {
				DaoJu d =DaoJu.AddATkDaoJuList.get(i);
				g.drawImage(d.getImage(),d.getX(),d.getY(),this);
			}
			for (int i = 0; i < DaoJu.AddSpeedDaoJuList.size(); i++) {
				DaoJu d =DaoJu.AddSpeedDaoJuList.get(i);
				g.drawImage(d.getImage(),d.getX(),d.getY(),this);
			}
		}
		private void DrawDelectPlants(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(GetImages.IMAGES.get("ShovelBack.png"),520,12,this);
			g.drawImage(GetImages.IMAGES.get("Shovel.png"),520,12,this);
		}
		private void DrawXuanGuan(Graphics g) {
			g.drawImage(GetImages.IMAGES.get("xg.png"),0,0,Config.WINDOWS_WEIGHT,Config.WINDOWS_HEIGHT,this);
			g.setColor(Color.black);
			for (int i = 0; i < 5; i++) {
				g.drawRect(258+i*99, 141, 77, 30);
			}
		}

		private void DrawDaoJu(Graphics g) {
			g.drawImage(GetImages.IMAGES.get("AwardScreen_Back.jpg"),0,0,Config.WINDOWS_WEIGHT,Config.WINDOWS_HEIGHT,this);
			g.drawImage(GetImages.IMAGES.get(image),380,150,this);
			
		}

		private void DrawRightZombie(Graphics g) {
				for (int i = 0; i < LoadingPlants.LoadingZobieLists.size(); i++) {
					Zombie zb = LoadingPlants.LoadingZobieLists.get(i);
					g.drawImage(zb.getGifImage(),0,0,zb.getWeight(),zb.getHeight(),this);
				}
		}
		Zombie zb = new Zombie();
		private void DrawGetPlants(Graphics g) {
			if(LoadingPlants.LoadingZobieLists.size() == 1) {
				Zombie zb = LoadingPlants.LoadingZobieLists.get(0);
				lastZombieX = zb.getX();
				lastZombieY = zb.getY();	
			}
			if(LoadingPlants.LoadingZobieLists.size() == 0) {
				if(LevelIndex == 1) {
					g.drawImage(GetImages.IMAGES.get("double.png"),lastZombieX,lastZombieY,this);
					image = "double.png";
				}	
			}
		}
		
		private void DrawGameOver(Graphics g) {
			g.drawImage(GetImages.IMAGES.get("ZombiesWon.png"),0,0,Config.WINDOWS_WEIGHT,Config.WINDOWS_HEIGHT,this);
		}

		private void DrawShouJiSun(Graphics g) {
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			g.drawString(""+Config.CHUSHISUN, 50, 85);
		}

		private void DrawBullet(Graphics g) {
			super.repaint();
			if(Plants.BulletsList.size()>0) {
				Set<Entry<Bullet, GetPoint>> entrySet=Plants.BulletsList.entrySet();
				for (Entry<Bullet, GetPoint> entry : entrySet) {
						g.drawImage(entry.getKey().getGifImage(),entry.getKey().getX(),entry.getValue().getY(),this);
						
				}
			}
			
			if(JianIndex == 1) {
				if(bulletAtk >= 10) {
					atkr = bulletAtk % 10 ;
					atkl = bulletAtk/10%10;
					g.drawImage(GetImages.IMAGES.get("jian.png"),bX-5,bY-31,this);
					g.drawImage(GetImages.IMAGES.get(atkl+".png"),bX+20,bY-45,this);
					g.drawImage(GetImages.IMAGES.get(atkr+".png"),bX+38,bY-45,this);
				}else {
					g.drawImage(GetImages.IMAGES.get("jian.png"),bX-5,bY-31,this);
					g.drawImage(GetImages.IMAGES.get(bulletAtk+".png"),bX+20,bY-45,this);
				}
				Timer t = new Timer();
				t.schedule(new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						JianIndex = 0;
					}
				}, 200);
			}
			
		}

		int atkr, atkl = 0;

		private void DrawZobie(Graphics g) {
			if(LoadingPlants.LoadingZobieLists.size()>0) {
				for (int i = 0; i < LoadingPlants.LoadingZobieLists.size(); i++) {
					Zombie zb = LoadingPlants.LoadingZobieLists.get(i);
					if(!zb.isDeathing() && zb.getDie() != 1) {
						g.drawImage(zb.getGifImage(), zb.getX(), zb.getY(),zb.getWeight(),zb.getHeight() ,this);
						int w = (int) (zb.getHP()*1.0/zb.getMaxHP()*zb.getGifImage().getWidth(null));
							g.setColor(Color.red);
							g.drawRect(zb.getX()-2, zb.getY()-8, zb.getGifImage().getWidth(null), 6);
							g.fillRect(zb.getX()-2, zb.getY()-8, w,  6);
					}
					if(zb.isDeathing() && zb.getDie() != 1){
						g.drawImage(zb.getZombieDie(), zb.getX(), zb.getY(),zb.getZombieDie().getWidth(null),zb.getZombieDie().getHeight(null) ,this);
					}	

					if(zb.getDie() == 1 && zb.isDeathing()) {
						g.drawImage(GetImages.GIFIMAGES.get("BoomDie2.gif").getImage(), zb.getX()-80, zb.getY(),GetImages.GIFIMAGES.get("BoomDie2.gif").getImage().getWidth(null),GetImages.GIFIMAGES.get("BoomDie2.gif").getImage().getHeight(null),this);
					}
					
					if(buindex == 1) {
						g.drawImage(GetImages.GIFIMAGES.get("PeaBulletHit.gif").getImage(),bX-10,bY+60,this);
						Timer t = new Timer();
						t.schedule(new TimerTask() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								buindex = 0;
							}
						}, 30);
					}
				}
			}
		}


		private void DrawSunflowerSun(Graphics g) {
			if(SunFlower.FlowerSunList.size()>0) {
			Iterator<Entry<Sun, GetPoint>> it = SunFlower.FlowerSunList.entrySet().iterator();
			while(it.hasNext()) {
				Entry<Sun, GetPoint> b = it.next();
				g.drawImage(b.getKey().getGifImage(),b.getValue().getX(),b.getValue().getY(),this);
				}
			}
			
		}


		/**
		 * 游戏开始，初始化背景
		 * 
		 * @param ls
		 */
		private void DrawWelcomeBG(Graphics g) {
			g.drawImage(GetImages.IMAGES.get("menu.png"), 0, 0, Config.WINDOWS_WEIGHT, Config.WINDOWS_HEIGHT-Config.PY_TOP, null);
			if(StartBtnIndex == 1) {
				g.drawImage(GetImages.IMAGES.get("gamestart.png"),Config.WINDOWS_WEIGHT/2-GetImages.IMAGES.get("gamestart.png").getWidth()/2-12, 560,322,GetImages.IMAGES.get("gamestart.png").getHeight(),this);
			}else {
				g.drawImage(GetImages.IMAGES.get("gamestart1.png"),Config.WINDOWS_WEIGHT/2-GetImages.IMAGES.get("gamestart1.png").getWidth()/2-12, 560,322,GetImages.IMAGES.get("gamestart.png").getHeight(),this);
			}
		}
		//欢迎界面2
		private void DrawWelcomeTwoBG(Graphics g) {
			g.drawImage(GetImages.IMAGES.get("ZombieStart.png"), 0, 0, Config.WINDOWS_WEIGHT, Config.WINDOWS_HEIGHT, this);
			if(MxmsStartIndex == 1) {
				g.drawImage(GetImages.IMAGES.get("mxms2.png"),Config.WINDOWS_WEIGHT/2+GetImages.IMAGES.get("mxms2.png").getWidth()/2, 100,this);
			}else {
				g.drawImage(GetImages.IMAGES.get("mxms.png"),Config.WINDOWS_WEIGHT/2+GetImages.IMAGES.get("mxms.png").getWidth()/2, 100,this);
			}
			if(TuJianIndex == 1) {
				g.drawImage(GetImages.IMAGES.get("TuJian.png"),Config.WINDOWS_WEIGHT/5*4, Config.WINDOWS_HEIGHT/5*4-Config.PY_TUJIAN,this);
			}else {
				g.drawImage(GetImages.IMAGES.get("TuJian2.png"),Config.WINDOWS_WEIGHT/5*4, Config.WINDOWS_HEIGHT/5*4-Config.PY_TUJIAN,this);
			}
		}
		//欢迎回来
		private void DrawComeBack(Graphics g) {
			g.drawImage(GetImages.IMAGES.get("comeback.png"),Config.WINDOWS_WEIGHT/6,-GetImages.IMAGES.get("comeback.png").getHeight()+comeBackY,this);
		}
		
		//画图鉴
		private void DrawTuJian(Graphics g) {
			
		}
		//植物栏
		private void DrawPlantsLan(Graphics g) {
			Factory f = new Factory();
			g.drawImage(GetImages.IMAGES.get("SeedBank.png"),30,5,this);
			for (int i = 0; i < PlantsBar.PlantsBarList.size(); i++) {
				if(f.ColdTime(PlantsBar.PlantsBarList.get(i),gs) > 0) {
					g.drawImage(PlantsBar.PlantsBarList.get(i).getChoicedImg(), 103+i*52, 12, 50, 72, this);	
					PlantsBar.PlantsBarList.get(i).setIscold(true);
				}else {
					g.drawImage(PlantsBar.PlantsBarList.get(i).getImage(), 103+i*52, 12, 50, 72, this);	
					PlantsBar.PlantsBarList.get(i).setIscold(false);
				}
				
				if(gs == GameState.GAMEING || gs == GameState.LEVEL1 && f.ColdTime(PlantsBar.PlantsBarList.get(i),gs) != 0) {
					setFont(new Font("微软雅黑", Font.BOLD, 20));
					g.setColor(Color.WHITE);
					g.drawString(""+f.ColdTime(PlantsBar.PlantsBarList.get(i),gs), 103+i*52+23, 50);	
				}
			}
		}
		
		private void DrawPlantsBack(Graphics g) {
			g.drawImage(GetImages.IMAGES.get("background1unsodded.jpg").getSubimage(200, 0, Config.WINDOWS_WEIGHT, GetImages.IMAGES.get("background1unsodded_1.jpg").getHeight()),0,0,Config.WINDOWS_WEIGHT, Config.WINDOWS_HEIGHT-Config.PY_TOP,this);
			g.drawImage(GetImages.GIFIMAGES.get("daifu.gif").getImage(),0,85,this);
			if(TipsIndex == 0) {
				g.drawImage(GetImages.IMAGES.get("SeedBank.png"),30,5,this);
				g.drawImage(GetImages.IMAGES.get("SeedChooser_Background.png"),GetImages.GIFIMAGES.get("daifu.gif").getIconWidth() , GetImages.IMAGES.get("SeedBank.png").getHeight()+50,470,400, this);
				g.drawImage(GetImages.IMAGES.get("go.png"),550,480,this);
				g.drawImage(GetImages.IMAGES.get("reset.png"),480,480,this);
				
				for (int j = 0; j < LoadingPlants.PlantsList.size(); j++) {
					if(j<=6) {
						
						if(LoadingPlants.PlantsList.get(j).isChoiced()) {
							g.drawImage(LoadingPlants.PlantsList.get(j).getChoicedImg(),310+j*65,163,55,80, this);
						}else {
							g.drawImage(LoadingPlants.PlantsList.get(j).getImage(),310+j*65,163,55,80, this);
						}
					}else {
						g.drawImage(LoadingPlants.PlantsList.get(j).getImage(),310+(j-7)*65,163+85,55,80, this);
					}			
				}				
			}
		}		
		//背景地图右移
		private void DrawMoveMapRight(Graphics g) {
			g.drawImage(GetImages.IMAGES.get("background1unsodded.jpg").getSubimage(180+bgIndex, 0, Config.WINDOWS_WEIGHT, GetImages.IMAGES.get("background1unsodded.jpg").getHeight()),0,0,Config.WINDOWS_WEIGHT, Config.WINDOWS_HEIGHT-Config.PY_TOP,this);
			g.drawImage(GetImages.GIFIMAGES.get("daifu.gif").getImage(),0,85,this);
			g.drawImage(GetImages.IMAGES.get("jiangshi.png"), Config.WINDOWS_WEIGHT/2-GetImages.IMAGES.get("jiangshi.png").getWidth()/4,85,GetImages.IMAGES.get("jiangshi.png").getWidth()/3*2,GetImages.IMAGES.get("jiangshi.png").getHeight()/2, this);
		}
		//背景地图左移
		private void DrawMoveMapLeft(Graphics g) {
			g.drawImage(GetImages.IMAGES.get("background1unsodded.jpg").getSubimage(540-MoveMapLeftIndex, 0, Config.WINDOWS_WEIGHT, GetImages.IMAGES.get("background1unsodded.jpg").getHeight()),0,0,Config.WINDOWS_WEIGHT, Config.WINDOWS_HEIGHT-Config.PY_TOP,this);
			g.drawImage(GetImages.GIFIMAGES.get("daifu.gif").getImage(),0,85,this);			
		}
		private void DrawMoveCaoAndCar(Graphics g) {
			//画背景
			g.drawImage(GetImages.IMAGES.get("background1unsodded.jpg").getSubimage(200, 0, Config.WINDOWS_WEIGHT, GetImages.IMAGES.get("background1unsodded_1.jpg").getHeight()),0,0,Config.WINDOWS_WEIGHT, Config.WINDOWS_HEIGHT-Config.PY_TOP,this);
			//画  人物 退出
			g.drawImage(GetImages.GIFIMAGES.get("daifu2.gif").getImage(),0,85,this);
			//画  草 逐渐向右展开
			g.drawImage(GetImages.IMAGES.get("sod1row.png"),48,Config.WINDOWS_HEIGHT/2-47,CaoWeight,GetImages.IMAGES.get("sod1row.png").getHeight(), this);
			//画 土 逐渐向右展开
			g.drawImage(GetImages.IMAGES.get("SodRoll1.png"),25+CaoWeight, Config.WINDOWS_HEIGHT/2-40,(int)(80-TuWeight),90, this);
			//画  草 逐渐向右展开
			g.drawImage(GetImages.IMAGES.get("SodRollCap.png"),25+CaoWeight, Config.WINDOWS_HEIGHT/2,(int)(80-TuWeight),75, this);		
			//画  车 逐渐向右展开
			g.drawImage(GetImages.GIFIMAGES.get("LawnMower.gif").getImage(),-GetImages.GIFIMAGES.get("LawnMower.gif").getIconWidth()+CarWeight,Config.WINDOWS_HEIGHT/2-40,this);

		}
		

		//游戏开始
		private void DrawGaming(Graphics g) {
			g.drawImage(GetImages.IMAGES.get("background1.jpg").getSubimage(200, 0, Config.WINDOWS_WEIGHT, GetImages.IMAGES.get("background1.jpg").getHeight()),0,0,Config.WINDOWS_WEIGHT, Config.WINDOWS_HEIGHT-Config.PY_TOP,this);
			
			g.drawImage(GetImages.GIFIMAGES.get("LawnMower.gif").getImage(),0,Config.WINDOWS_HEIGHT/2-40,this);
			
			if(prepare == 0) {
				g.drawImage(GetImages.GIFIMAGES.get("PrepareGrowPlants.gif").getImage(),300,300,GetImages.GIFIMAGES.get("PrepareGrowPlants.gif").getIconWidth(),GetImages.GIFIMAGES.get("PrepareGrowPlants.gif").getIconHeight(),this);
				Timer t = new Timer();
				t.schedule(new TimerTask() {
					
					@Override
					public void run() {
						prepare = 1;
					}
				}, 3000);
			}
			
			if(PointerUP == 0) {
				g.drawImage(GetImages.GIFIMAGES.get("PointerUP.gif").getImage(), 110, 90, this);
			}else if(PointerUP == 1  && DrawPlantsInMap.PlantsMap.size()<=0) {
				g.drawImage(GetImages.GIFIMAGES.get("PointerDown.gif").getImage(), 80, 110, this);
				
			}
			
			g.drawImage(GetImages.IMAGES.get("FlagMeterLevelProgress.png"), 680, 580,157,20, this);
			
			int w = (int) (LoadingPlants.LoadingZobieLists.size()*1.0/LoadingPlants.zombiesize*GetImages.IMAGES.get("FlagMeterFull.png").getWidth());
			g.drawImage(GetImages.IMAGES.get("FlagMeterEmpty.png"), 680, 560, this);
			
			if(w<=0) {
				g.drawImage(GetImages.IMAGES.get("FlagMeterFull.png").getSubimage(0, 0, 157, 21), 676+w-1, 560, this);
				
			}else{
				g.drawImage(GetImages.IMAGES.get("FlagMeterFull.png").getSubimage(5, 0, 158-w, 21), 676+w-1, 560, this);	
			}g.drawImage(GetImages.IMAGES.get("FlagMeterParts2.png"), 676+w, 545, this);
			
			g.drawImage(GetImages.IMAGES.get("daojubark.png"), 650, 12, this);
			g.drawImage(GetImages.IMAGES.get("huixue.png"), 652, 12, this);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
			g.drawString("剩余治疗道具"+Config.CHUSHISUNHPHUIFU+"个", 685, 31);
			
			g.drawImage(GetImages.IMAGES.get("daojubark.png"), 650, 46, this);
			g.drawImage(GetImages.IMAGES.get("addatk.png"), 652, 46, this);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
			g.drawString("剩余加攻道具"+Config.CHUSHIADDATK+"个", 685, 68);
			
			g.drawImage(GetImages.IMAGES.get("daojubark.png"), 650, 80, this);
			g.drawImage(GetImages.IMAGES.get("addspeed.png"), 652, 80, this);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
			g.drawString("剩余攻速道具"+Config.CHUSHIADDSPEED+"个", 685,100);
			
		}
		//更随鼠标移动
		private void DrawPlayerPlants(Graphics g) {
			if(PlayerChoicedPlantRect != null) {			
				g.drawImage(PlantsBar.GetPlayerPlants(PlayerChoicedPlantRect).getGifImage(),MouseX-30,MouseY-35,this);
			}
			if(ChanZiIndex == 1) {
				g.drawImage(GetImages.IMAGES.get("Shovel.png"),MouseX-30,MouseY-20,this);
			}
			if(HxdjIndex == 1) {
				g.drawImage(GetImages.IMAGES.get("huixue.png"),MouseX-20,MouseY-20,this);
			}
			if(AddAtkIndex == 1) {
				g.drawImage(GetImages.IMAGES.get("addatk.png"),MouseX-20,MouseY-20,this);
			}
			if(AddSpeedIndex == 1) {
				g.drawImage(GetImages.IMAGES.get("addspeed.png"),MouseX-20,MouseY-20,this);
			}
		}
		//将玩家选择的植物画入地图中
		private void DrawPlantsInMap(Graphics g) {
			Set<Entry<Plants, GetPoint>> entrySet=DrawPlantsInMap.PlantsMap.entrySet();
			for(Entry<Plants, GetPoint> entry: entrySet){
				Plants p = entry.getKey();
				if(entry.getKey().getPlantstype() != PlantsType.CHERRYBOOM) {
					g.drawImage(p.getGifImage(),p.getX(),entry.getValue().getY(),this);
					int w = (int) (p.getHP()*1.0/p.getMaxHP()*p.getGifImage().getWidth(null));
					g.setColor(Color.red);
					g.drawRect(entry.getValue().getX() - 2, entry.getValue().getY() - 8, p.getGifImage().getWidth(null),
							6);
					g.fillRect(entry.getValue().getX() - 2, entry.getValue().getY() - 8, w, 6);
				}else {
					g.drawImage(p.getGifImage(),p.getX(),entry.getValue().getY(),this);
					Timer t = new Timer();
					t.schedule(new TimerTask() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							DrawPlantsInMap.PlantsMap.remove(p);
							
						}
					}, 500);
					g.drawImage(GetImages.GIFIMAGES.get("Boom.gif").getImage(),p.getX()-50,entry.getValue().getY(),this);	

					g.drawRect(boomX-100,boomY-100,200,200);
				}
			} 
		}
		//画 随机产生的太阳
		private void DrawSun(Graphics g) {
			if(Sun.SunList.size()>0 && SjSunIndex != 1) {
				g.drawImage(GetImages.GIFIMAGES.get("Sun.gif").getImage(),Sun.SunList.get(0).getX(),-GetImages.GIFIMAGES.get("Sun.gif").getIconHeight()+SunY,60,60,this);
			}
		}
		
		//拾取太阳
		private void DrawSunMove(Graphics g) {
			if(SunIndex == 1) {
				g.drawImage(GetImages.GIFIMAGES.get("Sun.gif").getImage(),SunXX,SunYY,60,60,this);
			}
			if(SjSunIndex == 1) {
				g.drawImage(GetImages.GIFIMAGES.get("Sun.gif").getImage(),SunXXX,SunYYY,60,60,this);
			}
			if(HuiXueDaoJuIndex == 1) {
				g.drawImage(GetImages.IMAGES.get("huixue.png"), djX, djY, this);
			}
			if(AddATKDaoJuIndex == 1) {
				g.drawImage(GetImages.IMAGES.get("addatk.png"), djX, djY, this);
			}
			if(ADDSPEEDDaoJuIndex == 1) {
				g.drawImage(GetImages.IMAGES.get("addspeed.png"), djX, djY, this);
			}
		}
	}
	//鼠标事件监听
	class MouseAda extends MouseAdapter {


		@Override
		public void mouseClicked(MouseEvent e) {
			//System.out.println(Thread.currentThread().getName());
			
			
			if(gs == GameState.WELCOME) {
				//获取开始按钮 ，当点击时 更改游戏状态为WELECOMETWO
				Rectangle ActionRect = new Rectangle(Config.WINDOWS_WEIGHT/2 - GetImages.IMAGES.get("gamestart.png").getWidth() / 2, 545, GetImages.IMAGES.get("gamestart.png").getWidth(),GetImages.IMAGES.get("gamestart.png").getHeight());
				if (ActionRect.contains(e.getPoint())) {
					gs = GameState.WELCOMETWO;
				}
			}else if(gs == GameState.WELCOMETWO) {
				//获取  冒险模式按钮 位置，当点击时 更改游戏状态为GAMEING
				Rectangle MxmsRect = new Rectangle(Config.WINDOWS_WEIGHT/2 + GetImages.IMAGES.get("mxms.png").getWidth() / 2, 100, GetImages.IMAGES.get("mxms.png").getWidth(),GetImages.IMAGES.get("mxms.png").getHeight());
				if (MxmsRect.contains(e.getPoint())) {
					//更该游戏状态  为MAPMOVERIGHT  背景地图向右移动
						SoundUtils.Play(button, false, GameState.WELCOMETWO);
						SoundUtils.Play(action, false, GameState.WELCOMETWO);
						Timer t = new Timer();
						t.schedule(new TimerTask() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								gs = GameState.XUNGUAN;
							}
						}, 2000);
						
				}
				if(TuJianRec.contains(e.getPoint())) {
					//玩家点击 图鉴按钮  更改游戏状态  TUJIAN
					gs = GameState.TUJIAN;
					//System.out.println(gs);
				}
			}else if(gs == GameState.XUNGUAN) {
				LoadingPlants l = new LoadingPlants();
				if(l.ChocedGuanQia(e) == 1) {
					LevelIndex = 1;
					//SoundUtils.Play(choiced,true,GameState.MAPMOVERIGHT);
					SoundUtils.Play(GetImages.AUDIO.get("choiced.wav"), true, GameState.MAPMOVERIGHT);
					//SoundUtils.Play(choiced,true,GameState.MAPMOVELEFT);
					gs = GameState.MAPMOVERIGHT;	
				}else if(l.ChocedGuanQia(e) == 2) {
					LevelIndex = 2;
					SoundUtils.Play(GetImages.AUDIO.get("choiced.wav"), true, GameState.MAPMOVERIGHT);
					gs = GameState.MAPMOVERIGHT;		
				}else if(l.ChocedGuanQia(e) == 3) {
					LevelIndex = 3;
					SoundUtils.Play(GetImages.AUDIO.get("choiced.wav"), true, GameState.MAPMOVERIGHT);
					gs = GameState.MAPMOVERIGHT;	
				}else if(l.ChocedGuanQia(e) == 4) {
					LevelIndex = 4;
					SoundUtils.Play(GetImages.AUDIO.get("choiced.wav"), true, GameState.MAPMOVERIGHT);
					gs = GameState.MAPMOVERIGHT;		
				}else if(l.ChocedGuanQia(e) == 5) {
					LevelIndex = 5;
					SoundUtils.Play(GetImages.AUDIO.get("choiced.wav"), true, GameState.MAPMOVERIGHT);
					gs = GameState.MAPMOVERIGHT;		
				}	
			}else if(gs == GameState.MAPMOVERIGHT) {
				Rectangle AllRec = new Rectangle(0, 0, Config.WINDOWS_WEIGHT, Config.WINDOWS_HEIGHT);
				if(AllRec.contains(e.getPoint())) {
					
					gs = GameState.MAPMOVELEFT;
					
				}
			}else if(gs == GameState.CHOICEPLANTS) {
				
				//玩家选择植物
				Rectangle goRec = new Rectangle(550,480,65,37);
				LoadingPlants.ChoicedPlants(MouseIndex, LoadingPlants.sunflowerRect, sunflower, e);
				LoadingPlants.ChoicedPlants(MouseIndex, LoadingPlants.wandouRect, singlewandou, e);
				LoadingPlants.ChoicedPlants(MouseIndex, LoadingPlants.DoubleWaRect, doublewan, e);
				LoadingPlants.ChoicedPlants(MouseIndex, LoadingPlants.icewandou, icewandou, e);
				LoadingPlants.ChoicedPlants(MouseIndex, LoadingPlants.cherryboom, cherryboom, e);
				LoadingPlants.ChoicedPlants(MouseIndex, LoadingPlants.quanhuang, qh, e);
				LoadingPlants.ChoicedPlants(MouseIndex, LoadingPlants.jianguo, jg, e);
				if(goRec.contains(e.getPoint())) {
					//点击 GO图标  更改游戏状态为MOVECAOANDCAR   移动车和草地
					gs = GameState.MOVECAOANDCAR;
				}
			}else if(gs == GameState.GAMEING || gs == GameState.LEVEL1 || gs == GameState.LEVEL2 ||gs == GameState.LEVEL3||gs == GameState.LEVEL4||gs == GameState.LEVEL5) {
				
				for (int i = 0; i < DaoJu.DaoJuList.size(); i++) {
					d = DaoJu.DaoJuList.get(i);
					if(d.GetDaoJuRectangle().contains(e.getPoint())) {
						djX = d.getX();
						djY = d.getY();
						HuiXueDaoJuIndex = 1;
						Config.CHUSHISUNHPHUIFU=Config.CHUSHISUNHPHUIFU+1 ;
						DaoJu.DaoJuList.remove(d);
					}
				}
				for (int i = 0; i < DaoJu.AddATkDaoJuList.size(); i++) {
					d = DaoJu.AddATkDaoJuList.get(i);
					if(d.GetDaoJuRectangle().contains(e.getPoint())) {
						djX = d.getX();
						djY = d.getY();
						AddATKDaoJuIndex = 1;
						Config.CHUSHISUNHPHUIFU=Config.CHUSHIADDATK+1 ;
						DaoJu.AddATkDaoJuList.remove(d);
					}
				}
				for (int i = 0; i < DaoJu.AddSpeedDaoJuList.size(); i++) {
					d = DaoJu.AddSpeedDaoJuList.get(i);
					if(d.GetDaoJuRectangle().contains(e.getPoint())) {
						djX = d.getX();
						djY = d.getY();
						ADDSPEEDDaoJuIndex = 1;
						Config.CHUSHISUNHPHUIFU=Config.CHUSHIADDSPEED+1 ;
						DaoJu.AddSpeedDaoJuList.remove(d);
					}
				}
				
				Rectangle hxdjRect = new Rectangle(652, 12, 24, 24);
				Rectangle addatkjRect = new Rectangle(652, 46, 24, 24);
				Rectangle addspeedjRect = new Rectangle(652, 80, 24, 24);
				if(hxdjRect.contains(e.getPoint())  && Config.CHUSHISUNHPHUIFU > 0) {
					HxdjIndex = 1;
				}
				if(addatkjRect.contains(e.getPoint()) && Config.CHUSHIADDATK > 0) {
					AddAtkIndex = 1;
				}
				if(addspeedjRect.contains(e.getPoint())  && Config.CHUSHIADDSPEED >0) {
					AddSpeedIndex = 1;
				}
				Rectangle rr = new Rectangle(SunX, SunY-60, 60, 60);
				if(e.getButton() == 3) {
					HxdjIndex = 0;
					AddAtkIndex = 0;
					AddSpeedIndex = 0;
					ChanZiIndex = 0;
				}
				if(rr.contains(e.getPoint())) {
					SunXXX = e.getX();
					SunYYY = e.getY();
					SjSunIndex = 1;
					Config.CHUSHISUN = Config.CHUSHISUN + 25;
					//System.out.println("太阳被点击");	
					SoundUtils.Play(dian, false, gs);
					//SunY = 0;
				}
				Rectangle djrect = new Rectangle(lastZombieX, lastZombieY, 100, 60);
				if(djrect.contains(e.getPoint()) && LoadingPlants.LoadingZobieLists.size() <=0) {
					//SoundUtils.Play(GetImages.AUDIO.get("winner.wav"), false, GameState.LEVEL1);
					DaoJuIndex = 1;
				}
				Rectangle CzRect = new Rectangle(520, 12, 76, 34);
				if(CzRect.contains(e.getPoint())) {
					ChanZiIndex = 1;
				}
				Rectangle CRect = new Rectangle(MouseX, MouseY, 76, 34);
				Rectangle HXect = new Rectangle(MouseX, MouseY, 24, 24);
				Set<Entry<Plants, GetPoint>> entrySet=DrawPlantsInMap.PlantsMap.entrySet();
				for(Entry<Plants, GetPoint> entry: entrySet){
					Plants p = entry.getKey();
					if(p.GetRectangle().intersects(CRect) && ChanZiIndex == 1) {
						DrawPlantsInMap.PlantsMap.remove(p);
						ChanZiIndex = 0;
					}	
					if(p.GetRectangle().intersects(HXect) && HxdjIndex == 1) {
						if(p.getMaxHP()<p.getHP()+4000) {
							p.setHP(p.getMaxHP());
						}else {
							p.setHP(p.getHP()+4000);
						}	
						Config.CHUSHISUNHPHUIFU --;
						HxdjIndex = 0;
					}
					if(p.GetRectangle().intersects(HXect)&& AddAtkIndex == 1) {
						p.setAdatk(1);
						Config.CHUSHIADDATK --;
						AddAtkIndex = 0;
					}
					if(p.GetRectangle().intersects(HXect)&& AddSpeedIndex == 1) {
						p.setAdspeed(1);
						Config.CHUSHIADDSPEED --;
						AddSpeedIndex = 0;
					}

				}
				for (int i = 0; i < LoadingPlants.LoadingZobieLists.size(); i++) {
					Zombie zb = LoadingPlants.LoadingZobieLists.get(i);
					if(zb.GetRectangle().intersects(CRect) && ChanZiIndex == 1) {
						LoadingPlants.LoadingZobieLists.remove(zb);
						ChanZiIndex = 0;
					}
				}
				
				Iterator<Entry<Sun, GetPoint>> it = SunFlower.FlowerSunList.entrySet().iterator();
				while(it.hasNext()) {
					Entry<Sun, GetPoint> b = it.next();
					if(b.getKey().GetRectangle().contains(e.getPoint())) {
						SunXX = b.getValue().getX();
						SunYY = b.getValue().getY();
						SunIndex = 1;
						//System.out.println("太阳------被点");
						SoundUtils.Play(dian, false, gs);
						Config.CHUSHISUN = Config.CHUSHISUN + 25;
						it.remove();
					}					
				}

				Rectangle rec = new Rectangle(50, 80, 730, 520);
				Rectangle PlantsBarRec = new Rectangle(103,12,350,72);
				for (int i = 0; i < PlantsBar.PlantsBarList.size(); i++) {
					//System.out.println(PlantsBar.PlantsBarList.get(i).isIscold()+"===================");
					if(PlantsBarRec.contains(e.getPoint())  && !PlantsBar.PlantsBarList.get(i).isIscold() && Config.CHUSHISUN >= PlantsBar.PlantsBarList.get(i).getSun()) {
						PlayerChoicedPlantRect = PlantsBar.GetRect(e);	
						PlantsBar.GetPlayerPlants(PlayerChoicedPlantRect).setColdSpeed(0);
						PlantsBar.PlantsBarList.get(i).setIscold(true);
						setCursor(handCursor);
						PointerUP = 1;
					}
				}
				
				if(rec.contains(e.getPoint()) && PlayerChoicedPlantRect != null) {
					boomX = e.getX();
					boomY = e.getY();
					x = (e.getX()-52)/81*81+60;
					y = (e.getY()-100)/100*100+100;
					GetPoint getpoint = new GetPoint(x,y);
					Plants player = PlantsBar.GetPlayerPlants(PlayerChoicedPlantRect);
					Plants MapPlants = null;
					switch (player.getPlantstype()) {
					case SUNFLOWER:
						MapPlants = new SunFlower();
						MapPlants.setX(x);
						MapPlants.setY(y);
						
						break;
					case WANDOU:
						MapPlants = new SingleWandou();
						MapPlants.setX(x);
						MapPlants.setY(y);
						
						break;
					case DOUBLEWANDOU:
						MapPlants = new DoubleWanDou();
						MapPlants.setX(x);
						MapPlants.setY(y);
						
						break;
					case ICEWANDOU:
						MapPlants = new IceWanDou();
						MapPlants.setX(x);
						MapPlants.setY(y);
						break;
					case CHERRYBOOM:
						MapPlants = new CherryBoom();
						MapPlants.setX(x);
						MapPlants.setY(y);
						break;
					case QUANHUANG:
						MapPlants = new QuanHuang();
						MapPlants.setX(x);
						MapPlants.setY(y);
						break;
					case JIANGUO:
						MapPlants = new JianGuo();
						MapPlants.setX(x);
						MapPlants.setY(y);
						break;
					default:
						break;
					}
					if(DrawPlantsInMap.IsExitPlant(getpoint)) {
						
						Config.CHUSHISUN = Config.CHUSHISUN-MapPlants.getSun();
						if(Config.CHUSHISUN <  0) {
							//JOptionPane.showMessageDialog(null, "钱不够","警告",JOptionPane.ERROR_MESSAGE);
							Config.CHUSHISUN = Config.CHUSHISUN + MapPlants.getSun();
						}else {	
							SoundUtils.Play(paint, false, gs);
							DrawPlantsInMap.PlantsMap.put(MapPlants, getpoint);
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "这块地种过植物了","警告",JOptionPane.ERROR_MESSAGE);
					}
						PlayerChoicedPlantRect = null;
						setCursor(JianTouCursor);
						//System.out.println(DrawPlantsInMap.PlantsMap.size());
				}
			}
			//System.out.println(e.getX()+"===="+e.getY());
			//hb.repaint();
			hb.updateUI();
		}

		@Override
		public void mouseMoved(MouseEvent e) {

			if(gs == GameState.WELCOME) {
				Rectangle StartRect = new Rectangle(Config.WINDOWS_WEIGHT/2 - GetImages.IMAGES.get("gamestart.png").getWidth() / 2, 545, GetImages.IMAGES.get("gamestart.png").getWidth(),GetImages.IMAGES.get("gamestart.png").getHeight());
				if (StartRect.contains(e.getPoint())) {
					setCursor(handCursor);
					StartBtnIndex = 1;
				}else {
					setCursor(JianTouCursor);
					StartBtnIndex = 0;
				}
			}
			if(gs == GameState.WELCOMETWO) {
				Rectangle WelcomeRect = new Rectangle(Config.WINDOWS_WEIGHT/2 + GetImages.IMAGES.get("mxms.png").getWidth() / 2, 100, GetImages.IMAGES.get("mxms.png").getWidth(),GetImages.IMAGES.get("mxms.png").getHeight());
				if (WelcomeRect.contains(e.getPoint())) {
					setCursor(handCursor);
					MxmsStartIndex = 1;
				}else {
					setCursor(JianTouCursor);
					MxmsStartIndex =  0;
				}
				if(TuJianRec.contains(e.getPoint())) {
					setCursor(handCursor);
					TuJianIndex = 1;
				}else {
					setCursor(JianTouCursor);
					TuJianIndex = 0;
				}
			}
			if(gs == GameState.CHOICEPLANTS) {
				Rectangle goRec = new Rectangle(550,480,65,37);
				Rectangle sunflowerRect = new Rectangle(310,163,55,80);
				Rectangle wandouRect = new Rectangle(375,163,55,80);
				if(goRec.contains(e.getPoint()) || wandouRect.contains(e.getPoint())|| sunflowerRect.contains(e.getPoint())) {
					setCursor(handCursor);
				}else {
					setCursor(JianTouCursor);
				}
			}			
			if(gs == GameState.MOVECAOANDCAR) {
				setCursor(JianTouCursor);
			}
			
			if(gs == GameState.GAMEING || gs == GameState.LEVEL1 || gs == GameState.LEVEL2 ||gs == GameState.LEVEL3||gs == GameState.LEVEL4||gs == GameState.LEVEL5) {
				MouseX = e.getX();
				MouseY = e.getY();
			}
				//hb.repaint();
				hb.updateUI();
		}
	}
	

	
	@Override
	public void run() {	
	
		
		while (true) {
			if (gs == GameState.WELCOMETWO) {
				ComeBack();
			}
			if(gs == GameState.MAPMOVERIGHT) {
				//System.out.println(bgIndex);
				MapMoveRight();
			}
			if(gs ==GameState.MAPMOVELEFT) {
				MapMoveLeft();
			}
			if (gs == GameState.MOVECAOANDCAR) {
				MoveCaoDi();
			}
			if(SunIndex == 1) {
				MoveSun();
			}
			if(SjSunIndex == 1) {
				SjSunMove();
			}
			if(DaoJuIndex == 1) {
				MoveDaoJu();
			}
			if(HuiXueDaoJuIndex == 1) {
				MoveHuiXueDaoju();
			}
			if(AddATKDaoJuIndex == 1) {
				MoveAddAtk();
			}
			if(ADDSPEEDDaoJuIndex == 1) {
				MoveAddSpeed();
			}
			
			if(gs == GameState.GAMEING  || gs == GameState.LEVEL1 || gs == GameState.LEVEL2 ||gs == GameState.LEVEL3||gs == GameState.LEVEL4||gs == GameState.LEVEL5) {
				//Count();
				DrawPlantsInMap.AcdMapCreatBullet();	
				
				//CreatSun();
				if(Plants.BulletsList.size()>0) {
					MoveBullet();
				}
//				File f = new File("C:\\Users\\LS\\eclipse-workspace\\植物大战僵尸\\src\\mp3\\gaming.wav");
//				SoundUtils.Play(f, false, gs);
				moveZobie();
			}
			if(gs == GameState.GAMEING|| gs == GameState.LEVEL1 || gs == GameState.LEVEL2 ||gs == GameState.LEVEL3||gs == GameState.LEVEL4||gs == GameState.LEVEL5 && Sun.SunList.size() <= 0) {
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
					@Override
					protected Void doInBackground() throws Exception {
						Thread.sleep(12000);
						CreatSun();
						movesun();
						return null;
					}
				};
				worker.execute();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		
	}

	private void MoveAddAtk() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					double jd = 90 - Math.atan2(46 - djY, 652 - djX) * 180 / Math.PI;
					djX = (int) (djX + Math.sin(jd * Math.PI / 180) * 8);
					djY = (int) (djY + Math.cos(jd * Math.PI / 180) * 8);
					if(djY <= 46) {
						AddATKDaoJuIndex = 0;
						break;
					}
					break;
				}
			}
		}).start();
	}
	
	private void MoveAddSpeed() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					double jd = 90 - Math.atan2(80 - djY, 652 - djX) * 180 / Math.PI;
					djX = (int) (djX + Math.sin(jd * Math.PI / 180) * 8);
					djY = (int) (djY + Math.cos(jd * Math.PI / 180) * 8);
					if(djY <= 80) {
						ADDSPEEDDaoJuIndex = 0;
						break;
					}
					break;
				}
			}
		}).start();
	}
	

	private void MoveHuiXueDaoju() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					double jd = 90 - Math.atan2(12 - djY, 652 - djX) * 180 / Math.PI;
					djX = (int) (djX + Math.sin(jd * Math.PI / 180) * 8);
					djY = (int) (djY + Math.cos(jd * Math.PI / 180) * 8);
					if(djY <= 12) {
						HuiXueDaoJuIndex = 0;
						break;
					}
					break;
				}
			}
		}).start();
	}

	private void MoveDaoJu() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					double jd = 90 - Math.atan2(152-lastZombieY , 385 - lastZombieX) * 180 / Math.PI;
					lastZombieX = (int) (lastZombieX + Math.sin(jd * Math.PI / 180) * 1.2);
					lastZombieY = (int) (lastZombieY + Math.cos(jd  * Math.PI / 180) * 1.2);
					//System.out.println(lastZombieX+"============="+lastZombieY);
//					if(lastZombieY <= 150) {
//						DaoJuIndex = 0;
//						break;
//					}
					try {
						Thread.sleep(2000);
						gs = GameState.WIN;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				}
			}
		}).start();
	}

	private void moveZobie() {
//			Timer t = new Timer();
//			t.schedule(new TimerTask() {	
//				@Override
//				public void run() {
//					Factory.ZbMove();		
//				}
//			}, 1000);
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Factory.ZbMove();		
				}
			}).start();
		}
	
	
	//子弹移动
	private void MoveBullet() {	
		Iterator<Map.Entry<Bullet, GetPoint>> it = Plants.BulletsList.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Bullet, GetPoint> b = it.next();
			if (!b.getKey().MoveBullet()) {
				it.remove();
			} else {
				for (int i = 0; i < LoadingPlants.LoadingZobieLists.size(); i++) {
					Zombie zb  =LoadingPlants.LoadingZobieLists.get(i);
					if(zb.isDeathing() == false && b.getKey().GetRectangle().intersects(zb.GetRectangle())) {
						Factory.BulletAtkZombie(zb, b.getKey());
						SoundUtils.Play(jizhong, false, GameState.LEVEL1);
						bX = zb.getX();
						bY = zb.getY();
						bulletAtk = b.getKey().getATK();
						buindex  = 1;
						JianIndex = 1;
						try {
							it.remove();
						} catch (Exception e) {
						}
						
					}
					if(zb.isDeathing() == false && b.getKey().getBulletType() == BulletType.ICEWANDOU && b.getKey().GetRectangle().intersects(zb.GetRectangle())) {
						Factory.BulletAtkZombie(zb, b.getKey());
						//System.out.println(zb.getSpeed());
						zb.setSpeed(zb.getSpeed()+100);
						//System.out.println(zb.getSpeed());
						new Thread(new Runnable() {
							
							@Override
							public void run() {
									try {
										Thread.sleep(1000);
										zb.setSpeed(100);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}	
							}
						}).start();		
					}
				}
			}
		}
		}
	//地图 右移
	private void MapMoveRight() {
		bgIndex = bgIndex + 4;
		if(bgIndex >= 360) {
			bgIndex = 360;
		}
	}
	//地图左移
	private void MapMoveLeft() {
		MoveMapLeftIndex  = MoveMapLeftIndex + 4;
		if(MoveMapLeftIndex >= 355) {
			MoveMapLeftIndex = 355;
			gs = GameState.CHOICEPLANTS;
			SoundUtils.Play(GetImages.AUDIO.get("choiced.wav"), true, GameState.CHOICEPLANTS);
			//SoundUtils.Play(choiced, false, GameState.CHOICEPLANTS);
		}
	}
	//点击太阳  太阳移动
	private void MoveSun() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					double jd = 90 - Math.atan2(20- SunYY, 25 - SunXX) * 180 / Math.PI;
					SunXX = (int) (SunXX + Math.sin(jd * Math.PI / 180) * 8);
					SunYY = (int) (SunYY + Math.cos(jd  * Math.PI / 180) * 8);
					if(SunXX <= 20 || SunYY <= 25) {
						SunIndex = 0;
						break;
					}
					break;
				}
			}
		}).start();
	}
	
	private void SjSunMove() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//System.out.println(SjSunIndex);
				while(true) {
					double jd = 90 - Math.atan2(20- SunYYY, 25 - SunXXX) * 180 / Math.PI;
					SunXXX = (int) (SunXXX + Math.sin(jd * Math.PI / 180) * 8);
					SunYYY = (int) (SunYYY + Math.cos(jd  * Math.PI / 180) * 8);
					if(SunXXX <= 20 || SunYYY <= 25) {
						SjSunIndex = 0;
						break;
					}
					break;
				}
			}
		}).start();
	}
	//每隔十秒产生一个阳光
	public  void CreatSun() {
		if (Sun.SunList.size() <= 0 && SjSunIndex != 1 && SunIndex != 1) {
			Random r = new Random();
			SunX = r.nextInt(500) + 100;
			SjSunY = r.nextInt(300) + 200;
			p = new GetPoint(SunX, SjSunY);
			Sun.SunList.add(p);
		}
	}
	
	public void movesun() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(50);
						SunY = SunY + 1;
						//break;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (SjSunIndex == 1) {
						SunY = 0;
						break;
					}
					if (SunY >= SjSunY) {
						SunY = SjSunY;
					}
				}
			}
		}).start();
	}
	
	//游戏开始 草地移动
	private void MoveCaoDi() {
		CaoWeight = CaoWeight + 5;
		CarWeight++;
		TuWeight = TuWeight + 0.5;
		if (CaoWeight >= GetImages.IMAGES.get("sod1row.png").getWidth()) {
			//break;
			CaoWeight = GetImages.IMAGES.get("sod1row.png").getWidth();
			if(LevelIndex == 1) {
				gs = GameState.LEVEL1;
				//
				//SoundUtils.Play(GetImages.AUDIO.get("1.wav"), false, GameState.LEVEL1);
				SoundUtils.Play(gaming, false, GameState.LEVEL1);
			}else if(LevelIndex == 2) {
				gs = GameState.LEVEL2;
			}if(LevelIndex == 3) {
				gs = GameState.LEVEL3;
			}if(LevelIndex == 4) {
				gs = GameState.LEVEL4;
			}if(LevelIndex == 5) {
				gs = GameState.LEVEL5;
			}
			LoadingPlants.CreatZombie();
		}
		if (CarWeight >= GetImages.GIFIMAGES.get("LawnMower.gif").getIconWidth()) {
			CarWeight = GetImages.GIFIMAGES.get("LawnMower.gif").getIconWidth();
		}
		if(TuWeight >=60) {
			TuWeight =60;
		}
	}
	//欢迎回来
	private void ComeBack() {
		comeBackY++;
		if (comeBackY >= GetImages.IMAGES.get("comeback.png").getHeight()) {
			comeBackY = GetImages.IMAGES.get("comeback.png").getHeight();
		}
	}
	//Main
	public static void main(String[] args) {
		PlantsVSZobie UI = new PlantsVSZobie();
		Thread t = new Thread(UI);
		t.start();
		File f = new File(".\\src\\mp3\\welcome.wav");
		SoundUtils.playMusic(true, f, GameState.WELCOME);
	}
}


