package geekforgeeks;

import java.util.Hashtable;
import java.util.LinkedList;

public class FirstNonRepeatingChar {

	public void firstNonRepeatingChar(String s){
		
		LinkedList<Character> list = new LinkedList<Character>();
		Hashtable<Character,Boolean> visited = new Hashtable<Character, Boolean>();
		Hashtable<Character,Boolean> removed = new Hashtable<Character, Boolean>();
		
		for(int i=0; i<s.length();i++){
			char ch = s.charAt(i);
			if(visited.containsKey(ch)){
				if(!removed.containsKey(ch)){
					removed.put(ch,true);
					//Remove this character from the list as well
					for(int j=0;j<list.size();j++){
						char c = list.get(j);
						if(c == ch){
							list.remove(j);
						}
					}
				}
			}else{
				list.add(ch);
				visited.put(ch, true);
			}
		}
		System.out.println("Final List Elements = "+list);
		System.out.println("First Non-Repeating element="+((list.isEmpty())?"All elements repeat":list.get(0)));
	}
	public static void main(String args[]){
		FirstNonRepeatingChar f = new FirstNonRepeatingChar();
		f.firstNonRepeatingChar("GEEKSFORGEEKS");
		f.firstNonRepeatingChar("GEEKSQUIZ");
	}
}
