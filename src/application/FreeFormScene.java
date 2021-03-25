package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FreeFormScene extends BasicGameScene {
	
	 static BorderPane pane = new BorderPane();
	 static Scene freeform = new Scene(pane,500,500);
	 static ToggleButton hint;
	
	public  void display() {

	//	freeform.getStylesheets().add("application/sudoku.css");
		
		FreeFormBoard freeformBoard = new FreeFormBoard();
		pane.setCenter(freeformBoard.getGridPane());
		
	
	    createPlayButtons(pane);
	    createMenuBar(pane);
	    createBackButton(pane);
	   
	    
	    Main.getStage().setScene(freeform);
	
	}
	

	public static Scene getScene() {
		return freeform;
	}
	

}