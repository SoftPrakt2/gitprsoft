package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import application.BasicGameBuilder;
import application.FreeFormGameBuilder;
import application.GUI;
import application.MainMenu;
import application.SamuraiGameBuilder;
import application.SudokuField;
import application.SudokuGameBuilder;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import logic.BasicGameLogic;


public class MainMenuController {
	
	
	MainMenu menu;
	SudokuGameBuilder sudokuGame = new SudokuGameBuilder();
	SamuraiGameBuilder samuraiGame = new SamuraiGameBuilder();
	FreeFormGameBuilder freeFormGame = new FreeFormGameBuilder();
	
	public MainMenuController(MainMenu menu) {
		this.menu = menu;
	}
	
	
	public void handleToSudoku(ActionEvent e) {
		
		GUI.getStage().setScene(sudokuGame.initializeScene());
	
	}
	
	public void handleToSamurai(ActionEvent e) {
		Scene scene = samuraiGame.initializeScene();
		GUI.getStage().setScene(scene);
	
	}
	
	public void handleToFreeForm(ActionEvent e) {
		Scene scene = freeFormGame.initializeScene();
		GUI.getStage().setScene(scene);
	}
	
	
	
	

}
