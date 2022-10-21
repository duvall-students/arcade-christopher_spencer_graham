package game_object;

import javafx.scene.input.KeyCode;

public interface MoveableKeyCode {
	
	public void move(KeyCode keyCode, int moveSpeed);
}