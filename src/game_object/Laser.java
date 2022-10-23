package game_object;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

// Spencer Buehlman

public class Laser extends Projectile {
	
	protected static final int LASER_MOVE_SPEED = 200;

	public Laser(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		super.myMoveSpeed = LASER_MOVE_SPEED;
		super.myVelocity = new Point2D(0, -LASER_MOVE_SPEED);
	}

	@Override
	public void move(double elapsedTime) {

		myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
	}
}

