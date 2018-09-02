/*
 * Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. Expected time complexity is O(n).
 */
package geekforgeeks;

import java.util.HashMap;


public class LargestSubArrayWithEqualZeroOne {

	public static void main(String[] args) {
		int a[] = {1, 0, 1, 1, 0, 1, 1};
		//int a[] = {15, -2, 2, -8, 1, 7, 10, 23};
		for(int i=0;i<a.length;i++){
			if(a[i] == 0){
				a[i] = -1;
			}
		}
		
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int currSum = 0, maxLen=0, start=0, end=-1,sumToFind = 0;
		for(int i=0;i<a.length;i++){
			currSum = currSum+a[i];
			if(currSum == sumToFind){
				maxLen = i+1;
				end = i;
			}
			if(hm.containsKey(currSum-sumToFind)){
				int prevLen = hm.get(currSum-sumToFind);
				if(maxLen<(i-prevLen)){
					maxLen = i-prevLen;
					//hm.put(currSum, maxLen);
					end = i;
				}
			}
			else{
				hm.put(currSum,i);
			}
		}
		System.out.println("Start="+(end-maxLen+ 1)+" End="+end);
	}

}
