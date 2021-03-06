package com.supinfo.entity;

import java.util.Scanner;

import com.supinfo.game.Board;
import com.supinfo.game.Line;

public class Player extends Entity {

	private int score;
	private Board board;
	private Scanner sc;

	public Player(Board board) {
		this.board = board;
		this.setScore(0);
		this.sc = new Scanner(System.in);
	}

	@Override
	public void turn() {
		int p1, p2, res = 0;
		Line line = null;
		while((line == null || res > 0) && board.canPlay()) {
			res = 0;
			System.out.println("Choisissez un point ");
			p1 = sc.nextInt();
			System.out.println("Choisissez un autre point ");
			p2 = sc.nextInt();

			line = board.addLine(p1, p2);
			if (line != null) {
				res = board.winPoints(line);
				score += res;
			}
		}

	}

	// GETTERS & SETTERS
	@Override
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
