//package logic;
//
//public class SudokuLogic extends BasicGameLogic {
//
//	private Cell[] cells;
//
//	public SudokuLogic(Gamestate gamestate, double timer, boolean isCorrect) {
//		super(gamestate, timer, isCorrect);
//		this.cells = new Cell[81];
//	}
//
//	//just a test
//	public Cell[] getCells() {
//		return cells;
//	}
//
//	public void setCells(Cell[] cells) {
//		this.cells = cells;
//	}
//
//	@Override
//	public boolean checkRows() {
//		String compare = "";
//		for (int k = 1; k <= 9; k++) {
//			for (int i = 0; i < this.cells.length; i++) {
//				int rowRow = this.cells[i].getRow();
//				if (rowRow == k && this.cells[i].getValue() != 0) {
//					if (compare.contains("" + this.cells[i].getValue())) {
//
//						return false;
//					} else {
//						compare = compare + "" + this.cells[i].getValue();
//					}
//				}
//			}
//			compare = "";
//		}
//		return true;
//	}
//
//	@Override
//	public boolean checkBoxs() {
//		String compare = "";
//		for (int k = 1; k <= 9; k++) {
//			for (int i = 0; i < this.cells.length; i++) {
//				int rowBox = this.cells[i].getBox();
//				if (rowBox == k && this.cells[i].getValue() != 0) {
//					if (compare.contains("" + this.cells[i].getValue())) {
//
//						return false;
//					} else {
//						compare = compare + "" + this.cells[i].getValue();
//					}
//				}
//			}
//			compare = "";
//		}
//		return true;
//	}
//
//	@Override
//	public boolean checkCols() {
//		String compare = "";
//		for (int k = 1; k <= 9; k++) {
//			for (int i = 0; i < this.cells.length; i++) {
//				int colCol = this.cells[i].getCol();
//				if (colCol == k && this.cells[i].getValue() != 0) {
//					if (compare.contains("" + this.cells[i].getValue())) {
//
//						return false;
//					} else {
//						compare = compare + "" + this.cells[i].getValue();
//					}
//				}
//			}
//			compare = "";
//		}
//		return true;
//	}
//
//	@Override
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
//		return true;
//	}
//
//	@Override
//	public boolean checkBoxsUser() {
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
//		return true;
//	}
//
//	@Override
//	public boolean checkColsUser() {
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
//
//	public void fill() {
//		int a;
//		int count;
//		int durchlaufe = 100;
//		int universal = 0;
//		boolean isTrueOrFalse;
//		for (int k = 0; k < this.cells.length; k++) {
//			count = 0;
//			a = (int) (Math.random() * (10 - 1)) + 1;
//
//			this.cells[k].setValue(a);
//			isTrueOrFalse = valid();
//			while (isTrueOrFalse == false) {
//				count++;
//				universal++;
//				a = (int) (Math.random() * (10 - 1)) + 1;
//
//				this.cells[k].setValue(a);
//				isTrueOrFalse = valid();
//				if (count == durchlaufe && k < 9) {
//					for (int r = 0; r <= k; r++) {
//						cells[r].setValue(0);
//					}
//					k = 0;
//				} else if (count == durchlaufe && k < 18) {
//					for (int r = 9; r <= k; r++) {
//						cells[r].setValue(0);
//					}
//					k = 9;
//				} else if (count == durchlaufe && k < 27) {
//					for (int r = 18; r <= k; r++) {
//						cells[r].setValue(0);
//					}
//					k = 18;
//				} else if (count == durchlaufe && k < 36) {
//					for (int r = 27; r <= k; r++) {
//						cells[r].setValue(0);
//					}
//					k = 27;
//				} else if (count == durchlaufe && k < 45) {
//					for (int r = 36; r <= k; r++) {
//						cells[r].setValue(0);
//					}
//					k = 36;
//				} else if (count == durchlaufe && k < 54) {
//					for (int r = 45; r <= k; r++) {
//						cells[r].setValue(0);
//					}
//					k = 45;
//				} else if (count == durchlaufe && k < 63) {
//					for (int r = 54; r <= k; r++) {
//						cells[r].setValue(0);
//					}
//					k = 54;
//				} else if (count == durchlaufe && k < 72) {
//					for (int r = 63; r <= k; r++) {
//						cells[r].setValue(0);
//					}
//					k = 63;
//				} else if (count == durchlaufe && k < 81) {
//					for (int r = 72; r <= k; r++) {
//						cells[r].setValue(0);
//					}
//					k = 72;
//				}
//			}
//		}
//		System.out.println("Universalcount: " + universal);
//	}
//
//	
//	public void manualSolve() {
//		int a;
//		int singleRowCount;
//		int multipleRowCount;
//		int globalCount;
//		int durchlaufe = 100;
//		int universal = 0;
//		boolean isTrueOrFalse;
//		
//		for (int i = 0; i < this.cells.length; i++) {
//            this.cells[i].setValue(this.cells[i].getGuess());
//        }
//		multipleRowCount = 0;
//		globalCount = 0;
//		
//		for (int k = 0; k < this.cells.length; k++) {
//			if (!this.cells[k].getIsReal()) {
//				
//				singleRowCount = 0;
//				isTrueOrFalse = true;
//				
//				a = (int) (Math.random() * (10 - 1)) + 1;
//				this.cells[k].setValue(a);
//				isTrueOrFalse = valid();
//				
//				while (isTrueOrFalse == false) {
//					singleRowCount++;
//					multipleRowCount++;
//					globalCount++;
//					
//					universal++;
//					
//					a = (int) (Math.random() * (10 - 1)) + 1;
//					this.cells[k].setValue(a);
//					isTrueOrFalse = valid();
//
//					if (globalCount > 25000 && k < 81) {
//						for (int r = 0; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//							cells[r].setValue(0);
//							}
//						}
//						k = 0;
//						globalCount = 0;
//						multipleRowCount = 0;
//						singleRowCount = 0;
////						System.out.println("GLOBAL zurückgesetzt");
//					}
//					
//					if (multipleRowCount > 3000 && k < 27) {
//						for (int r = 0; r <= k; r++) {
//							if (!this.cells[k].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 0;
//						multipleRowCount = 0;
//						singleRowCount = 0;
////						System.out.println("MultipleRow zurückgesetzt - 1");
//					}
//					if (multipleRowCount > 3000 && k < 54) {
//						for (int r = 27; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 27;
//						multipleRowCount = 0;
//						singleRowCount = 0;
////						System.out.println("MultipleRow zurückgesetzt - 2");
//					}
//					if (multipleRowCount > 3000 && k < 81) {
//						for (int r = 54; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 54;
//						multipleRowCount = 0;
//						singleRowCount = 0;
////						System.out.println("MultipleRow zurückgesetzt - 3");
//					}
//
//					if (singleRowCount == durchlaufe && k < 9) {
//						for (int r = 0; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 0;
//						singleRowCount = 0;
////						System.out.println("SingleRow zurückgesetzt - 1");
//					} else if (singleRowCount == durchlaufe && k < 18) {
//						for (int r = 9; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 9;
//						singleRowCount = 0;
////						System.out.println("SingleRow zurückgesetzt - 2");
//					} else if (singleRowCount == durchlaufe && k < 27) {
//						for (int r = 18; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 18;
//						singleRowCount = 0;
////						System.out.println("SingleRow zurückgesetzt - 3");
//					} else if (singleRowCount == durchlaufe && k < 36) {
//						for (int r = 27; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 27;
//						singleRowCount = 0;
////						System.out.println("SingleRow zurückgesetzt - 4");
//					} else if (singleRowCount > durchlaufe && k < 45) {
//						for (int r = 36; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 36;
////						System.out.println("SingleRow zurückgesetzt - 5");
//					} else if (singleRowCount == durchlaufe && k < 54) {
//						for (int r = 45; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 45;
//						singleRowCount = 0;
////						System.out.println("SingleRow zurückgesetzt - 6");
//					} else if (singleRowCount == durchlaufe && k < 63) {
//						for (int r = 54; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 54;
//						singleRowCount = 0;
////						System.out.println("SingleRow zurückgesetzt - 7");
//					} else if (singleRowCount == durchlaufe && k < 72) {
//						for (int r = 63; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 63;
//						singleRowCount = 0;
////						System.out.println("SingleRow zurückgesetzt - 8");
//					} else if (singleRowCount == durchlaufe && k < 81) {
//						for (int r = 72; r <= k; r++) {
//							if (!this.cells[r].getIsReal()) {
//								cells[r].setValue(0);
//								}
//						}
//						k = 72;
//						singleRowCount = 0;
////						System.out.println("SingleRow zurückgesetzt - 9");
//					}
//					
////					System.out.println();
////					System.out.println();
////					System.out.println();
////					System.out.println();
////					System.out.println("Global Count = " + globalCount);
////					System.out.println("Multiple Count = " + multipleRowCount);
////					System.out.println("Single Count = " + singleRowCount);
////					printCells2();
//				}
//			} else {
//				this.cells[k].setValue(this.cells[k].getGuess());
//			}
//		}
//		System.out.println("Universalcount: " + universal);
//	}
//
//	@Override
//	public void hint() {
//
//	}
//
//	@Override
//	public void autosolve() {
//		for (int i = 0; i < 81; i++) {
//			this.cells[i].setGuess(this.cells[i].getValue());
//		}
//	}
//
//	@Override
//	public void autofill() {
//		int c = 0;
//		int d = 1;
//		for (int a = 1; a <= 9; a++) {
//			for (int b = 1; b <= 9; b++) {
//				if (a <= 4 && b <= 4) {
//					d = 1;
//				}
//				if (a <= 4 && b >= 4) {
//					d = 4;
//				}
//				if (a <= 4 && b >= 7) {
//					d = 7;
//				}
//
//				if (a >= 4 && b <= 4) {
//					d = 2;
//				}
//				if (a >= 4 && b >= 4) {
//					d = 5;
//				}
//				if (a >= 4 && b >= 7) {
//					d = 8;
//				}
//
//				if (a >= 7 && b <= 4) {
//					d = 3;
//				}
//				if (a >= 7 && b >= 4) {
//					d = 6;
//				}
//				if (a >= 7 && b >= 7) {
//					d = 9;
//				}
//
//				Cell cell = new Cell(c, a, b, d, 0, 0);
//				cells[c] = cell;
//				c++;
//
//			}
//		}
//	}
//
//	public void difficulty(int diff) {
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
//	}
//
//	public void setCell(int x, int where) {
//		this.cells[where].setGuess(x);
//		this.cells[where].setIsReal(true);
//	}
//
//	public void printCells() {
//		for (int i = 0; i < 81; i++) {
//			if (i % 9 == 0) {
//				System.out.println("  ");
//			}
//			int val = this.cells[i].getGuess();
//			System.out.print(val + " ");
//		}
//	}
//	
//	public void printCells2() {
//		for (int i = 0; i < 81; i++) {
//			if (i % 9 == 0) {
//				System.out.println("  ");
//			}
//			int val = this.cells[i].getValue();
//			System.out.print(val + " ");
//		}
//	}
//
//}




package logic;

public class SudokuLogic extends BasicGameLogic {

	private int[][] cells;

	public SudokuLogic(Gamestate gamestate, double timer, boolean isCorrect) {
		super(gamestate, timer, isCorrect);
		this.cells = new int[9][9];
	}

	public int[][] getCells() {
		return cells;
	}

	public void setCells(int[][] cells) {
		this.cells = cells;
	}
	
	@Override
	public boolean valid(int row, int col, int guess) {
		if (checkRow(row, guess) == true && checkCol(col, guess) == true && checkBox(row, col, guess) == true ) {
			return true;
		}
//		if(!checkRow(row, guess)) {
//			System.out.println("ROW Mistake");
//		}
//		if(!checkCol(col, guess)) {
//			System.out.println("COL Mistake");
//		}
//		if(!checkBox(row, col, guess)) {
//			System.out.println("BOX Mistake");
//		}
		return false;
	}

	@Override
	public boolean checkRow(int row, int guess) {
		for(int i = 0; i < this.cells.length; i++) {
			if(this.cells[row][i] == guess) {
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
				if(this.cells[i][j] == guess) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean checkCol(int col, int guess) {
		for(int i = 0; i < this.cells.length; i++) {
			if(this.cells[i][col]== guess) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkRowsUser() {
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
		return true;
	}

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
	public boolean checkColsUser() {
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
		return true;
	}

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
					this.cells[i][j] = a;
				}
				else {
					while(!isTrueOrFalse) {
						counter++;
						a = (int) (Math.random() * 9) + 1;
						isTrueOrFalse = valid(i, j, a);
						if(isTrueOrFalse) {
							this.cells[i][j] = a;
							break;
						}
						if(counter == 100) {
							for(int y = 0; y < cells[i].length; y++) {
								this.cells[i][y] = 0;
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
	public boolean manualSolve() {
		
		
		int a;
		boolean isTrueOrNot = false;
		
		for(int i = 0; i < this.cells.length; i++) {
			for(int j = 0; j < this.cells[i].length; j++) {
				if(this.cells[i][j] == 0) {
					for(int y = 0; y < this.cells.length; y++) {
						counter++;
//						a = (int) (Math.random() * 9) + 1;
						if(valid(i, j, y + 1)) {
							this.cells[i][j] = y + 1;
							if(manualSolve() == true) {
								return true;
							}
							else {
								this.cells[i][j] = 0;
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

	}

//	@Override
//	public void autosolve() {
//		for (int i = 0; i < 81; i++) {
//			this.cells[i].setGuess(this.cells[i].getValue());
//		}
//	}

	@Override
	public void autofill() {
//		int c = 0;
//		int d = 1;
//		for (int a = 1; a <= 9; a++) {
//			for (int b = 1; b <= 9; b++) {
//				if (a <= 4 && b <= 4) {
//					d = 1;
//				}
//				if (a <= 4 && b >= 4) {
//					d = 4;
//				}
//				if (a <= 4 && b >= 7) {
//					d = 7;
//				}
//
//				if (a >= 4 && b <= 4) {
//					d = 2;
//				}
//				if (a >= 4 && b >= 4) {
//					d = 5;
//				}
//				if (a >= 4 && b >= 7) {
//					d = 8;
//				}
//
//				if (a >= 7 && b <= 4) {
//					d = 3;
//				}
//				if (a >= 7 && b >= 4) {
//					d = 6;
//				}
//				if (a >= 7 && b >= 7) {
//					d = 9;
//				}
//
//				Cell cell = new Cell(c, a, b, d, 0, 0);
//				cells[c] = cell;
//				c++;
//
//			}
//		}
		
//		int a = 0;
//		int b = 0;
//		int c = 0;
//		int d = 0;
//		Cell cell = new Cell(0);
//		
//		for(int i = 0; i < this.cells.length; i++) {
//			for(int j = 0; j < this.cells[i].length; j++) {
//				this.cells[i][j] = cell;
//			}
//		}
//		int box = 1;
//		int uid = 0;
//		for(int i = 0; i < this.cells.length; i++) {
//			for(int j = 0; j < this.cells[i].length; j++) {
//				if(i < 3 && j < 3) {
//					box = 1;
//				}
//				else if(i < 3 && j < 3) {
//					box = 1;
//				}
//				else if(i < 3 && j < 6) {
//					box = 2;
//				}
//				else if(i < 3 && j < 9) {
//					box = 3;
//				}
//				else if(i < 6 && j < 3) {
//					box = 4;
//				}
//				else if(i < 6 && j < 6) {
//					box = 5;
//				}
//				else if(i < 6 && j < 9) {
//					box = 6;
//				}
//				else if(i < 9 && j < 3) {
//					box = 7;
//				}
//				else if(i < 9 && j < 6) {
//					box = 8;
//				}
//				else if(i < 9 && j < 9) {
//					box = 9;
//				}
//				Cell cell = new Cell(uid, i, j, box, 0, 0);
//				cells[i][j] = cell;
//				uid++;
//			}
//		}
		
		for(int i = 0; i < this.cells.length; i++) {
			for(int j = 0; j < this.cells[i].length; j++) {
				this.cells[i][j] = 0;
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
	}

	public void setCell(int col, int row, int guess) {

		this.cells[col][row] = guess;
//		this.cells[col][row].setIsReal(true);
	}

	public void printCells() {	
		for(int i = 0; i < this.cells.length; i++) {
			for(int j = 0; j < this.cells[i].length; j++) {
				System.out.print(this.cells[i][j] + " ");
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
	
	public void printCells2() {
		for(int i = 0; i < this.cells.length; i++) {
			for(int j = 0; j < this.cells[i].length; j++) {
				System.out.print(this.cells[i][j] + " ");
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

	@Override
	public void autosolve() {
		// TODO Auto-generated method stub
		
	}

}






















