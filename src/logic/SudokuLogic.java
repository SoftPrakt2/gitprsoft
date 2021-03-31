package logic;

public class SudokuLogic extends BasicGameLogic {

	private Cell[] cells;

	public SudokuLogic(Gamestate gamestate, double timer, boolean isCorrect) {
		super(gamestate, timer, isCorrect);
		this.cells = new Cell[81];
	}

	public Cell[] getCells() {
		return cells;
	}

	public void setCells(Cell[] cells) {
		this.cells = cells;
	}

	@Override
	public boolean checkRows() {
		String compare = "";
		for (int k = 1; k <= 9; k++) {
			for (int i = 0; i < this.cells.length; i++) {
				int rowRow = this.cells[i].getRow();
				if (rowRow == k && this.cells[i].getValue() != 0) {
					if (compare.contains("" + this.cells[i].getValue())) {

						return false;
					} else {
						compare = compare + "" + this.cells[i].getValue();
					}
				}
			}
			compare = "";
		}
		return true;
	}

	@Override
	public boolean checkBoxs() {
		String compare = "";
		for (int k = 1; k <= 9; k++) {
			for (int i = 0; i < this.cells.length; i++) {
				int rowBox = this.cells[i].getBox();
				if (rowBox == k && this.cells[i].getValue() != 0) {
					if (compare.contains("" + this.cells[i].getValue())) {

						return false;
					} else {
						compare = compare + "" + this.cells[i].getValue();
					}
				}
			}
			compare = "";
		}
		return true;
	}

	@Override
	public boolean checkCols() {
		String compare = "";
		for (int k = 1; k <= 9; k++) {
			for (int i = 0; i < this.cells.length; i++) {
				int colCol = this.cells[i].getCol();
				if (colCol == k && this.cells[i].getValue() != 0) {
					if (compare.contains("" + this.cells[i].getValue())) {

						return false;
					} else {
						compare = compare + "" + this.cells[i].getValue();
					}
				}
			}
			compare = "";
		}
		return true;
	}

	@Override
	public boolean checkRowsUser() {
		String compare = "";
		for (int k = 1; k <= 9; k++) {
			for (int i = 0; i < this.cells.length; i++) {
				int rowRow = this.cells[i].getRow();
				if (rowRow == k && this.cells[i].getGuess() != 0) {
					if (compare.contains("" + this.cells[i].getGuess())) {

						return false;
					} else {
						compare = compare + "" + this.cells[i].getGuess();
					}
				}
			}
			compare = "";
		}
		return true;
	}

	@Override
	public boolean checkBoxsUser() {
		String compare = "";
		for (int k = 1; k <= 9; k++) {
			for (int i = 0; i < this.cells.length; i++) {
				int rowBox = this.cells[i].getBox();
				if (rowBox == k && this.cells[i].getGuess() != 0) {
					if (compare.contains("" + this.cells[i].getGuess())) {

						return false;
					} else {
						compare = compare + "" + this.cells[i].getGuess();
					}
				}
			}
			compare = "";
		}
		return true;
	}

	@Override
	public boolean checkColsUser() {
		String compare = "";
		for (int k = 1; k <= 9; k++) {
			for (int i = 0; i < this.cells.length; i++) {
				int colCol = this.cells[i].getCol();
				if (colCol == k && this.cells[i].getGuess() != 0) {
					if (compare.contains("" + this.cells[i].getGuess())) {

						return false;
					} else {
						compare = compare + "" + this.cells[i].getGuess();
					}
				}
			}
			compare = "";
		}
		return true;
	}

	public void fill() {
		int a;
		int count;
		int durchlaufe = 100;
		int universal = 0;
		boolean isTrueOrFalse;
		for (int k = 0; k < this.cells.length; k++) {
			count = 0;
			a = (int) (Math.random() * (10 - 1)) + 1;

			this.cells[k].setValue(a);
			isTrueOrFalse = valid();
			while (isTrueOrFalse == false) {
				count++;
				universal++;
				a = (int) (Math.random() * (10 - 1)) + 1;

				this.cells[k].setValue(a);
				isTrueOrFalse = valid();
				if (count == durchlaufe && k < 9) {
					for (int r = 0; r <= k; r++) {
						cells[r].setValue(0);
					}
					k = 0;
				} else if (count == durchlaufe && k < 18) {
					for (int r = 9; r <= k; r++) {
						cells[r].setValue(0);
					}
					k = 9;
				} else if (count == durchlaufe && k < 27) {
					for (int r = 18; r <= k; r++) {
						cells[r].setValue(0);
					}
					k = 18;
				} else if (count == durchlaufe && k < 36) {
					for (int r = 27; r <= k; r++) {
						cells[r].setValue(0);
					}
					k = 27;
				} else if (count == durchlaufe && k < 45) {
					for (int r = 36; r <= k; r++) {
						cells[r].setValue(0);
					}
					k = 36;
				} else if (count == durchlaufe && k < 54) {
					for (int r = 45; r <= k; r++) {
						cells[r].setValue(0);
					}
					k = 45;
				} else if (count == durchlaufe && k < 63) {
					for (int r = 54; r <= k; r++) {
						cells[r].setValue(0);
					}
					k = 54;
				} else if (count == durchlaufe && k < 72) {
					for (int r = 63; r <= k; r++) {
						cells[r].setValue(0);
					}
					k = 63;
				} else if (count == durchlaufe && k < 81) {
					for (int r = 72; r <= k; r++) {
						cells[r].setValue(0);
					}
					k = 72;
				}
			}
		}
		System.out.println("Universalcount: " + universal);
	}

	
	public void manualSolve() {
		int a;
		int singleRowCount;
		int multipleRowCount;
		int globalCount;
		int durchlaufe = 100;
		int universal = 0;
		boolean isTrueOrFalse;
		
		for (int i = 0; i < this.cells.length; i++) {
            this.cells[i].setValue(this.cells[i].getGuess());
        }
		multipleRowCount = 0;
		globalCount = 0;
		
		for (int k = 0; k < this.cells.length; k++) {
			if (!this.cells[k].getIsReal()) {
				
				singleRowCount = 0;
				isTrueOrFalse = true;
				
				a = (int) (Math.random() * (10 - 1)) + 1;
				this.cells[k].setValue(a);
				isTrueOrFalse = valid();
				
				while (isTrueOrFalse == false) {
					singleRowCount++;
					multipleRowCount++;
					globalCount++;
					
					universal++;
					
					a = (int) (Math.random() * (10 - 1)) + 1;
					this.cells[k].setValue(a);
					isTrueOrFalse = valid();

					if (globalCount > 25000 && k < 81) {
						for (int r = 0; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
							cells[r].setValue(0);
							}
						}
						k = 0;
						globalCount = 0;
						multipleRowCount = 0;
						singleRowCount = 0;
//						System.out.println("GLOBAL zurückgesetzt");
					}
					
					if (multipleRowCount > 3000 && k < 27) {
						for (int r = 0; r <= k; r++) {
							if (!this.cells[k].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 0;
						multipleRowCount = 0;
						singleRowCount = 0;
//						System.out.println("MultipleRow zurückgesetzt - 1");
					}
					if (multipleRowCount > 3000 && k < 54) {
						for (int r = 27; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 27;
						multipleRowCount = 0;
						singleRowCount = 0;
//						System.out.println("MultipleRow zurückgesetzt - 2");
					}
					if (multipleRowCount > 3000 && k < 81) {
						for (int r = 54; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 54;
						multipleRowCount = 0;
						singleRowCount = 0;
//						System.out.println("MultipleRow zurückgesetzt - 3");
					}

					if (singleRowCount == durchlaufe && k < 9) {
						for (int r = 0; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 0;
						singleRowCount = 0;
//						System.out.println("SingleRow zurückgesetzt - 1");
					} else if (singleRowCount == durchlaufe && k < 18) {
						for (int r = 9; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 9;
						singleRowCount = 0;
//						System.out.println("SingleRow zurückgesetzt - 2");
					} else if (singleRowCount == durchlaufe && k < 27) {
						for (int r = 18; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 18;
						singleRowCount = 0;
//						System.out.println("SingleRow zurückgesetzt - 3");
					} else if (singleRowCount == durchlaufe && k < 36) {
						for (int r = 27; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 27;
						singleRowCount = 0;
//						System.out.println("SingleRow zurückgesetzt - 4");
					} else if (singleRowCount > durchlaufe && k < 45) {
						for (int r = 36; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 36;
//						System.out.println("SingleRow zurückgesetzt - 5");
					} else if (singleRowCount == durchlaufe && k < 54) {
						for (int r = 45; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 45;
						singleRowCount = 0;
//						System.out.println("SingleRow zurückgesetzt - 6");
					} else if (singleRowCount == durchlaufe && k < 63) {
						for (int r = 54; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 54;
						singleRowCount = 0;
//						System.out.println("SingleRow zurückgesetzt - 7");
					} else if (singleRowCount == durchlaufe && k < 72) {
						for (int r = 63; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 63;
						singleRowCount = 0;
//						System.out.println("SingleRow zurückgesetzt - 8");
					} else if (singleRowCount == durchlaufe && k < 81) {
						for (int r = 72; r <= k; r++) {
							if (!this.cells[r].getIsReal()) {
								cells[r].setValue(0);
								}
						}
						k = 72;
						singleRowCount = 0;
//						System.out.println("SingleRow zurückgesetzt - 9");
					}
					
//					System.out.println();
//					System.out.println();
//					System.out.println();
//					System.out.println();
//					System.out.println("Global Count = " + globalCount);
//					System.out.println("Multiple Count = " + multipleRowCount);
//					System.out.println("Single Count = " + singleRowCount);
//					printCells2();
				}
			} else {
				this.cells[k].setValue(this.cells[k].getGuess());
			}
		}
		System.out.println("Universalcount: " + universal);
	}

	@Override
	public void hint() {

	}

	@Override
	public void autosolve() {
		for (int i = 0; i < 81; i++) {
			this.cells[i].setGuess(this.cells[i].getValue());
		}
	}

	@Override
	public void autofill() {
		int c = 0;
		int d = 1;
		for (int a = 1; a <= 9; a++) {
			for (int b = 1; b <= 9; b++) {
				if (a <= 4 && b <= 4) {
					d = 1;
				}
				if (a <= 4 && b >= 4) {
					d = 4;
				}
				if (a <= 4 && b >= 7) {
					d = 7;
				}

				if (a >= 4 && b <= 4) {
					d = 2;
				}
				if (a >= 4 && b >= 4) {
					d = 5;
				}
				if (a >= 4 && b >= 7) {
					d = 8;
				}

				if (a >= 7 && b <= 4) {
					d = 3;
				}
				if (a >= 7 && b >= 4) {
					d = 6;
				}
				if (a >= 7 && b >= 7) {
					d = 9;
				}

				Cell cell = new Cell(c, a, b, d, 0, 0);
				cells[c] = cell;
				c++;

			}
		}
	}

	public void difficulty(int diff) {
		double effect = 0;
		if (diff == 0) {
			effect = 0.9;
		}
		if (diff == 1) {
			effect = 0.7;
		}
		if (diff == 2) {
			effect = 0.5;
		}
		if (diff == 3) {
			effect = 0.3;
		}
		if (diff > 3) {
			effect = 0.2;
		}

		for (int i = 0; i < this.cells.length; i++) {
			if (Math.random() < effect) {
				int makeVisible = this.cells[i].getValue();
				this.cells[i].setGuess(makeVisible);
			}
		}
	}

	public void setCell(int x, int where) {
		this.cells[where].setGuess(x);
		this.cells[where].setIsReal(true);
	}

	public void printCells() {
		for (int i = 0; i < 81; i++) {
			if (i % 9 == 0) {
				System.out.println("  ");
			}
			int val = this.cells[i].getGuess();
			System.out.print(val + " ");
		}
	}
	
	public void printCells2() {
		for (int i = 0; i < 81; i++) {
			if (i % 9 == 0) {
				System.out.println("  ");
			}
			int val = this.cells[i].getValue();
			System.out.print(val + " ");
		}
	}

}
