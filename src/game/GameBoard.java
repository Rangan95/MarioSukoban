package game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * La valeur à x et y du plateau est égale à :
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
	
	public GameBoard(String lvl, int sizeOfX, int sizeOfY){
		this.sizeOfX = sizeOfX;
		this.sizeOfY = sizeOfY;
		board = new int[sizeOfX][sizeOfY];
		this.loadBoard(lvl);
	}
	
	public void loadBoard(String lvl){
		try {
			InputStream ips = new FileInputStream(lvl);
			InputStreamReader ipsr = new InputStreamReader(ips);
			
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			
			while((ligne=br.readLine()) != null){
				String[] tab = ligne.split(" ");
				board[Integer.parseInt(tab[1])][Integer.parseInt(tab[0])] = Integer.parseInt(tab[2]);
			}
				
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
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
