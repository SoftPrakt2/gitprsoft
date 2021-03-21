package application;

import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
	sudokuBoard.setPadding(new Insets(5,5,5,5));
	
	sudokuBoard.setVgap(1);
	sudokuBoard.setHgap(1);
	
	  PseudoClass right = PseudoClass.getPseudoClass("right");
      PseudoClass bottom = PseudoClass.getPseudoClass("bottom");
	

	for (int blockC = 0; blockC < 9 ; blockC++) {
        for (int blockRow = 0; blockRow < 9; blockRow++) {
        	StackPane cell = new StackPane();
        	cell.getStyleClass().add("cell");
        	
               SudokuField sudokuField = new SudokuField("0");
               textFields[blockC][blockRow] = sudokuField;
               cell.pseudoClassStateChanged(right, blockC == 2 || blockC == 5);
               cell.pseudoClassStateChanged(bottom, blockRow == 2 || blockRow == 5);
                sudokuField.setStyle("-fx-pref-width: 2em;");
                cell.getChildren().add(sudokuField);
                
                sudokuBoard.add(cell,blockC,blockRow);
                }
            }


        
       sudokuBoard.setAlignment(Pos.CENTER);
      sudokuBoard.add(new Line(0,0,0,0),1,1);      
      
   
	}
    

	
	
	

	
	
	public GridPane getGridPane() {
		return sudokuBoard;
	}

}