package game_object;

import javafx.scene.input.KeyCode;

public interface MoveableKeyCode extends Moveable<KeyCode>{
	
	public void move(KeyCode keyCode, int moveSpeed);
}