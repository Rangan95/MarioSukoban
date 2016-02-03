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
import game.Entity;
import game.Game;

public class GamePanel extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private JLabel[][] label;
	private GameBoard gameBoard;
	private Player player;
	private Game game;

	public GamePanel(Game game, int sizeOfX, int sizeOfY){
		this.setPreferredSize(new Dimension(sizeOfX, sizeOfY));
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		this.game = game;
		this.gameBoard = game.getGameBoard();
		this.label = new JLabel[gameBoard.getSizeOfX()][gameBoard.getSizeOfY()];
		this.player = game.getPlayer();
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
				else if(gameBoard.getValue(x, y) == 2){
					label[x][y].setIcon(new ImageIcon("caisse.jpg"));
				}else if(gameBoard.getValue(x, y) == 4){
					label[x][y].setIcon(new ImageIcon("objectif.png"));
				}else if(gameBoard.getValue(x, y) == 5){
					label[x][y].setIcon(new ImageIcon("marioface.gif"));
					player.setCoordonnees(x, y);
				}else 
					label[x][y].setIcon(new ImageIcon(""));
			}
		}
	}
	
	public void setMario(int x, int y){
		if(gameBoard.getValue(player.myGetXX(), player.myGetYY()) == 4
				&& gameBoard.getValue(player.myGetXX()+x, player.myGetYY()+y) == 4){
			
			label[player.myGetXX()][player.myGetYY()].setIcon(new ImageIcon("objectif.png"));			
			player.setCoordonnees(player.myGetXX()+x, player.myGetYY()+y);
			
		}else if (gameBoard.getValue(player.myGetXX(), player.myGetYY()) == 4){
			label[player.myGetXX()][player.myGetYY()].setIcon(new ImageIcon("objectif.png"));			
			player.setCoordonnees(player.myGetXX()+x, player.myGetYY()+y);
			gameBoard.setValue(player.myGetXX(), player.myGetYY(), 5);
		}else if(gameBoard.getValue(player.myGetXX()+x, player.myGetYY()+y) == 4){	
			label[player.myGetXX()][player.myGetYY()].setIcon(new ImageIcon(""));
			gameBoard.setValue(player.myGetXX(), player.myGetYY(), 0);
			player.setCoordonnees(player.myGetXX()+x, player.myGetYY()+y);
			
		}else{
			label[player.myGetXX()][player.myGetYY()].setIcon(new ImageIcon(""));
			gameBoard.setValue(player.myGetXX(), player.myGetYY(), 0);
			player.setCoordonnees(player.myGetXX()+x, player.myGetYY()+y);
			gameBoard.setValue(player.myGetXX(), player.myGetYY(), 5);
		}		
	}
	
	public void setCaisse(int x, int y, int xx, int yy){
		label[player.myGetXX()+x][player.myGetYY()+y].setIcon(new ImageIcon(""));
		
		if(gameBoard.getValue(player.myGetXX()+x, player.myGetYY()+y) == 3){
				gameBoard.setValue(player.myGetXX()+x, player.myGetYY()+y, 4);
		}else
			gameBoard.setValue(player.myGetXX()+x, player.myGetYY()+y, 0);
		
		if(gameBoard.getValue(player.myGetXX()+xx, player.myGetYY()+yy) == 4){
			label[player.myGetXX()+xx][player.myGetYY()+yy].setIcon(new ImageIcon("caisseplace.jpg"));
			gameBoard.setValue(player.myGetXX()+xx, player.myGetYY()+yy, 3);
			
		}else{
			label[player.myGetXX()+xx][player.myGetYY()+yy].setIcon(new ImageIcon("caisse.jpg"));
			gameBoard.setValue(player.myGetXX()+xx, player.myGetYY()+yy, 2);
		}
	}
	
	public void setMarioPicture(String picture){
		label[player.myGetXX()][player.myGetYY()].setIcon(new ImageIcon(picture));
	}
	
	public boolean verifyOutBoard(int x, int y, Entity entity){
		try{
			gameBoard.getValue(entity.myGetXX()+x, entity.myGetYY()+y);
			return true;
		}catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if(verifyOutBoard(0, -1, player) && gameBoard.getValue(player.myGetXX(), player.myGetYY()-1) == 0
						|| gameBoard.getValue(player.myGetXX(), player.myGetYY()-1) == 4)
					setMario(0, -1);
				else if(verifyOutBoard(0, -1, player) && (gameBoard.getValue(player.myGetXX(), player.myGetYY()-1) == 2
						|| gameBoard.getValue(player.myGetXX(), player.myGetYY()-1) == 3)
						&& (gameBoard.getValue(player.myGetXX(), player.myGetYY()-2) == 0
						|| gameBoard.getValue(player.myGetXX(), player.myGetYY()-2) == 4)){
					setCaisse(0, -1, 0, -2);
					setMario(0, -1);
				}
				setMarioPicture("mariodos.gif");
				break;
			case KeyEvent.VK_DOWN:
				if(verifyOutBoard(0, 1, player) && (gameBoard.getValue(player.myGetXX(), player.myGetYY()+1) == 0
						|| gameBoard.getValue(player.myGetXX(), player.myGetYY()+1) == 4))
					setMario(0, 1);
				else if(verifyOutBoard(0, 1, player) && (gameBoard.getValue(player.myGetXX(), player.myGetYY()+1) == 2
						|| gameBoard.getValue(player.myGetXX(), player.myGetYY()+1) == 3)
						&& (gameBoard.getValue(player.myGetXX(), player.myGetYY()+2) == 0
						|| gameBoard.getValue(player.myGetXX(), player.myGetYY()+2) == 4)){
					setCaisse(0, 1, 0, 2);
					setMario(0, 1);
				}
				setMarioPicture("marioface.gif");
						
						break;
			case KeyEvent.VK_LEFT:
				if(verifyOutBoard(-1, 0, player) && (gameBoard.getValue(player.myGetXX()-1, player.myGetYY()) == 0
						|| gameBoard.getValue(player.myGetXX()-1, player.myGetYY()) == 4)){
					setMario(-1, 0);
				}else if(verifyOutBoard(-1, 0, player) && (gameBoard.getValue(player.myGetXX()-1, player.myGetYY()) == 2
						|| gameBoard.getValue(player.myGetXX()-1, player.myGetYY()) == 3)
						&& (gameBoard.getValue(player.myGetXX()-2, player.myGetYY()) == 0
						|| gameBoard.getValue(player.myGetXX()-2, player.myGetYY()) == 4)){
					setCaisse(-1, 0, -2, 0);
					setMario(-1, 0);
				}
				setMarioPicture("mariogauche.gif");
				
				break;
			case KeyEvent.VK_RIGHT:
				if(verifyOutBoard(1, 0, player) && (gameBoard.getValue(player.myGetXX()+1, player.myGetYY()) == 0 
						|| gameBoard.getValue(player.myGetXX()+1, player.myGetYY()) == 4)){
					setMario(1, 0);
				}else if(verifyOutBoard(1, 0, player) && (gameBoard.getValue(player.myGetXX()+1, player.myGetYY()) == 2
						|| gameBoard.getValue(player.myGetXX()+1, player.myGetYY()) == 3)
						&& (gameBoard.getValue(player.myGetXX()+2, player.myGetYY()) == 0
						|| gameBoard.getValue(player.myGetXX()+2, player.myGetYY()) == 4)){
					setCaisse(1, 0, 2, 0);
					setMario(1, 0);
				}			
				setMarioPicture("mariodroite.gif");
				
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
