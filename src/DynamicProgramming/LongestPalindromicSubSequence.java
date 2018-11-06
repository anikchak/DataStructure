package DynamicProgramming;

public class LongestPalindromicSubSequence {
	
	/*
	 * Use this method. Below method is also correct but this method is more understandable
	 * Step 1: Reverse the string 
	 * Step 2: Compute Longest Common SubSequence. The Length of LCS will be the length of longest palindromic sub-sequence 
	 */
	
	public static void longestPalindromicSubSequenceLCS(String s){
		//Longest palindromic sub-sequence LCS method
		
		//Step 1: Reverse the input string
		StringBuffer sb = new StringBuffer(s);
		sb.reverse();
		String t = sb.toString();
		
		//Step 2: Compute LCS
		int T[][] = new int[s.length()+1][t.length()+1];
		for(int i=0;i<T.length;i++){
			T[i][0] = 0;
		}
		for(int i=0;i<T[0].length;i++){
			T[0][i] = 0;
		}
		
		for(int i=1;i<T.length;i++){
			for(int j=1;j<T[0].length;j++){
				if(s.charAt(i-1)==t.charAt(j-1)){
					T[i][j] = 1+T[i-1][j-1];
				}else{
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
			}
		}
		
		int sLen = s.length();
		int tLen = t.length();
		int maxLen = T[sLen][tLen];
		System.out.println("Length of longest panlindromic subsequence (LCS) = "+maxLen);
		
		//Computing sequence
		int count = 0;
		int i = sLen, j = tLen; 
		while(count < maxLen){
			if(T[i-1][j]==T[i][j]){
				i--;
			}else if(T[i][j-1]==T[i][j]){
				j--;
			}else if(1+T[i-1][j-1] == T[i][j]){
				System.out.print(s.charAt(i-1));
				i--;
				j--;
				count++;
			}
		}
	}
	public static void longestPalindromicSubSequence(String s){
		int len = s.length();
		int T[][] = new int[len][len];
		for(int i=0;i<T.length;i++){
			T[i][i] = 1;
		}
		for(int l=2;l<=len;l++){
			for(int i=0;i<=len-l;i++){
				int j = i+l-1;
				if(s.charAt(i) == s.charAt(j)){
					T[i][j] = 2+T[i+1][j-1];
				}else{
					T[i][j] = Math.max(T[i][j-1], T[i+1][j]);
				}
			}
		}
		
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[0].length;j++){
				System.out.print(" "+T[i][j]);
			}
			System.out.println();
		}
		int i = 0, j=T[0].length-1;
		System.out.println("Longest Palindromic Subsequence is of length = "+T[i][j]);
		//Computing the elements involved in longest Palindromic subsequence
		
		int k=0, l = j-1;
		int result[] = new int[T[i][j]];
		while(i!=j){
			if((T[i][j] == T[i+1][j])||(T[i][j] == T[i][j-1])){
				if(T[i][j] == T[i+1][j]){
					i++;
				}else if(T[i][j] == T[i][j-1]){
					j--;
				}
			}else{
				result[k] = i;
				result[l-k] = j;
				k++;
				i++;
				j--;
			}
		}
		if(i==j){
			result[k] = i;
		}
		//Printing
		for(int r: result){
			System.out.print(" "+s.charAt(r));
		}
	}
	public static void main(String[] args) {
		longestPalindromicSubSequence("agbdba");
		System.out.println();
		longestPalindromicSubSequenceLCS("agbdba");
	}

}
