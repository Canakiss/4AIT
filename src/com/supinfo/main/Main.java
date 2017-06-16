package com.supinfo.main;

import com.supinfo.game.Board;

public class Main {

	public static void main(String[] args) {
		
		Board board = new Board(3, 3);
		board.promptBoard();

		System.out.println(board.addLine(101, 100));
		System.out.println(board.addLine(104, 100));
		System.out.println(board.addLine(104, 100));
		board.promptBoard();
	}

}
