package com.supinfo.entity;

import java.util.Scanner;

import com.supinfo.game.Board;

public class AI {

	private int score;
	private Board board;
	
	public AI(Board board) {
		this.board = board;
		this.score = 0;
	}
}
