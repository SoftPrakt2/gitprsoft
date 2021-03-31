package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.sun.javafx.logging.Logger;
import com.sun.javafx.logging.PlatformLogger.Level;

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
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public abstract class BasicGameScene {
	
	 VBox leftMenu;
	 Button play = new Button("play");
	 Button check = new Button("check");
	 Button manuel = new Button("manuel");
	 Button autosolve;
	
	 long startTime;
	
	  ToggleButton hint;
	
	 public abstract void display();
	
	public void createPlayButtons(BorderPane pane) {
		  leftMenu = new VBox(6);
		    leftMenu.setPrefWidth(100);
		 
		    play.setMinWidth(leftMenu.getPrefWidth());
		    play.getStyleClass().add("button1");
		   
		    
		    hint = new ToggleButton("Hint");
		    hint.setMinWidth(leftMenu.getPrefWidth());
		    hint.setOnAction(e -> showHint(pane));
		    
		    hint.getStyleClass().add("button2");
		    
		    Button check = new Button("Check");
		    check.setMinWidth(leftMenu.getPrefWidth());
		    check.getStyleClass().add("button1");
		    
		    Button autosolve = new Button("Autosolve");
		    autosolve.setMinWidth(leftMenu.getPrefWidth());
		    autosolve.getStyleClass().add("button1");
		    
		    Button create = new Button("Create Game");
		    create.getStyleClass().add("button1");
		    create.setMinWidth(leftMenu.getPrefWidth());
		    
		     manuel = new Button("Manuel fill");
		    manuel.getStyleClass().add("button1");
		    manuel.setMinWidth(leftMenu.getPrefWidth());
		    
		    play.setOnAction(e -> startTime = System.currentTimeMillis());
		    
		    
		    check.setOnAction(e -> {
		    	Long endtime = System.currentTimeMillis();
		    	Long differenz = ((endtime -startTime) /1000);
		    	
		    	if(differenz < 60) {
		    	Label timeStop = new Label("Playtime: " +differenz + "s");
		    	leftMenu.getChildren().addAll(timeStop);
		    	}
		    	if(differenz > 60) {
		    		differenz = differenz/60;
		    		long sek = differenz % 60;
		    		Label timeStop2 = new Label("Playtime: " +differenz + "m" + sek +"s");
			    	leftMenu.getChildren().addAll(timeStop2);
			    
		    	}
		    	
		    });
		    
		    leftMenu.getChildren().addAll(play, hint,autosolve,create, check,manuel);
		    leftMenu.setAlignment(Pos.CENTER_LEFT);
		    pane.setLeft(leftMenu);
	}
	
	
public void showHint(BorderPane pane) {
		
	   	HBox hintBox = new HBox(5);
	    hintBox.setVisible(false);
	    Label hintLabel = new Label("The next number is: ");
	    hintBox.getChildren().add(hintLabel);
	    hintBox.setAlignment(Pos.CENTER_RIGHT);
	    pane.setRight(hintBox);
	  
	   if(hint.isSelected()) {
		   hintBox.setVisible(true);
	   }
	  
   }





public void createMenuBar(BorderPane pane) {
		Menu helpMenu = new Menu("Help");
		helpMenu.getItems().add(new MenuItem("Rules"));
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(helpMenu);
		pane.setTop(menuBar);
		
		Menu saveMenu = new Menu("Savegame"); 
		MenuItem save = new MenuItem("Save");
		MenuItem load = new MenuItem("Load");
		saveMenu.getItems().addAll(save,load);
		menuBar.getMenus().add(saveMenu);

		
		Menu difficultyMenu = new Menu("Difficulty");
		ToggleGroup difficultyToggle = new ToggleGroup();
		RadioMenuItem easy = new RadioMenuItem("Easy");
		RadioMenuItem medium = new RadioMenuItem("Medium");
		RadioMenuItem hard = new RadioMenuItem("Hard");

		easy.setToggleGroup(difficultyToggle);
		medium.setToggleGroup(difficultyToggle);
		hard.setToggleGroup(difficultyToggle);
		difficultyMenu.getItems().addAll(easy, medium, hard);
		menuBar.getMenus().add(difficultyMenu);
		
		
		
		load.setOnAction(e-> openFile());
          
}


public void createBackButton(BorderPane pane) {
	 VBox backMenu = new VBox();
	    Button back = new Button("main menu");
	    Scene main = Main.getScene();
	    back.setOnAction(e -> Main.getStage().setScene(main));
	    backMenu.getChildren().add(back);
	    backMenu.setAlignment(Pos.CENTER);
	    pane.setBottom(backMenu);
	    back.getStyleClass().add("buttonmainmenu");
}


public Button getPlayButton() {
	return play;
	
}



public static File openFile() {
	FileChooser chooser = new FileChooser();
	chooser.setTitle("Choose a Sudoku");
	File defaultDirectory = new File("d:/sudoku");
	chooser.setInitialDirectory(defaultDirectory);
	File selectedFile = chooser.showOpenDialog(Main.getStage());
	
	return selectedFile;
}
	

	

	
	
}