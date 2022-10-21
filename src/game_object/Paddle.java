package game_object;

import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import main.GameLoop;

//Written by Graham Young
public class Paddle extends Player {
	
	private static final int MOVE_SPEED = 10;

	public Paddle(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		super(imagePath, sizeWidth, sizeHeight, pos);
		// TODO Auto-generated constructor stub
	}

	
	

}
