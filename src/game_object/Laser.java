package game_object;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

// Spencer Buehlman

public class Laser extends Projectile {
	
	protected static final int LASER_MOVE_SPEED = 200;


	public Laser(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/10, screenSize.getY()/10, pos);
		myMoveSpeed = LASER_MOVE_SPEED;
		myVelocity = new Point2D(0, -LASER_MOVE_SPEED);
	}


	@Override
	public void move(Double elapsedTime) {
		myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
	}

}

