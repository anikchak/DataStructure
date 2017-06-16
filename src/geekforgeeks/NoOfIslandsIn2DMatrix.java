/*
 * Given a boolean 2D matrix, find the number of islands.

A group of connected 1s forms an island. For example, the below matrix contains 5 islands

{1, 1, 0, 0, 0},
{0, 1, 0, 0, 1},
{1, 0, 0, 1, 1},
{0, 0, 0, 0, 0},
{1, 0, 1, 0, 1} 
 */
package geekforgeeks;

public class NoOfIslandsIn2DMatrix {

	public void noOfIslands(int a[][]){
		int r = a.length;
		int c = a[0].length;
		boolean visited[][] = new boolean[r][c];
		int count=0;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(a[i][j]==1 && !visited[i][j]){
					count++;
					//If there is connected region; that is there exists 1 in neighbourhood of this 1; then they will come under one island 
					findConnectedIsland(a,visited,i,j);
				}
			}
		}
		System.out.println("No. of island = "+count);
	}
	
	public void findConnectedIsland(int a[][], boolean visited[][], int r, int c){
		if(!visited[r][c]){
			visited[r][c] = true;
			for(int i=-1;i<=1;i++){
				for(int j=-1;j<=1;j++){
					int row = r+i;
					int col = c+j;
					if(isSafe(a,visited, row, col)){
						findConnectedIsland(a, visited, row, col);
					}
				}
			}
		}
	}
	public boolean isSafe(int a[][], boolean visited[][], int r, int c){
		if(
			(r>=0 && r<a.length)&&
			(c>=0 && c<a[0].length)&&
			(a[r][c]==1)&&
			(!visited[r][c])
		  ){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int a[][] = {
				{1, 1, 0, 0, 0},
				{0, 1, 0, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 0, 0, 0},
				{1, 0, 1, 0, 1}
		};
		NoOfIslandsIn2DMatrix n  = new NoOfIslandsIn2DMatrix();
		n.noOfIslands(a);
	}

}
