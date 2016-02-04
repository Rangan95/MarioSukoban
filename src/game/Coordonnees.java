package game;

/**
 * Permet  de représenter et de garder en mémoire le
 * placement de mario sur la carte.
 * @author remy
 *
 */

public class Coordonnees {
	int x;
	int y;
	
	public void setCoordonnees(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int myGetXX(){
		return x;
	}
	
	public int myGetYY(){
		return y;
	}
}
