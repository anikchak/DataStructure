package practice.arraysandstrings;

import java.util.Hashtable;

import hashtable.HashTable;

public class StringRotate {

	public boolean isStringRotated(String s1,String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		
		//Finding point of rotation
		int len = s1.length();
		int pos = -1;
		/*
		for(int i=len-1;i>=0;i--){
			if(s1.charAt(len-1) == s2.charAt(i)){
				pos=i;
				break;
			}
		}
		*/
		for(int i=0;i<len;i++){
			if(s1.charAt(i) == s2.charAt(0)){
				pos=i;
				break;
			}
		}
		
		if(pos == -1){
			return false;
		}
		
		int wordsRoatatedTillIndex = pos;
		System.out.println("Words have been rotated till index = "+(wordsRoatatedTillIndex-1));
		System.out.println("isSubstring = "+isSubString(s1, s2,pos));
		
		
		//Check if substring is present
		if(isSubString(s1, s2,pos)){
			for(int i=0;i<wordsRoatatedTillIndex;i++){
				if(s1.charAt(i) != s2.charAt((len-wordsRoatatedTillIndex)+i)){
					return false;
				}
			}
		}else {
			return false;
		}
		return true;
	}
	
	public boolean isSubString(String a, String b, int pos){
		int start = pos;
		int c=0, len = a.length()-pos;
		while(len>0){
			if(a.charAt(start) == b.charAt(c)){
				start++;
				c++;
				len--;
			}else{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringRotate sr = new StringRotate();
		System.out.println("Is String rotated = "+sr.isStringRotated("waterbottle", "ewaterbottl"));
	}

}
