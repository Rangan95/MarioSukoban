package game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Permet de charger la carte de jeu.
 * 
 * Les valeurs dans le tableau de jeu peuvent être :
 * 			- 0 : rien
 * 			- 1 : mur
 * 			- 2 : caisse
 * 			- 3 : caisseplace
 * 			- 4 : but
 * 			- 5 : mario
 * 
 * @author remy
 */

public class GameBoard {
	private int[][] board;
	private int sizeOfX;
	private int sizeOfY;
	private int nbObjectif;
	
	public int getNbObjectif() {
		return nbObjectif;
	}

	public GameBoard(String lvl){
		this.loadBoard(lvl);
	}
	
	public void loadBoard(String lvl){
		try {
			InputStream ips = new FileInputStream(lvl);
			InputStreamReader ipsr = new InputStreamReader(ips);			
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			String[] tab;
			
			ligne = br.readLine();
			tab = ligne.split(" ");
			sizeOfX = Integer.parseInt(tab[0]);
			sizeOfY = Integer.parseInt(tab[0]);
			board = new int[sizeOfX][sizeOfY];
			nbObjectif = Integer.parseInt(tab[1]);
			
			while((ligne=br.readLine()) != null){
				tab = ligne.split(" ");
				board[Integer.parseInt(tab[1])][Integer.parseInt(tab[0])] = Integer.parseInt(tab[2]);
			}
				
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Permet d'afficher dans la console le plateau de jeu.
	 */
	public void printBoard(){
		for(int y = 0; y < sizeOfY; y++){
			for(int x = 0; x < sizeOfX; x++){
				System.out.print(board[x][y]);
			}
			System.out.println();
		}
	}

	public int[][] getBoard() {
		return board;
	}
	
	public int getValue(int x, int y) {
		return board[x][y];
	}
	
	public void setValue(int x, int y, int z) {
		board[x][y] = z;
	}

	public int getSizeOfX() {
		return sizeOfX;
	}

	public void setSizeOfX(int sizeOfX) {
		this.sizeOfX = sizeOfX;
	}

	public int getSizeOfY() {
		return sizeOfY;
	}

	public void setSizeOfY(int sizeOfY) {
		this.sizeOfY = sizeOfY;
	}
}
