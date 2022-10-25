package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;

public class Alien extends Obstacle implements MoveableTime{

	public Alien(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/10, screenSize.getY()/10, pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(Double elapsedTime) {
		// TODO Auto-generated method stub
		
	}
	

}
