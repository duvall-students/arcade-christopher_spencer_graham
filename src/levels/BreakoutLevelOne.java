package levels;

import javafx.scene.input.KeyCode;
import javafx.geometry.Point2D;

public class BreakoutLevelOne extends BreakoutLevel {

	public BreakoutLevelOne() {
		super();
		createLevelOneObjectPositions();
	}

	@Override
	protected void handleKeyInput(KeyCode code) {
		// TODO Auto-generated method stub
		
	}
	
	private void createLevelOneObjectPositions() {
		for (double i = screenSize.getX()/20; i < (19*screenSize.getX())/20; i = i + screenSize.getX()/10) {
			for (double j = (2*screenSize.getY())/10; j < (7*screenSize.getY())/10; j = j + screenSize.getY()/10) {
				Point2D obstaclePosition = new Point2D(i,j);
				obstaclePositions.add(obstaclePosition);
			}
		}
	}

}
