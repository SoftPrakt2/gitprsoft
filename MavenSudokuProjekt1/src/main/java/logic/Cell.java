package logic;

public class Cell {

	// ID 1 - 81
	int uid; 
	
	// Spalte 1 - 9
	int col;
	
	// Reihe 1 - 9
	int row;	
	
	// Box 1 - 9
	int box;
	
	// Sichtbarkeit 0 oder 1 ev 2 (vorgegebne Zahlen)
	int guess;
	
	// Wert 1 - 9
	int value;


	public Cell(int uid2, int col2, int row2, int box2, int visibility2, int value2) {
		super();
		this.uid = uid2;
		this.col = col2;
		this.row = row2;
		this.box = box2;
		this.guess = visibility2;
		this.value = value2;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getBox() {
		return box;
	}

	public void setBox(int box) {
		this.box = box;
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Feld [uid=" + uid + ", col=" + col + ", row=" + row + ", box=" + box + ", guess=" + guess
				+ ", value=" + value + "]";
	}
}