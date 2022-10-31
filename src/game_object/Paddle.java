package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;


//Written by Graham Young
public class Paddle extends Player {
	
	public static final int PADDLE_MOVE_SPEED = 50;

	
	public Paddle(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/WIDTH, screenSize.getY()/HEIGHT, pos);
		
	}

	@Override
	public void move(KeyCode keyCode, int moveSpeed) {
		super.move(keyCode, moveSpeed);
	}
	
	public void move(KeyCode keyCode) {
		move(keyCode, PADDLE_MOVE_SPEED);
	}
	

}
