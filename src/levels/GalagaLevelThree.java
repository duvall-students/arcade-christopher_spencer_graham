package levels;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

public class GalagaLevelThree extends GalagaLevel {


	public GalagaLevelThree() {
		super();
		createPlayer(screenSize, PLAYER_START_POS);
		
		List<Point2D> alienPositions = new ArrayList<>();
		
		createObstacles(screenSize, alienPositions);
		myScene = setupLevelScene();
	}
}
