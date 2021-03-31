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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application  {
	
	BorderPane pane;
	
	static Stage window;
	Button sudoku;
	Button samurai;
	Button freeform;
	
	
	
	Scene freeformScene;
	static Scene mainScene;
	
	ToggleButton hint;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage scene) {
		 pane = new BorderPane();
		
	
		
		window = scene;
		window.setTitle("Sudoku");
		

		 //knöpfe erste seite
	    HBox buttonMenu = new HBox();
	    sudoku = new Button("Sudoku");
		
	    SudokuScene sudokuScene = new SudokuScene();
	    sudoku.setOnAction(e ->  {
	    	e.consume();
	    	sudokuScene.display();
	    });
		samurai = new Button("Samurai");
		
		SamuraiScene samuraiScene = new SamuraiScene();
		samurai.setOnAction(e -> samuraiScene.display());
		
		
		
		FreeFormScene freeformscene = new FreeFormScene();
		freeform = new Button("Freeform");
		freeform.setOnAction(e -> freeformscene.display());
		
		buttonMenu.setSpacing(210);
		buttonMenu.getChildren().addAll(sudoku,samurai,freeform);
		
		
		Label welcomeLabel = new Label("Welcome to our Sudoku Game, please choose a gamemode");
		welcomeLabel.setFont(new Font("Arial",20));
		
		
	
		BorderPane borderPane = new BorderPane();
		borderPane.setBottom(buttonMenu);
		borderPane.setCenter(welcomeLabel);
		
		
	
		mainScene = new Scene(borderPane,600,600);
		window.setScene(mainScene);
		window.show();
		
		
	
	 
	    window.setOnCloseRequest(e-> {
			//consume heißt wir führen den schließvorgang fort und es wird nicht immer geschlossen nur wenn yes gedrückt wird
			e.consume();
			closeProgram();
		});
	    
	}
	    
	   
	    private void closeProgram() {
			Boolean answer = ConfirmBox.showPopUp("Closing","Are you sure that you want to close the program?");
			if(answer) window.close();
			
		}    
	    
	    
	    public static  Stage getStage() {
	    	return window;
	    }
	    
	    
	  public static Scene getScene() {
		  return mainScene;
	  }
	    
	    
	   
	}
	
	
	