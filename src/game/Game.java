package game;

import graphics.Fenetre;

public class Game {
	private Fenetre fenetre;
	private GameBoard gameBoard;
	private String lvl;
	
	public Game(String lvl){
		this.lvl = lvl;
		gameBoard = new GameBoard(lvl);
		setFenetre(new Fenetre(this, gameBoard.getSizeOfX()*34, gameBoard.getSizeOfY()*34));
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}
	
	public void reload(){
		gameBoard.loadBoard(lvl);
		fenetre.getPanelOfGame().loadPicture();
	}

	public Fenetre getFenetre() {
		return fenetre;
	}

	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	
		
	
}
