package game_objects;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import main.GameLoop;

//Written by Graham Young
public class Paddle extends Player implements MovableKeyCode {
	
	private static final int MOVE_SPEED = 10;

	public Paddle(ImageView imageView) {
		super(imageView);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void move(KeyCode keyCode) {
			
	        if (keyCode == KeyCode.LEFT ) {
	        	myView.setX(myView.getX() - MOVE_SPEED);
	        }
	        else if (keyCode == KeyCode.RIGHT ) {
	        	myView.setX(myView.getX() + MOVE_SPEED);
	        }
		
		

	}

}
