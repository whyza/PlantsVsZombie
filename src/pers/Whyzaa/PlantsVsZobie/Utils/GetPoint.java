package pers.Whyzaa.PlantsVsZobie.Utils;

import pers.Whyzaa.PlantsVsZobie.Config.Config;

public class GetPoint {
	private int x;
    private int y;
    
    public GetPoint(int x, int y) {
       setX(x);
       setY(y);
    }
    
	public int getX() {
        return x;
    }
 
    public void setX(int x) {
        this.x = x;
    }
 
    public int getY() {
        return y;
    }
 
    public void setY(int y) {
        this.y = y;
    }
    
    
    public boolean MoveBullet() {
		boolean f = true;
		int x = getX() + 15;
		if(x > Config.WINDOWS_WEIGHT) {
			f = false;
		}else {
			setX(x);
		}
		return f;
	}
}
