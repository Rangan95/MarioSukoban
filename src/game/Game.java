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
	private int nbOfLvl;
	

	public Game(Fenetre fen, String lvl){
		this.lvl = lvl;
		this.nbOfLvl = Integer.parseInt(lvl.substring(6, 7));
		this.fen = fen;
		this.gameBoard = new GameBoard();
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
	
	public int getNbOfLvl() {
		return nbOfLvl;
	}
	
	public String getLvl() {
		return lvl;
	}
}
