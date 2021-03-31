package logic;

public class SamuraiLogic extends BasicGameLogic {
	
	private Cell[] cells;
	private Cell[] cellsCenter;
	private Cell[] cellsOne;
	private Cell[] cellsTwo;
	private Cell[] cellsThree;
	private Cell[] cellsFour;
	
	public SamuraiLogic(Gamestate gamestate, double timer, boolean isCorrect) {
		super(gamestate, timer, isCorrect);
		this.cells = new Cell[441];
		this.cellsCenter = new Cell[81];
		this.cellsOne = new Cell[81];
		this.cellsTwo = new Cell[81];
		this.cellsFour = new Cell[81];
	}

	public Cell[] getCells() {
		return cells;
	}

	public void setCells(Cell[] cells) {
		this.cells = cells;
	}

	public Cell[] getCellsCenter() {
		return cellsCenter;
	}

	public void setCellsCenter(Cell[] cellsCenter) {
		this.cellsCenter = cellsCenter;
	}

	public Cell[] getCellsOne() {
		return cellsOne;
	}

	public void setCellsOne(Cell[] cellsOne) {
		this.cellsOne = cellsOne;
	}

	public Cell[] getCellsTwo() {
		return cellsTwo;
	}

	public void setCellsTwo(Cell[] cellsTwo) {
		this.cellsTwo = cellsTwo;
	}

	public Cell[] getCellsThree() {
		return cellsThree;
	}

	public void setCellsThree(Cell[] cellsThree) {
		this.cellsThree = cellsThree;
	}

	public Cell[] getCellsFour() {
		return cellsFour;
	}

	public void setCellsFour(Cell[] cellsFour) {
		this.cellsFour = cellsFour;
	}

	@Override
	public boolean checkRows() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkCols() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkBoxs() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkRowsUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkColsUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkBoxsUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void autofill() {
		// TODO Auto-generated method stub
		
	}

	public void fillSimple(int centralBox) {
		
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
	}
	
	@Override
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
	}

	@Override
	public void hint() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void autosolve() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void difficulty(int diff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printCells() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void manualSolve() {
		// TODO Auto-generated method stub
		
	}


}