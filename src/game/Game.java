package game;

import graphics.Fenetre;

public class Game {
	private GameBoard gameBoard;
	private int sizeOfX;
	private int sizeOfY;
	
	public Game(){
		sizeOfX = 340;
		sizeOfY = 340;
		gameBoard = new GameBoard((int)sizeOfX/34, (int)sizeOfY/34);
		new Fenetre(gameBoard, sizeOfX, sizeOfY);
	}
}
