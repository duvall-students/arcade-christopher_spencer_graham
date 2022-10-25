package scenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.scene.input.KeyCode;

import javafx.stage.Stage;
import javafx.util.Duration;

// Name: Christopher Boyette

public class BreakoutScene extends GameScene {
	// some things we need to remember during our game

	
	@Override
	protected void createDisplays() {
		createTextDisplay(0.4*screenSize.getX(), screenSize.getY()/15, TEXT_FONT, GAME_TITLE_FONT_SIZE, "BREAKOUT", TEXT_COLOR, root);
	}

	@Override
	protected void handleKeyInput(KeyCode keyCode) {
		// TODO Auto-generated method stub
		

	private static final String BREAKOUT_HIGH_SCORE_FILE_NAME = "BreakoutHighScore.txt";

	
	@Override
	protected void createDisplays() {
		createTextDisplay(0.4*screenWidth, screenHeight/15, TEXT_FONT, GAME_TITLE_FONT_SIZE, "BREAKOUT", TEXT_COLOR, root);

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

