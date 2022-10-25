package scenes;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import game_object.GameObject;
import game_object.Movable;
import game_object.Collider;
import game_object.MovableKeyCode;
import game_object.MovableTime;
import game_object.Obstacle;
import game_object.Player;
import game_object.Projectile;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import levels.GameLevel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//Graham Young

public abstract class GameScene extends Application {

	protected GraphicsDevice gd[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();

	protected Point2D screenSize = new Point2D(gd[0].getDisplayMode().getWidth(), gd[0].getDisplayMode().getHeight());

	protected static final Paint BACKGROUND = Color.BLACK;
	protected Scene myScene;
	protected Timeline animation = new Timeline();
	protected static final int FRAMES_PER_SECOND = 60;
	protected static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	protected static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;



	protected static final KeyCode PLAYER_MOVE_LEFT = KeyCode.LEFT;
	protected static final KeyCode PLAYER_MOVE_RIGHT = KeyCode.RIGHT;
	protected static final int REGULAR_FONT_SIZE = 20;
	protected static final int GAME_TITLE_FONT_SIZE = 75;
	protected static final int END_GAME_TITLE_FONT_SIZE = 20;
	protected static final String TEXT_FONT = "Arial";
	protected static final Color TEXT_COLOR = Color.WHITE;
	protected static final int PLAYER_STARTING_SCORE = 0;

	
	protected Group root = new Group();
	protected Collection<Text> texts;
	protected Collection<GameObject> gameObjects;
	protected Collection<Collider> colliders;
	protected Collection<Movable> movables;
	protected Player myPlayer;

	protected int playerLives = 3;
	
	@Override
	public void start (Stage stage) {
		// attach scene to the stage and display it

		double screenWidth = screenSize.getX();
		double screenHeight = screenSize.getY();

		myScene = setupGame(screenWidth, screenHeight, BACKGROUND);
		stage.setScene(myScene);
		stage.show();
		//texts = new Collection<Text>();
		createTextDisplay((15.5*screenWidth)/20, screenHeight/20, TEXT_FONT, REGULAR_FONT_SIZE, "Score: " + PLAYER_STARTING_SCORE, TEXT_COLOR, root);
		createTextDisplay((17.5*screenWidth)/20, screenHeight/20, TEXT_FONT, REGULAR_FONT_SIZE, "High Score: 0", TEXT_COLOR, root);
		createTextDisplay((0.2*screenWidth)/20, screenHeight/20, TEXT_FONT, REGULAR_FONT_SIZE, "Lives: " + playerLives, TEXT_COLOR, root);
		createDisplays();
		// attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	

	protected Scene setupGame (double width, double height, Paint background) {
		gameObjects = new ArrayList<GameObject>();
		colliders = new ArrayList<Collider>();
		movables = new ArrayList<Movable>();

		
		GameLevel level = setupLevel();
		
		
		
		addObjectsToCollectionsFromLevel(level.getPlayers());
		addObjectsToCollectionsFromLevel(level.getObstacles());
		addObjectsToCollectionsFromLevel(level.getProjectiles());
		

		//setUpLevel();
		//createLevel();
		//createPlayer();
		//createProjectiles();
		//root.getChildren().add(myPlayer.getView()); 
		Scene scene = new Scene(root, width, height, background);

		return scene;
	}
	
	
	
	private void addObjectsToCollectionsFromLevel(List<? extends GameObject> list) {
		
		for(int i = 0; i <= list.size(); i++) {
			GameObject t = list.get(i);
			gameObjects.add(t);
			colliders.add(t);
			try {
				movables.add((Movable)t);
			}
			catch (ClassCastException e) {
				e.printStackTrace();
			}
			
			root.getChildren().add(t.getView());
		}
	}
	

	protected abstract void createDisplays();
	
	protected void setupLevel(int width, int height) {
		
	}
	
	protected void step (double elapsedTime) {
		//myPlayer.move(PLAYER_MOVE_LEFT, PLAYER_MOVE_SPEED);
		//myPlayer.move(PLAYER_MOVE_RIGHT, PLAYER_MOVE_SPEED);
	}

	protected abstract void handleKeyInput(KeyCode keyCode);

	

	protected void createTextDisplay(double xPosition, double yPosition, String textFont, int textSize, String textToDisplay, Color colorOfText, Group gameSceneImages) {
		Text newDisplay = new Text();
		newDisplay.setFont(new Font(textFont, textSize));
		newDisplay.setX(xPosition);
		newDisplay.setY(yPosition);
		newDisplay.setText(textToDisplay);
		newDisplay.setStroke(colorOfText);
		gameSceneImages.getChildren().add(newDisplay);
		//texts.add(newDisplay);
	}
	
//	public static void main(String[] args) {
//		launch(args);
//	}

}