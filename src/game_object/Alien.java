package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;

public class Alien extends Obstacle implements MoveableTime{

	private Point2D myVelocity;
	protected static final int ALIEN_MOVE_SPEED = 20;

	public Alien(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/10, screenSize.getY()/10, pos);
		// TODO Auto-generated constructor stub
		myVelocity = new Point2D(0, 20);

	}

	@Override
	public void move(Double elapsedTime) {

		myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
	}
	

}
