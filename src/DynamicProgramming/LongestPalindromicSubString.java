/*
 * Find the longest palindromic substring in O(n) 
 * Code reference: https://www.youtube.com/watch?v=nbTSfrEfo6M
 */
package DynamicProgramming;

public class LongestPalindromicSubString {

	public static void main(String args[]){
		String s = "ABBA";
		char a[] = s.toCharArray();
		char T[] = new char[2*a.length+3]; //This array is created to calculate the palindrome length in case the length is even 
		//Mark the start and end of this array with special chars so as to maintain uniqueness  
		T[0] = '$';
		T[T.length-1] = '@';
		//Assign values to new array
		int index=0;
		for(int i=1;i<T.length-1;i++){
			if(i%2 == 0){
				T[i] = a[index];
				index++;
			}else{
				T[i] = '#';
			}
		}
		System.out.print("T = ");
		for(char t:T){
			System.out.print(t);
		}
		System.out.println();
		//C - denotes actual center
		//R - denotes Right boundary of the array from where we need to test expanding logic
		//i - denotes potential center
		int p[] = new int[T.length];
		int C=0,R=0;
		for(int i=1;i<T.length-1;i++){
			int mirror = 2*C -i; //Location of mirror element when i is being considered as the next potential center
			if(i<R){ //if i lies well within right boundary then calculate palindrome length as follows 
				p[i] = Math.min(R-i /*Left boundary expansion case*/, p[mirror]/*Right boundary expansion case*/);
			}
			//Expanding around the potential center i
			while(T[i+(1+p[i])] == T[i-(1+p[i])]){
				p[i]++;
			}
			//If i is found outside the right boundary R then expand right boundary and change the center C
			if(i+p[i]>R){
				R = i+p[i];
				C = i;
			}
		}
		System.out.println("Longest Palindrome substring in T (for actual length max/2)= ");
		int max = Integer.MIN_VALUE, cen = -1;
		for(int i=0;i<p.length;i++){
			if(max<p[i]){
				max = p[i];
				cen = i;
			}
		}
		System.out.println(max+" "+cen);
		
		//Checking method 2
		longestPalindromeSubString("abc");
	}
	
	/*This is method 2 : This method takes O(n^2)*/
	public static void longestPalindromeSubString(String s){
		char a[] = s.toCharArray();
		int longestSubString = 1;
		for(int i=0;i<a.length;i++){
			//This is for even length of string
			int x = i;
			int y = i+1;
			int palin = 0;
			while(x>=0 && y<a.length && a[x]==a[y]){
				x--;
				y++;
				palin = palin+2;
			}
			longestSubString = Math.max(longestSubString, palin);
			//This is for odd length of string
			x = i-1;
			y = i+1;
			palin = 1;
			while(x>=0 && y<a.length && a[x]==a[y]){
				x--;
				y++;
				palin = palin+2;
			}
			longestSubString = Math.max(longestSubString, palin);
		}
		System.out.println("Method 2: Longest sub-String = "+longestSubString);
	}
}
