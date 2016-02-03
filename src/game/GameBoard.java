package game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

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
	
	public GameBoard(int sizeOfX, int sizeOfY){
		this.sizeOfX = sizeOfX;
		this.sizeOfY = sizeOfY;
		board = new int[sizeOfX][sizeOfY];
		this.loadBoard();
	}
	
	public void loadBoard(){
		/*Random r = new Random();
		int nbRandom = r.nextInt(10);
		
		for(int y = 0; y < sizeOfY; y++){
			for(int x = 0; x < sizeOfX; x++){
				nbRandom = r.nextInt(10);
				if(nbRandom < 6)
					board[x][y] = 0;
				else if(nbRandom >= 6 && nbRandom < 9)
					board[x][y] = 1;
				else
					board[x][y] = 4;
			}
		}
		board[5][5] = 5;
		board[5][7] = 2;
		*/
		try {
			InputStream ips = new FileInputStream("niveau1.txt");
			InputStreamReader ipsr = new InputStreamReader(ips);
			
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			
			for(int y = 0; y < sizeOfY; y++){
				for(int x = 0; x < sizeOfX; x++){
					if((ligne=br.readLine()) != null)
						board[x][y] = Integer.parseInt(ligne);
				}								
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
