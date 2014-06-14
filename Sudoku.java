/**
 * Sudoku.java
 * Created: 14.01.2014, 13:17:06
 */

/**
 *
 */
public class Sudoku {
	
	int[][] grid;
	
	public Sudoku(int[][] grid) throws IllegalArgumentException {
		this.grid = new int[grid.length][grid.length];
		if (isValid(grid)) this.grid=grid;
		else throw new IllegalArgumentException();
	}

	/**
	 * Checks whether a two dimensional grid represents a valid solution for a 9x9
	 * Sudoku.
	 * @param grid the grid of numbers
	 * @return {@code true} if the solution is valid, {@code false} otherwise.
	 */
    public static boolean isValid(int[][] grid) {
			
			return true;
    }
	
    public boolean isGridValid() {
		if( grid == null ) {
			return false;
		}
		if( grid.length != 9 ) {
			return false;
		}
		for( int i = 0; i < grid.length; i++ ) {
			if( grid[i].length != grid.length ) {
				return false;
			}
			for( int j = 0; j < grid.length; j++ ) {
				if (grid[i][j] < 0 || grid[i][j] > 9) {
					return false;
				}
			}
		}
		// Check rows
		for( int i = 0; i < grid.length; i++ ) {
			boolean[] occurs = new boolean[grid.length + 1];
			for( int j = 0; j < grid.length; j++ ) {
				if (grid[i][j]!=0) {
					if (occurs[grid[i][j]]) {
						return false;
					} else {
						occurs[grid[i][j]] = true;
					}
				}
			}
		}
		// Check columns
		for( int i = 0; i < grid.length; i++ ) {
			boolean[] occurs = new boolean[grid.length+1];
			for( int j = 0; j < grid.length; j++ ) {
				if (grid[j][i]!=0) {
					if( occurs[grid[j][i]] ) {
						return false;
					} else {
						occurs[grid[j][i]] = true;
					}
				}
			}
		}
		// Check squares
		for( int i = 0; i < grid.length; i++ ) {
			boolean[] occurs = new boolean[grid.length + 1];
			for( int j = 0; j < grid.length; j++ ) {
				if (grid[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]!=0) {
					if( occurs[grid[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]] ) return false;
					else occurs[grid[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]] = true;
				}
			}
		}
		return true;
    }
	
	public int getValue( int row, int column ) {
		return grid[row][column];
	}
	
	public void setValue( int row, int column, int value ) {
		grid[row][column] = value;
	}
	
	 public String toString() {
		 String s = ("\n");
		 for (int i=0; i<grid.length; i++) {
			 for (int j=0; j<grid.length; j++) {
				 if (j!=0 && (j%3) ==0) {
					 s+=" |";
				 }
				 s+=(" "+grid[i][j]);
			 }
 			 if (i!=8 && (i%3)-2 ==0) {
 				 s+="\n"+ " ------+-------+------";
 			 }
			 s+="\n";
		 }
		 return s;
	 }
	
}
