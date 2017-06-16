/*
 * Given N X N matrix filled with 1 , 0 , 2 , 3 . 
 * Find whether there is a path possible from source to destination, traversing through blank cells only. You can traverse up, down, right and left.

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Blank Wall.
Note : there is only single source and single destination(sink).

Examples:

Input : M[3][3] = {{ 0 , 3 , 2 },
                   { 3 , 3 , 0 },
                   { 1 , 3 , 0 }};
Output : Yes

Input : M[4][4] = {{ 0 , 3 , 1 , 0 },
                   { 3 , 0 , 3 , 3 },
                   { 2 , 3 , 0 , 3 },
                   { 0 , 3 , 3 , 3 }};
Output : Yes
 */
package geekforgeeks;

public class IsPathPresentIn2DMatrix {

	public void isPathPresent(int a[][]){
		int r = a.length;
		int c = a[0].length;
		boolean pathPresent=false;
		boolean visited[][] = new boolean[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(a[i][j]==1 && !visited[i][j]){
					pathPresent = isPathPresent(a,visited,i,j);
					//showVisited(visited);
					if(pathPresent){
						break;
					}
				}
			}
		}
		System.out.println("Is path present = "+pathPresent);
	}
	public void showVisited(boolean visited[][]){
		for(int i=0;i<visited.length;i++)
		{
			for(int j=0;j<visited[0].length;j++){
				System.out.print(visited[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public boolean isPathPresent(int a[][], boolean visited[][], int r, int c){
		boolean pathFound = false;
		if(!visited[r][c]){
			visited[r][c] = true;
			//Check if destination is reached
			if(a[r][c]==2){
				return true;
			}else{
				//Upward movement
				if(isSafe(a,visited,r-1,c)){
					pathFound = isPathPresent(a, visited, r-1, c);
					if(pathFound) return true;
				}
				//downward movement
				if(isSafe(a,visited,r+1,c)){
					pathFound = isPathPresent(a, visited, r+1, c);
					if(pathFound) return true;
				}
				//leftward movement
				if(isSafe(a,visited,r,c-1)){
					pathFound = isPathPresent(a, visited, r, c-1);
					if(pathFound) return true;
				}
				//rightward movement
				if(isSafe(a,visited,r,c+1)){
					pathFound = isPathPresent(a, visited, r, c+1);
					if(pathFound) return true;
				}
			}
		}
		return false;
	}
	public boolean isSafe(int a[][], boolean visited[][], int row, int col){
		if(
			(row>=0 && row<a.length)&&
			(col>=0 && col<a[0].length)&&
			(a[row][col] != 0)&&
			(!visited[row][col])
		  ){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		IsPathPresentIn2DMatrix p = new IsPathPresentIn2DMatrix();
		int M[][] = {
				{ 0 , 3 , 2 },
                { 3 , 3 , 0 },
                { 1 , 3 , 0 }
                };
		p.isPathPresent(M); 
		int a[][] = {
				{ 0 , 3 , 1 , 0 },
                { 3 , 0 , 3 , 3 },
                { 2 , 3 , 0 , 3 },
                { 0 , 3 , 3 , 3 }
                };
		p.isPathPresent(a); 
	}

}
