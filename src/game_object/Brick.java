package game_object;


import java.io.FileNotFoundException;

import javafx.geometry.Point2D;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Written by Graham Young
public class Brick extends Obstacle{
	
	public Brick(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/20, screenSize.getY()/20, pos);
		myScoreValue = getRandomInRange(MIN_SCORE_VALUE, MAX_SCORE_VALUE);
	}





	


}