/*
 * Given a string, find the minimum number of cuts that will be needed to make each substring palindrome
 */
package DynamicProgramming;

public class PalindromePartioning {

	public static void palindromePartition(String s){
		int n = s.length();
		boolean T[][] = new boolean[n][n];
		//The boolean matrix T will be used to check if the substrings are palindrome or not
		//When we consider L=1 that is, 1 char, then they will be always palindrome
		for(int i=0;i<T.length;i++){
			T[i][i] = true;
		}
		//Checking for len=2 
		for(int i=0;i<T.length-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				T[i][i+1] = true;
			}else{
				T[i][i+1] = false;
			}
		}
		//Checking for other lengths
		for(int L = 3;L<=n;L++){
			for(int i=0;i<=n-L;i++){
				int j = i+L-1;
				//Case 1: When outer elements are not same then full substring will not be palindrome
				if(s.charAt(i)!=s.charAt(j)){
					T[i][j] = false;
				}
				//Case 2: When outer elements are same then check, if the remaining substring after trimming both the outer elements is palindrome
				else{
					T[i][j] = T[i+1][j-1];
				}
			}
		}
		System.out.println("Boolean matrix: ");
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[0].length;j++){
				if(T[i][j]){
				System.out.print("T ");
			}else{
				System.out.print("F ");
			}
			}
			System.out.println();
		}
		
		//Once the boolean matrix is ready, calculate the minimum cuts needed
		//Create an array which will hold the minimum cuts needed 
		int cuts[] = new int[n];
		//calculate minimum cuts needed for each substring
		//s[0] -> will be palindrome always so no cuts will be needed
		cuts[0] = 0;
		for(int i=1;i<n;i++){
			int temp = Integer.MAX_VALUE;
			//Check if substring is palindrome or not from the boolean matrix table created
			if(T[0][i]){
				cuts[i] = 0; //If the substring is palindrome then no cuts are needed
			}else{
				for(int j=0;j<i;j++){ //Starting the loop from 1 coz, first char will always 
					if(T[j+1][i] && temp>cuts[j]+1){ //Minimize the cuts
						temp = cuts[j]+1;
					}
				}
				cuts[i] = temp;
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(" "+cuts[i]);
		}
		System.out.println("\nMinimum number of cuts needed = "+cuts[n-1]);
	}
	public static void main(String[] args) {
		palindromePartition("BANANA");
	}

}
