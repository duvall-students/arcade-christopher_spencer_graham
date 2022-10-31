package levels;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

import javafx.geometry.Point2D;

public class BreakoutLevelThree extends BreakoutLevel {

	protected final Point2D PLAYER_START_POS = new Point2D(screenSize.getX()/2, screenSize.getY()*.9);

	public BreakoutLevelThree() {
		super();
		createPlayer(screenSize, PLAYER_START_POS);
		createObstacles(screenSize, createObstaclePositions());
		createProjectiles(screenSize, createProjectilePositions());
		myScene = setupLevelScene();
	}
	
	private ArrayList<Point2D> createObstaclePositions() {
		ArrayList<Point2D> obstaclePositions = new ArrayList<Point2D>();
		for (double i = screenSize.getX()/20; i < (19*screenSize.getX())/20; i = i + screenSize.getX()/20) {
				if (i < (5.5*screenSize.getX())/20) {
					Point2D obstaclePosition1 = new Point2D(i,(2*screenSize.getY())/10);
					Point2D obstaclePosition2 = new Point2D(i,(7*screenSize.getY())/10);
					obstaclePositions.add(obstaclePosition1);
					obstaclePositions.add(obstaclePosition2);
				}
				if ((i >= (5.5*screenSize.getX())/20) && (i < (10*screenSize.getX())/20)) {
					Point2D obstaclePosition1 = new Point2D(i,(4*screenSize.getY())/10);
					Point2D obstaclePosition2 = new Point2D(i,(5*screenSize.getY())/10);
					obstaclePositions.add(obstaclePosition1);
					obstaclePositions.add(obstaclePosition2);
				}
				if ((i >= (10*screenSize.getX())/20) && (i < (14.5*screenSize.getX())/20)) {
					Point2D obstaclePosition1 = new Point2D(i,(5*screenSize.getY())/10);
					Point2D obstaclePosition2 = new Point2D(i,(4*screenSize.getY())/10);
					obstaclePositions.add(obstaclePosition1);
					obstaclePositions.add(obstaclePosition2);
				}
				if ((i >= (14.5*screenSize.getX())/20) && (i < (19*screenSize.getX())/20)) {
					Point2D obstaclePosition1 = new Point2D(i,(2*screenSize.getY())/10);
					Point2D obstaclePosition2 = new Point2D(i,(7*screenSize.getY())/10);
					obstaclePositions.add(obstaclePosition1);
					obstaclePositions.add(obstaclePosition2);
				}
		}
		return obstaclePositions;
	}
	
	private ArrayList<Point2D> createProjectilePositions() {
		Point2D ballPosition = new Point2D(screenSize.getX()/2,(8*screenSize.getY())/10);
		ArrayList<Point2D> ballPositions = new ArrayList<Point2D>();
		ballPositions.add(ballPosition);
		return ballPositions;
	}

}
