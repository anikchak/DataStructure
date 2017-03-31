/*
 * In this code anagrams are being rearranged
 * Input:
 * 1.CAT
 * 2.DOG
 * 3.TAC
 * 4.ACT
 * 5.GOD
 * 6.ODG
 * 
 * Output:
 * 1.CAT 1,3,4
 * 2.DOG 2,5,6
 * 3.TAC 1,3,4
 * 4.ACT 1,3,4
 * 5.GOD 2,5,6
 * 6.ODG 2,5,6
 */
package geekforgeeks;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AnagramRearrange {

	public void rearrange(String arr[]){
		boolean visited[] = new boolean[arr.length];
		ArrayList position[] = new ArrayList[arr.length];
		ArrayList<Character> sList= new ArrayList<Character>();
		//Initializing visited to false
		for(int i=0;i<visited.length;i++){
			visited[i] = false;
		}
		//Initializing positions
		for(int i=0;i<position.length;i++){
			position[i] = new ArrayList();
			position[i].add(i);
		}
		
		for(int i=0;i<arr.length;i++){
			if(!visited[i]){
				String curr = arr[i];
				visited[i] = true;
				sList.clear();
				for(int j=0;j<curr.length();j++){
					sList.add(curr.charAt(j));
				}
				ArrayList<Character> temp = new ArrayList<Character>();
				temp.addAll(sList);
				
				for(int j=i+1;j<arr.length;j++){
					String now = arr[j];
					boolean flag = true;
					//Check lengths
					if(curr.length() == now.length() && !visited[j]){
						for(int k=0;k<now.length();k++){
							if(!temp.contains(now.charAt(k))){
								flag = false;
								break;
							}else{
								temp.remove(new Character(now.charAt(k)));
							}
						}
						
						if(flag){
							visited[j] = true;
							ArrayList<Integer> p = position[i];
							p.add(j);
							for(int k=1;k<p.size();k++){
								ArrayList<Integer> pos = position[p.get(k)];
								pos.clear();
								pos.addAll(p);
							}
						}
					}//End of len if
					temp.clear();
					temp.addAll(sList);
				}//end of j loop
			}
		}//end of i loop
		
		for(int i=0;i<position.length;i++){
			System.out.println(arr[i]+" "+position[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagramRearrange a = new AnagramRearrange();
		String arr[] = {"CAT","DOG","TAC","ACT","GOD","ODG","CAA","ACA"};
		//String arr[] = {"CAT","CAA"};
		a.rearrange(arr);
	}

}
