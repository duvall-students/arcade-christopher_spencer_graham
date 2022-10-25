package game_object;


import java.io.FileNotFoundException;

import javafx.geometry.Point2D;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Written by Graham Young
public class Brick extends Obstacle{
	


	protected static final int MIN_SCORE_VALUE = 100;
	protected static final int MAX_SCORE_VALUE = 200;
	

	
	
	public Brick(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/10, screenSize.getY()/10, pos);
		myScoreValue = getRandomInRange(MIN_SCORE_VALUE, MAX_SCORE_VALUE);
		
		
	}




	


}