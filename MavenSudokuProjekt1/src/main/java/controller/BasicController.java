package controller;

import application.BasicGameBuilder;
import application.GUI;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import logic.BasicGameLogic;

public abstract class BasicController {
	


	
	public abstract void createGameHandler(ActionEvent e);
	
	public abstract void enableEditHandler(ActionEvent e);
	
	public abstract void easyHandler(ActionEvent e);
	
	public abstract void mediumHandler(ActionEvent e);
	
	public abstract void hardHandler(ActionEvent e);
	
	public abstract void newGameHandler(ActionEvent e);
	
	public abstract void checkHandler(ActionEvent e);
	
	public abstract void saveHandler(ActionEvent e);
	
	public abstract void autoSolveHandler(ActionEvent e);
	
	public abstract void switchToSamurai(ActionEvent e);
	
	public abstract void switchToFreeForm(ActionEvent e);
	

	
}
