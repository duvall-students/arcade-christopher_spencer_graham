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
import javafx.scene.media.MediaPlayer;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

// Spencer Buehlman

public class GalagaScene extends GameScene {
	private static final String GALAGA_HIGH_SCORE_FILE_NAME = "GalagaHighScore.txt";
	
	
	@Override
	protected void createDisplays() {
		createTextDisplay(0.4*screenWidth, screenHeight/15, TEXT_FONT, GAME_TITLE_FONT_SIZE, "GALAGA", TEXT_COLOR, root);
	}
	
}
