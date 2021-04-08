package application;

import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import logic.*;

public class SudokuBoard extends GridPane {

	 GridPane sudokuBoard;
	 SudokuField[][] textFields = new SudokuField[9][9];
	 
	 
	 
	 SudokuLogic logic = new SudokuLogic(Gamestate.OPEN,0.0,false);

	public SudokuBoard() {
	//	sudokuBoard = new GridPane();
		createBoard();
	}
	
	
	public void createBoard() {
		//SudokuLogic s = new SudokuLogic(Gamestate.DEFAULT, 0, false);
//
//		s.autofill();
//		s.fill();
//		s.difficulty(3); // 0, 1, 2 oder 3
//		s.setCell(1, 0);
//		s.setCell(2, 1);
//		s.setCell(3, 2);
//		boolean isValid = s.validUser();
//
//		Cell[] outputCells = s.getCells();

		sudokuBoard = new GridPane();
		sudokuBoard.setPadding(new Insets(5, 5, 5, 5));

		sudokuBoard.setVgap(1);
		sudokuBoard.setHgap(1);

		PseudoClass right = PseudoClass.getPseudoClass("right");
		PseudoClass bottom = PseudoClass.getPseudoClass("bottom");
		
//		logic.autofill();
//		logic.fill();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				StackPane cell = new StackPane();
				cell.getStyleClass().add("cell");


					
				SudokuField sudokuField = new SudokuField("0");
				
				textFields[i][j] = sudokuField;
				cell.pseudoClassStateChanged(right, i == 2 || i == 5);

				cell.pseudoClassStateChanged(bottom, j == 2 || j == 5);
				sudokuField.setStyle("-fx-pref-width: 2em;");
				textFields[i][j].setDisable(true);
				cell.getChildren().add(sudokuField);

				sudokuBoard.add(cell, i, j);
			}
		}
		textFields[3][4].setText("5");
		sudokuBoard.setAlignment(Pos.CENTER);
		sudokuBoard.add(new Line(0, 0, 0, 0), 1, 1);
	}

	public GridPane getGridPane() {
		return sudokuBoard;
	}

	public void fillOnClick() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				textFields[i][j].setText("7");
			}
		}
	}

	public void enableEdit() {
		for (SudokuField[] cell : textFields) {
			for (SudokuField cells : cell) {
				cells.setDisable(false);
			}
		}
	}
	
	public SudokuLogic getLogic() {
		return logic;
	}
	
	public SudokuField[][] getField() {
		return textFields;
	}
	
	public void setField(SudokuField[][] textFields) {
		this.textFields = textFields;
	}
	

}