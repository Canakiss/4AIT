package com.supinfo.game;

public class Square {

	private Line top;
	private Line bottom;
	private Line left;
	private Line right;
	
	public Square(Line top, Line bottom, Line left, Line right) {
		
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
	}
		
	// GETTERS
	public Line getTop() {
		return top;
	}

	public Line getBottom() {
		return bottom;
	}

	public Line getLeft() {
		return left;
	}

	public Line getRight() {
		return right;
	}
}
