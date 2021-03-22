package application;

import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;

public class SamuraiScene extends BasicGameScene {
	
	
	
	static BorderPane pane = new BorderPane();
	 static Scene samurai = new Scene(pane,800,800);
	 static ToggleButton hint;
	

	
	public void display() {

		samurai.getStylesheets().add("application/sudoku.css");
		
		SamuraiBoard samuraiBoard = new SamuraiBoard();
		pane.setCenter(samuraiBoard.getGridPane());
		
	
	    createPlayButtons(pane);
	    createMenuBar(pane);
	    createBackButton(pane);
	   
	    
	    Main.getStage().setScene(samurai);
	
	}

}
