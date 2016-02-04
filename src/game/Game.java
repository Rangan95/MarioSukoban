package game;

import graphics.Fenetre;
import graphics.GamePanel;

public class Game {
	private Fenetre fenetre;
	private GameBoard gameBoard;
	private String lvl;
	
	public Game(Fenetre fen, String lvl){
		this.lvl = lvl;
		this.fenetre = fen;
		gameBoard = new GameBoard(lvl);
		fen.setCurrentPanel(new GamePanel(this, gameBoard.getSizeOfX()*34, gameBoard.getSizeOfY()*34));
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}
	
	public void reload(){
		gameBoard.loadBoard(lvl);
		((GamePanel)fenetre.getCurrentPanel()).loadPicture();
	}

	public Fenetre getFenetre() {
		return fenetre;
	}

	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	
		
	
}
