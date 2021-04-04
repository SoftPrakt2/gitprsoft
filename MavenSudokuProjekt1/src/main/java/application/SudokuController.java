package application;

import javafx.event.ActionEvent;
import javafx.scene.control.Cell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import logic.Gamestate;
import logic.SudokuLogic;

public class SudokuController {
	
	SudokuScene scene;
	SudokuLogic logic = new SudokuLogic(Gamestate.OPEN,0.0,false);
	
	
	public SudokuController(SudokuScene scene) {
		this.scene = scene;
	}
	
	
	
	public void playHandler(ActionEvent e) {
		
		SudokuField[][] fields = scene.getBoard().getField();
		
		logic.autofill();
		logic.fill(6);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				String number = Integer.toString(logic.cells[i][j].getValue());
				if(fields[i][j].getText().equals("1")) {
				fields[i][j].setText(number);
				}
				//System.out.println(fields[i][j].getText());
				
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
	
	
	
	
	
	
	
	
	
	
	
	
	
}
