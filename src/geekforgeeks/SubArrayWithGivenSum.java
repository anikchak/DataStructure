/*
 * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
 */
package geekforgeeks;

import java.util.HashMap;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
		int currSum = 0;
		//int a[] = {1,4,20,3,10,5};
		//int a[] = {-10,0,2,-2,-20,10};
		int a[] = {10,2,-2,-20,10};
		int sum = -10;
		for(int i=0;i<a.length;i++){
			currSum = currSum+a[i];
			if(currSum == sum){
				System.out.println("Range<0,"+i+">");
				return;
			}
			if(hm.containsKey(currSum-sum)){
				System.out.println("Range<"+(hm.get(currSum-sum)+1)+","+i+">");
				return;
			}
			hm.put(currSum, i);
		}
		System.out.println("no subarray returns the given sum");
	}

}
