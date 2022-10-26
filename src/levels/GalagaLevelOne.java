package levels;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

public class GalagaLevelOne extends GalagaLevel {
	
	protected final int NUM_ALIEN_ROWS = 2;
	protected final int NUM_ALIEN_COLS = 10;
	protected final Point2D FIRST_ALIEN_POS = new Point2D(screenSize.getX()/NUM_ALIEN_COLS, screenSize.getY()/20);
	protected final Point2D ALIEN_OFFSET = new Point2D(screenSize.getX()/NUM_ALIEN_COLS, screenSize.getY()/20);
	protected final int numAliens = NUM_ALIEN_ROWS * NUM_ALIEN_COLS;
	protected final Point2D PLAYER_START_POS = new Point2D(screenSize.getX()/2, screenSize.getY()*.75);

	public GalagaLevelOne() {
		createPlayer(screenSize, PLAYER_START_POS);
		
		List<Point2D> alienPositions = new ArrayList<>();
		for(int i = 0; i <= numAliens; i++) {
			double newX = FIRST_ALIEN_POS.getX()+(ALIEN_OFFSET.getX()*(i%NUM_ALIEN_COLS));
			double newY = FIRST_ALIEN_POS.getY()+(ALIEN_OFFSET.getY()*(i%NUM_ALIEN_ROWS));
			Point2D newPoint = new Point2D(newX, newY);
			alienPositions.add(newPoint);
		}
		createObstacles(screenSize, alienPositions);
		
	}

}
