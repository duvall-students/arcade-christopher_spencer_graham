package levels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import game_object.Collider;
import game_object.GameObject;
import game_object.Moveable;
import game_object.MoveableKeyCode;
import game_object.MoveableTime;
import game_object.Obstacle;
import game_object.Player;
import game_object.Projectile;
import javafx.geometry.Point2D;
import javafx.scene.text.Text;

public abstract class GameLevel{

	
	protected Collection<Text> texts;
	protected Collection<GameObject> gameObjects;
	protected Collection<Collider> colliders;
	protected Collection<Moveable> movables;
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
	
	
	public abstract void createObstacles(Point2D screenSize, List<Point2D> positions);

	public abstract void createProjectiles(Point2D screenSize, List<Point2D> positions);
	
	public abstract void createPlayers(Point2D screenSize, List<Point2D> positions);
	
	
	
	
	
	
	
	
	
	
	
	
}
