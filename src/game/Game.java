package game;

import graphics.Fenetre;
import graphics.GamePanel;

/**
 * Classe centrale, permet le lancement et la gestion d'une partie.
 * @author remy
 *
 */

public class Game {
	private Fenetre fen;
	private GameBoard gameBoard;
	private String lvl;
	
	public Game(Fenetre fen, String lvl){
		this.lvl = lvl;
		this.fen = fen;
		this.gameBoard = new GameBoard(lvl);
		this.fen.setCurrentPanel(new GamePanel(this, gameBoard.getSizeOfX()*34, gameBoard.getSizeOfY()*34));
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}
	
	/**
	 * Permet de recharger une partie actuellement en cours.
	 */
	public void reload(){
		gameBoard.loadBoard(lvl);
		((GamePanel)fen.getCurrentPanel()).loadPicture();
	}

	public Fenetre getFenetre() {
		return fen;
	}

	public void setFenetre(Fenetre fenetre) {
		this.fen = fenetre;
	}	
}
