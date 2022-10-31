package game_object;

import java.io.FileNotFoundException;
import javafx.geometry.Point2D;

// Spencer Buehlman
public abstract class Projectile extends GameObject implements MovableTime{
	
	protected Point2D myVelocity;
	protected int myMoveSpeed;
	
	
	public Projectile(String imagePath, double sizeWidth, double sizeHeight, Point2D pos) throws FileNotFoundException {
		super( imagePath, sizeWidth, sizeHeight, pos);
	}

	@Override

	public void move(Double elapsedTime) {

        myView.setX(myView.getX() + myVelocity.getX() * elapsedTime);
        myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
		
	}
}