public class SudokuSolver2 {
	
	Sudoku sudoku;
	
	public SudokuSolver(Sudoku sudoku) {
		this.sudoku = sudoku;
	}
	
	public boolean solveRec(int r, int c) {
		if (r==9) {
			r=0;
			c++;
			if (c==9) {
				return true;
			}
		}
		if (sudoku.getValue(r,c) != 0) {
			return solveRec(r+1, c);
		} else {
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					SimpleLinkedList<int> numbers = new SimpleLinkedList<int>;
					for (int k=1; k<=9; k++) {
						if (isPossible(r, c, k)) {
							numbers.add(k);
						}
					}
				}
			}
			numbers.reset();
			sudoku.setValue (r, c, numbers.getCurrent());
			numbers.remove();
			sudoku.setValue (r, c, k);
			if (solveRec(r+1, c)== true) {
				return true;
			}
		}
		
		sudoku.setValue (r, c, 0);
		return false;
	}
	
	public int[][] solve() {
		int[][] solve = new int[9][9];
		if (solveRec(0,0)==true) {
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					solve[i][j] = sudoku.getValue(i,j);
				}
			}
			System.out.println(sudoku.toString() + "\n");
			return solve;
		}
		return null;
	}
	
	public boolean isPossible (int row, int column, int number) {
		for (int i=0; i<9; i++) {
			if (sudoku.getValue(row,i)== number) {
				return false;
			}
		}
		for (int i=0; i<9; i++) {
			if (sudoku.getValue(i,column)== number) {
				return false;
			}
		}
		int squarer= (row/3)*3;
		int squarec= (column/3)*3;
		for (int i=squarer; i<squarer+3; i++) {
			for (int j=squarec; j<squarec+3; j++) {
				if (i!= row && j!=column && sudoku.getValue(i,j)==number) {
					return false;
				}
			}
		}
		return true;
	}
}
