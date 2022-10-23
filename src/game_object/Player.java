package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class Player extends GameObject implements MoveableKeyCode {

	public Player(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		// TODO Auto-generated constructor stub
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
}
