package com.supinfo.game;

public class Line {

	private Point point1;
	private Point point2;
	private boolean available;
	
	public Line(Point point1, Point point2) {
		
		this.point1 = point1;
		this.point2 = point2;
		this.available = true;
	}

	//GETTERS
	public Point getPoint1() {
		return point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
