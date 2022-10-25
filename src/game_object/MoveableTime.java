package game_object;

import javafx.scene.input.KeyCode;

//Written by Graham Young
public interface MoveableTime extends Moveable<Double>{
	
	
	//move the implementation based on time
	public void move(Double elapsedTime);

}
