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
	static int difficulty = 0;
	
	public SudokuController(SudokuScene scene) {
		this.scene = scene;
	}
	
	
	
	public void createGameHandler(ActionEvent e) {
		
		SudokuField[][] fields = scene.getBoard().getField();
		
		logic.autofill();
		logic.fill();
		logic.difficulty(difficulty);
		
	

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				String number = Integer.toString(logic.getCells()[j][i].getValue());
				if(fields[i][j].getText().equals("0")) {
				fields[i][j].setText(number);
				}
				
				scene.startTime = System.currentTimeMillis();
			}
		}
		
		logic.autoSolve();
		logic.printCells();
		
		
	}
	
	
	public void enableEditHandler(ActionEvent e) {
		
		SudokuField[][] cellArray = scene.getBoard().getField();
	
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
					if(!logic.getCells()[j][i].getIsReal())
					cellArray[i][j].setDisable(false);
				}
			}
	}
		
//	public void checkHandler(ActionEvent e) {
//		SudokuField[][] fields = scene.getBoard().getField();
//		System.out.println();
		
		
		//problem stand jetzt wir haben 2 verschiedene arrays, eines für die logik das andere für die gui, in der gui ist ein array von sudokufeldern und in der logik eines von cells
		//stand jetzt kann man keine listener machen weil sich beim sudoku array nichts verändert sondern nur beim logik array, die änderungen werden dann immer manuell mit getvalue ins sudoku array reinkopiert
		
		
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				System.out.println(fields[i][j].getText());
//			}
//		}
//	}
	
		public void easyHandler(ActionEvent e) {
			difficulty = 100;
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
				logic.fill();
				logic.difficulty(difficulty);
		
				for (int x = 0; x < 9; x++) {
					for (int y = 0; y < 9; y++) {
				String number = Integer.toString(logic.getCells()[y][x].getValue());
					if(cellArray[x][y].getText().equals("0")) {
						cellArray[x][y].setText(number);
					
				}
			}
	}
	
	}
	
	
	
	
	public void autoSolveHandler(ActionEvent e) {
		SudokuField[][] cellArray = scene.getBoard().getField();
		
		logic.autoSolve();
		logic.printCells();
		
		logic.connectArrays(cellArray);
		
	}
		
		
	public void checkHandler(ActionEvent e) {
		SudokuField[][] cellArray = scene.getBoard().getField();
		logic.autoSolve();
		logic.compareResult(cellArray);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

