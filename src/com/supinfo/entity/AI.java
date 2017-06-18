package com.supinfo.entity;

import java.util.List;
import java.util.Scanner;

import com.supinfo.game.Board;
import com.supinfo.game.Line;

public class AI {

	private int score;
	private Board board;
	private List<Line> lines;

	public AI(Board board) {
		this.board = board;
		this.score = 0;
	}

	public void turn() {
		int res = 1;
		while (res > 0 && board.canPlay()) {
			lines = board.getAvailableLines();
			int rand = (int)(Math.random() * lines.size()); 
			Line line = lines.get(rand);
			board.addLine(line.getPoint1().getValue(), line.getPoint2().getValue());
			res = board.winPoints(line);
			score += res;
		} 
	}
	
	// GETTERS
	public int getScore() {
		return score;
	}
}
