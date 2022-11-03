package game_object;


import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
	protected Point2D startingPosition;
	protected GraphicsDevice gd[];
	protected Point2D screenSize;
	
	
	public GameObject(String imagePath, double sizeWidth, double sizeHeight, Point2D pos) throws FileNotFoundException {
		Image image = new Image(new FileInputStream(imagePath));
        myView = new ImageView(image);
        
        myView.setFitWidth(sizeWidth);
        myView.setFitHeight(sizeHeight);

        myView.setX(pos.getX());
        myView.setY(pos.getY());
        startingPosition = pos;
        gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		screenSize = new Point2D((9*gd[0].getDisplayMode().getWidth())/10, (9*gd[0].getDisplayMode().getHeight())/10);

	}
	
	protected int getRandomInRange (int min, int max) {
		Random dice = new Random();
        return min + dice.nextInt(max - min) + 1;
    }

	
	public Node getView() {
		return myView;
	}
	
	public ImageView getImageView() {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameObject other = (GameObject) obj;
		return  this.getView() == other.getView();
	}

	@Override
	public String toString() {
		return "GameObject [myView=" + myView + "]";
	}
	
	public void resetPosition() {
		myView.setX(startingPosition.getX());
		myView.setY(startingPosition.getY());
	}






}