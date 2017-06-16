/*
 * Consider a matrix with rows and columns, where each cell contains either a ‘0’ or a ‘1’ and any cell containing a 1 is called a filled cell. 
 * Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally .
 * If one or more filled cells are also connected, they form a region. find the length of the largest region.

Examples:

Input : M[][5] = { 0 0 1 1 0
                   1 0 1 1 0
                   0 1 0 0 0
                   0 0 0 0 1 }
Output : 6 
Ex: in the following example, there are 2 regions one with length 1 and the other as 6.
    so largest region : 6
 */
package geekforgeeks;

public class LengthOfLargestRegionInBooleanMatrix {

	public void findLargestRegion(int a[][]){
		int r = a.length;
		int c = a[0].length;
		int currSize = 0, maxSize = 0;
		boolean visited[][] = new boolean[r][c];
		//Search for the starting point; that is cell having value 1. Once found then do DFS to find the largest region
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(a[i][j]==1 && !visited[i][j]){
					currSize = findLargestRegion(a,visited,i,j,0);
					if(currSize>maxSize){
						maxSize = currSize;
					}
				}
			}
		}
		System.out.println("Length of Largest Region in boolean matrix = "+maxSize);
	}
	public int findLargestRegion(int a[][], boolean visited[][], int r, int c,int count){
		if(!visited[r][c]){
			visited[r][c] = true;
			count++;
			//Check the neighbours for this cell
			for(int i=-1;i<=1;i++){
				for(int j=-1;j<=1;j++){
					int row = r+i;
					int col = c+j;
					if(isSafe(a,visited,row,col)){
						count = findLargestRegion(a, visited, row, col, count);
					}
				}
			}
		}
		return count;
	}
	public boolean isSafe(int a[][], boolean visited[][],int r, int c){
		if(
				(r>=0 && r<a.length) &&
				(c>=0 && c<a[0].length)&&
				(a[r][c]==1) &&
				(!visited[r][c])
		  ){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int a[][] = {
				{0,0,1,1,0},
				{1,0,1,1,0},
				{0,1,0,0,0},
				{0,0,0,0,1}
		};
		LengthOfLargestRegionInBooleanMatrix l = new LengthOfLargestRegionInBooleanMatrix();
		l.findLargestRegion(a);
	}

}
