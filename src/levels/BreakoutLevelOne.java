package levels;

import javafx.scene.input.KeyCode;
import javafx.geometry.Point2D;
import java.util.ArrayList;

public class BreakoutLevelOne extends BreakoutLevel {
	
	protected final Point2D PLAYER_START_POS = new Point2D(screenSize.getX()/2, screenSize.getY()*.75);

	public BreakoutLevelOne() {
		super();
		createPlayer(screenSize, PLAYER_START_POS);
		createObstacles(screenSize, createObstaclePositions());
		createProjectiles(screenSize, createProjectilePositions());
		myScene = setupLevelScene();
	}

	@Override
	protected void handleKeyInput(KeyCode code) {
		// TODO Auto-generated method stub
		
	}
	
	private ArrayList<Point2D> createObstaclePositions() {
		ArrayList<Point2D> obstaclePositions = new ArrayList<Point2D>();
		for (double i = screenSize.getX()/20; i < (19*screenSize.getX())/20; i = i + screenSize.getX()/10) {
			for (double j = (2*screenSize.getY())/10; j < (7*screenSize.getY())/10; j = j + screenSize.getY()/10) {
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
