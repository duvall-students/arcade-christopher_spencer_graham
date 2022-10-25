package levels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import game_object.Collider;
import game_object.GameObject;
import game_object.Movable;
import game_object.MovableKeyCode;
import game_object.MovableTime;
import game_object.Obstacle;
import game_object.Player;
import game_object.Projectile;
import javafx.geometry.Point2D;
import javafx.scene.text.Text;

public abstract class GameLevel{

	
	protected Collection<Text> texts;
	protected Collection<GameObject> gameObjects;
	protected Collection<Collider> colliders;
	protected Collection<Movable> movables;
	protected Collection<Player> players;
	protected Collection<Obstacle> obstacles;
	protected Collection<Projectile> projectiles;
	
	public GameLevel() {
		texts = new ArrayList<>();
		gameObjects = new ArrayList<>();
		colliders = new ArrayList<>();
		movables = new ArrayList<>();
		obstacles = new ArrayList<>();
		projectiles = new ArrayList<>();
	}
	
	
	private void addObjectsToCollectionsFromLevel(List<? extends GameObject> list) {
		
		for(int i = 0; i <= list.size(); i++) {
			GameObject t = list.get(i);
			gameObjects.add(t);
			colliders.add(t);
			try {
				movables.add((Movable)t);
			}
			catch (ClassCastException e) {
				e.printStackTrace();
			}
			
			root.getChildren().add(t.getView());
		}
	}
	
	public abstract void createObstacles(Point2D screenSize, List<Point2D> positions);

	public abstract void createProjectiles(Point2D screenSize, List<Point2D> positions);
	
	public abstract void createPlayers(Point2D screenSize, List<Point2D> positions);
	
	public abstract void step(double elapsedTime);
	
	
	
	
	
	
	
	
	
	
}
