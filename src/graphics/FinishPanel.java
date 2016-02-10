package graphics;

import game.Game;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinishPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Game game;
	private JLabel bravo_sentence;
	
	private Box verticalBox;
	private Box horizontalBox1;
	private Box horizontalBox2;
	
	private JButton menu;
	private JButton niveauSuivant;
	private JButton enregistrement;

	public FinishPanel(Game game){
		this.setPreferredSize(new Dimension(600, 150));
		this.game = game;
		this.verticalBox = Box.createVerticalBox();
		this.horizontalBox1 = Box.createHorizontalBox();
		this.horizontalBox2 = Box.createHorizontalBox();
		this.menu = new JButton("Retour au menu");
		this.menu.addActionListener(this);
		this.niveauSuivant = new JButton("Niveau suivant");
		this.niveauSuivant.addActionListener(this);
		this.enregistrement = new JButton("Enregistre ton score");
		this.bravo_sentence = new JLabel("Bravo, tu as reussi ce niveau !");
		this.init_graphics();
	}
	
	public void init_graphics(){
		horizontalBox1.add(bravo_sentence);
		horizontalBox2.add(menu);
		horizontalBox2.add(Box.createRigidArea(new Dimension(50, 0)));
		horizontalBox2.add(niveauSuivant);
		horizontalBox2.add(Box.createRigidArea(new Dimension(50, 0)));
		horizontalBox2.add(enregistrement);
		verticalBox.add(horizontalBox1);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 75)));
		verticalBox.add(horizontalBox2);
		this.add(verticalBox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(menu)){
			this.game.getFenetre().setCurrentPanel(new Menu(this.game.getFenetre()));
		} else if(e.getSource().equals(niveauSuivant)){
			this.game.getFenetre().loadGame(new Game(game.getFenetre(), "niveau" + (game.getNbOfLvl()+1) + ".txt"));
		}
		
	}
	
}
