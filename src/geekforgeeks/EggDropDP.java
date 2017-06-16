/*
 * Given 2 eggs and n floors; find the minimum number of attempts needed to know from which floor if the egg is thrown, the egg will break  
 */
package geekforgeeks;

public class EggDropDP {

	public static void main(String[] args) {
		int eggs = 2;
		int floors = 6;
		int minAttempts = Integer.MAX_VALUE;
		int T[][] = new int [eggs+1][floors+1];
		//If there is only 1 egg then, min. attempts needed would be equal to floors 
		for(int i=1;i<=floors;i++){
			T[1][i] = i;
		}
		for(int i=2;i<=eggs;i++){
			for(int j=1;j<=floors;j++){
				if(i>j){
					T[i][j] = T[i-1][j];
				}else{
					for(int k=1;k<=j;k++){
						int eggBreaks = T[i-1][k-1];//If egg breaks then we will have, one less egg and one less below floors
						int eggDoesntBreak = T[i][j-k]; //If egg doesnot break, then we will have, all the eggs and remaining above floors (j-k)
						int maxValue = Math.max(eggBreaks, eggDoesntBreak);
						minAttempts = Math.min(minAttempts, maxValue);
					}
					T[i][j] = 1+minAttempts;
					minAttempts = Integer.MAX_VALUE;
				}
			}
		}
		for(int i=1;i<=eggs;i++){
			for(int j=1;j<=floors;j++){
				System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Min attempts needed = "+T[eggs][floors]);
	}

}
