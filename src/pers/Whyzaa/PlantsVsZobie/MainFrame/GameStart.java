package pers.Whyzaa.PlantsVsZobie.MainFrame;

public class GameStart {
	public static void main(String[] args) {
		PlantsVSZobie UI = new PlantsVSZobie();
		Thread t = new Thread(UI);
		t.start();
	}
}
