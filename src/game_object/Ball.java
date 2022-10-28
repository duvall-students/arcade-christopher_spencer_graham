package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
//Written by Graham Young

// Spencer Buehlman

public class Ball extends Projectile{

	protected static final int BALL_MOVE_SPEED = 200;
	protected Point2D screensize;
	
	public Ball(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/38, screenSize.getX()/38, pos);
		screensize = screenSize;
		myMoveSpeed = BALL_MOVE_SPEED;
		myVelocity = new Point2D(BALL_MOVE_SPEED, -BALL_MOVE_SPEED);

	}
	
	@Override
	public boolean collide(GameObject other) {
		boolean check = super.collide(other);
		if (check) {
			//remove a life and if there are still lives remaining reset
			myVelocity = new Point2D(myVelocity.getX(), -1*myVelocity.getY());
			//System.out.println(myVelocity);
		}
		return check;
	}

	@Override
	public void move(Double elapsedTime) {
		if (myView.getX() < 0 || myView.getX() > (screensize.getX() - myView.getBoundsInLocal().getWidth())) {
			myVelocity = new Point2D(-1*myVelocity.getX(), myVelocity.getY());
		}
		else if (myView.getY() < screensize.getY()/10) {
			myVelocity = new Point2D(myVelocity.getX(), -1*myVelocity.getY());
		}
		myView.setX(myView.getX() + myVelocity.getX() * elapsedTime);
		myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
	}

}