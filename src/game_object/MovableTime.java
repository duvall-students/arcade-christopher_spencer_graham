package game_object;

import javafx.scene.input.KeyCode;

//Written by Graham Young
public interface MovableTime extends Movable<Double>{
	
	
	//move the implementation based on time
	public void move(Double elapsedTime);

}
