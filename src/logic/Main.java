package logic;

public class Main {

	public static void main(String[]args) {
		
		SudokuLogic test = new SudokuLogic(Gamestate.OPEN, 0.0, false);
		
		test.autofill();
		
////		test.setCell(4, 0);
////		test.setCell(6, 1);
////		test.setCell(3, 2);
////		test.setCell(8, 3);
////		test.setCell(7, 4);
//		test.setCell(2, 5);
////		test.setCell(1, 6);
////		test.setCell(9, 7);
////		test.setCell(5, 8);
////		test.setCell(1, 9);
////		test.setCell(8, 10);
////		test.setCell(5, 11);
////		test.setCell(9, 12);
////		test.setCell(6, 13);
////		test.setCell(4, 14);
////		test.setCell(3, 15);
////		test.setCell(7, 16);
////		test.setCell(2, 17);
////		test.setCell(2, 18);
////		test.setCell(7, 19);
////		test.setCell(9, 20);
////		test.setCell(1, 21);
////		test.setCell(5, 22);
////		test.setCell(3, 23);
////		test.setCell(4, 24);
////		test.setCell(8, 25);
////		test.setCell(6, 26);
////		test.setCell(6, 27);
////		test.setCell(2, 28);
////		test.setCell(1, 29);
////		test.setCell(3, 30);
////		test.setCell(8, 31);
////		test.setCell(9, 32);
////		test.setCell(7, 33);
////		test.setCell(5, 34);
////		test.setCell(4, 35);
////		test.setCell(5, 36);
////		test.setCell(3, 37);
////		test.setCell(8, 38);
////		test.setCell(2, 39);
////		test.setCell(4, 40);
////		test.setCell(7, 41);
////		test.setCell(6, 42);
////		test.setCell(1, 43);
////		test.setCell(9, 44);
////		test.setCell(7, 45);
////		test.setCell(9, 46);
////		test.setCell(4, 47);
////		test.setCell(5, 48);
////		test.setCell(1, 49);
//		test.setCell(6, 50);
////		test.setCell(2, 51);
////		test.setCell(3, 52);
////		test.setCell(8, 53);
////		test.setCell(8, 54);
////		test.setCell(1, 55);
////		test.setCell(2, 56);
////		test.setCell(4, 57);
////		test.setCell(3, 58);
////		test.setCell(5, 59);
////		test.setCell(9, 60);
////		test.setCell(6, 61);
////		test.setCell(7, 62);
////		test.setCell(3, 63);
////		test.setCell(4, 64);
////		test.setCell(6, 65);
////		test.setCell(7, 66);
////		test.setCell(9, 67);
////		test.setCell(8, 68);
////		test.setCell(5, 69);
////		test.setCell(2, 70);
////		test.setCell(1, 71);
////		test.setCell(9, 72);
////		test.setCell(5, 73);
////		test.setCell(7, 74);
////		test.setCell(6, 75);
////		test.setCell(2, 76);
//		test.setCell(1, 77);
////		test.setCell(8, 78);
////		test.setCell(4, 79);
////		test.setCell(3, 80);
		
		
		
		
		
		
		
		test.setCell(3, 0);
		test.setCell(4, 1);
		test.setCell(6, 4);
		test.setCell(2, 6);
		test.setCell(9, 8);

		test.setCell(2, 9);
		test.setCell(8, 11);
		test.setCell(4, 12);
		test.setCell(9, 13);
		test.setCell(6, 17);

		test.setCell(2, 28);
		test.setCell(3, 30);
		test.setCell(1, 31);

		test.setCell(4, 38);
		test.setCell(1, 42);

		test.setCell(2, 49);
		test.setCell(5, 50);
		test.setCell(4, 52);

		test.setCell(9, 63);
		test.setCell(5, 67);
		test.setCell(1, 68);
		test.setCell(4, 69);
		test.setCell(3, 71);

		test.setCell(4, 72);
		test.setCell(3, 74);
		test.setCell(7, 76);
		test.setCell(6, 79);
		test.setCell(8, 80);
		
		
//		test.setCell(4, 0);
//		test.setCell(5, 2);
//		test.setCell(2, 4);
//		test.setCell(7, 12);
//		test.setCell(5, 13);
//		test.setCell(4, 21);
//		test.setCell(3, 26);
//		test.setCell(2, 28);
//		test.setCell(8, 29);
//		test.setCell(6, 35);
//		test.setCell(7, 42);
//		test.setCell(1, 44);
//		test.setCell(8, 46);
//		test.setCell(9, 49);
//		test.setCell(3, 56);
//		test.setCell(2, 57);
//		test.setCell(7, 58);
//		test.setCell(1, 65);
//		test.setCell(6, 69);
//		test.setCell(9, 70);
//		test.setCell(7, 74);
//		test.setCell(6, 75);
//		test.setCell(1, 79);
		
		
		test.manualSolve();
		
		test.printCells2();
	}
}
