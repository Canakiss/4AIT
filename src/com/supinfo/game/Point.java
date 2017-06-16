package com.supinfo.game;

public class Point {

	@SuppressWarnings("unused")
	private int x;
	@SuppressWarnings("unused")
	private int y;
	private int value;
	
	public Point(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value+100;
	}
	
	//GETTERS
	public int getValue() {
		return value;
	}
}
