package scenes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import levels.GalagaLevelOne;
import levels.GalagaLevelThree;
import levels.GalagaLevelTwo;
import javafx.scene.media.MediaPlayer;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

import functionality.HighScore;

// Spencer Buehlman

public class GalagaScene extends GameScene {
	private static final String GALAGA_HIGH_SCORE_FILE_NAME = "GalagaHighScore.txt";
	
	@Override
	public void start (Stage stage) {
		levels.offer(new GalagaLevelOne());
		levels.offer(new GalagaLevelTwo());
		levels.offer(new GalagaLevelThree());
		super.start(stage);

	}
	
	public void updateHighScore(int score) {
		int previousHighScore =  HighScore.getCurrentScore(GALAGA_HIGH_SCORE_FILE_NAME);
		if (score > previousHighScore) {
			HighScore.setNewScore(score, GALAGA_HIGH_SCORE_FILE_NAME);
		}
	}

	
	
}
