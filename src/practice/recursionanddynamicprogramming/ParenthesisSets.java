package practice.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParenthesisSets {

	public ArrayList<String> parenSet(int n){
		if(n==0){
			return null;
		}
		if(n==1){
			ArrayList<String> result = new ArrayList<String>();
			result.add("()");
			return result;
		}
		ArrayList<String> parenSubSet = parenSet(n-1);
		ArrayList<String> result = new ArrayList<String>();
		String newParen = ((List<String>) parenSubSet).get(parenSubSet.size()-1);
		newParen = newParen+"()";
		parenSubSet.add(newParen);
		
		for(String s : parenSubSet){
			//Calculate no. of left parenthesis
			int leftParenCount = countParen(s);
			int count=0,i=0;
			
			if(leftParenCount<n){
				while(count<leftParenCount && i<s.length()){
					if(s.charAt(i) == '('){
						String left = s.substring(0,i+1);
						String right = s.substring(i+1);
						String newSet = left+"()"+right;
						result.add(newSet);
						count++;
					}
					i++;
				}
			}else if(leftParenCount == n){
				result.add(s);
			}
		}
		return result;
	}
	
	public int countParen(String s){
		int count = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '('){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String args[]){
		ParenthesisSets ps = new ParenthesisSets();
		ArrayList<String> result = ps.parenSet(4);
		System.out.println(result);
		System.out.println(result.size());
		Set<String> s = new HashSet<String>();
		for(String str: result){
			s.add(str);
		}
		System.out.println("Set size = "+s.size());
	}
}
