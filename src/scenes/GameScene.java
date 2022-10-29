package scenes;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
import levels.BreakoutLevel;
import levels.GalagaLevelOne;
import levels.BreakoutLevelOne;
import levels.GameLevel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//Graham Young

public class GameScene extends Application {


	protected static final int FRAMES_PER_SECOND = 60;
	protected static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	protected static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;

	protected static final KeyCode PLAYER_MOVE_LEFT = KeyCode.LEFT;
	protected static final KeyCode PLAYER_MOVE_RIGHT = KeyCode.RIGHT;
	
	protected static final String LEVEL = "level";

	private HashMap<String, GameLevel> levels = new HashMap<>();
	protected GameLevel myCurrentLevel;
	
	
	@Override
	public void start (Stage stage) {
		// attach scene to the stage and display it
		
		myCurrentLevel = new GalagaLevelOne();
		
		//myCurrentLevel = new BreakoutLevelOne();

		//myCurrentLevel.setupLevelScene();

		stage.setScene(myCurrentLevel.getScene());
		stage.show();


		// attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> myCurrentLevel.step(SECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	

	public static void main(String[] args) {
		launch(args);
	}

}