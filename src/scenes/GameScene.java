package scenes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;
import levels.BreakoutLevel;
import levels.GalagaLevelOne;
import levels.GalagaLevelThree;
import levels.GalagaLevelTwo;
import levels.BreakoutLevelOne;
import levels.BreakoutLevelTwo;
import levels.BreakoutLevelThree;
import levels.GameLevel;


import functionality.HighScore;


//Graham Young

public abstract class GameScene extends Application {


	protected static final int FRAMES_PER_SECOND = 60;
	protected static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	protected static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;

	protected static final KeyCode PLAYER_MOVE_LEFT = KeyCode.LEFT;
	protected static final KeyCode PLAYER_MOVE_RIGHT = KeyCode.RIGHT;
	

	protected Queue<GameLevel> levels = new LinkedList<>();
	protected GameLevel myCurrentLevel;
	Timeline animation;
	Stage myStage;
	
	@Override
	public void start (Stage stage) {
		myStage = stage;
		loadNewLevel();
	}
	
	private void loadNewLevel() {
		myCurrentLevel = levels.poll();
		
		// attach scene to the stage and display it
		
		myStage.setScene(myCurrentLevel.getScene());
		myStage.show();
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY));
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}

	
	private void step(double elapsedTime) {
		myCurrentLevel.step(elapsedTime);
		if(myCurrentLevel.isLevelEnd()) {
			if(myCurrentLevel.isGameEnd()) {
				stop();
			}
			else {
				loadNewLevel();
			}
		}
		
		
	}
	
	@Override
	public void stop() {
		myCurrentLevel.endGame();
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}

}