package DynamicProgramming;

public class LongestPalindromicSubSequence {
	
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
	}

}
