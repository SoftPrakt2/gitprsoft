package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.Cell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import logic.Gamestate;
import logic.SudokuLogic;

public class SudokuController {
	
	SudokuScene scene;
	SudokuLogic logic = new SudokuLogic(Gamestate.OPEN,0.0,false);
	 int difficulty = 0;
	
	public SudokuController(SudokuScene scene) {
		this.scene = scene;
	}
	
	
	
	public void playHandler(ActionEvent e) {
		
		SudokuField[][] fields = scene.getBoard().getField();
		
		logic.autofill();
		logic.fill(difficulty);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				String number = Integer.toString(logic.cells[i][j].getValue());
				if(fields[i][j].getText().equals("0")) {
				fields[i][j].setText(number);
				}
				System.out.println(fields[i][j].getText());
				
				scene.startTime = System.currentTimeMillis();
			}
		}
		
	}
	
	
	public void manuelHandler(ActionEvent e) {
		
		SudokuField[][] cellArray = scene.getBoard().getField();
	
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
					if(!logic.cells[i][j].getIsReal())
					cellArray[i][j].setDisable(false);
				}
			}
	}
		
	public void checkHandler(ActionEvent e) {
		SudokuField[][] fields = scene.getBoard().getField();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.println(fields[i][j].getText());
			}
		}
	}
	
		public void easyHandler(ActionEvent e) {
			difficulty = 6;
		}
		
	public void mediumHandler(ActionEvent e) {
		difficulty = 5;
	}
		
	public void hardHandler(ActionEvent e) {
		difficulty = 1;
	}
		
		
	public void newGameHandler(ActionEvent e) {
		SudokuField[][] cellArray = scene.getBoard().getField();
		
		
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
					cellArray[i][j].clear();
					cellArray[i][j].setText("0");
			}
		}
				
				logic.autofill();
				logic.fill(difficulty);
		
				for (int x = 0; x < 9; x++) {
					for (int y = 0; y < 9; y++) {
				String number = Integer.toString(logic.cells[x][y].getValue());
					if(cellArray[x][y].getText().equals("0")) {
						cellArray[x][y].setText(number);
					
				}
			}
		
		
	

		
	}
	
	}
	
	
	
	
	
	
	
	//test für speicher und lade sachen, sicher besser in anderer klasse
	
	FileChooser fileChooser = new FileChooser();
	
	
	
	public void saveHandler(ActionEvent e) {
		
		fileChooser.setInitialDirectory(new File("d:/sudoku"));
		fileChooser.setInitialFileName("sudoku");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("text file","*.txt"));
		
		
		
	File file= fileChooser.showSaveDialog(Main.getStage());
		
	try {
		FileWriter filew = new FileWriter(file);
		BufferedWriter buf = new BufferedWriter(filew);
		buf.write("test");
		buf.close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	fileChooser.setInitialDirectory(file.getParentFile());
	
	
	
}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

