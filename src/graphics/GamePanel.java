package graphics;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import game.GameBoard;
import game.Coordonnees;

public class GamePanel extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private JLabel[][] label;
	private GameBoard gameBoard;
	private Game game;
	private Coordonnees coordPlayer;

	public GamePanel(Game game, int sizeOfX, int sizeOfY){
		this.setPreferredSize(new Dimension(sizeOfX, sizeOfY));
		this.addKeyListener(this);
		this.gameBoard = game.getGameBoard();
		this.game = game;
		this.label = new JLabel[gameBoard.getSizeOfX()][gameBoard.getSizeOfY()];
		this.coordPlayer = new Coordonnees();
		this.initLayout();
		this.loadPicture();
	}
	
	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public void initLayout(){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.setLayout(new GridBagLayout());
		for(int x = 0; x < gameBoard.getSizeOfX(); x++){
			for(int y = 0; y < gameBoard.getSizeOfY(); y++){
				label[x][y] = new JLabel();
				gbc.gridx = x;
				gbc.gridy = y;
				this.add(label[x][y], gbc);
			}
		}
	}
	
	public void loadPicture(){
		for(int x = 0; x < gameBoard.getSizeOfX(); x++){
			for(int y = 0; y < gameBoard.getSizeOfY(); y++){
				if(gameBoard.getValue(x, y) == 1)
					label[x][y].setIcon(new ImageIcon("mur.jpg"));
				else if(gameBoard.getValue(x, y) == 2){
					label[x][y].setIcon(new ImageIcon("caisse.jpg"));
				}else if(gameBoard.getValue(x, y) == 4){
					label[x][y].setIcon(new ImageIcon("objectif.png"));
				}else if(gameBoard.getValue(x, y) == 5){
					label[x][y].setIcon(new ImageIcon("marioface.gif"));
					coordPlayer.setCoordonnees(x, y);
				}else 
					label[x][y].setIcon(new ImageIcon(""));
			}
		}
	}
	
	public void setMario(int x, int y){
		if(gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()) == 4
				&& gameBoard.getValue(coordPlayer.myGetXX()+x, coordPlayer.myGetYY()+y) == 4){
			
			label[coordPlayer.myGetXX()][coordPlayer.myGetYY()].setIcon(new ImageIcon("objectif.png"));			
			coordPlayer.setCoordonnees(coordPlayer.myGetXX()+x, coordPlayer.myGetYY()+y);
			
		}else if (gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()) == 4){
			label[coordPlayer.myGetXX()][coordPlayer.myGetYY()].setIcon(new ImageIcon("objectif.png"));			
			coordPlayer.setCoordonnees(coordPlayer.myGetXX()+x, coordPlayer.myGetYY()+y);
			gameBoard.setValue(coordPlayer.myGetXX(), coordPlayer.myGetYY(), 5);
		}else if(gameBoard.getValue(coordPlayer.myGetXX()+x, coordPlayer.myGetYY()+y) == 4){	
			label[coordPlayer.myGetXX()][coordPlayer.myGetYY()].setIcon(new ImageIcon(""));
			gameBoard.setValue(coordPlayer.myGetXX(), coordPlayer.myGetYY(), 0);
			coordPlayer.setCoordonnees(coordPlayer.myGetXX()+x, coordPlayer.myGetYY()+y);
			
		}else{
			label[coordPlayer.myGetXX()][coordPlayer.myGetYY()].setIcon(new ImageIcon(""));
			gameBoard.setValue(coordPlayer.myGetXX(), coordPlayer.myGetYY(), 0);
			coordPlayer.setCoordonnees(coordPlayer.myGetXX()+x, coordPlayer.myGetYY()+y);
			gameBoard.setValue(coordPlayer.myGetXX(), coordPlayer.myGetYY(), 5);
		}		
	}
	
	public void setCaisse(int x, int y, int xx, int yy){
		label[coordPlayer.myGetXX()+x][coordPlayer.myGetYY()+y].setIcon(new ImageIcon(""));
		
		if(gameBoard.getValue(coordPlayer.myGetXX()+x, coordPlayer.myGetYY()+y) == 3){
				gameBoard.setValue(coordPlayer.myGetXX()+x, coordPlayer.myGetYY()+y, 4);
		}else
			gameBoard.setValue(coordPlayer.myGetXX()+x, coordPlayer.myGetYY()+y, 0);
		
		if(gameBoard.getValue(coordPlayer.myGetXX()+xx, coordPlayer.myGetYY()+yy) == 4){
			label[coordPlayer.myGetXX()+xx][coordPlayer.myGetYY()+yy].setIcon(new ImageIcon("caisseplace.jpg"));
			gameBoard.setValue(coordPlayer.myGetXX()+xx, coordPlayer.myGetYY()+yy, 3);
			
		}else{
			label[coordPlayer.myGetXX()+xx][coordPlayer.myGetYY()+yy].setIcon(new ImageIcon("caisse.jpg"));
			gameBoard.setValue(coordPlayer.myGetXX()+xx, coordPlayer.myGetYY()+yy, 2);
		}
	}
	
	public void setMarioPicture(String picture){
		label[coordPlayer.myGetXX()][coordPlayer.myGetYY()].setIcon(new ImageIcon(picture));
	}
	
	public boolean verifyOutBoard(int x, int y){
		try{
			gameBoard.getValue(coordPlayer.myGetXX()+x, coordPlayer.myGetYY()+y);
			return true;
		}catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if(verifyOutBoard(0, -1) && gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()-1) == 0
						|| gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()-1) == 4)
					setMario(0, -1);
				else if(verifyOutBoard(0, -1) && (gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()-1) == 2
						|| gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()-1) == 3)
						&& (gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()-2) == 0
						|| gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()-2) == 4)){
					setCaisse(0, -1, 0, -2);
					setMario(0, -1);
				}
				setMarioPicture("mariodos.gif");
				break;
			case KeyEvent.VK_DOWN:
				if(verifyOutBoard(0, 1) && (gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()+1) == 0
						|| gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()+1) == 4))
					setMario(0, 1);
				else if(verifyOutBoard(0, 1) && (gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()+1) == 2
						|| gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()+1) == 3)
						&& (gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()+2) == 0
						|| gameBoard.getValue(coordPlayer.myGetXX(), coordPlayer.myGetYY()+2) == 4)){
					setCaisse(0, 1, 0, 2);
					setMario(0, 1);
				}
				setMarioPicture("marioface.gif");
						
						break;
			case KeyEvent.VK_LEFT:
				if(verifyOutBoard(-1, 0) && (gameBoard.getValue(coordPlayer.myGetXX()-1, coordPlayer.myGetYY()) == 0
						|| gameBoard.getValue(coordPlayer.myGetXX()-1, coordPlayer.myGetYY()) == 4)){
					setMario(-1, 0);
				}else if(verifyOutBoard(-1, 0) && (gameBoard.getValue(coordPlayer.myGetXX()-1, coordPlayer.myGetYY()) == 2
						|| gameBoard.getValue(coordPlayer.myGetXX()-1, coordPlayer.myGetYY()) == 3)
						&& (gameBoard.getValue(coordPlayer.myGetXX()-2, coordPlayer.myGetYY()) == 0
						|| gameBoard.getValue(coordPlayer.myGetXX()-2, coordPlayer.myGetYY()) == 4)){
					setCaisse(-1, 0, -2, 0);
					setMario(-1, 0);
				}
				setMarioPicture("mariogauche.gif");
				
				break;
			case KeyEvent.VK_RIGHT:
				if(verifyOutBoard(1, 0) && (gameBoard.getValue(coordPlayer.myGetXX()+1, coordPlayer.myGetYY()) == 0 
						|| gameBoard.getValue(coordPlayer.myGetXX()+1, coordPlayer.myGetYY()) == 4)){
					setMario(1, 0);
				}else if(verifyOutBoard(1, 0) && (gameBoard.getValue(coordPlayer.myGetXX()+1, coordPlayer.myGetYY()) == 2
						|| gameBoard.getValue(coordPlayer.myGetXX()+1, coordPlayer.myGetYY()) == 3)
						&& (gameBoard.getValue(coordPlayer.myGetXX()+2, coordPlayer.myGetYY()) == 0
						|| gameBoard.getValue(coordPlayer.myGetXX()+2, coordPlayer.myGetYY()) == 4)){
					setCaisse(1, 0, 2, 0);
					setMario(1, 0);
				}			
				setMarioPicture("mariodroite.gif");
				
				break;
				
			case KeyEvent.VK_ALT:
				game.reload();
				
				break;
			case KeyEvent.VK_ENTER:
				game.getFenetre().setCurrentPanel(new SelectLvl(game.getFenetre()));
				
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
