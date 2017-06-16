/*
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
For example, consider the below binary matrix.
01101
11010
01110
11110
11111
00000
Approach: DP - check if T[i-1][j-1], T[i-1][j], T[i][j-1] are squares or not
 */
package DynamicProgramming;

public class MaximumSizeSquareSubmatrix {

	public static void main(String[] args) {
		int a[][] = {
				{0,1,1,0,1},
				{1,1,0,1,0},
				{0,1,1,1,0},
				{1,1,1,1,0},
				{1,1,1,1,1},
				{0,0,0,0,0}
		};
		int T[][] = new int[a.length][a[0].length];
		for(int i=0;i<a.length;i++){
			T[i][0] = a[i][0];
		}
		for(int i=0;i<a[0].length;i++){
			T[0][i] = a[0][i];
		}
		for(int i=1;i<a.length;i++){
			for(int j=1;j<a[0].length;j++){
				if(a[i][j]==1){
					T[i][j] = 1+Math.min(T[i-1][j-1], Math.min(T[i-1][j], T[i][j-1]));
				}else{
					T[i][j] = 0;
				}
			}
		}
		int max = 0,s=-1,e=-1;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				if(T[i][j]>max){
					max = T[i][j];
					s = i;
					e = j;
				}
			}
		}
		System.out.println("Maximum size sub-matrix is: " + max);
		// Printing the max size sub-matrix square
		for (int i1 = s; i1 > (s - max); i1--) {
			for (int j = e; j > (e - max); j--) {
				System.out.print(a[i1][j] + " ");
			}
			System.out.println();
		}
	}
}
