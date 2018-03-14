package pers.Whyzaa.PlantsVsZobie.Zobie;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import pers.Whyzaa.PlantsVsZobie.Config.GameState;
import pers.Whyzaa.PlantsVsZobie.MainFrame.PlantsVSZobie;
import pers.Whyzaa.PlantsVsZobie.Plants.GameModel;
import pers.Whyzaa.PlantsVsZobie.Plants.Plants;

public class Zombie extends GameModel{
//	private ArrayList<Zombie> eatZombie = new ArrayList<Zombie>();
//	public ArrayList<Zombie> getEatZombie() {
//		return eatZombie;
//	}
//
//	public void setEatZombie(ArrayList<Zombie> eatZombie) {
//		this.eatZombie = eatZombie;
//	}

	private ConcurrentHashMap<Plants,Zombie> eatzombie = new ConcurrentHashMap<Plants,Zombie>();
	public ConcurrentHashMap<Plants, Zombie> getEatzombie() {
		return eatzombie;
	}

	public void setEatzombie(ConcurrentHashMap<Plants, Zombie> eatzombie) {
		this.eatzombie = eatzombie;
	}

	private int die;
	public int getDie() {
		return die;
	}

	public void setDie(int die) {
		this.die = die;
	}

	private int ZombieAtk;
	public int getZombieAtk() {
		return ZombieAtk;
	}

	public void setZombieAtk(int zombieAtk) {
		ZombieAtk = zombieAtk;
	}

	private boolean isChuXian;
	public boolean isChuXian() {
		return isChuXian;
	}

	public void setChuXian(boolean isChuXian) {
		this.isChuXian = isChuXian;
	}

	private Image ZombieDie;

	public Image getZombieDie() {
		return ZombieDie;
	}

	public void setZombieDie(Image zombieDie) {
		ZombieDie = zombieDie;
	}

	private ZombieType zbType;
	
	public ZombieType getZbType() {
		return zbType;
	}

	public void setZbType(ZombieType zbType) {
		this.zbType = zbType;
	}

	public  boolean MoveZombie() {
		boolean f = true;
		int x = getX() - 1;
		try {
			Thread.sleep(getSpeed());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(x <= -getWeight()) {
			PlantsVSZobie.gs = GameState.GAMEOVER;
			f = false;
		}else {
			setX(x);
		}
		return f;
	}
	
	public  int RanSetY() {
		Random r = new Random();
		int rr = r.nextInt(5);
		int y = 0;
		switch (rr) {
		case 0:
			y = 100;
			break;
		case 1:
			y = 200;
			break;
		case 2:
			y = 300;
			break;
		case 3:
			y = 400;
			break;
		default :
			y = 500;
			break;				
		}
		return y;
	}
	
	public Rectangle GetRectangle() {
		Rectangle r = new Rectangle( getX()+20, getY()+60,getWeight()/2,getHeight()/4);
		return r;
	}

}
