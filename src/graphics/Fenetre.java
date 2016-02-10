package graphics;

import game.Game;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Représente la fenêtre de jeu.
 * @author remy
 *
 */

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	/**
	 * L'attribut currentPanel contient le panel actuellement
	 * afficher dans la fenêtre.
	 */
	private JPanel currentPanel;
	
	public Fenetre(){
		this.setTitle("Mario Sukoban");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.currentPanel = new Menu(this);
		this.setContentPane(currentPanel);
		this.setVisible(true);
		this.pack();
	}
	
	public JPanel getCurrentPanel(){
		return this.currentPanel;
	}
	
	/**
	 * Méthode permettant de changer le panel
	 * actuellement affiché.
	 * @param pan
	 */
	public void setCurrentPanel(JPanel pan){
		this.currentPanel = pan;
		this.setContentPane(currentPanel);
		this.currentPanel.setFocusable(true);
		this.currentPanel.requestFocus();
		this.pack();
		this.repaint();
		this.revalidate();
	}
	
	public void loadGame(Game game){
		if(game.getGameBoard().loadBoard(game.getLvl()))
			this.setCurrentPanel(new GamePanel(game, game.getGameBoard().getSizeOfX()*34, game.getGameBoard().getSizeOfY()*34));
		else
			this.setCurrentPanel(new Menu(this));
	}
}
