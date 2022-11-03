import java.util.HashMap;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import scenes.BreakoutScene;
import scenes.GalagaScene;
import scenes.GameScene;

public class Main {

  public static void main (String[] args) {


	  HashMap<String, Class<? extends GameScene>> games = new HashMap<>();
	  
	  
	  games.put("Galaga", GalagaScene.class);
	  games.put("Breakout", BreakoutScene.class);
	  
	  Scanner console = new Scanner(System.in);
	  System.out.println("Enter 'Galaga' to play Galaga or 'Breakout' to play Breakout");
	  String userInput = console.nextLine();
	  console.close();
	  Application.launch(games.get(userInput), args);

  }


    
}
