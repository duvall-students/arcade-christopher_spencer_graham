package game_objects;


import java.util.Objects;
import java.util.Random;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//Written by Graham Young
public abstract class GameObject implements Collider {
	
	
	protected ImageView myView;
	
	
	
	public GameObject(ImageView imageView) {
		myView = imageView;

	}
	

	
	"""
	protected int getRandomInRange (int min, int max) {
		Random dice = new Random();
        return min + dice.nextInt(max - min) + 1;
    }
	"""
	
	public Node getView() {
		return myView;
	}
	
	
	public boolean isIntersecting(GameObject other) {
		return myView.intersects(other.getView().getBoundsInParent());
	}
	

		


	@Override
	public String toString() {
		return "GameObject [myView=" + myView + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(myVelocity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameObject other = (GameObject) obj;
		return  Objects.equals(myVelocity, other.myVelocity);
	}

}