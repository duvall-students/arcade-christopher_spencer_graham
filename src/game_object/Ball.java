package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
//Written by Graham Young


public class Ball extends Projectile implements MovableTime{

	
	protected static final int MOVE_SPEED = 200;

	
	public Ball(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		
		super.myVelocity = new Point2D(MOVE_SPEED, -MOVE_SPEED);
		
	}
	



	@Override
	public void move(double elapsedTime) {

        myView.setX(myView.getX() + myVelocity.getX() * elapsedTime);
        myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
		}



    
	
}