/*
 * Given: Various lengths of rods and the prices at which they sell
 * 		: A Rod of n length
 * Problem: how should a rod of length n be cut such that there is Maximum profit
 * Approach: Max(Include the rod of x length and calculate profit, Exclude this rod and calculate profit)
 */
package DynamicProgramming;

public class CuttingRod {

	public static void maxProfit(int total, int len[], int val[]){
		int r = len.length;
		int c = total;
		int T[][] = new int[r+1][c+1];
		
		for(int i=0;i<T.length;i++){
			T[i][0] = 0;
		}
		for(int i=0;i<T[0].length;i++){
			T[0][i] = 0;
		}
		
		for(int i=1;i<T.length;i++){
			for(int j=1;j<T[0].length;j++){
				if(i>j){
					T[i][j] = T[i-1][j];
				}else{
					T[i][j] = Math.max(T[i-1][j]/*Excluding*/, val[i-1]+T[i][j-len[i-1]]/*Including*/);
				}
			}
		}
		System.out.println("Result = "+T[r][c]);
		System.out.println("Rod Cuts =");
		int max = T[r][c];
		while(max>0){
			if(T[r][c] == T[r-1][c]){
				r--;
			}else{
				System.out.println("Len = "+len[r-1]+" Cost = "+val[r-1]);
				c = c-len[r-1];
				max = T[r][c];
			}
		}
	}
	public static void main(String[] args) {
		int len[] = {1,2,3,4};
		int val[] = {2,5,7,8};
		maxProfit(5, len, val);

	}

}
