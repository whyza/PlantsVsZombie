package pers.Whyzaa.PlantsVsZobie.DaoJu;

import java.awt.Rectangle;
import java.util.ArrayList;

import pers.Whyzaa.PlantsVsZobie.Plants.GameModel;

public class DaoJu extends GameModel{
	public Rectangle GetDaoJuRectangle() {
		Rectangle r = new Rectangle(getX(),getY(), getWeight(), getHeight());
		return r;
	}	
	public static ArrayList<DaoJu> DaoJuList = new ArrayList<DaoJu>();
	public static ArrayList<DaoJu> AddATkDaoJuList = new ArrayList<DaoJu>();
	public static ArrayList<DaoJu> AddSpeedDaoJuList = new ArrayList<DaoJu>();
	private DaoJuType dt;
	public static ArrayList<DaoJu> getDaoJuList() {
		return DaoJuList;
	}
	public static void setDaoJuList(ArrayList<DaoJu> daoJuList) {
		DaoJuList = daoJuList;
	}
	public DaoJuType getDt() {
		return dt;
	}
	public void setDt(DaoJuType dt) {
		this.dt = dt;
	}
}
