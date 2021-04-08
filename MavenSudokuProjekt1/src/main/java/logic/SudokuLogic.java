package logic;

import application.SudokuField;

public class SudokuLogic extends BasicGameLogic {

	private Cell [][] cells;

	public SudokuLogic(Gamestate gamestate, double timer, boolean isCorrect) {
		super(gamestate, timer, isCorrect);
		this.cells = new Cell[9][9];
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
	@Override
	public boolean valid(int row, int col, int guess) {
		if (checkRow(row, guess) == true && checkCol(col, guess) == true && checkBox(row, col, guess) == true ) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkRow(int row, int guess) {
		for(int i = 0; i < this.cells.length; i++) {
			if(this.cells[row][i].getValue() == guess) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkCol(int col, int guess) {
		for(int i = 0; i < this.cells.length; i++) {
			if(this.cells[i][col].getValue() == guess) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean checkBox(int row, int col, int guess) {
		int r = row - row % 3;
		int c = col - col % 3;
		
		for(int i = r; i < r + 3; i++) {
			for(int j = c; j < c + 3; j++) {
				if(this.cells[i][j].getValue() == guess) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
//	public boolean checkRowsUser() {
//		String compare = "";
//		for (int k = 1; k <= 9; k++) {
//			for (int i = 0; i < this.cells.length; i++) {
//				int rowRow = this.cells[i].getRow();
//				if (rowRow == k && this.cells[i].getGuess() != 0) {
//					if (compare.contains("" + this.cells[i].getGuess())) {
//
//						return false;
//					} else {
//						compare = compare + "" + this.cells[i].getGuess();
//					}
//				}
//			}
//			compare = "";
//		}
	//	return true;
//	}

	@Override
	public boolean checkBoxsUser() {
//		String compare = "";
//		for (int k = 1; k <= 9; k++) {
//			for (int i = 0; i < this.cells.length; i++) {
//				int rowBox = this.cells[i].getBox();
//				if (rowBox == k && this.cells[i].getGuess() != 0) {
//					if (compare.contains("" + this.cells[i].getGuess())) {
//
//						return false;
//					} else {
//						compare = compare + "" + this.cells[i].getGuess();
//					}
//				}
//			}
//			compare = "";
//		}
		return true;
	}

	@Override
	//public boolean checkColsUser() {
//		String compare = "";
//		for (int k = 1; k <= 9; k++) {
//			for (int i = 0; i < this.cells.length; i++) {
//				int colCol = this.cells[i].getCol();
//				if (colCol == k && this.cells[i].getGuess() != 0) {
//					if (compare.contains("" + this.cells[i].getGuess())) {
//
//						return false;
//					} else {
//						compare = compare + "" + this.cells[i].getGuess();
//					}
//				}
//			}
//			compare = "";
//		}
//		return true;
//	}
	//erstellt generell sudoku spiel mit richtigen ziffern
	public void fill() {
		int a;
		int counter;
		int globalCounter = 0;
		boolean isTrueOrFalse = false;
		
		for(int i = 0; i < this.cells.length; i++) {
			counter = 0;
			for(int j = 0; j < this.cells[i].length; j++) {
				a = (int) (Math.random() * 9) + 1;
				isTrueOrFalse = valid(i, j, a);
				globalCounter++;
				if(isTrueOrFalse) {
					this.cells[i][j].setValue(a);
				}
				else {
					while(!isTrueOrFalse) {
						counter++;
						a = (int) (Math.random() * 9) + 1;
						isTrueOrFalse = valid(i, j, a);
						if(isTrueOrFalse) {
							this.cells[i][j].setValue(a);;
							break;
						}
						if(counter == 100) {
							for(int y = 0; y < cells[i].length; y++) {
								this.cells[i][y].setValue(0);
							}
							j = -1;
							counter = 0;
							break;
						}
						globalCounter++;
					}
				}
			}
		}
		System.out.println("Global Counter = " + globalCounter);	
	}
	
	static int counter = 0;
	
	//l�st restliches sudoku automatisch
	public boolean autoSolve() {	
		for(int i = 0; i < this.cells.length; i++) {
			for(int j = 0; j < this.cells[i].length; j++) {
				if(this.cells[i][j].getValue() == 0) {
					for(int y = 0; y < this.cells.length; y++) {
						counter++;
						if(valid(i, j, y + 1)) {
							this.cells[i][j].setValue(y + 1);
							if(autoSolve() == true) {
								return true;
							}
							else {
								this.cells[i][j].setValue(0);
							}
						}
					}
					return false;
				}
			}
		}
		System.out.println(counter);
		return true;
	}

	@Override
	public void hint() {
		int randomRow = (int)(Math.random() * 9) + 1;
		int randomCol = (int)(Math.random() * 9) + 1;
		
		for(int i = 0; i < this.cells.length; i++) {
			for(int j = 0; j < this.cells[i].length; j++) {
				if(this.cells[i][j].getValue() == 0 && i == randomRow && j == randomCol) {
					
				}
				else if(this.cells[i][j].getValue() != 0 && i == randomRow && j == randomCol) {
					randomRow = (int)(Math.random() * 9) + 1;
					randomCol = (int)(Math.random() * 9) + 1;
					i = -1;
					j = -1;
					break;
				}
			}
		}
	}

//	@Override
//	public void autosolve() {
//		for (int i = 0; i < 81; i++) {
//			this.cells[i].setGuess(this.cells[i].getValue());
//		}
//	}

	@Override
	public void autofill() {		
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;

		int box = 1;
		int uid = 0;
		for(int i = 0; i < this.cells.length; i++) {
			for(int j = 0; j < this.cells[i].length; j++) {
				if(i < 3 && j < 3) {
					box = 1;
				}
				else if(i < 3 && j < 3) {
					box = 1;
				}
				else if(i < 3 && j < 6) {
					box = 2;
				}
				else if(i < 3 && j < 9) {
					box = 3;
				}
				else if(i < 6 && j < 3) {
					box = 4;
				}
				else if(i < 6 && j < 6) {
					box = 5;
				}
				else if(i < 6 && j < 9) {
					box = 6;
				}
				else if(i < 9 && j < 3) {
					box = 7;
				}
				else if(i < 9 && j < 6) {
					box = 8;
				}
				else if(i < 9 && j < 9) {
					box = 9;
				}
				Cell cell = new Cell(uid, i, j, box, 0, 0);
				cells[i][j] = cell;
				uid++;
			}
		}
	}

	public void difficulty(int diff) {
//		double effect = 0;
//		if (diff == 0) {
//			effect = 0.9;
//		}
//		if (diff == 1) {
//			effect = 0.7;
//		}
//		if (diff == 2) {
//			effect = 0.5;
//		}
//		if (diff == 3) {
//			effect = 0.3;
//		}
//		if (diff > 3) {
//			effect = 0.2;
//		}
//
//		for (int i = 0; i < this.cells.length; i++) {
//			if (Math.random() < effect) {
//				int makeVisible = this.cells[i].getValue();
//				this.cells[i].setGuess(makeVisible);
//			}
//		}
		
		for(int i = 0; i < this.cells.length;i++) {
			for(int j = 0; j < this.cells[i].length;j++) {
			long random =(int) (Math.random()*10)+1;
			if(random <= diff) {
				this.cells[i][j].setIsReal(true);
			} else {
				this.cells[i][j].setValue(0);
			}
			}
		}
	}

	public void setCell(int col, int row, int guess) {
		this.cells[col][row].setValue(guess);;
		this.cells[col][row].setIsReal(true);
	}

	public void printCells() {	
		for(int i = 0; i < this.cells.length; i++) {
			for(int j = 0; j < this.cells[i].length; j++) {
				System.out.print(this.cells[i][j].getValue() + " ");
				if(j == 2 || j == 5) {
					System.out.print("|");
				}
			}
			System.out.println();
			if(i == 2 || i == 5 || i == 8) {
				System.out.println("-------------------");
			}
		}
	}
	
	
		//updatet den stand des sudoku arrays auf den stand des logik arrays, nach autosolve immer?
	public void connectArrays(SudokuField[][] sudokuField) {
		for(int i = 0; i < sudokuField.length; i++) {
			for(int j = 0; j < sudokuField[i].length;j++) {
			sudokuField[i][j].setText(Integer.toString(cells[j][i].getValue()));
		}
	}	
	}
	
	public boolean compareResult(SudokuField[][] sudokuField) {
			boolean result = true;
			this.autoSolve();
		
			for(int i = 0; i < sudokuField.length; i++) {
				for(int j = 0; j < sudokuField[i].length;j++) {
						if(!sudokuField[i][j].getText().equals(Integer.toString(cells[j][i].getValue())) && !sudokuField[i][j].getText().equals("0")) {
						sudokuField[i][j].setStyle("-fx-text-fill: red");
						result = false;
						}
						else {
							sudokuField[i][j].setStyle("-fx-text-fill: green");
						}
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}