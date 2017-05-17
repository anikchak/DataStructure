package geekforgeeks;

import java.util.HashMap;

public class LongestSubStrWithoutRepeatingChar {

	public static void main(String[] args) {
		//String s = "geeksforgeeks";
		//String s = "bbba";
		//String s = "abdefgabef";
		String s = "abdbfgabef";
		HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
		int len=1,maxLen=1,end=0;
		hm.put(s.charAt(0), 0);
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)!=s.charAt(i-1)){
				if(hm.containsKey(s.charAt(i))){
					int lastIndex = hm.get(s.charAt(i));
					if((i-lastIndex)>maxLen){
						len++;
						end = i;
					}
				hm.put(s.charAt(i), i);
				}else{
					len++;
					hm.put(s.charAt(i), i);
				}
			}else{
				hm.put(s.charAt(i), i);
			}
			if(len>maxLen){
				end = i;
				maxLen = len;
			}
		}
		System.out.println("MaxLen ="+maxLen+"<"+(end-maxLen+1)+","+end+">");
	}

}
