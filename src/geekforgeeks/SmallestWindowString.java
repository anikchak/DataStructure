/*
 * Given two strings string1 and string2, find the smallest substring in string1 containing all characters of string2 efficiently.
For Example:

Input :  string = "this is a test string"
         pattern = "tist"
Output :  Minimum window is "t stri"
Explanation: "t stri" contains all the characters
              of pattern.

Input :  string = "geeksforgeeks"
         pattern = "ork" 
Output :  Minimum window is "ksfor"
 */
package geekforgeeks;

public class SmallestWindowString {

	public void findSmallestWindow(String s, String p){
		int sLen = s.length();
		int pLen = p.length();
		int start = -1, startIndex = -1, minLen = Integer.MAX_VALUE,count=0,k=0;
		boolean matchFound = false;
		int freqPattern[] = new int[256];
		int freqInput[] = new int[256];
		//Compute the frequency for each character of Pattern
		for(int i=0;i<pLen;i++){
			freqPattern[(int)p.charAt(i)]++;
		}
		//Logic to find the smallest window
		for(int i=0;i<sLen;i++){
			char ch = s.charAt(i);
			freqInput[(int)ch]++;
			//If the current character is present in the pattern then increment the count of characters visited from pattern
			if(freqPattern[(int)ch]!=0 && freqInput[(int)ch]<=freqPattern[(int)ch]){
				count++;
				if(start==-1){
					start = i;
				}
			}
			if(count==pLen){
				while(freqInput[(int)s.charAt(start)]>freqPattern[(int)s.charAt(start)]
						|| freqPattern[(int)s.charAt(start)]==0){
					if(freqInput[(int)s.charAt(start)]>freqPattern[(int)s.charAt(start)]){
						freqInput[(int)s.charAt(start)]--;
					}
					start++;
				}
				int len = i-start+1;
				if(len<minLen){
					minLen = len;
					startIndex = start;
				}
			}
		}
		if(startIndex == -1){
			System.out.println("Pattern match not found in input string");
		}else{
			System.out.println("Min. window length = "+minLen+" Window start index = "+startIndex);
			System.out.println("Window = " + s.substring(startIndex,startIndex+minLen));
		}
	}
	public static void main(String[] args) {
		SmallestWindowString sw = new SmallestWindowString();
		String s = "this is a test string";
		String p = "tist";
		sw.findSmallestWindow(s, p);
	}

}
