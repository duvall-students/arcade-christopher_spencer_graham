package levels;

import javafx.scene.input.KeyCode;
import javafx.geometry.Point2D;

public class BreakoutLevelThree extends BreakoutLevel {

	public BreakoutLevelThree() {
		super();
		createLevelThreeObjectPositions();
	}

	@Override
	protected void handleKeyInput(KeyCode code) {
		// TODO Auto-generated method stub
		
	}
	
	private void createLevelThreeObjectPositions() {
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
	}

}
