package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
	
	  BorderPane pane = new BorderPane();
	  Scene sudoku = new Scene(pane,500,500);
	  ToggleButton hint;
	  SudokuBoard sudokuBoard;

	
	public void display() {

		sudoku.getStylesheets().add("application/sudoku.css");
	
		
		sudokuBoard = new SudokuBoard();
		pane.setCenter(sudokuBoard.getGridPane());
		
	    createPlayButtons(pane);
	    createMenuBar(pane);
	    createBackButton(pane);
	   
	    
	   
	    
	   SudokuController controller = new SudokuController(this);
	   
	  play.setOnAction(controller::playHandler);
	  manuel.setOnAction(controller::manuelHandler);
	  autosolve.setOnAction(controller::checkHandler);
	  
	 
	  easy.setOnAction(controller::easyHandler);
	  medium.setOnAction(controller::mediumHandler);
	  hard.setOnAction(controller::hardHandler);
	  
	  newGame.setOnAction(controller::newGameHandler);
	  
	  save.setOnAction(controller::saveHandler);
	    
//	    manuel.setOnMouseClicked(e -> {
//	    System.out.println("halo");
//	    sudokuBoard.enableEdit();
//	    
//	});
	
	  Main.getStage().setScene(sudoku);
	}
	
	
	    public SudokuBoard getBoard() {
			return sudokuBoard;
		}
	
	
	
	
	


}