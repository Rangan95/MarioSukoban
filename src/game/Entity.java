package game;

public class Entity {
private Coordonnees coord;
	
	public Entity(){
		coord = new Coordonnees();
	}
	
	public void setCoordonnees(int x, int y){
		this.coord.setCoordonnees(x, y);
	}
	
	public Coordonnees getCoord(){
		return coord;
	}
	
	public int myGetXX(){
		return this.coord.myGetXX();
	}
	
	public int myGetYY(){
		return this.coord.myGetYY();
	}
}
