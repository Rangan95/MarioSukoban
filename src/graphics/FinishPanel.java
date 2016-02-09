package graphics;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinishPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Fenetre fen;
	private JLabel bravo_sentence;
	
	private Box verticalBox;
	private Box horizontalBox1;
	private Box horizontalBox2;
	
	private JButton menu;
	private JButton niveauSuivant;

	public FinishPanel(Fenetre fen){
		this.setPreferredSize(new Dimension(600, 150));
		this.fen = fen;
		this.verticalBox = Box.createVerticalBox();
		this.horizontalBox1 = Box.createHorizontalBox();
		this.horizontalBox2 = Box.createHorizontalBox();
		this.menu = new JButton("Retour au menu");
		this.menu.addActionListener(this);
		this.niveauSuivant = new JButton("Niveau suivant");
		this.bravo_sentence = new JLabel("Bravo, tu as reussi ce niveau !");
		this.init_graphics();
	}
	
	public void init_graphics(){
		horizontalBox1.add(bravo_sentence);
		horizontalBox2.add(menu);
		horizontalBox2.add(Box.createRigidArea(new Dimension(100, 0)));
		horizontalBox2.add(niveauSuivant);
		verticalBox.add(horizontalBox1);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 75)));
		verticalBox.add(horizontalBox2);
		this.add(verticalBox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(menu)){
			this.fen.setCurrentPanel(new Menu(this.fen));
		} else if(e.getSource().equals(niveauSuivant)){
			// A compléter
		}
		
	}
	
}
