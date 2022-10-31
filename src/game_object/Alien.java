package game_object;

import java.io.FileNotFoundException;

import game_object.MovableTime;
import javafx.geometry.Point2D;

public class Alien extends Obstacle implements MovableTime{

	private Point2D myVelocity;
	protected static final int ALIEN_MOVE_SPEED = 20;

	public Alien(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/50, screenSize.getY()/50, pos);
		// TODO Auto-generated constructor stub
		myVelocity = new Point2D(0, ALIEN_MOVE_SPEED);
		myScoreValue = getRandomInRange(MIN_SCORE_VALUE, MAX_SCORE_VALUE);

	}

	@Override
	public void move(Double elapsedTime) {

		myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
	}
	

}
