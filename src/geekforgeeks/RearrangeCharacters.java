/*
 * Given a string with repeated characters, task is rearrange characters in a string so that no two adjacent characters are same.

Note : It may be assumed that the string has only lowercase English alphabets.

Examples:

Input: aaabc 
Output: abaca 

Input: aaabb
Output: ababa 

Input: aa 
Output: Not Possible

Approach: 
1. Compute the frequency of each character
2. Create a Priority Queue based on the character frequency. Higher the frequency -> Higher Priority
3. Fetch the character with highest priority andn print it. Reduce the freq by 1
4. Store it as prev value. If the freq is not equal to 0 then push it back to priority q
 */
package geekforgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RearrangeCharacters {
	class Node{
		char ch;
		int freq;
		Node(char c, int f){
			this.ch = c;
			this.freq = f;
		}
	}
	public Node[] computeFreq(String s){
		HashMap<Character,Integer> m = new HashMap<Character, Integer>();
		Node n[] = null;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(m.containsKey(c)){
				int f = m.get(c);
				m.put(c, f+1);
			}else{
				m.put(c, 1);
			}
		}
		n = new Node[m.size()];
		int k=0;
		for(Map.Entry<Character,Integer> entry:m.entrySet()){
			char key = (char)entry.getKey();
			int freq = (int)entry.getValue();
			n[k] = new Node(key, freq);
			k++;
		}
		return n;
	}

	public void rearrangeCharacter(String s){
		Node n[] = computeFreq(s);
		buildMaxHeapOnFreq(n,n.length);
		Node prev = new Node('#',0);
		Node curr=null;
		StringBuffer sb = new StringBuffer();
		int size = n.length;
		while(size>0){
			curr = n[0];
			sb.append(curr.ch);
			curr.freq = curr.freq-1;
			if((size-1)>0){
				n[0] = n[size-1];
				size--;
				maxHeapify(n, 0, size);
			}else{
				size=0;
			}
			if(prev.freq>0){
				n[size] = prev;
				maxHeapifyInsert(n,size);
				size++;
			}
			prev = curr;
		}
		if(sb.toString().length()!=s.length()){
			System.out.println("Rearranged String for input "+s+" is not possible ");
		}else{
			System.out.println("Rearranged String for input "+s+" = "+sb.toString());
		}
	}
	
	public void buildMaxHeapOnFreq(Node[] n, int size){
		for(int i = size/2;i>=0;i--){
			maxHeapify(n,i,size);
		}
	}
	public void maxHeapify(Node n[], int pos, int size){
		int left = 2*pos+1;
		int right = 2*pos+2;
		int max = pos;
		if(left<size && n[left].freq>n[max].freq){
			max = left;
		}
		if(right<size && n[right].freq>n[max].freq){
			max = right;
		}
		if(max!=pos){
			Node temp = n[max];
			n[max] = n[pos];
			n[pos] = temp;
			maxHeapify(n, max, size);
		}
	}
	public void maxHeapifyInsert(Node n[],int index){
		int parentPos = index/2;
		if(n[index].freq>n[parentPos].freq){
			Node temp = n[parentPos];
			n[parentPos] = n[index];
			n[index] = temp;
		}
	}
	public static void main(String[] args) {
		RearrangeCharacters rc = new RearrangeCharacters();
		rc.rearrangeCharacter("aabb");
		rc.rearrangeCharacter("aa");
		rc.rearrangeCharacter("aaabc");
		rc.rearrangeCharacter("aaabb");
		rc.rearrangeCharacter("aaaabc");
	}

}
