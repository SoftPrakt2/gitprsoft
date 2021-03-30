package application;

import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;

public class SamuraiScene extends BasicGameScene {
	
	
	
	 BorderPane pane = new BorderPane();
	  Scene samurai = new Scene(pane,800,800);
	  ToggleButton hint;
	 

	
	public void display() {

		samurai.getStylesheets().add("application/sudoku.css");
		
		SamuraiBoard samuraiBoard = new SamuraiBoard();
		pane.setCenter(samuraiBoard.getGridPane());
		
		play.setOnMouseClicked(e -> samuraiBoard.fillSamurai());
		
	
	    createPlayButtons(pane);
	    createMenuBar(pane);
	    createBackButton(pane);
	   
	    
	    Main.getStage().setScene(samurai);
	    
	    manuel.setOnMouseClicked(e -> {
		    System.out.println("bbbb");
		    samuraiBoard.enableSamurai();
		    
		});
	
	}
	
	

}