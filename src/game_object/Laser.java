package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;

public class Laser extends Projectile {

	public Laser(String imagePath, Point2D screenSize, Point2D pos) throws FileNotFoundException {
		super(imagePath, screenSize.getX()/10, screenSize.getY()/10, pos);
		// TODO Auto-generated constructor stub
	}

	
}
