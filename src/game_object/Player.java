package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;


//Graham Young

public abstract class Player extends GameObject implements MovableKeyCode {
	
	public static final int DEFAULT_LIVES = 3;
	
	protected int myLives = DEFAULT_LIVES;
	protected Point2D startingPosition;

	public Player(String imagePath, double sizeWidth, double sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		startingPosition = pos;
	}
	
	public Player(String imagePath, double sizeWidth, double sizeHeight, Point2D pos, int lives) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		startingPosition = pos;
		myLives = lives;
	}

	@Override
	public void move(KeyCode keyCode, int moveSpeed) {
			
	        if (keyCode == KeyCode.LEFT ) {
	        	myView.setX(myView.getX() - moveSpeed);
	        }
	        else if (keyCode == KeyCode.RIGHT ) {
	        	myView.setX(myView.getX() + moveSpeed);
	        }

	}
	
	public void resetPosition() {
		myView.setX(startingPosition.getX());
		myView.setY(startingPosition.getY());
		

	}
	
	public void removeALife() {
		myLives--;
		
	}
	
	public int getLives() {
		return myLives;
	}

	public boolean isAlive() {
		return myLives > 0;

	}
	
	

}
