package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;

public class Playfield extends GridPane {
	
	static GridPane sudokuBoard;
	static SudokuField[][] textFields = new SudokuField[9][9];
	
	public Playfield() {
		sudokuBoard = new GridPane();
		createBoard();
		
	}

	
	public static void createBoard() {
	sudokuBoard = new GridPane();
	sudokuBoard.setPadding(new Insets(10,10,10,10));
	
	sudokuBoard.setVgap(5);
	sudokuBoard.setHgap(5);
	

	for (int blockC = 0; blockC < 9 ; blockC++) {
        for (int blockRow = 0; blockRow < 9; blockRow++) {
               SudokuField sudokuField = new SudokuField("0");
               textFields[blockC][blockRow] = sudokuField;
            
                sudokuField.setStyle("-fx-pref-width: 2em;");
                sudokuField.setAlignment(Pos.CENTER);
                 
                   sudokuBoard.add(sudokuField, blockC, blockRow);
                    
                }
            }


        
       sudokuBoard.setAlignment(Pos.CENTER);
      sudokuBoard.add(new Line(0,0,0,0),1,1);       }
    

	
	
	

	
	
	public GridPane getGridPane() {
		return sudokuBoard;
	}

}