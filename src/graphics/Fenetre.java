package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel;
	private Menu menu;
	//private SelectLvl selectLvl;
	private JPanel currentPanel;
	
	public Fenetre(){
		this.setTitle("Mario Sukoban");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		menu = new Menu(this);
		this.currentPanel = menu;
		this.setContentPane(currentPanel);
		this.setVisible(true);
		this.pack();
	}
	
	public JPanel getCurrentPanel(){
		return this.currentPanel;
	}
	
	public void setCurrentPanel(JPanel pan){
		this.currentPanel = pan;
		this.setContentPane(currentPanel);
		this.currentPanel.setFocusable(true);
		this.currentPanel.requestFocus();
		this.pack();
		this.repaint();
		this.revalidate();
	}
}
