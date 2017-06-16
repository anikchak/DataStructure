/*
 * Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating turns. 
 * In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, 
 * and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.
 */
package DynamicProgramming;

public class OptimalStrategyForGame {

	/*
	 * Recursive Approach - starts
	 * Approach: For user 1: in iteration 1: he can choose either 1st or last coin
	 * 					   : in iteration 2: user two would have chosen the max coin out of remaining coins after itr 1. He would have chosen the coin in 
	 * 										 in such a way that user 1 gets to pick out min value coins. Hence options would be
	 */
	public int optimalGameStrategy(int coins[],int s, int e){
		// If there is only one coin; then return that
		if(s==e){
			return coins[s];
		}
		//If there are two coins, then return the max coin value
		if(s+1 == e){
			return Math.max(coins[s], coins[e]);
		}
		//If user 1 picks the start coin
		int startValue = coins[s]+Math.min(optimalGameStrategy(coins, s+2, e), optimalGameStrategy(coins, s+1, e-1));
		//If user 1 picks the end coin
		int endValue = coins[e]+Math.min(optimalGameStrategy(coins, s, e-2), optimalGameStrategy(coins, s+1, e-1));
		
		//Return the max value fetched
		return Math.max(startValue, endValue);
	}
	/*
	 * Recursive Approach - ends
	 */
	/*
	 * DP Approach starts
	 */
	public int optimalGameStrategyDP(int coins[]){
		int T[][] = new int [coins.length][coins.length];
		for(int i=0;i<T.length;i++){
			T[i][i] = coins[i];
		}
		for(int k=0;k<coins.length;k++){
			int i = 0, j=k;
			while(i<coins.length && j<coins.length){
				int x = (i+2 < j)? T[i+2][j]:0;
				int y = (i+1 < j-1)? T[i+1][j-1]:0;
				int z = (i < j-2)? T[i][j-2]:0;
				T[i][j] = Math.max(coins[i]+Math.min(x, y), coins[j]+Math.min(y, z));
				i++; j++;
			}
		}
		
		return T[0][coins.length-1];
	}
	/*
	 * DP Approach ends
	 */
	public static void main(String[] args) {
		OptimalStrategyForGame o =  new OptimalStrategyForGame();
		int coins[] = {5,3,7,10};
		System.out.println("Max Value Recursion = "+o.optimalGameStrategy(coins, 0, coins.length-1));
		System.out.println("Max Value DP = "+o.optimalGameStrategyDP(coins));
		int coins1[] = {8,15,3,7};
		System.out.println("Max Value Recursion = "+o.optimalGameStrategy(coins1, 0, coins1.length-1));
		System.out.println("Max Value DP = "+o.optimalGameStrategyDP(coins1));

	}

}
