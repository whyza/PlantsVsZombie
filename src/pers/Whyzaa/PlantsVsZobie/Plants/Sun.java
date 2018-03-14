package pers.Whyzaa.PlantsVsZobie.Plants;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import pers.Whyzaa.PlantsVsZobie.Utils.GetPoint;

public class Sun extends GameModel{
	Random r = new Random();
	public Sun() {
		setDate(new Date().getSeconds()+r.nextInt(10));
	}
	private int date;
	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public static  ArrayList<GetPoint> SunList = new ArrayList<GetPoint>();

	public  ArrayList<GetPoint> getSunList() {
		return SunList;
	}

	public  void setSunList(ArrayList<GetPoint> sunList) {
		SunList = sunList;
	}	
	public Rectangle GetRectangle() {
		Rectangle r = new Rectangle(getX(),getY(), getWeight(), getHeight());
		return r;
	}
}

