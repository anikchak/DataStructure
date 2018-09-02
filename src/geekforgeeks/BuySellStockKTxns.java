/*
 * Maximize the profit by buying and selling stocks in Ktransactions only.
 * Approach: Dynamic Programming: Let no. of txn be rows and Days or Price on each day as column
 * Formula to calculate max Profit in K txns will be 
 * MaxProfit = Max(By doing txn on that day, By Not doing txn on that day)
 * maxProfit = max(T[i][j-1]//Not doing txn, maxDiff+price[j_th_day]); where maxDiff = max(maxDiff,T[i-1][j-1]-price[j-1])
 */
package geekforgeeks;

import java.util.Stack;

public class BuySellStockKTxns {

	public void computeMaxProfit(int[] price, int txn){
		int n=price.length;
		//int maxDiff = Integer.MIN_VALUE;
		int T[][] = new int[txn+1][n];
		for(int i=0;i<T.length;i++){
			T[i][0] = 0;
		}
		for(int i=0;i<T[0].length;i++){
			T[0][i] = 0;
		}
		for(int i=1;i<T.length;i++){
			int maxDiff = Integer.MIN_VALUE;
			for(int j=1;j<T[0].length;j++){
				maxDiff = Math.max(maxDiff, T[i-1][j-1]-price[j-1]);
				T[i][j] = Math.max(T[i][j-1], maxDiff+price[j]);
			}
		}
//		for(int i=0;i<T.length;i++){
//			for(int j=0;j<T[0].length;j++){
//				System.out.print(T[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println("Max Profit = "+T[txn][n-1]);
		System.out.println();
		//Printing buy and sell days
		Stack<Integer> days = new Stack<Integer>();
		int totalOps = txn*2; //If there are 3 txns then there will be 3 sell and 3 buys. Hence multiplying by 2
		int r=txn,c=n-1;
		while(0<totalOps){
			if(T[r][c-1] == T[r][c]){
				c--;
			}else{//Txn happened on this day
				//Selling op performed
				int rem = T[r][c]-price[c];
				days.push(c);
				r--;
				totalOps--;
				//Buying op. performed
				while(rem != (T[r][c]-price[c])){
					c--;
				}
				days.push(c);
				totalOps--;
			}
		}
		while(!days.isEmpty()){
			System.out.println("Buy on Day = "+days.pop());
			System.out.println("Sell on Day = "+days.pop());
		}
	}
	public static void main(String[] args) {
		BuySellStockKTxns bs = new BuySellStockKTxns();
		int price[] = {2,5,7,1,4,3,1,3};
		bs.computeMaxProfit(price, 3);
	}

}
