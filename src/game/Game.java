package game;

import graphics.Fenetre;

public class Game {
	private GameBoard gameBoard;
	private int sizeOfX;
	private int sizeOfY;
	private Player player;
	
	public Game(String lvl, int size){
		player = new Player();
		if(size == 12){
			sizeOfX = 408;
			sizeOfY = 408;
		} else if (size == 10){
			sizeOfX = 340;
			sizeOfY = 340;
		}
		gameBoard = new GameBoard(lvl, (int)sizeOfX/34, (int)sizeOfY/34);
		new Fenetre(this, sizeOfX, sizeOfY);
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public GameBoard getGameBoard(){
		return gameBoard;
	}
}
