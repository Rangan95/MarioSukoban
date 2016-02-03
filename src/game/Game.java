package game;

import graphics.Fenetre;

public class Game {
	private int sizeOfX;
	private int sizeOfY;
	
	public Game(String lvl, int size){
		if(size == 12){
			sizeOfX = 408;
			sizeOfY = 408;
		} else if (size == 10){
			sizeOfX = 340;
			sizeOfY = 340;
		}
		new Fenetre(new GameBoard(lvl, (int)sizeOfX/34, (int)sizeOfY/34), sizeOfX, sizeOfY);
	}
}
