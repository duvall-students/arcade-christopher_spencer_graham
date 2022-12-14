package levels;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import game_object.Brick;
import game_object.Laser;
import game_object.Obstacle;
import game_object.Paddle;
import game_object.Projectile;
import game_object.Alien;
import game_object.Ball;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import functionality.HighScore;

public abstract class BreakoutLevel extends GameLevel {

	protected static final String LEVEL_ONE_BRICK_IMAGE_PATH = "resources/brick1.gif";
	protected static final String LEVEL_TWO_BRICK_IMAGE_PATH = "resources/brick2.gif";
	protected static final String LEVEL_THREE_BRICK_IMAGE_PATH = "resources/brick3.gif";
	private static final String DEFAULT_BALL_IMAGE = "resources/ball.gif";
	private static final String DEFAULT_PLAYER_IMAGE = "resources/paddle.gif";
	private static final String BREAKOUT_TITLE = "BREAKOUT";
	private static final String BREAKOUT_HIGH_SCORE_TXT = "BreakoutHighScore.txt";
	private static final String BREAKOUT_CURRENT_SCORE_TXT = "BreakoutCurrentScore.txt";
	
	private Ball newBall;
	
	protected static final String[] BRICK_IMAGES = {LEVEL_ONE_BRICK_IMAGE_PATH,
			LEVEL_TWO_BRICK_IMAGE_PATH,
			LEVEL_THREE_BRICK_IMAGE_PATH};

	//private HighScore highScore;

	public BreakoutLevel() {
		super();
		//createProjectilePositions();
		currentScoreText = createTextDisplay((15.5*screenSize.getX())/20, screenSize.getY()/20, TEXT_FONT, REGULAR_FONT_SIZE, "Score: " + HighScore.getCurrentScore(BREAKOUT_CURRENT_SCORE_TXT), TEXT_COLOR, root);
		highScoreText = createTextDisplay((17.5*screenSize.getX())/20, screenSize.getY()/20, TEXT_FONT, REGULAR_FONT_SIZE, "High Score: " + HighScore.getCurrentScore(BREAKOUT_HIGH_SCORE_TXT), TEXT_COLOR, root);
		gameTitleText = createTextDisplay((4*screenSize.getX())/10, screenSize.getY()/10, TEXT_FONT, GAME_TITLE_FONT_SIZE, BREAKOUT_TITLE, TEXT_COLOR, root);
		texts.add(currentScoreText);
		texts.add(highScoreText);
		texts.add(gameTitleText);
	}

	@Override
	public void createObstacles(Point2D screenSize, List<Point2D> positions) {
		for (Point2D pos : positions) {
			try {
				Brick newBrick = new Brick(BRICK_IMAGES[getRandomInRange(0, BRICK_IMAGES.length)], screenSize, pos);
				gameObjects.add(newBrick);
				obstacles.add(newBrick);
				//colliders.add(newBrick);
			}
			catch(FileNotFoundException e) {

			}
		}
	}

	@Override
	public void createProjectiles(Point2D screenSize, List<Point2D> positions) {
		for (Point2D pos : positions) {	
			try {
				newBall = new Ball(DEFAULT_BALL_IMAGE, screenSize, pos);
				gameObjects.add(newBall);
				movableTimes.add(newBall);
				projectiles.add(newBall);
			}
			catch(FileNotFoundException e) {	
			}
		}

	}

	@Override
	public void createPlayer(Point2D screenSize, Point2D position) {
		try {
			myPlayer = new Paddle(DEFAULT_PLAYER_IMAGE, screenSize, position);
			gameObjects.add(myPlayer);
			//colliders.add(myPlayer);
		}
		catch(FileNotFoundException e) {

		}

	}

	@Override
	protected void handleKeyInput(KeyCode code) {
		myPlayer.move(code);
	}
	
//	protected void endGame() {
//		HighScore.setNewHighScore(playerScore, BREAKOUT_HIGH_SCORE_FILE_NAME);
//		newBall.pauseVelocity();
//		endGameText = createTextDisplay((0.25*screenSize.getX())/2, screenSize.getY()/2, TEXT_FONT, END_GAME_TITLE_FONT_SIZE, "GAME OVER", TEXT_COLOR, root);
//		texts.add(endGameText);
//		root.getChildren().add(endGameText);
//	}
	
	protected void setHighScore() {
		int currentHighScore = HighScore.getCurrentScore(BREAKOUT_HIGH_SCORE_TXT);
		if (playerScore > currentHighScore) {
			HighScore.setNewScore(playerScore, BREAKOUT_HIGH_SCORE_TXT);
		}
	}
	
	public void setCurrentScore() {
		HighScore.setNewScore(playerScore, BREAKOUT_CURRENT_SCORE_TXT);
	}
	
	protected void resetCurrentScore() {
		HighScore.setNewScore(PLAYER_STARTING_SCORE, BREAKOUT_CURRENT_SCORE_TXT);
	}
	
//	@Override
//	protected void checkForCollisions(Collection<Obstacle> obstacles, Collection<Projectile> projectiles) {
//		obstacleloop:
//			for(Obstacle o : obstacles) {
//				//check if the obstacles collide with projectiles
//				for(Projectile p : projectiles) {
//					if (p.collide(o)) {
//						playerScore += o.getScoreValue();
//						removeFromAllLists(o);
//						root.getChildren().remove(o.getView());
//						scoreText.setText("Score: " + playerScore);
//					}
//					if(p.collide(myPlayer) && p instanceof Ball) {
//						break obstacleloop;
//						//p.collide(myPlayer);
//					}
//				}
//			}
//	}

}
