/*
 * Given: An array. The elements of array denote price of share for that particular day. 
 * 		: k transactions: Maximum no. of trxns that can be done across all days
 * Problem: Given share prices on each day and no. of trxns ind the max profit that can be earned
 * Approach: Represent days as columns
 * 		   : Represent trxns as rows
 * max profit = max(if no trxn is done on that particular day, price of share on that day + max profit earned before that day before this current trxn)
 * maxProfit = max(T[i][j-1], price[j]+maxDiff), where maxDiff = max(maxDiff, T[i-1][j-1]-price[j-1] {denotes profit earned before this txn and day})	
 */
package DynamicProgramming;

import java.util.Stack;

public class StockBuySellKTxn {

	public static void maxProfit(int price[],int trxn){
		int T[][] = new int[trxn+1][price.length];
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
				T[i][j] = Math.max(price[j]+maxDiff, T[i][j-1]);
			}
		}
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[0].length;j++){
				System.out.print(" "+T[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("Max Profit that can be earned is = "+T[trxn][price.length-1]);
		//Calculating order of buy and sell of shares 
		Stack<Integer> s = new Stack<Integer>();
		int i = trxn;
		int j = price.length-1;
		
		while(true){
			if(i==0 || j==0){
				break;
			}
			if(T[i][j] == T[i][j-1]){
				j = j-1;
			}else{
				s.push(j);
				int diff = T[i][j] - price[j];
				for(int k = j-1;k>=0;k--){
					if(T[i-1][k]-price[k] == diff){
						s.push(k);
						i = i-1;
						j = k;
						break;
					}
				}
			}
		}
		while(!s.isEmpty()){
			System.out.println("Buy on day  "+s.pop());
			System.out.println("Sell on day "+s.pop());
		}
		
	}
	public static void main(String[] args) {
		int price[] = {2,5,7,1,4,3,1,3};
		maxProfit(price, 3);
	}

}
