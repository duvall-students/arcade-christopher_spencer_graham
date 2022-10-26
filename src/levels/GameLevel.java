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

//Graham Young
public abstract class GameLevel{
	
	protected GraphicsDevice gd[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
	protected Point2D screenSize = new Point2D(gd[0].getDisplayMode().getWidth(), gd[0].getDisplayMode().getHeight());


	protected static final Paint BACKGROUND = Color.BLACK;
	protected static final int REGULAR_FONT_SIZE = 20;
	protected static final int GAME_TITLE_FONT_SIZE = 75;
	protected static final int END_GAME_TITLE_FONT_SIZE = 20;
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
	
	protected Group root = new Group();
	
	protected Player myPlayer;
	protected Scene myScene;
	
	
	
	public GameLevel() {
		texts = new ArrayList<>();
		gameObjects = new ArrayList<>();
		colliders = new ArrayList<>();
		movableTimes = new ArrayList<>();
		movableKeyCodes = new ArrayList<>();
		obstacles = new ArrayList<>();
		projectiles = new ArrayList<>();
	}
	
	protected Scene setupLevelScene (double width, double height, Paint background) {
		


		for(GameObject g : gameObjects) {
			root.getChildren().add(g.getView());
		}
	
		for(Text t : texts) {
			root.getChildren().add(t);
		}
		
		createTextDisplay((15.5*width)/20, height/20, TEXT_FONT, REGULAR_FONT_SIZE, "Score: " + PLAYER_STARTING_SCORE, TEXT_COLOR, root);
		createTextDisplay((17.5*width)/20, height/20, TEXT_FONT, REGULAR_FONT_SIZE, "High Score: 0", TEXT_COLOR, root);
		createTextDisplay((0.2*width)/20, height/20, TEXT_FONT, REGULAR_FONT_SIZE, "Lives: " + myPlayer.getLives(), TEXT_COLOR, root);

		//setUpLevel();
		//createLevel();
		//createPlayer();
		//createProjectiles();
		//root.getChildren().add(myPlayer.getView()); 
		Scene scene = new Scene(root, width, height, background);
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
	
	//default step method
	public void step(double elapsedTime) {

		//move the objects
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
		gameSceneImages.getChildren().add(newDisplay);
		//texts.add(newDisplay);
	}
	
	
	
	
	
	
	
}
