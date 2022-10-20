package game_objects;


import javafx.geometry.Point2D;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Written by Graham Young
public class Brick extends Obstacle{
	


	protected static final int MIN_SCORE_VALUE = 100;
	protected static final int MAX_SCORE_VALUE = 200;
	

	protected int scoreValue;
	
	
	public Brick(ImageView imageView) {
		
		super(imageView);
		scoreValue = getRandomInRange(MIN_SCORE_VALUE, MAX_SCORE_VALUE);
		
		
	}

	public int getScoreValue() {
		return scoreValue;
	}


	


}