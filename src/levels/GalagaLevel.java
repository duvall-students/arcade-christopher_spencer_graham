package levels;

import game_object.GameObject;
import game_object.Laser;
import game_object.Projectile;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import game_object.Alien;
import game_object.Brick;
import game_object.Spaceship;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public abstract class GalagaLevel extends GameLevel {
	
	protected static final String DEFAULT_ALIEN_IMAGE = "resouces/galaga-enemy1.gif";
	protected static final String SPACESHIP_IMAGE = "resources/galaga-ship.png";

	
	
	
	
	
	
	public GalagaLevel() {
		
	}

	@Override
	public void createObstacles(Point2D screenSize, List<Point2D> positions) {
		for(Point2D pos : positions) {
			try {
				Alien newAlien = new Alien(DEFAULT_ALIEN_IMAGE, screenSize, pos);
				gameObjects.add(newAlien);
				movableTimes.add(newAlien);
				colliders.add(newAlien);
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
		
		Laser laser = ((Spaceship) myPlayer).shoot(code, screenSize);
		if(laser != null) {
			root.getChildren().add(laser.getView());
			myScene.setRoot(root);
		}
		
		myPlayer.move(code);
		
		
	}

}
