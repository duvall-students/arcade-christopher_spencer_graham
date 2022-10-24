package game_object;

import java.io.FileNotFoundException;
import java.util.Random;

import javafx.geometry.Point2D;

public abstract class PowerUp extends Obstacle {

	public PowerUp(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		// TODO Auto-generated constructor stub
	}
	
	public int setRandomBrick(int numBricks) {
		Random ran = new Random();
		return ran.nextInt(numBricks);
	}

}
