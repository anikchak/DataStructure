package stringstorage;

import java.util.HashMap;
import java.util.Map;

public class Tries {

	public class TriesNode{
		Map<Character,TriesNode> child;
		boolean endOfWord;
		TriesNode(){
			this.child = new HashMap<Character,TriesNode>();
			this.endOfWord = false;
		}
	}
	
	private TriesNode root = new TriesNode();
	//Inserting characters using iterative method
	public void insertItr(String word){
		TriesNode current = root;
		int wLen = word.length();
		for(int i=0;i<wLen;i++){
			char c = word.charAt(i);
			TriesNode node = current.child.get(c);
			if(node == null){
				node = new TriesNode();
				current.child.put(c, node);
			}
			current = node;
		}
		current.endOfWord = true;
		}
	
	//Inserting characters using recursion
	public void insertRecurse(String word){
		insertRecurseUtil(word,0,root);
	}
	
	public void insertRecurseUtil(String word, int index,TriesNode current){
		if(index == word.length()){
			current.endOfWord = true;
			return;
		}else{
			char c = word.charAt(index);
			TriesNode node = current.child.get(c);
			if(node == null){
				node = new TriesNode();
				current.child.put(c, node);
			}
			insertRecurseUtil(word, index+1, node);
		}
	}
	
	//Search word iteratively
	public boolean searchItr(String word){
		TriesNode current = root;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			TriesNode node = current.child.get(c);
			if(node == null){
				return false;
			}
			current = node;
		}
		return current.endOfWord;
	}
	
	//Search given word recursively
	public boolean searchRecurse(String word){
		return searchRecurseUtil(word,0,root);
	}
	
	public boolean searchRecurseUtil(String word,int index,TriesNode current){
		if(index == word.length()){
			return current.endOfWord;
		}
		char ch = word.charAt(index);
		TriesNode node = current.child.get(ch);
		if(node == null){
			return false;
		}
		return searchRecurseUtil(word, index+1, node);
	}
	
	public boolean prefixSearch(String word){
		return prefixSearch(word,0,root);
	}
	
	public boolean prefixSearch(String w,int index, TriesNode current){
		if(index == w.length()){
			return true;
		}
		char ch = w.charAt(index);
		TriesNode node = current.child.get(ch);
		if(node == null){
			return false;
		}else{
			return prefixSearch(w,index+1,node);
		}
	}
	
	public void deleteWord(String word){
		 deleteWord(word,0,root);
	}
	
	public boolean deleteWord(String w, int index, TriesNode current){
		if(index == w.length()){
			current.endOfWord = false;
			return current.child.isEmpty();
		}
		char ch =  w.charAt(index);
		TriesNode node  = current.child.get(ch);
		if(node == null){
			return false;
		}
		boolean removeChar = deleteWord(w, index+1, node);
		if(removeChar){
			current.child.remove(ch);
		}
		return current.child.isEmpty();
	}
	public static void main(String []args){
		Tries t = new Tries();
		t.insertRecurse("abc");
		t.insertRecurse("abcd");
		t.insertItr("ab");
		t.insertItr("lmn");
		t.insertItr("abce");
		System.out.println("c present = "+t.searchItr("c"));
		System.out.println("lmn present = "+t.searchRecurse("lmn"));
		System.out.println("Prefix lm present ? = "+t.prefixSearch("a"));
		t.deleteWord("lmn");
		
		System.out.println("After Delete: lmn present = "+t.searchRecurse("lmn"));
		System.out.println("After Delete: Prefix l present ? = "+t.prefixSearch("l"));
		
		t.deleteWord("abc");
		System.out.println("After Delete: abc present = "+t.searchRecurse("abc"));
		System.out.println("After Delete: Prefix abc present ? = "+t.prefixSearch("abc"));
		
	}
}
