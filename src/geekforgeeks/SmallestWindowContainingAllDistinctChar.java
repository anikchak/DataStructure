/*
 * Given a string, find the smallest window length with all distinct characters of the given string. 
 * For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .

Examples:

Input  : aabcbcdbca
Output : 4
Explanation : dbca of length 4 is the smallest 
              window with highest number of distinct
              characters.         

Input : aaab
Output : 2
Explanation : ab of length 2 is the smallest window 
              with highest number of distinct characters.
 */
package geekforgeeks;

public class SmallestWindowContainingAllDistinctChar {
	public void findSmallestDistinctWindow(String s){
		int sLen = s.length();
		//Compute the length of distinct characters
		boolean visited[] = new boolean[256];
		int distinctCharCount = 0;
		
		for(int i=0;i<sLen;i++){
			char ch = s.charAt(i);
			if(!visited[(int)ch]){
				visited[(int)ch] = true;
				distinctCharCount++;
			}
		}
		System.out.println("Total distinct chars = "+distinctCharCount);
		//Now, compute the distinct char count frequency with input string to find the smallest window
		int freqInput[] = new int[256];
		int start=0,startIndex=-1,minLen = Integer.MAX_VALUE, count=0;
		for(int i=0;i<sLen;i++){
			char ch = s.charAt(i);
			freqInput[(int)ch]++;
			//Comparing with 1 as the distinct element freq will be 1
			//If any distinct character found then increment the count
			if(freqInput[(int)ch]==1){
				count++;
			}
			//System.out.println("itr = "+i+" count="+count);
			if(count==distinctCharCount){
				//Check the frequency from element[start]
				while(freqInput[s.charAt(start)]>1){
					if(freqInput[s.charAt(start)]>1){
						freqInput[s.charAt(start)]--;
					}
					start++;
				}
				int len = i-start+1;
				//System.out.println("We are here itr = "+i+" len = "+len+ " start = "+start);
				if(len<minLen){
					minLen = len; 
					startIndex = start;
				}
			}
		}
		if(startIndex==-1){	
			System.out.println("No window with distinct characters found");
		}else{
			System.out.println("Min window length = "+minLen+" Start index = "+startIndex);
			if(minLen==distinctCharCount)
			System.out.println("Window = "+s.substring(startIndex,startIndex+minLen));
			else{
				System.out.println("No continuous disctinct char window found");
			}
		}
	}
	public static void main(String[] args) {
		String s = "caab";
		SmallestWindowContainingAllDistinctChar sw = new SmallestWindowContainingAllDistinctChar();
		sw.findSmallestDistinctWindow(s);
	}

}
