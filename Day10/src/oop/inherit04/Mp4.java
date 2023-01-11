package oop.inherit04;

public class Mp4 extends MediaFile{
	
	private double speed;

	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		if(speed == 1 || speed == 1.2 || speed == 1.5 || speed == 2) {
			this.speed = speed;
		}
	}
	
}

