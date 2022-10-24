package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;

public class Alien extends Obstacle implements MoveableTime{

	public Alien(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(double elapsedTime) {
		// TODO Auto-generated method stub
		
	}

}
