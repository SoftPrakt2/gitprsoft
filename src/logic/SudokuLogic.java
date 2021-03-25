package logic;

public class SudokuLogic extends BasicGameLogic {

	private Cell[] cells;

	public SudokuLogic(Gamestate gamestate, double timer, boolean isCorrect) {
		super(gamestate, timer, isCorrect);
		this.cells = new Cell[81];
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

	public void fill() {
		int a;
		int count;
		int durchlaufe = 100;
		int universal = 0;
		boolean isTrueOrFalse;
		for (int k = 0; k < this.cells.length; k++) {
			count = 0;
			a = (int) (Math.random()*(10 - 1)) + 1;

			this.cells[k].setValue(a);
			isTrueOrFalse = valid();
			while (isTrueOrFalse == false) {
				count++;
				universal++;
				a = (int) (Math.random()*(10 - 1)) + 1;

				this.cells[k].setValue(a);
				isTrueOrFalse = valid();
				 if (count == durchlaufe && k <9) {for(int r = 0; r <= k; r++ ) {cells[r].setValue(0); }  k=0;  }
				 else if (count == durchlaufe && k <18) {for(int r = 9; r <= k; r++ ) {cells[r].setValue(0); } k=9;}																			
				 else if (count == durchlaufe && k <27) {for(int r = 18; r <=k; r++ ) {cells[r].setValue(0); } k=18; }
				 else if (count == durchlaufe && k <36) {for(int r = 27; r <=k; r++ ) {cells[r].setValue(0); }k=27;}
				 else if (count == durchlaufe && k <45) {for(int r =36; r <=k; r++ ) {cells[r].setValue(0); } k=36; }
				 else if (count == durchlaufe && k <54) {for(int r = 45; r <=k; r++ ) {cells[r].setValue(0); } k=45; }
				 else if (count == durchlaufe && k <63) {for(int r = 54; r <=k; r++ ) {cells[r].setValue(0); } k=54;} 
				 else if (count == durchlaufe && k <72) {for(int r = 63; r <=k; r++ ) {cells[r].setValue(0); } k=63; }
				 else if (count == durchlaufe && k <81) {for(int r = 72; r <=k; r++ ) {cells[r].setValue(0); } k=72;}
					
			}
		}
		System.out.println("Universalcount: "+universal);
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
	
	public void printFelder() {
		for (int i = 0; i < 81; i++) {
			if (i %9 == 0) {
				System.out.println("  ");
			}
			int val = this.cells[i].getValue();
				System.out.print(val+" ");
		}
	}
}
