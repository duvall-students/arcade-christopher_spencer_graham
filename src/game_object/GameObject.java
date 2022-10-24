package game_object;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	
	public GameObject(String imagePath, int sizeWidth, int sizeHeight, Point2D pos) throws FileNotFoundException {
		Image image = new Image(new FileInputStream(imagePath));
        myView = new ImageView(image);
        
        myView.setFitWidth(sizeWidth);
        myView.setFitHeight(sizeHeight);

        myView.setX(pos.getX());
        myView.setY(pos.getY());

	}
	
	protected int getRandomInRange (int min, int max) {
		Random dice = new Random();
        return min + dice.nextInt(max - min) + 1;
    }

	
	public Node getView() {
		return myView;
	}
	
	
	public boolean isIntersecting(GameObject other) {
		return this.getBounds().intersects(other.getBounds());
	}
	
	public Bounds getBounds() {
		return myView.getBoundsInParent();
	}
	
	@Override
	public boolean collide(GameObject other) {
		
		
		return this.isIntersecting(other);
		
	}


	@Override
	public String toString() {
		return "GameObject [myView=" + myView + "]";
	}






}