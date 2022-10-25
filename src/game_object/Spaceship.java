package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Spaceship extends Player {

	public static final int SPACESHIP_MOVE_SPEED = 50;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	
	public Spaceship(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/WIDTH, screenSize.getY()/HEIGHT, pos);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean collide(GameObject other) {
		boolean check = this.isIntersecting(other);
		if (check) {
			//remove a life and if there are still lives remaining reset
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
	
	public Laser shoot(KeyCode keyCode, Point2D screenSize) {
		Laser laser = null;
		if (keyCode == KeyCode.UP) {
			try {
				laser = new Laser(screenSize, new Point2D(myView.getX(), myView.getY()+1));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return laser;
	}

	
	
}
