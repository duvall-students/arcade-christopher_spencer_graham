package levels;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

import javafx.geometry.Point2D;

public class BreakoutLevelTwo extends BreakoutLevel {
	
	protected final Point2D PLAYER_START_POS = new Point2D(screenSize.getX()/2, screenSize.getY()*.9);

	public BreakoutLevelTwo() {
		super();
		createPlayer(screenSize, PLAYER_START_POS);
		createObstacles(screenSize, createObstaclePositions());
		createProjectiles(screenSize, createProjectilePositions());
		myScene = setupLevelScene();
	}
	
	private ArrayList<Point2D> createObstaclePositions() {
		ArrayList<Point2D> obstaclePositions = new ArrayList<Point2D>();
		for (double i = screenSize.getX()/20; i < (19*screenSize.getX())/20; i = i + screenSize.getX()/5) {
			for (double j = (2*screenSize.getY())/10; j < (7*screenSize.getY())/10; j = j + screenSize.getY()/20) {
				Point2D obstaclePosition = new Point2D(i,j);
				obstaclePositions.add(obstaclePosition);
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
