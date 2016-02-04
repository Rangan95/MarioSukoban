package graphics;

import game.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener {
	private JButton jouer;
	private Fenetre fen;
	
	public Menu(Fenetre fen){
		this.setPreferredSize(new Dimension(300, 300));
		this.setFocusable(true);
		this.fen = fen;
		this.jouer = new JButton("JOUER");
		this.jouer.addActionListener(this);
		this.initGraphics();
	}
	
	public void initGraphics(){
		this.setLayout(new BorderLayout());
		this.add(jouer, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jouer))
			fen.setCurrentPanel(new SelectLvl(fen));
		
	}
}
