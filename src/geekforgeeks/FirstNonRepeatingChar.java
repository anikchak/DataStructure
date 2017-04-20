package geekforgeeks;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
	/*
	 * Printing first non-repeated char for stream of characters
	 * Eg: ip: aabc op: a-1 b b
	 * */
	public void printFirstNonRepeat(String s){
	
		char c[] = s.toCharArray();
		LinkedList<Character> ll = new LinkedList<Character>();
		HashMap<Character,Boolean> visitedChar = new HashMap<Character, Boolean>();
		HashMap<Character,Boolean> removedChar = new HashMap<Character, Boolean>();
		
		for(int i=0;i<c.length;i++){
			char ch = c[i];
			if(visitedChar.containsKey(ch)){
				//If key => ch is contained in visitedChar , then it means that the key has already been encounter, hence this char is repeating
				//Check if this repeating char has been removed from list or not. If not then, remove it from list and add it to removedChar map
				if(!removedChar.containsKey(ch)){
					removedChar.put(ch, true);
					//Remove from list
					for(int j=0;j<ll.size();j++){
						if(ch == ll.get(j)){
							ll.remove(j);
						}
					}
				}
				//Check if the list is empty 
				if(ll.isEmpty()){
					System.out.print("-1 ");
				}else{
					System.out.print(ll.get(0)+" ");
				}
			}else{
				ll.add(ch);
				visitedChar.put(ch,true);
				System.out.print(ll.get(0)+" ");
			}
		}
		System.out.println();
	}
	/*
	 * End
	 * */
	public static void main(String args[]){
		FirstNonRepeatingChar f = new FirstNonRepeatingChar();
//		f.firstNonRepeatingChar("GEEKSFORGEEKS");
//		f.firstNonRepeatingChar("GEEKSQUIZ");
//		f.printFirstNonRepeat("aabc");
//		f.printFirstNonRepeat("aac");
//		f.printFirstNonRepeat("abba");
//		Scanner sc = new Scanner(System.in);
//		String s = sc.next();
		f.printFirstNonRepeat("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoqhnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcacehchzvfrkmlnozjkpqpxrjxkitzyxacbhhkicqcoendtomfgdwdwfcgpxiqvkuytdlcgdewhtaciohordtqkvwcsgspqoqmsboaguwnnyqxnzlgdgw");
	}
}
