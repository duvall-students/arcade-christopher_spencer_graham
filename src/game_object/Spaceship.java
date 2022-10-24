package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class Spaceship extends Player {

	public static final int SPACESHIP_MOVE_SPEED = 50;
	
	
	public Spaceship(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean collide(GameObject other) {
		boolean check = this.isIntersecting(other);
		if (check) {
			if (this.removeALife()) {
				resetPosition();
			}
			
		}
		return check;
	}

	@Override
	public void move(KeyCode keyCode, int moveSpeed) {
		super.move(keyCode, moveSpeed);
	}
	
	public void move(KeyCode keyCode) {
		move(keyCode, SPACESHIP_MOVE_SPEED);
	}
	
	
}
