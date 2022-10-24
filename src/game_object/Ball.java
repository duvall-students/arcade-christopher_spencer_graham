package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
//Written by Graham Young

// Spencer Buehlman

public class Ball extends Projectile{


	protected static final int BALL_MOVE_SPEED = 200;


	public Ball(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		myMoveSpeed = BALL_MOVE_SPEED;
		myVelocity = new Point2D(BALL_MOVE_SPEED, -BALL_MOVE_SPEED);

	}




	@Override
	public void move(double elapsedTime) {

		myView.setX(myView.getX() + myVelocity.getX() * elapsedTime);
		myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);

	}



	
	

}