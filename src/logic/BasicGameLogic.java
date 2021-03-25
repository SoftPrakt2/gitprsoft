package logic;

public abstract class BasicGameLogic{

	private Gamestate gamestate;
	private double timer;
	private boolean isCorrect;
	
	public BasicGameLogic(Gamestate gamestate, double timer, boolean isCorrect) {
		super();
		this.gamestate = gamestate;
		this.timer = timer;
		this.isCorrect = isCorrect;
	}
	
	public boolean valid(){
		if (checkRows() == true && checkCols() == true && checkBoxs() == true ) {
			return true;
		} else {
			return false;
		}
	}
	
	public abstract boolean checkRows();
	public abstract boolean checkCols();
	public abstract boolean checkBoxs();

	public abstract void autofill();
	
	public abstract void fill();
	
	public abstract void hint();
	
	public abstract void autosolve();
	
	public abstract void printFelder();
}