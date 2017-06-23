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
	
	public boolean belongsSquare(Line line) {		
		return line.equals(this.top) || line.equals(this.bottom) || line.equals(this.left) || line.equals(this.right);
	}
	
	public int squareValue() {
		
		int res = 0;
		
		if (!top.isAvailable()) {
			res+=1;
		}
		if (!bottom.isAvailable()) {
			res+=1;
		}
		if (!left.isAvailable()) {
			res+=1;
		}
		if (!right.isAvailable()) {
			res+=1;
		}
		
		return res;
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
