package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;

public class Obstacle extends GameObject {
	
	protected int myScoreValue;

	public Obstacle(String imagePath, double sizeWidth, double sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		// TODO Auto-generated constructor stub
	}

	
	public int getScoreValue() {
		return myScoreValue;
	}
}
