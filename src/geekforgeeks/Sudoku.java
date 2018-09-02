/*
 * Given a partially filled 9×9 2D array ‘grid[9][9]’, the goal is to assign digits (from 1 to 9) to the empty cells so that every row, 
 * column, and subgrid of size 3×3 contains exactly one instance of the digits from 1 to 9.
 */
package geekforgeeks;

public class Sudoku {

	class Cell{
		int row;
		int col;
	}
	public boolean completeSudoku(int grid[][]){
		Cell c = new Cell();
		c = isGridComplete(grid,c);
		//If the value of c is null then all the cells have been filled and a successful value can be sent
		if(c==null){
			return true;
		}
		//Place numbers between 1 and 9
		for(int i=1;i<=9;i++){
			//Check if the value of i can be placed in cell position identified as blank 
			if(isSafe(grid,c.row,c.col,i)){
				grid[c.row][c.col] = i;
				if(completeSudoku(grid)){
					return true;
				}
				grid[c.row][c.col] = 0;
			}
		}
		return false;
	}
	public boolean isSafe(int grid[][],int row, int col,int num){
		//Check if num is present in row
		for(int i=0;i<9;i++){
			if(grid[row][i]==num){
				return false;
			}
		}
		// Check if num is present in col
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == num) {
				return false;
			}
		}
		//Check if num is present in 3X3 sub-matrix
		int boxRowStart = row-row%3;
		int boxColStart = col-col%3;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(grid[i+boxRowStart][j+boxColStart] == num){
					return false;
				}
			}
		}
		return true;
	}
	public Cell isGridComplete(int grid[][], Cell c){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(grid[i][j]==0) {
					c.row = i;
					c.col = j;
					return c;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		int grid[][] = {
				{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
		if(s.completeSudoku(grid)){
			System.out.println("Success");
			System.out.println();
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					System.out.print(grid[i][j]+" ");
				}
				System.out.println();
			}
		}
		else{
			System.out.println("Unsuccessful");
		}
	}

}
