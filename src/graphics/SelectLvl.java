package graphics;

import game.Game;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Permet au joueur de choisir le niveau dans lequel
 * il veut jouer. Une évolution possible sera
 * un tableau de boutons.
 * @author remy
 *
 */

public class SelectLvl extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton lvl1;
	private JButton lvl2;
	private JButton lvl3;
	private Fenetre fen;
	
	public SelectLvl(Fenetre fen){
		this.setPreferredSize(new Dimension(300, 300));
		
		this.lvl1 = new JButton("niveau1");
		this.lvl2 = new JButton("niveau2");
		this.lvl3 = new JButton("niveau3");
		
		this.fen = fen;
		
		this.initGraphics();
	}
	
	public void initGraphics(){
		GridLayout gl = new GridLayout();
		gl.setColumns(1);
		gl.setRows(3);
		
		this.setLayout(gl);
		this.add(lvl1);
		this.add(lvl2);
		this.add(lvl3);
		
		this.lvl1.addActionListener(this);
		this.lvl2.addActionListener(this);
		this.lvl3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(lvl1))
			new Game(fen, "niveau1.txt");
		
		else if(e.getSource().equals(lvl2))
			new Game(fen, "niveau2.txt");
		
		else if(e.getSource().equals(lvl3))
			new Game(fen, "niveau3.txt");
		
	}

}
