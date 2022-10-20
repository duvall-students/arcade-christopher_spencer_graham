package game_objects;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
//Written by Graham Young


public class Ball extends Projectile implements MovableTime{

	
	protected static final int MOVE_SPEED = 200;

	
	public Ball(ImageView imageView) {
		super(imageView);
		
		super.myVelocity = new Point2D(MOVE_SPEED, -MOVE_SPEED);
		
	}
	
	/**
     * Bounce off the walls represented by the edges of the screen but not the bottom of the screen
     */
    public void bounceWalls (double screenWidth, double screenHeight) {
        // collide all bouncers against the walls
        if (myView.getX() < 0 || myView.getX() > screenWidth - myView.getBoundsInLocal().getWidth()) {
            myVelocity = new Point2D(-myVelocity.getX(), myVelocity.getY());
        }
        if (myView.getY() < 0 - myView.getBoundsInLocal().getHeight()) {
            myVelocity = new Point2D(myVelocity.getX(), -myVelocity.getY());
        }
    }
    
    public boolean hitsFloor(double screenHeight) {
    	return myView.getY() > screenHeight;
    }
    
    /*
     * bounce off of other game objects such as the paddle or the bricks
     */
    public boolean bounceGameObject(GameObject gameObject) {
    	if (this.isIntersecting(gameObject)) {
    		myVelocity = new Point2D(myVelocity.getX(), -myVelocity.getY());
    		if(gameObject.getBoundsYMax() == this.getBoundsYMax()) {
    			setPositition(myView.getX(), gameObject.getBoundsYMax() + 1);
    		}
    		if(gameObject.getBoundsYMin() == this.getBoundsYMin()) {
    			setPositition(myView.getX(), gameObject.getBoundsYMin() - 1);
    		}
    		return true;
    	}
    	return false;
    }
	


	@Override
	public void move(double elapsedTime) {

        myView.setX(myView.getX() + myVelocity.getX() * elapsedTime);
        myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
		}



    
	
}