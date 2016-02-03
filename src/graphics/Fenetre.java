package graphics;

import javax.swing.JFrame;

import game.Game;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Fenetre(Game game, int sizeOfX, int sizeOfY){
		this.setTitle("Mario Sukoban");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new GamePanel(game, sizeOfX, sizeOfY));
		this.setVisible(true);
		this.pack();
	}
}
