package com.supinfo.main;

import java.util.List;

import com.supinfo.game.Board;
import com.supinfo.game.Point;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Board board = new Board(3, 3);
		board.promptBoard();

		System.out.println(board.addLine(101, 100));
		System.out.println(board.addLine(104, 100));
		System.out.println(board.addLine(104, 100));
		board.promptBoard();
	}

}
