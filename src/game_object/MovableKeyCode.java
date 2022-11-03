package game_object;

import javafx.scene.input.KeyCode;

public interface MovableKeyCode extends Movable<KeyCode>{
	
	public void move(KeyCode keyCode, int moveSpeed);
}