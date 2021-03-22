package application;

import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class SamuraiBoard {

	
	static GridPane samuraiBoard;
	static SudokuField[][] textFields = new SudokuField[21][21];
	
	public SamuraiBoard() {
		samuraiBoard = new GridPane();
		createSamurai();
	}
	
	
	
	
	public static void createSamurai() {
		samuraiBoard = new GridPane();
		samuraiBoard.setPadding(new Insets(5,5,5,5));
		
		samuraiBoard.setVgap(1);
		samuraiBoard.setHgap(1);
		
		PseudoClass right = PseudoClass.getPseudoClass("right");
	    PseudoClass bottom = PseudoClass.getPseudoClass("bottom");
	   // PseudoClass left = PseudoClass.getPseudoClass("left");
		
		for(int spalte = 0; spalte <21; spalte++) {
			for(int zeile = 0; zeile < 21; zeile++) {
				StackPane cell = new StackPane();
				cell.getStyleClass().add("cell");
				
				StackPane cellEmpty = new StackPane();
				cellEmpty.getStyleClass().add("hidden");
				
				
			if((spalte == 9 || spalte == 10 || spalte ==11) && zeile < 6) {
				
				 samuraiBoard.add(cellEmpty,spalte,zeile);
				 
			} else if((spalte == 9 || spalte == 10 || spalte ==11) && zeile > 14) {
				
				 samuraiBoard.add(cellEmpty,spalte,zeile);
			} else if(spalte <6 && (zeile ==9 || zeile == 10 || zeile == 11)) {
					
						 samuraiBoard.add(cellEmpty,spalte,zeile);
			} else if(spalte > 14 &&(zeile ==9 || zeile == 10 || zeile == 11)) {
				
				 samuraiBoard.add(cellEmpty,spalte,zeile);
			} else {
				
				SudokuField sudokuField = new SudokuField("0");
				textFields[spalte][zeile] = sudokuField;
				cell.pseudoClassStateChanged(right, spalte == 2 || spalte == 5 || spalte == 8 || spalte == 11 || spalte ==14 || spalte == 17);
	            cell.pseudoClassStateChanged(bottom, zeile == 2 || zeile == 5 ||zeile ==8 ||zeile == 11|| zeile == 14 || zeile == 17);
	            cellEmpty.pseudoClassStateChanged(right, spalte == 5);
	           
				
				 sudokuField.setStyle("-fx-pref-width: 2em;");
				 cell.getChildren().add(sudokuField);
				 samuraiBoard.add(cell,spalte,zeile);
			}
			}
		}
		
		samuraiBoard.setAlignment(Pos.CENTER);
	      samuraiBoard.add(new Line(0,0,0,0),1,1);      
		
		
		
		
		
		
		
		
	}
	
	
	public GridPane getGridPane() {
		return samuraiBoard;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
