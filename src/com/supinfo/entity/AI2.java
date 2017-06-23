package com.supinfo.entity;

import java.util.List;

import com.supinfo.game.Board;
import com.supinfo.game.Line;
import com.supinfo.game.Square;

public class AI2 extends Entity {

	private int score;
	private Board board;
	private List<Line> lines;
	

	public AI2(Board board) {
		this.board = board;
		this.score = 0;
	}

	public void turn() {
		int res = 1;
		while (res > 0 && board.canPlay()) {
			
			/*int rand = (int)(Math.random() * lines.size()); 
			Line line = lines.get(rand);
			board.addLine(line.getPoint1().getValue(), line.getPoint2().getValue());
			res = board.winPoints(line);
			score += res;*/
			Line line = null;
			Square win = winPoint();
			if (win != null) {
				if (win.getTop().isAvailable()) {
					line = win.getTop();
				} else if (win.getRight().isAvailable()) {
					line = win.getRight();
				} else if (win.getBottom().isAvailable()) {
					line = win.getBottom();
				} else if (win.getLeft().isAvailable()) {
					line = win.getLeft();
				}
			} else {
				lines = board.getAvailableLines();
				int rand = (int)(Math.random() * lines.size()); 
				line = lines.get(rand);
			}
			board.addLine(line.getPoint1().getValue(), line.getPoint2().getValue());
			res = board.winPoints(line);
			score += res;
			
		} 
	}
	
	private Square winPoint() {
		Square[][] tab = board.getTab();
		for (int y = 0; y < board.getHeight(); y++) {
			for ( int x = 0; x < board.getWidth(); x++) {
				if (tab[x][y].squareValue() == 3) {
					return tab[x][y];
				}
			}
		}
		return null;
	}
	
	// GETTERS
	public int getScore() {
		return score;
	}
}
