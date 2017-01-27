package practice.arraysandstrings;

import java.util.HashMap;

public class Unique {
	public boolean isUniqueMap(String str){
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		char a[] = str.toLowerCase().toCharArray();
		for(int i=0;i<a.length;i++){
			if(map.containsKey(a[i])){
				return false;
			}else{
				map.put(a[i],a[i]);
			}
		}
		return true;
	}
	
	public boolean isUniqueNoDS(String str){
		for(int i=0;i<str.length();i++){
			char ch = str.toLowerCase().charAt(i);
			for(int j=i+1;j<str.length();j++){
				if(ch==str.toLowerCase().charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main (String args[]){
		Unique u = new Unique();
		System.out.println(u.isUniqueMap("aniket"));
		System.out.println(u.isUniqueNoDS("shivam"));
		System.out.println(u.isUniqueMap("anAs"));
		System.out.println(u.isUniqueNoDS("Anjali"));
		
	}
}
