package permutation;

import java.util.HashMap;
import java.util.Map;

public class Permutation {

	public void permutation(String str){
		permutationUtil(str,"");
	}
	
	public void permutationUtil(String str, String prefix){
		if(str.length()==0){
			System.out.println(prefix);
		}
		for(int i=0;i<str.length();i++){
			String rem = str.substring(0, i)+str.substring(i+1);
			permutationUtil(rem, prefix+str.charAt(i));
		}
	}
	
	/*
	 * Method 2: Recursion based on frequency count of each character - Tushar Roy style
	 */
	public void permutation2(String s){
		HashMap<Character,Integer> m = new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++){
			if(m.containsKey(s.charAt(i))){
				int val = m.get(s.charAt(i));
				m.put(s.charAt(i), ++val);
			}else{
				m.put(s.charAt(i), 1);
			}
		}
		int [] count  = new int[m.size()];
		char [] str = new char[m.size()];
		int index = 0;
		for(Map.Entry<Character, Integer> entry: m.entrySet()){
			count[index] = entry.getValue();
			str[index] = entry.getKey();
			index++;
		}
		permUtil(str,count,0,new char[s.length()]);
	}
	
	public void permUtil(char[] str, int[] count, int level, char[] result){
		if(level == result.length){
			printResult(result);
			return;
		}
		
		for(int i=0;i<str.length;i++){
			if(count[i] != 0){
				count[i] = count[i]-1;
				result[level] = str[i];
				permUtil(str, count, level+1, result);
				count[i] = count[i]+1;
				
			}
		}
	}
	
	public void printResult(char[] result){
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]);
		}
		System.out.println();
	}
	/*
	 * End of method 2
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation p = new Permutation();
		//p.permutation("abc");
		p.permutation2("abc");
	}

}
