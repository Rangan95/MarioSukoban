package graphics;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.GameBoard;
import game.Player;

public class GamePanel extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private JLabel[][] label;
	private GameBoard gameBoard;
	private Player player;

	public GamePanel(GameBoard gameBoard, int sizeOfX, int sizeOfY){
		this.setPreferredSize(new Dimension(sizeOfX, sizeOfY));
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		this.gameBoard = gameBoard;
		this.label = new JLabel[gameBoard.getSizeOfX()][gameBoard.getSizeOfY()];
		this.player = new Player();
		this.loadPicture();
		this.initLayout();
	}
	
	public void initLayout(){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.setLayout(new GridBagLayout());
		for(int x = 0; x < gameBoard.getSizeOfX(); x++){
			for(int y = 0; y < gameBoard.getSizeOfY(); y++){
				gbc.gridx = x;
				gbc.gridy = y;
				this.add(label[x][y], gbc);
			}
		}
	}
	
	public void loadPicture(){
		for(int x = 0; x < gameBoard.getSizeOfX(); x++){
			for(int y = 0; y < gameBoard.getSizeOfY(); y++){
				label[x][y] = new JLabel();
				if(gameBoard.getValue(x, y) == 1)
					label[x][y].setIcon(new ImageIcon("mur.jpg"));
				else if(gameBoard.getValue(x, y) == 2)
					label[x][y].setIcon(new ImageIcon("caisse.jpg"));
				else if(gameBoard.getValue(x, y) == 4)
					label[x][y].setIcon(new ImageIcon("objectif.png"));
				else if(gameBoard.getValue(x, y) == 5){
					label[x][y].setIcon(new ImageIcon("marioface.gif"));
					player.setCoordonnees(x, y);
				}else 
					label[x][y].setIcon(new ImageIcon(""));
			}
		}
	}
	
	public void setMario(int x, int y, String picture, boolean deplaceCaisse){
		label[player.myGetXX()][player.myGetYY()].setIcon(new ImageIcon(""));
		gameBoard.setValue(player.myGetXX(), player.myGetYY(), 0);
		player.setCoordonnees(player.myGetXX()+x, player.myGetYY()+y);
		label[player.myGetXX()][player.myGetYY()].setIcon(new ImageIcon(picture));
		gameBoard.setValue(player.myGetXX(), player.myGetYY(), 5);
	}
	
	public boolean verifyOutBoard(int x, int y){
		try{
			gameBoard.getValue(player.myGetXX()+x, player.myGetYY()+y);
			return true;
		}catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if(verifyOutBoard(0, -1) &&gameBoard.getValue(player.myGetXX(), player.myGetYY()-1) == 0)
					setMario(0, -1, "mariodos.gif", false);
					
				break;
			case KeyEvent.VK_DOWN:
				if(verifyOutBoard(0, 1) && gameBoard.getValue(player.myGetXX(), player.myGetYY()+1) == 0 )
					setMario(0, 1, "marioface.gif", false);
						
						break;
			case KeyEvent.VK_LEFT:
				if(verifyOutBoard(-1, 0) && gameBoard.getValue(player.myGetXX()-1, player.myGetYY()) == 0)
					setMario(-1, 0, "mariogauche.gif", false);
				
				break;
			case KeyEvent.VK_RIGHT:
				if(verifyOutBoard(1, 0) && gameBoard.getValue(player.myGetXX()+1, player.myGetYY()) == 0)
					setMario(1, 0, "mariodroite.gif", false);
				
				break;
	
			default:
				break;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
				
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
