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

public class SudokuScene extends BasicGameScene {
	
	 static BorderPane pane = new BorderPane();
	 static Scene sudoku = new Scene(pane,500,500);
	 static ToggleButton hint;
	

	
	public void display() {

		sudoku.getStylesheets().add("application/sudoku.css");
	
		
		Playfield sudokuBoard = new Playfield();
		pane.setCenter(sudokuBoard.getGridPane());
		
	
	    createPlayButtons(pane);
	    createMenuBar(pane);
	    createBackButton(pane);
	   
	    
	    Main.getStage().setScene(sudoku);
	
	}
	

	public static Scene getScene() {
		return sudoku;
	}
	


	
	
	
	
	

}
