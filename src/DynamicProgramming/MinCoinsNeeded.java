/*
 * Given an infinite supply of coins, find the minimum no. of coins that are needed to reach to a total 
 */
package DynamicProgramming;

public class MinCoinsNeeded {

	/*
	 * DP method
	 */
	public static void minCoinsNeeded(int coins[], int total){
		int result[] = new int[total+1];
		int minCoins[] = new int[total+1];
		for(int i=0;i<result.length;i++){
			result[i] = -1;
			minCoins[i] = Integer.MAX_VALUE-1;
		}
		minCoins[0] = 0;
		for(int j=0;j<coins.length;j++){
			for(int i=1; i< result.length;i++){
				if(coins[j] <= i){
					if(minCoins[i] > 1+minCoins[i-coins[j]]){
						result[i] = j;
					}
					minCoins[i] = Math.min(minCoins[i]/*Without Including the coin*/, 1+minCoins[i-coins[j]]/*Including the coin*/);
					
				}
			}
		}
		System.out.println("\nMin coins needed="+minCoins[minCoins.length-1]);
		System.out.println("Coins included");
		
		int len = result.length-1;
		int pos = result[len];
//		for(int i=0; i< result.length;i++){
//			System.out.print(" "+result[i]);
//		}
		while(pos != -1){
			int coin = coins[pos];
			System.out.print(coin+" ");
			len = len-coin;
			pos = result[len];
		}
	}
	/*
	 * DP Method -ends
	 */
	public static void main(String[] args) {
		int a[] = {7,2,3,6};
		minCoinsNeeded(a, 13);
		int b[] =  {9, 6, 5, 1};
		minCoinsNeeded(b, 11);
	}

}
