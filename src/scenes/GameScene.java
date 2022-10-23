package scenes;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import game_object.GameObject;
import game_object.Collider;
import game_object.MoveableKeyCode;
import game_object.MoveableTime;
import game_object.Player;

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

public abstract class GameScene extends Application {

	private GraphicsDevice gd[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
	private int screenHeight;
	private int screenWidth;
	private static final Paint BACKGROUND = Color.BLACK;
	private Scene myScene;
	private Timeline animation = new Timeline();
	private static final int FRAMES_PER_SECOND = 60;
	private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	private static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	private Group root = new Group();
	private Collection<Text> texts;
	private Collection<GameObject> gameObjects;
	private Collection<Collider> colliders;
	private Collection<MoveableTime> moveableTimes;
	private Collection<MoveableKeyCode> moveableKeyCodes;
	private Player myPlayer;
	private static final int PLAYER_MOVE_SPEED = 20;
	private static final KeyCode PLAYER_MOVE_LEFT = KeyCode.LEFT;
	private static final KeyCode PLAYER_MOVE_RIGHT = KeyCode.RIGHT;
	
	public GameScene() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void start (Stage stage) {
		// attach scene to the stage and display it
		screenWidth = gd[0].getDisplayMode().getWidth();
		screenHeight = gd[0].getDisplayMode().getHeight();
		myScene = setupGame(screenWidth, screenHeight, BACKGROUND);
		stage.setScene(myScene);
		stage.show();
		// attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	protected Scene setupGame (int width, int height, Paint background) {
		//setUpLevel();
		root.getChildren().add(myPlayer.getView()); 
		Scene scene = new Scene(root, width, height, background);
		return scene;
	}
	
	protected void setupLevel(int width, int height) {
		
	}
	
	protected void step (double elapsedTime) {
		myPlayer.move(PLAYER_MOVE_LEFT, PLAYER_MOVE_SPEED);
		myPlayer.move(PLAYER_MOVE_RIGHT, PLAYER_MOVE_SPEED);
	}
	
	private void createDisplay(double xPosition, double yPosition, Font textFont, String textToDisplay, Color colorOfText, Group gameSceneImages) {
		Text newDisplay = new Text();
		newDisplay.setFont(textFont);
		newDisplay.setX(xPosition);
		newDisplay.setY(yPosition);
		newDisplay.setText(textToDisplay);
		newDisplay.setStroke(colorOfText);
		gameSceneImages.getChildren().add(newDisplay);
		texts.add(newDisplay);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
