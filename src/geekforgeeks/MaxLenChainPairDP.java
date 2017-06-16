/*
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. 
 * A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. 
 * Find the longest chain which can be formed from a given set of pairs.
 * For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }, 
 * then the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
 */
package geekforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

class Chain{
	int start;
	int end;
	Chain(int s, int e){
		this.start = s;
		this.end = e;
	}
}
class ChainSort implements Comparator<Chain>{

	@Override
	public int compare(Chain o1, Chain o2) {
		return o1.start - o2.start;
	}
	
}
public class MaxLenChainPairDP  {
	public static void main(String[] args) {
		MaxLenChainPairDP m = new MaxLenChainPairDP();
		List<Chain> al = new ArrayList<Chain>();
		
		al.add(new Chain(5,24));
		al.add(new Chain(39,60));
		al.add(new Chain(15,28));
		al.add(new Chain(27,40));
		al.add(new Chain(50,90));
		Collections.sort(al,new ChainSort());
		System.out.println("After Sorting");
		for(Chain c:al){
			System.out.println(c.start+" "+c.end);
		}
		/*
		 * Greedy Algorithm problem: Time Complexity - O(nlogn)
		 */
		//Now check if end(i)<start(i+1); if true then add this value to the result list
		Vector<Integer> res = new Vector<Integer>();
		int i=0;
		res.add(0);
		for(int j=1;j<al.size();j++){
			Chain a = al.get(i);
			Chain b = al.get(j);
			if(a.end <= b.start){
				res.add(j);
				i=j;
			}
		}
		System.out.println("Greedy Algo: Longest Chain = "+res.size()+" values at given index form longest chain="+res);
		/*
		 * DP Algorithm: Time Complexity - O(n^2)
		 * Logic here is to find Longest Increasing Subsequence (LIS) with a twist. Here we are comparing end(i) with start(i+1)
		 */
		int len[] = new int[al.size()];
		int max = 0;
		for(int k=0;k<len.length;k++){
			len[k] = 1;
		}
		for(int k=1;k<len.length;k++){
			for(int j=0;j<k;j++){
				Chain a = al.get(k);
				Chain b = al.get(j);
				if(b.end<=a.start && len[k]<len[j]+1){
					len[k] =len[j]+1;
					if(len[k]>max){
						max = len[k];
					}
				}
			}
		}
		System.out.println("Dp: max chain length = "+max);
	}

}
