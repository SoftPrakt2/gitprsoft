package controller;

import application.BasicGameBuilder;
import javafx.event.ActionEvent;

public interface BasicController {

	
	public void createGameHandler(ActionEvent e);
	
	public void enableEditHandler(ActionEvent e);
	
	public void easyHandler(ActionEvent e);
	
	public void mediumHandler(ActionEvent e);
	
	public void hardHandler(ActionEvent e);
	
	public void newGameHandler(ActionEvent e);
	
	public void checkHandler(ActionEvent e);
	
	public void saveHandler(ActionEvent e);
	
	public void autoSolveHandler(ActionEvent e);
	
	public void switchToSamurai(ActionEvent e);
	
	public void switchToFreeForm(ActionEvent e);
	
}
