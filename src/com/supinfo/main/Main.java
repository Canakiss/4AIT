package com.supinfo.main;

import java.io.IOException;

import com.supinfo.entity.AI;
import com.supinfo.entity.Player;
import com.supinfo.game.Board;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Board board = new Board(2, 2);
		Player player = new Player(board);
		AI ai = new AI(board);
		//board.promptBoard();
		
		while (board.canPlay()) {
			player.turn();
			ai.turn();
			System.out.println("Player score = "+player.getScore());
			System.out.println("AI score = "+ai.getScore());
			System.out.println("-------------------");
		}
		System.out.println('\n'+'\n'+'\n'+'\n'+'\n');
		System.out.println("-------------------");
		System.out.println("THE END");
		System.out.println("Player score = "+player.getScore());
		System.out.println("AI score = "+ai.getScore());
		board.promptBoard();
		System.out.println("-------------------");
		
	}
}
