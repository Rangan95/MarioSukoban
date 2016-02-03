package game;

public class Coordonnees {
	int x;
	int y;
	
	public Coordonnees(){
		
	}
	
	public Coordonnees(int x, int y){
		this.x = x;
		this.y = y;
	}
	
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
