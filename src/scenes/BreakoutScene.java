package Map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Entities.Ball;
import Entities.Player;
import Settings.GameRules;
import Settings.HighScore;
import Settings.Sound;
import Settings.Images;
import Settings.Display;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.MediaPlayer;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

// Name: Christopher Boyette

public class BreakoutScene extends GameScene {
	// some things we need to remember during our game
	private static final String PONG_SOUND = "resources/pong_beep.wav"; 
	private Scene myScene;
	private Ball myBouncers;
	private Player myPaddle;
	private List<Brick> myBricks;
	Group root = new Group();
	Powerup powerup = new Powerup();
	private int totalScore = 0;
	GameRules gamerule = new GameRules();
	HighScore highscore = new HighScore();
	Display display = new Display();
	Sound sound = new Sound();
	Timeline animation = new Timeline();
	Images image = new Images();
	ArrayList<Integer> specialBricks;
	private GraphicsDevice gd[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
	private int screenHeight;
	private int screenWidth;
	private int levelsCompleted = 0;
	private int currentLevel = 1;
	private MediaPlayer pongSound;

	/**
	 * Initialize what will be displayed and how it will be updated.
	 */
	@Override
	public void start (Stage stage) {
		// attach scene to the stage and display it
		gamerule.setScreenSize(gd);
		screenHeight = gamerule.getScreenHeight();
		screenWidth = gamerule.getScreenWidth();
		myScene = setupGame(screenWidth, screenHeight, gamerule.backgroundColor());
		stage.setScene(myScene);
		stage.show();
		// attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
		KeyFrame frame = new KeyFrame(Duration.millis(gamerule.millisecondDelay()), e -> step(gamerule.secondDelay()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}

	// Create the game's "scene": what shapes will be in the game and their starting properties
	private Scene setupGame (int width, int height, Paint background) {
		// create one top level collection to organize the things in the scene
		// make some shapes and set their properties
		setupLevel(width, height);
		display.createCurrentScoreDisplay(width, height, root);
		display.createHighScoreDisplay(width, height, root);
		display.createGameTitle(width, height, root);
		display.createLivesDisplay(width, height, root);
		display.createCurrentLevelsDisplay(width, height, root);
		createPlayer(width, height);
		Scene scene = new Scene(root, width, height, background);
		scene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
		sound.createSound(PONG_SOUND);
		pongSound = sound.getPongSound();
		return scene;
	}

	private void setupLevel(int width, int height) {
		// create one top level collection to organize the things in the scene
		// make some shapes and set their properties
		if (levelsCompleted >= 1) {
			myBricks.clear();
			specialBricks.clear();
		}
		int doubleBrick = setRandomBrick(gamerule.numberOfBricks());
		int obstacleBrick = setRandomBrick(gamerule.numberOfBricks());
		if (doubleBrick == obstacleBrick) {
			obstacleBrick = setRandomBrick(gamerule.numberOfBricks());
		}
		createLevel(width, height, doubleBrick, obstacleBrick);
		createBall(width, height, image.getBallImage());
	}

	// Change properties of shapes in small ways to animate them over time

	private void step (double elapsedTime) {
		myBouncers.move(elapsedTime);
		myBouncers.bounce(myScene.getWidth(), myScene.getHeight());
		playerHitsPaddle();
		ArrayList<Brick> destroyBricks = new ArrayList<Brick>();
		destroyBricks = playerHitsBrick(destroyBricks);
		removeBricksView (destroyBricks, specialBricks);
		display.getTextScore().setText("Score: " + totalScore);
		endGame();
		if (myBouncers.getImageView().getY() > screenHeight) {
			playerMinuslive();
			resetPositions();
		}
	}

	private void endGame() {
		int lives = gamerule.getPlayerlives();
		if(lives == 0 || levelsCompleted == gamerule.getNumberOfLevels()) {
			endGameSteps(lives);
		}
		else if (myBricks.size() == 1) {
			levelsCompleted++;
			currentLevel++;
			if (levelsCompleted == gamerule.getNumberOfLevels()) {
				endGameSteps(lives);
			}
			else {
				root.getChildren().remove(myBouncers.getView());
				root.getChildren().remove((myBricks.get(myBricks.size()-1).getView()));
				myPaddle.setPlayerPosition(screenWidth, screenHeight);
				setupLevel(screenWidth, screenHeight);
				display.getTextLevels().setText("Level: " + currentLevel);
			}
		}
		else {
		}
	}

	private void endGameSteps(int lives) {
		if (totalScore > highscore.getCurrentHighScore()) {
			highscore.setNewHighScore(totalScore);
		}
		root.getChildren().remove(myBouncers.getView());
		root.getChildren().remove(myPaddle.getView());
		root.getChildren().remove((myBricks.get(myBricks.size()-1).getView()));
		animation.stop();
		if (lives > 0) {
			display.createWinGameDisplay(screenWidth, screenHeight, root);
		}
		else {
			display.createEndGameDisplay(screenWidth, screenHeight, root);
		}
	}

	// What to do each time a key is pressed
	private void handleKeyInput (KeyCode code) {
		double paddleSpeed = screenWidth/20;
		if (code == KeyCode.RIGHT && myPaddle.getXPosition() < (19*screenWidth)/20) {
			myPaddle.getImageView().setX(myPaddle.getXPosition() + paddleSpeed);
		}
		else if (code == KeyCode.LEFT && myPaddle.getXPosition() > 0) {
			myPaddle.getImageView().setX(myPaddle.getXPosition() - paddleSpeed);
		}
	}

	// Sub class of general entities, Player Class
	private void createPlayer(int width, int height) {
		try {
			Image paddleImage = new Image(new FileInputStream(image.getPlayerImage()));
			Player p = new Player(paddleImage, width, height);
			myPaddle = p;
			root.getChildren().add(p.getView());
		}
		catch (FileNotFoundException e) {
		}   
	}

	// Sub class of general entities, Ball Class
	private void createBall(int width, int height, String userImage) {
		try {
			Image ballImage = new Image(new FileInputStream(userImage));
			Ball b = new Ball(ballImage, width, height);
			myBouncers = b;
			root.getChildren().add(b.getView());
		}
		catch (FileNotFoundException e) {
		}
	}

	private void createLevel(int width, int height, int doubleBrick, int obstacleBrick) {
		myBricks = new ArrayList<>();
		specialBricks = new ArrayList<>();
		try {
			for (int i = 0; i < gamerule.numberOfBricks(); i++) {
				int typeOfBrick = i%9+1;
				Image image2 = new Image(new FileInputStream("resources/brick" + Integer.toString(typeOfBrick) + ".gif"));
				int rowNumber = getRandomInRange(gamerule.lowerNumberOfRows(), gamerule.upperNumberOfRows());
				int columnNumber = getRandomInRange(gamerule.lowerNumberOfColumns(), gamerule.upperNumberOfColumns());
				Brick br = new Brick(image2, width, height, rowNumber, columnNumber);
				myBricks.add(br);
				if (i == obstacleBrick) {
					specialBricks.add(2);
					br.setScore(0);
				}
				else if (i == doubleBrick){
					specialBricks.add(1);
					br.setScore(typeOfBrick);
				}
				else {
					specialBricks.add(0);
					br.setScore(typeOfBrick);
				}
				root.getChildren().add(br.getView());
			}
		}
		catch (FileNotFoundException e) {
		}
	}

	// Maybe some type of Scene class
	// Player Class
	public void playerMinuslive() {
		gamerule.setPlayerlives(gamerule.getPlayerlives()-1);
		display.getTextLives().setText("Player lives: " + gamerule.getPlayerlives());
	}

	public void resetPositions() {
		myBouncers.setBouncerPosition(screenWidth, screenHeight);
		myPaddle.setPlayerPosition(screenWidth, screenHeight);
		myBouncers.resetBallVelocity();
	}

	//Scene Class
	public int getScreenWidth() {
		return screenWidth;
	}
	//Scene Class
	public int getScreenHeight() {
		return screenHeight;
	}

	public void playerHitsPaddle() {
		if (myBouncers.getView().getBoundsInParent().intersects(myPaddle.getView().getBoundsInParent())) {
			myBouncers.bouncePaddle();
			pongSound.play();
			pongSound.seek(Duration.ZERO);
		}
	}

	public ArrayList<Brick> playerHitsBrick(ArrayList<Brick> destroyBricks) {
		for (Brick br : myBricks) {
			if (myBouncers.getView().getBoundsInParent().intersects(br.getView().getBoundsInParent())) {       
				int indexBrick = myBricks.indexOf(br);
				if (specialBricks.get(indexBrick) == 1) {
					powerup.setDoublePointsBricks(myBricks);
					root.getChildren().remove(myBouncers.getView());
					createBall(screenWidth, screenHeight, image.getDoublePointsImage());
					totalScore = totalScore + br.getScore();
					destroyBricks.add(br);
					myPaddle.setPlayerPosition(screenWidth, screenHeight);
				}
				else if (specialBricks.get(indexBrick) == 2) {
					myBouncers.bounceBrick();
					totalScore = totalScore + br.getScore();
				}
				else {
					myBouncers.bounceBrick();
					totalScore = totalScore + br.getScore();
					destroyBricks.add(br);
				}
			}
		}
		return destroyBricks;
	}

	public void removeBricksView (ArrayList<Brick> destroyBricks, ArrayList<Integer> doubleBricks) {
		if (destroyBricks.size() > 0) {
			root.getChildren().remove((destroyBricks.get(destroyBricks.size()-1)).getView());
			myBricks.remove(destroyBricks.get(destroyBricks.size()-1)); 
			doubleBricks.remove(doubleBricks.get(doubleBricks.size()-1));
		}
	}
	
	public void setScreenSize(GraphicsDevice gd[]) {
		screenWidth = gd[0].getDisplayMode().getWidth();
		screenHeight = gd[0].getDisplayMode().getHeight();
	}

	private int getRandomInRange (int min, int max) {
		return min + dice.nextInt(max - min) + 1;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
