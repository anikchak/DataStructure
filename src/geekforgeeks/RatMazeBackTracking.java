/*
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] 
 * and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach destination. 
 * The rat can move only in two directions: forward and down.
 * In the maze matrix, 0 means the block is dead end and 1 means the block can be used in the path from source to destination
 */
package geekforgeeks;

public class RatMazeBackTracking {

	public boolean isMoveSafe(int maze[][],int i, int j){
		if((i>=0 && i<maze.length) && (j>=0 && j<maze[0].length)
				&&(maze[i][j]==1)){
			return true;
		}
		return false;
	}
	public void solve(int maze[][]){
		int sol[][] = new int[maze.length][maze[0].length];
		boolean result = solve(maze,sol,0,0);
		if(result){
			System.out.println("Moves = ");
			for(int i=0;i<maze.length;i++){
				for(int j=0;j<maze[0].length;j++){
					System.out.print(sol[i][j]+" ");
				}
				System.out.println();
			}
		}else{
			System.out.println("No possible solution");
		}
	}
	public boolean solve(int [][]maze, int sol[][],int i,int j){
		if((i==maze.length-1) && (j==maze[0].length-1) && (maze[i][j]==1)){
			sol[i][j] = 1;
			return true;
		}
		if(isMoveSafe(maze, i, j)){
			sol[i][j] = 1;
			//Checking if moving down is an option
			boolean down = solve(maze, sol, i+1, j);
			if(down) return true;
			//Checking if moving forward is an option
			boolean frwd = solve(maze, sol, i, j+1);
			if(frwd) return true;

			//If both moving down and forward, does not yield any result then the move cannot be considered
			sol[i][j] = 0;
		}
		return false;
	}
	public static void main(String[] args) {
		RatMazeBackTracking rat = new RatMazeBackTracking();
        int maze[][] = {
        	{1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        rat.solve(maze);
	}

}
