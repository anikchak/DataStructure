package geekforgeeks;

import java.util.HashMap;

public class LongestSubStrWithoutRepeatingChar {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		//String s = "bbba";
		//String s = "abdefgabef";
		//String s = "abdbfgabef";
		HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
		int len=0,maxLen=0,end=0;
		hm.put(s.charAt(0), 0);
		for(int i=1;i<s.length();i++){
			if(hm.containsKey(s.charAt(i))){
				int prevIndex = hm.get(s.charAt(i));
				if((i-prevIndex)>maxLen){
					len++;
					hm.put(s.charAt(i), i);
				}else{
					len = i-prevIndex;
					hm.put(s.charAt(i), i);
				}
			}else{
				len++;
				hm.put(s.charAt(i), i);
			}
			if(len>maxLen){
				maxLen = len;
				end = i;
			}
		}
		System.out.println("MaxLen ="+maxLen+"<"+(end-maxLen+1)+","+end+">");
	}

}
