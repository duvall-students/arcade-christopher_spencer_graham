package scenes;

import java.util.HashMap;
import levels.BreakoutLevel;
import levels.GameLevel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.scene.input.KeyCode;

import javafx.stage.Stage;
import javafx.util.Duration;
import levels.BreakoutLevelOne;
import levels.BreakoutLevel;
import levels.GameLevel;

// Name: Christopher Boyette

public class BreakoutScene extends GameScene {
	// some things we need to remember during our game
	private static final String BREAKOUT_HIGH_SCORE_FILE_NAME = "BreakoutHighScore.txt";
	protected BreakoutLevelOne myCurrentBreakoutLevel;
	
	@Override
	public void start(Stage stage) {
		myCurrentBreakoutLevel = new BreakoutLevelOne();
		stage.setScene(myCurrentBreakoutLevel.setupLevelScene(BACKGROUND));
		stage.show();
		// attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> myCurrentLevel.step(SECOND_DELAY));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
//	protected void setupLevel(int width, int height) {
//		
//	}
//	
//	@Override
//	protected void step (double elapsedTime) {
//		myPlayer.move(PLAYER_MOVE_LEFT, PLAYER_MOVE_SPEED);
//		myPlayer.move(PLAYER_MOVE_RIGHT, PLAYER_MOVE_SPEED);
//	}


}

