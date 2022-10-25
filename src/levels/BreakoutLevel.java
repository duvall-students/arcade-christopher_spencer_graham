package levels;

import java.io.FileNotFoundException;
import java.util.List;

import game_object.Brick;
import javafx.geometry.Point2D;

public abstract class BreakoutLevel extends GameLevel {
	
	protected static final String DEFAULT_BRICK_IMAGE_PATH = "resources/brick1.gif";

	public BreakoutLevel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createObstacles(Point2D screenSize, List<Point2D> positions) {
		for( Point2D pos : positions) {
			try {
				Brick newBrick = new Brick(DEFAULT_BRICK_IMAGE_PATH, screenSize, pos);
			}
			catch(FileNotFoundException e) {
				
			}
		}
	}
	

	@Override
	public void createProjectiles(Point2D screenSize, List<Point2D> positions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPlayers(Point2D screenSize, List<Point2D> positions) {
		// TODO Auto-generated method stub

	}

}