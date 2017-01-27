package practice.recursionanddynamicprogramming;

public class NQueen {

	/*
	 * Method 1: Brute Force method
	 */
	int board[][];
	public void placeQueen(int n){
		board = new int [n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				board[i][j] = 0;
			}
		}
		boolean success = placeQueenUtil(board,n);
		if(!success){
			System.out.println("Queens cannot be placed");
			return ;
		}
		//printing board after placement of Queens
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	int count=0;
	public boolean placeQueenUtil(int [][] board, int n){
		if(n == 0){
			//System.out.println("returned from here");
			return true;
		}
		
		for(int r=0;r<board.length;r++){
			for(int c=0;c<board[0].length;c++){
			//	System.out.println(r+"<->"+c+"="+isValidMove(board, r, c)+" depth="+n);
				if(isValidMove(board,r,c)){
					board[r][c] = 1;
					++count;
					boolean allQueenPlaced = placeQueenUtil(board, n-1);
					if(allQueenPlaced){
						return true;
					}else{
						board[r][c] = 0;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isValidMove(int [][] board, int r, int c){
		int n = board.length;
		//Check if Columns do not have a queen already placed
		for(int i=0;i<board[0].length;i++){
			if(board[r][i] == 1){
				return false;
			}
		}
		//Check if row do not have a queen already placed
		for(int i=0;i<board.length;i++){
			if(board[i][c] == 1){
				return false;
			}
		}
		//Check for diagonal
		int i=r, j=c;
		while(i>=0 && j>=0){
			if(board[i][j] == 1) return false;
			i--;
			j--;
		}
		i=r; j=c;
		while(n>i && n>j){
			if(board[i][j] == 1) return false;
			i++;
			j++;
		}
		i=r; j=c;
		while(i>=0 && j<n){
			if(board[i][j] == 1) return false;
			i--;
			j++;
		}
		i=r; j=c;
		while(n>i && j>=0){
			if(board[i][j] == 1) return false;
			i++;
			j--;
		}
		return true;
	}
	
	/*
	 * End of Method 1
	 */
	
	/*
	 * Method 2: optimized
	 */
	public void placeNQueenOpti(int n){
		int [] result = new int [n];
		placeNQueenOptiUtil(n,0,result);
	}
	public void placeNQueenOptiUtil(int n, int row, int[] result){
		if(n==0){
			System.out.print("<");
			for(int i=0;i<result.length;i++){
				System.out.print("("+i+","+result[i]+")");
			}
			System.out.print(">");
			System.out.println();
			return ;
		}
		for(int i=0;i<result.length;i++){
			if(isValidPos(row,i,result)){
				result[row] = i;
				placeNQueenOptiUtil(n-1, row+1, result);
			}
		}
		return ;
	}
	
	public boolean isValidPos(int row, int col,int[] result){
		 
		for(int i=0;i<row;i++){
			int prevCol = result[i];
			//Check columns
			if(prevCol == col){
				return false;
			}
			//Check Diagonal
			int rowDiff = row -i;
			int colDiff = Math.abs(prevCol-col);
			if(rowDiff == colDiff){
				return false;
			}
		}
		return true;
	}
	/*
	 * End of Method 2
	 */
	public static void main(String[] args) {
		NQueen nq = new NQueen();
		nq.placeQueen(4);
		System.out.println();
		nq.placeNQueenOpti(6);
	}

}
