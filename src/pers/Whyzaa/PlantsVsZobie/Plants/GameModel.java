package pers.Whyzaa.PlantsVsZobie.Plants;

import java.awt.Image;
import java.awt.Rectangle;

public class GameModel {

	// Height Weight speed x y

	//用于计时  
	public int Count() {
		int i = getT();
		i++;
		setT(i);
		return i;
	}
	
private int t;
	
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	private int X;
	private int y;
	private Image GifImage;
	private Image image;
	private int Height;
	private int Weight;
	private int speed;

	public Image getGifImage() {
		return GifImage;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setGifImage(Image gifImage) {
		GifImage = gifImage;
	}

	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}

	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int HP;
	private int MaxHP;
	public int getMaxHP() {
		return MaxHP;
	}
	public void setMaxHP(int maxHP) {
		MaxHP = maxHP;
	}
	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}
	
	private boolean isDeathing;

	public boolean isDeathing() {
		return isDeathing;
	}
	public void setDeathing(boolean isDeathing) {
		this.isDeathing = isDeathing;
	}

	
	
}
