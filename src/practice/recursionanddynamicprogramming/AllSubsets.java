package practice.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AllSubsets {

	public ArrayList<ArrayList<String>> getSubsets(ArrayList<String> set){
		ArrayList<ArrayList<String>> allSubSets = new ArrayList<ArrayList<String>>();
		int totalSubSets = 1<<set.size();
		for(int i=0;i<totalSubSets;i++){
			ArrayList<String> subset = fetchSubSets(i,set);
			allSubSets.add(subset);
		}
		return allSubSets;
	}
	
	public ArrayList<String> fetchSubSets(int x, ArrayList<String> set){
		ArrayList<String> newSets = new ArrayList<String>();
		int index = 0;
		for(int k=x;k>0;k = k>>1){
			
			if((k&1) == 1){
				newSets.add(set.get(index));
			}
			index++;
		}
		return newSets;
	}
	
	/*
	 * Method 2: Generate subsets using count algorithm
	 */
	public void generateSubSets(String s){
	HashMap<Character,Integer> m = new HashMap<Character, Integer>();
	//Mapping char count
	for(int i=0;i<s.length();i++){
		if(m.containsKey(s.charAt(i))){
			int val = m.get(s.charAt(i));
			m.put(s.charAt(i), ++val);
		}else{
			m.put(s.charAt(i), 1);
		}
	}
	//System.out.println(m);
	int count[] = new int[m.size()];
	char str[] = new char[m.size()];
	int index = 0;
	for(Map.Entry<Character,Integer> entry: m.entrySet() ){
		count[index] = entry.getValue();
		str[index] = entry.getKey();
		index++;
	}
	generateSubSetUtil(str,count,0,0,new char[s.length()]);
	}
	
	public void generateSubSetUtil(char[] str, int [] count, int index, int level, char[] result){
		
		
		for(int i=index; i<str.length;i++){
			if(count[i] != 0){
				count[i] = count[i]-1;
				result[level] = str[i];
				printResult(result,level);
				generateSubSetUtil(str, count, i, level+1, result);
				count[i] = count[i]+1;
			}
		}
	}
	
	public void printResult(char[] result, int level){
		System.out.println();
		for(int i=0;i<=level;i++){
			System.out.print(result[i]);
		}
	}
	/*
	 * End of Method 2
	 */
	public static void main(String args[]){
		AllSubsets as = new AllSubsets();
		ArrayList<String> set = new ArrayList<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		ArrayList<ArrayList<String>> result = as.getSubsets(set);
		for(ArrayList<String> r: result){
			for(String s : r){
				System.out.print(s);
			}
			System.out.println();
		}
		
		as.generateSubSets("abc");
	}
}
