package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;

// Spencer Buehlman
public class Projectile extends GameObject implements MoveableTime{
	
	protected Point2D myVelocity;
	protected int myMoveSpeed;
	
	public Projectile(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		super( imagePath, sizeWidth, sizeHeight, pos);
	}

	@Override
	public void move(double elapsedTime) {

        myView.setX(myView.getX() + myVelocity.getX() * elapsedTime);
        myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
		
	}
}