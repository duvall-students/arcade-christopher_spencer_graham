package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;

public class Spaceship extends Player {

	public Spaceship(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean collide(GameObject other) {
		boolean check = this.isIntersecting(other);
		if (check) {
			if (this.removeALife()) {
				resetPosition();
			}
			
		}
		return check;
	}

}
