package levels;

import java.io.FileNotFoundException;
import java.util.List;

import game_object.Alien;
import game_object.Brick;
import game_object.Spaceship;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public abstract class GalagaLevel extends GameLevel {
	
	protected static final String DEFAULT_ALIEN_IMAGE = "resouces/galaga-enemy1.gif";
	protected static final String SPACESHIP_IMAGE = "resources/galaga-ship.png";

	public GalagaLevel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createObstacles(Point2D screenSize, List<Point2D> positions) {
		for(Point2D pos : positions) {
			try {
				Alien newAlien = new Alien(DEFAULT_ALIEN_IMAGE, screenSize, pos);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void createProjectiles(Point2D screenSize, List<Point2D> positions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPlayer(Point2D screenSize, Point2D position) {
		
		try {
			Spaceship newSpaceship = new Spaceship(SPACESHIP_IMAGE, screenSize, position);
			myPlayer = newSpaceship;
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void handleKeyInput(KeyCode code) {
		// TODO Auto-generated method stub

	}

}
