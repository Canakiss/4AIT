package com.supinfo.entity;

import java.util.Scanner;

import com.supinfo.game.Board;

public class Player {

	private int score;
	private Board board;
	private Scanner sc;
	
	public Player(Board board) {
		this.board = board;
		this.setScore(0);
		this.sc = new Scanner(System.in);
	}
	
	public boolean turn() {
		int p1, p2;
		do {
		System.out.println("Choisissez un point ");
		p1 = sc.nextInt();
		System.out.println("Choisissez un autre point ");
		p2 = sc.nextInt();
		
		} while(board.addLine(p1, p2));
		return true;
	}
	
	// GETTERS & SETTERS
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
