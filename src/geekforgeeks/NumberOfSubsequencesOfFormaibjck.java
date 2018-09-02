/*
 * Given a string, count number of subsequences of the form a^ib^jc^k, i.e., it consists of i ’a’ characters, 
 * followed by j ’b’ characters, followed by k ’c’ characters where i >= 1, j >=1 and k >= 1.

Note: Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.

Expected Time Complexity : O(n)

Examples:

Input  : abbc
Output : 3
Subsequences are abc, abc and abbc

Input  : abcabc
Output : 7
Subsequences are abc, abc, abbc, aabc
abcc, abc and abc
 */
package geekforgeeks;

public class NumberOfSubsequencesOfFormaibjck {

	public static void main(String[] args) {
		String s = "abc";
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		
		for(int i=0;i<s.length();i++){
			//Subseq count start with char a
			if(s.charAt(i) == 'a'){
				aCount = 1+2*aCount;
			}
			//Subseq count start with char ab
			if(s.charAt(i) == 'b'){
				bCount = aCount+2*bCount;
			}
			//Subseq count start with char abc
			if(s.charAt(i) == 'c'){
				cCount = bCount+2*cCount;
			}
		}
		System.out.println("Count = "+cCount);
	}

}
