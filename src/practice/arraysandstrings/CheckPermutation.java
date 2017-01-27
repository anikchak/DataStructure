/**
 * This code checks if given two strings are permutation of each other
 * */
package practice.arraysandstrings;

import java.util.HashMap;

public class CheckPermutation {

	public boolean isPermutationUsingMap(String str1, String str2){
		if(str1.length()!= str2.length()){
			return false;
		}
		HashMap<Character,Character> chMap = new HashMap<Character, Character>();
		for(int i=0;i<str1.length();i++){
			chMap.put(str1.charAt(i), str1.charAt(i));
		}
		int len = 0;
		for(int i=0;i<str2.length();i++){
			if(chMap.containsKey(str2.charAt(i))){
				chMap.remove(str2.charAt(i));
				len++;
			}
		}
		if(len == str2.length()){
			return true;
		}
		return false;
	}
	
	public boolean isPermutationUsingArray(String str1, String str2){
		if(str1.length()!= str2.length()){
			return false;
		}
		int len = str1.length();
		boolean chArr[] = new boolean[256];
		for(int i=0;i<chArr.length;i++){
			chArr[i] = false;
		}
		for(int i=0;i<len;i++){
			int c = str1.charAt(i);
			chArr[c] = true;
		}
		
		int match = 0;
		for(int i=0;i<len;i++){
			int c = str2.charAt(i);
			if(chArr[c]){
				chArr[c] = false;
				match++;
			}
		}
		
		if(match==len){
			return true;
		}
		return false;
	}
	
	public static void main(String args[]){
		CheckPermutation cp = new CheckPermutation();
		System.out.println(cp.isPermutationUsingMap("abc","bca"));
		System.out.println(cp.isPermutationUsingMap("abc","bcc"));
		System.out.println(cp.isPermutationUsingArray("xyz","zyx"));
		System.out.println(cp.isPermutationUsingArray("xyz","xxx"));
	}
}
