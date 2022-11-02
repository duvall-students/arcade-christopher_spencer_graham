package levels;

import game_object.GameObject;
import game_object.Laser;
import game_object.Obstacle;
import game_object.Projectile;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import functionality.HighScore;
import game_object.Alien;
import game_object.Ball;
import game_object.Brick;
import game_object.Spaceship;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

//Graham Young

public abstract class GalagaLevel extends GameLevel {

	private static final String GALAGA_HIGH_SCORE_TXT = "GalagaHighScore.txt";
	private static final String GALAGA_CURRENT_SCORE_TXT = "GalagaCurrentScore.txt";
	private static final String GALAGA_TITLE = "GALAGA";

	protected static final String[] ALIEN_IMAGES = {"resources/galaga-enemy1.gif",
	                                                "resources/galaga-enemy2.gif",
	                                                "resources/galaga-enemy3.gif"};
	
	protected static final String SPACESHIP_IMAGE = "resources/galaga-ship.gif";

	protected final Point2D PLAYER_START_POS = new Point2D(screenSize.getX()/2, screenSize.getY()*.75);






	public GalagaLevel() {
		currentScoreText = createTextDisplay((15.5*screenSize.getX())/20, screenSize.getY()/20, TEXT_FONT, REGULAR_FONT_SIZE, "Score: " + HighScore.getCurrentScore(GALAGA_CURRENT_SCORE_TXT), TEXT_COLOR, root);
		highScoreText = createTextDisplay((17.5*screenSize.getX())/20, screenSize.getY()/20, TEXT_FONT, REGULAR_FONT_SIZE, "High Score: " + HighScore.getCurrentScore(GALAGA_HIGH_SCORE_TXT), TEXT_COLOR, root);
		gameTitleText = createTextDisplay((4*screenSize.getX())/10, screenSize.getY()/10, TEXT_FONT, GAME_TITLE_FONT_SIZE, GALAGA_TITLE, TEXT_COLOR, root);
		texts.add(currentScoreText);
		texts.add(highScoreText);
		texts.add(gameTitleText);
	}

	@Override
	public void createObstacles(Point2D screenSize, List<Point2D> positions) {
		for(Point2D pos : positions) {
			try {
				Alien newAlien = new Alien(ALIEN_IMAGES[getRandomInRange(0, ALIEN_IMAGES.length)], screenSize, pos);
				gameObjects.add(newAlien);
				movableTimes.add(newAlien);
				colliders.add(newAlien);
				obstacles.add(newAlien);
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
			gameObjects.add(newSpaceship);
			//movableKeyCodes.add(newSpaceship);
			colliders.add(newSpaceship);

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
			movableTimes.add(laser);
			colliders.add(laser);
			projectiles.add(laser);
		}

		myPlayer.move(code);


	}
	protected int getRandomInRange (int min, int max) {
		Random dice = new Random();
        return min + dice.nextInt(max - min);
    }
	
//	protected void endGame() {
//		
//		//newBall.pauseVelocity();
//		endGameText = createTextDisplay((0.25*screenSize.getX())/2, screenSize.getY()/2, TEXT_FONT, END_GAME_TITLE_FONT_SIZE, "GAME OVER", TEXT_COLOR, root);
//		texts.add(endGameText);
//		root.getChildren().add(endGameText);
//	}
	
	protected void setHighScore() {
		HighScore.setNewScore(playerScore, GALAGA_HIGH_SCORE_TXT);
	}

	public void setCurrentScore() {
		HighScore.setNewScore(playerScore, GALAGA_CURRENT_SCORE_TXT);
	}
	
	protected void resetCurrentScore() {
		HighScore.setNewScore(PLAYER_STARTING_SCORE, GALAGA_CURRENT_SCORE_TXT);
	}
	
	//@Override
//	protected void checkForCollisions(Collection<Obstacle> obstacles, Collection<Projectile> projectiles) {
//		for(Obstacle o : obstacles) {
//			//check if the obstacles collide with projectiles
//			for(Projectile p : projectiles) {
//				if (p.collide(o)) {
//					playerScore += o.getScoreValue();
//					removeFromAllLists(o);
//					root.getChildren().remove(p.getView());
//					removeFromAllLists(p);	
//					root.getChildren().remove(o.getView());
//					scoreText.setText("Score: " + playerScore);
//				}
//			}
//			//check if obstacles collide with player
//			if(myPlayer.collide(o)) {
//				removeFromAllLists(o);
//				root.getChildren().remove(o.getView());
//				updateLivesText();
//
//				if(!myPlayer.isAlive()) {
//					//endGame
//
//				}
//			}
//		}
//	}


}
