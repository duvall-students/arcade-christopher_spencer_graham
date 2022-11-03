package game_object;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

// Spencer Buehlman

public class Laser extends Projectile {
	
	protected static final String DEFAULT_LASER_IMAGE = "resources/galaga-laser.gif";
	
	protected static final int LASER_MOVE_SPEED = 200;


	public Laser(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/50, screenSize.getY()/50, pos);
		myMoveSpeed = LASER_MOVE_SPEED;
		myVelocity = new Point2D(0, -LASER_MOVE_SPEED);
	}

	public Laser(Point2D screenSize, Point2D pos) throws FileNotFoundException {
		this(DEFAULT_LASER_IMAGE, screenSize, pos);
		
	}
	

	@Override
	public void move(Double elapsedTime) {
		myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
	}

}

