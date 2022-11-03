package scenes;

import java.util.HashMap;
import levels.BreakoutLevelOne;
import levels.BreakoutLevelTwo;
import levels.BreakoutLevelThree;
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
	@Override
	public void start (Stage stage) {
		levels.offer(new BreakoutLevelOne());
		levels.offer(new BreakoutLevelTwo());
		levels.offer(new BreakoutLevelThree());
		super.start(stage);

	}


}

