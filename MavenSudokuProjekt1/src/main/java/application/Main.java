package application;
	
import java.util.stream.Stream;

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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application  {
	
	BorderPane mainPane;
	
  static Stage window;
  
  static Scene mainScene;
	private Button sudoku;
	private Button samurai;
	private Button freeform;
	
	 SudokuGameBuilder sudokuBuilder;
	 SamuraiGameBuilder samuraiBuilder;
	 FreeFormGameBuilder freeFormBuilder;
	
	
	
	
	ToggleButton hint;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage scene) {
		mainPane = new BorderPane();
		 
		window = scene;
		 
		 	HBox buttonMenu = new HBox();
		    buttonMenu.setSpacing(145);
			buttonMenu.setPrefWidth(100);
		    
		    sudoku = new Button("Sudoku");
		    sudokuBuilder = new SudokuGameBuilder();
		    Scene sceneSud = sudokuBuilder.initializeScene();
		    sudoku.setOnAction(e -> window.setScene(sceneSud));
		    
		    
		    
			samurai = new Button("Samurai");
			samuraiBuilder = new SamuraiGameBuilder();
			Scene sceneSam = samuraiBuilder.initializeScene();
			samurai.setOnAction(e -> window.setScene(sceneSam));
			
			
			freeform = new Button("Freeform");
			freeFormBuilder = new FreeFormGameBuilder();
			Scene freeFormScene = freeFormBuilder.initializeScene();
			freeform.setOnAction(e -> window.setScene(freeFormScene));
			
			
			//design for buttons
			 Stream.of(sudoku, samurai, freeform).forEach(button -> 
			    button.getStyleClass().add("button1"));
			
			//größe der Buttons
			 Stream.of(sudoku, samurai, freeform).forEach(button -> 
			    button.setMinWidth(buttonMenu.getPrefWidth()));
			 
			buttonMenu.getChildren().addAll(sudoku,samurai,freeform);
			
			
			Label welcomeLabel = new Label("Welcome to our Sudoku Game, please choose a gamemode");
			welcomeLabel.setFont(new Font("Arial",20));
			
			mainPane.setBottom(buttonMenu);
			mainPane.setCenter(welcomeLabel);
			
			mainScene = new Scene(mainPane,600,600);
			window.setScene(mainScene);
			window.show();
			
			
			mainScene.getStylesheets().add("main/resources/CSS/sudoku.css");
	
	 
	    window.setOnCloseRequest(e-> {
			//consume heißt wir führen den schließvorgang fort und es wird nicht immer geschlossen nur wenn yes gedrückt wird
			e.consume();
			closeProgram();
		});
	    
	}
	    
	   
	    private void closeProgram() {
	    	CloseWindowStage c = new CloseWindowStage();
			Boolean answer = c.showPopUp("Closing","Are you sure that you want to close the program?");
			if(answer) window.close();
			
		}    
	    
	    
	    public static Stage getStage() {
	    	return window;
	    }
	    
	    public static Scene getScene() {
	    	return mainScene;
	    }
	
	    
	    
	   
	}
	
	
	