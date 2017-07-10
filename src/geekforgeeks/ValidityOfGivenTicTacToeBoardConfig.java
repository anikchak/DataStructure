/*
 * A Tic-Tac-Toe board is given after some moves are played. 
 * Find out if the given board is valid, i.e., is it possible to reach this board position after some moves or not.
Note that every arbitrary filled grid of 9 spaces isn’t valid e.g. a grid filled with 3 X and 6 O isn’t valid situation 
because each player needs to take alternate turns
 */
package geekforgeeks;

public class ValidityOfGivenTicTacToeBoardConfig {
	public boolean isConfigValid(char [][]board){
		int xCount=0;
		int oCount=0;
		//Calculate the count of X and O
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[i][j]=='X') xCount++;
				if(board[i][j]=='O') oCount++;
			}
		}
		/*
		 * Approach: 
		 * Assumption: For Simplicity we assume that the first player makes move using X and second player uses O. 
		 * Hence first player will get 5 moves and second will get 4 moves
		 * With the above assumption -> a board will be valid if xCount==oCount OR xCount == oCount+1
		 * Case 1: if O is winning, then check if X is winning or not. If X is also winning then this is wrong config. 
		 * 		   if X is not winning then check if xCount==oCount. Return this value
		 * Case 2: Check if X is winning then count of X should be greater than oCount
		 * 			xCount != oCount+1 -> If true then return False as config will be wrong	
		 * Else return true -> Config is valid 
		 */
		
		//Board will be valid if xCount=oCount or xCount == 1+oCount
		if(xCount==oCount || (xCount == 1+oCount)){
			//Check if O is winning
			if(isWinning(board, 'O')){
				//Check if X is also winning
				if(isWinning(board, 'X')) return false;
				//If 'O' is winning then xCount==oCount; else config is invalid
				return (xCount==oCount);
			}
			//If 'X' is winning
			if(isWinning(board, 'X') && xCount != 1+oCount)
			{
				return false;
			}
			return true;	
		}
		return false;
	}
	public boolean isWinning(char b[][], char ch){
		//Check the rows
		for (int i = 0; i < 3; i++) {
			if (b[i][0] == ch && b[i][1] == ch && b[i][2] == ch) {
				return true;
			}
		}
		// Check the cols
		for (int i = 0; i < 3; i++) {
			if (b[0][i] == ch && b[1][i] == ch && b[2][i] == ch) {
				return true;
			}
		}
		//Check diagonal 1
		if(b[0][0] == ch && b[1][1] == ch && b[2][2] == ch){
			return true;
		}
		// Check diagonal 2
		if(b[0][2] == ch && b[1][1] == ch && b[2][0] == ch){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		ValidityOfGivenTicTacToeBoardConfig v = new ValidityOfGivenTicTacToeBoardConfig();
//		char b[][] = {
//				{'X','X','O'},
//				{'O','O','X'},
//				{'X','O','X'}
//		};
		char b[][] = {
				{' ','X','O'},
				{' ',' ',' '},
				{' ',' ',' '}
		};
		System.out.println("Is board config valid = "+v.isConfigValid(b));
	}

}
