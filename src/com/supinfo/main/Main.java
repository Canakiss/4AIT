package com.supinfo.main;

import java.io.IOException;
import java.util.Scanner;

import com.supinfo.entity.AI;
import com.supinfo.entity.AI2;
import com.supinfo.entity.AI3;
import com.supinfo.entity.Entity;
import com.supinfo.entity.Player;
import com.supinfo.game.Board;

public class Main {

	public static void main(String[] args) throws IOException {


		Scanner sc = new Scanner(System.in);
		String replay;
		do {
		System.out.println("Choisissez la largeur de la grille ");
		int x = sc.nextInt();
		System.out.println("Choisissez la hauteur de la grille ");
		int y = sc.nextInt();

		Board board = new Board(x, y);

		Entity player1 = null;
		Entity player2 = null;
		boolean ok;

		do {
			ok = true;
			System.out.println("1 : Joueur vs AI1");
			System.out.println("2 : Joueur vs AI2");
			System.out.println("3 : Joueur vs AI3");
			System.out.println("4 : AI1 vs AI2");
			System.out.println("5 : AI1 vs AI3");
			System.out.println("6 : AI2 vs AI3");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				player1 = new Player(board);
				player2 = new AI(board);
				break;
			case 2 :
				player1 = new Player(board);
				player2 = new AI2(board);
				break;
			case 3 :
				player1 = new Player(board);
				player2 = new AI3(board);
				break;
			case 4 :
				player1 = new AI(board);
				player2 = new AI2(board);
				break;
			case 5 :
				player1 = new AI(board);
				player2 = new AI3(board);
				break;
			case 6 :
				player1 = new AI2(board);
				player2 = new AI3(board);
				break;
			default:
				System.out.println("Choix invalide");
				ok = false;
			}
		} while (!ok);

		while (board.canPlay()) {
			board.promptBoard();
			player1.turn();
			player2.turn();

			//System.out.println("Player score = "+player.getScore());
			System.out.println("player1 score = "+player1.getScore());
			//System.out.println("AI2 score = "+ai2.getScore());
			System.out.println("player2 score = "+player2.getScore());
			System.out.println("-------------------");
			System.out.println("Appuyez sur une touche pour passer au tour suivant");
			sc.nextLine();
		}
		System.out.println('\n'+'\n'+'\n'+'\n'+'\n');
		System.out.println("-------------------");
		System.out.println("THE END");
		//System.out.println("Player score = "+player.getScore());
		System.out.println("player1 score = "+player1.getScore());
		//System.out.println("AI2 score = "+ai2.getScore());
		System.out.println("player2 score = "+player2.getScore());
		board.promptBoard();
		System.out.println("-------------------");
		
		System.out.println("Voulez-vous rejouer ? o/n");
		replay =  sc.nextLine();
		
		} while(replay.charAt(0) == 'o');

	}
}
