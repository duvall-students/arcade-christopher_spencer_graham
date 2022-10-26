package levels;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class GameLevel{
	protected GraphicsDevice gd[];

	protected Point2D screenSize;
	
	protected static final int REGULAR_FONT_SIZE = 20;
	protected static final int GAME_TITLE_FONT_SIZE = 75;
	protected static final int END_GAME_TITLE_FONT_SIZE = 1000;
	protected static final String TEXT_FONT = "Arial";
	protected static final Color TEXT_COLOR = Color.WHITE;
	protected static final int PLAYER_STARTING_SCORE = 0;
	
	protected Collection<Text> texts;
	protected Collection<GameObject> gameObjects;
	protected Collection<Collider> colliders;
	protected Collection<MovableTime> movableTimes;
	protected Collection<MovableKeyCode> movableKeyCodes;
	protected Collection<Obstacle> obstacles;
	protected Collection<Projectile> projectiles;
	protected List<Point2D> obstaclePositions;
	protected List<Point2D> ballStartingPositions;
	
	protected Player myPlayer;
	protected Point2D playerStartingPosition;
	protected Scene myScene;
	Group root;
	
	public GameLevel() {
		gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		screenSize = new Point2D((9*gd[0].getDisplayMode().getWidth())/10, (9*gd[0].getDisplayMode().getHeight())/10);
		texts = new ArrayList<>();
		gameObjects = new ArrayList<>();
		colliders = new ArrayList<>();
		movableTimes = new ArrayList<>();
		movableKeyCodes = new ArrayList<>();
		obstacles = new ArrayList<>();
		projectiles = new ArrayList<>();
		obstaclePositions = new ArrayList<Point2D>();
		ballStartingPositions = new ArrayList<Point2D>();
		playerStartingPosition = new Point2D(screenSize.getX()/2,(19*screenSize.getY())/20);
	}
	
	public Scene setupLevelScene (Paint background) {
		root = new Group();
		createTextDisplay((15.5*screenSize.getX())/20, screenSize.getY()/20, TEXT_FONT, REGULAR_FONT_SIZE, "Score: " + PLAYER_STARTING_SCORE, TEXT_COLOR, root);
		createObstacles(screenSize, obstaclePositions);
		createPlayer(screenSize, playerStartingPosition);
		createProjectiles(screenSize, ballStartingPositions);
		createTextDisplay((2*screenSize.getX())/20, screenSize.getY()/20, TEXT_FONT, REGULAR_FONT_SIZE, "Lives: " + myPlayer.getLives(), TEXT_COLOR, root);
		
		for(GameObject g : gameObjects) {
			root.getChildren().add(g.getView());
		}
	
		for(Text t : texts) {
			root.getChildren().add(t);
		}

		//setUpLevel();
		//createLevel();
		//createPlayer();
		//createProjectiles();
		//root.getChildren().add(myPlayer.getView()); 
		Scene scene = new Scene(root, screenSize.getX(), screenSize.getY(), background);
		scene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
		return scene;
	}
	
	public Scene getScene() {
		return myScene;
	}
	
	//when creating any GameObjects add them to all relevant collections
	public abstract void createObstacles(Point2D screenSize, List<Point2D> positions);

	public abstract void createProjectiles(Point2D screenSize, List<Point2D> positions);
	
	public abstract void createPlayer(Point2D screenSize, Point2D position);
	
	protected abstract void handleKeyInput(KeyCode code);
	
	public void step(double elapsedTime) {

		//move the ball
		for(MovableTime m : movableTimes) {	
			m.move(elapsedTime);
		}
			
		for(Collider c : colliders) {
			for(GameObject x : gameObjects) {
				c.collide(x);
			}
		}	
	}
		
	protected void createTextDisplay(double xPosition, double yPosition, String textFont, int textSize, String textToDisplay, Color colorOfText, Group gameSceneImages) {
		Text newDisplay = new Text();
		newDisplay.setFont(new Font(textFont, textSize));
		newDisplay.setX(xPosition);
		newDisplay.setY(yPosition);
		newDisplay.setText(textToDisplay);
		newDisplay.setStroke(colorOfText);
		texts.add(newDisplay);
	}
	
	
	
	
	
	
	
}
