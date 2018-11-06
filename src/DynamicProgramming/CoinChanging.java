/*
 * Given: a Total N, and a set of coin denomination C[]. Find the number of ways in which the total can be achieved using the given denominations
 * There is unlimited supply of coins
 */
package DynamicProgramming;

public class CoinChanging {
	
	/*
	 * Recursive method
	 */
	public static int changeRecusive(int coin[], int total,int i){
		if(total == 0){
			return 1;
		}
		if(total < 0){
			return 0;
		}
		//when all the coins are over and total is still not 0 - Then no Solution
		if(i == coin.length && total > 0){
			return 0;
		}
		int c1 = changeRecusive(coin, total, i+1); //coin not taken into consideration. Hence go to next coin denomination
		int c2 = changeRecusive(coin, total-coin[i], i); //coin taken into consideration
		return c1+c2;
	}
/*
 * End of recursive method
 */
	
	/*
	 * Dynamic Programming method
	 */
	public static void changeDP(int coin[], int total){
		int result[][] = new int[coin.length+1][total+1];
		/*
		for(int i=0;i<result[0].length;i++){
			result[0][i] = 1;
		}*/
		for(int i=0;i<result.length;i++){
			result[i][0] = 1;
		}
		for(int i=1;i<result.length;i++){
			for(int j=1;j<result[0].length;j++){
				if(coin[i-1] > j){
					result[i][j] = result[i-1][j];
				}else{
					result[i][j] = result[i-1][j] + result[i][j-coin[i-1]];
				}
			}
		}
		System.out.println("Result DP = "+result[coin.length][total]);
		/*
		for(int i=0;i<result.length;i++){
			for(int j=0;j<result[0].length;j++){
				System.out.print(" "+result[i][j]);
			}
			System.out.println();
		}
		*/
	}
	/*
	 * End of DP method
	 */
	
	public static void main(String[] args) {
		int a[] = {1,2,3};
		System.out.println(changeRecusive(a,4,0));
		changeDP(a,4);
		int b[] = {2, 5, 3, 6};
		System.out.println(changeRecusive(b,10,0));
		changeDP(b, 10);
	}

}
