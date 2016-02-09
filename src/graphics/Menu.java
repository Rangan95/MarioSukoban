package graphics;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Représente le panel contenant le menu.
 * Actuellement, le menu ne contient qu'un seul bouton : Jouer.
 * @author remy
 *
 */

public class Menu extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton jouer;
	private JButton score;
	private Fenetre fen;
	private GridLayout gl;
	
	public Menu(Fenetre fen){
		this.setPreferredSize(new Dimension(300, 300));
		this.fen = fen;
		this.gl = new GridLayout(2, 1);
		this.jouer = new JButton("Jouer");
		this.score = new JButton("Score");
		this.jouer.addActionListener(this);
		this.initGraphics();
	}
	
	public void initGraphics(){
		this.setLayout(gl);
		this.add(jouer);
		this.add(score);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jouer))
			fen.setCurrentPanel(new SelectLvl(fen));		
	}
}
