/*
 * Given two strings, find the number of times the second string occurs in the first string, whether continuous or discontinuous.

Examples:

Input:  
string a = "GeeksforGeeks"
string b = "Gks"

Output: 4

Explanation:  http://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
 */
package geekforgeeks;

public class NoOfTimesStringAppearAsSubSeq {

	public int countRecursive(String s, String p, int sLen, int pLen){
		//Base case: if both the lengths are zero or length of pattern is zero
		if((sLen==0 && pLen==0) || pLen==0) return 1;

		//If sLen is zero
		if(sLen==0) return 0;
		// If last characters are same
	    // Recur for remaining strings by
	    // 1. considering last characters of both strings
	    // 2. ignoring last character of first string
		if(s.charAt(sLen-1) == p.charAt(pLen-1)){
			return countRecursive(s, p, sLen-1, pLen-1)/*Consider last character*/ + countRecursive(s, p, sLen-1, pLen);//Ignore last character
		}else{
			return countRecursive(s, p, sLen-1, pLen);
		}
	}
	public void countDP(String s, String p){
		int sLen = s.length();
		int pLen = p.length();
		int T[][] = new int [sLen+1][pLen+1];
		
		//If string is missing, then no use of pattern
		for(int i=0;i<T[0].length;i++){
			T[0][i] = 0;
		}
		//If pattern is missing, then only 1 combination available
		for(int i=0;i<T.length;i++){
			T[i][0] = 1;
		}
		for(int i=1;i<T.length;i++){
			for(int j=1;j<T[0].length;j++){
				if(s.charAt(i-1)==p.charAt(j-1)){
					T[i][j] = T[i-1][j-1]/*char included*/ + T[i-1][j]/*char not included*/;
				}else{
					T[i][j] = T[i-1][j];
				}
			}
		}
		System.out.println("Count Dp = "+T[sLen][pLen]);
	}
	public static void main(String[] args) {
		NoOfTimesStringAppearAsSubSeq n = new NoOfTimesStringAppearAsSubSeq();
		String s = "GeeksforGeeks";
		String p = "Gks";
		System.out.println("Count = "+n.countRecursive(s, p, s.length(), p.length()));
		n.countDP(s, p);
	}

}
