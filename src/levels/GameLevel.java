package levels;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import functionality.HighScore;
import game_object.Collider;
import game_object.GameObject;
import game_object.Laser;
import game_object.Ball;
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

	private static final String BREAKOUT_HIGH_SCORE_TXT = "BreakoutHighScore.txt";

	protected GraphicsDevice gd[];

	protected Point2D screenSize;
	

	protected static final int REGULAR_FONT_SIZE = 20;
	protected static final int GAME_TITLE_FONT_SIZE = 75;
	protected static final int END_GAME_TITLE_FONT_SIZE = 1000;
	protected static final String TEXT_FONT = "Arial";
	protected static final Color TEXT_COLOR = Color.WHITE;
	protected static final Color BACKGROUND_COLOR = Color.AZURE;
	protected static final int PLAYER_STARTING_SCORE = 0;
	
	protected Collection<Text> texts;
	protected Collection<GameObject> gameObjects;
	protected Collection<Collider> colliders;
	protected Collection<MovableTime> movableTimes;
	protected Collection<MovableKeyCode> movableKeyCodes;
	protected Collection<Obstacle> obstacles;
	protected Collection<Projectile> projectiles;
	
	
	
	protected Player myPlayer;
	protected Scene myScene;
	protected Text livesText;
	protected Text scoreText;
	private int playerScore;
	
	
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
		playerScore = 0;
		//ballStartingPositions = new ArrayList<Point2D>();
		//playerStartingPosition = new Point2D(screenSize.getX()/2,(19*screenSize.getY())/20);
	}
	
  	public Scene setupLevelScene() {

		//root.getChildren().add(myPlayer.getView());
		root = new Group();
		scoreText = createTextDisplay((15.5*screenSize.getX())/20, screenSize.getY()/20, TEXT_FONT, REGULAR_FONT_SIZE, "Score: " + PLAYER_STARTING_SCORE, TEXT_COLOR, root);
		livesText = createTextDisplay((2*screenSize.getX())/20, screenSize.getY()/20, TEXT_FONT, REGULAR_FONT_SIZE, "Lives: " + myPlayer.getLives(), TEXT_COLOR, root);
		texts.add(livesText);
		texts.add(scoreText);

		for(GameObject g : gameObjects) {
			root.getChildren().add(g.getView());
		}
	
		for(Text t : texts) {
			root.getChildren().add(t);
		}

		Scene scene = new Scene(root, screenSize.getX(), screenSize.getY(), BACKGROUND_COLOR);
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
		ArrayList<GameObject> remove = new ArrayList<GameObject>();
		
		//move the objects
		for(MovableTime m : movableTimes) {	
			m.move(elapsedTime);
		}
		
		//checkForCollisions();
		obstacleloop:
		for(Obstacle o : obstacles) {
			//check if the obstacles collide with projectiles
			for(Projectile p : projectiles) {
				if (p.collide(o)) {
					playerScore += o.getScoreValue();
					remove.add(o);
					if(p instanceof Laser){
						root.getChildren().remove(p.getView());
						remove.add(p);
					}
					root.getChildren().remove(o.getView());
					//up
					scoreText.setText("Score: " + playerScore);
				}
				if(p.collide(myPlayer) && p instanceof Ball) {
					break obstacleloop;
				}
			}
			//check if obstacles collide with player
			if(myPlayer.collide(o)) {
				remove.add(o);
				root.getChildren().remove(o.getView());
				livesText.setText("Lives: " + myPlayer.getLives());
				
			}
		}
		
		if(isLevelEnd()) {
			
			endLevel();
		}
		removeFromAllLists(remove);
		myScene.setRoot(root);
	}
	
	//protected abstract void checkForCollisions();
	
	
	@SuppressWarnings("rawtypes")
	protected void removeFromAllLists(ArrayList<GameObject> remove) {
		//create an array with every list in it
		ArrayList[] allLists = {(ArrayList) texts, (ArrayList) gameObjects, (ArrayList) colliders, 
					(ArrayList) movableTimes, (ArrayList) movableKeyCodes, (ArrayList) obstacles, 
					(ArrayList) projectiles};
		
		//cross-reference remove with allLists and remove any mention of the objects in remove
		for (GameObject g : remove) {	
			for(ArrayList c : allLists) {
				if(c.contains(g)) {
					c.remove(g);
				}
			}
		}
	}
	
	//returns true if the level should end
	protected boolean isLevelEnd() {
		return !myPlayer.isAlive() || obstacles.size() == 0;
	}
	
	
	/*
	 * 
	 * change to a generic high score file
	 * 
	 */
	private void endLevel() {
		endLevel(BREAKOUT_HIGH_SCORE_TXT);
	}
	
	protected void endLevel(String scoreFile) {
		HighScore.setNewHighScore(playerScore, scoreFile);
	}
	
	
    
	protected Text createTextDisplay(double xPosition, double yPosition, String textFont, int textSize, String textToDisplay, Color colorOfText, Group gameSceneImages) {
		Text newDisplay = new Text();
		newDisplay.setFont(new Font(textFont, textSize));
		newDisplay.setX(xPosition);
		newDisplay.setY(yPosition);
		newDisplay.setText(textToDisplay);
		newDisplay.setStroke(colorOfText);
		return newDisplay;
	}
	
	
	
	
	
	
	
}
