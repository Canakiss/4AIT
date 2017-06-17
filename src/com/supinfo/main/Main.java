package com.supinfo.main;

import java.io.IOException;

import com.supinfo.entity.Player;
import com.supinfo.game.Board;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Board board = new Board(3, 3);
		Player player = new Player(board);
		//board.promptBoard();
		
		while (board.canPlay()) {
			player.turn();
			System.out.println("Player score = "+player.getScore());
		}
	}
}
