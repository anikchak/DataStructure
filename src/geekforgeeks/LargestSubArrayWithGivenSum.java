/*
 * Given an array of integers, find length of the largest subarray with sum equals to given integer.
 */
package geekforgeeks;

import java.util.HashMap;

public class LargestSubArrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = {10,2,-2,-20,10};
		findSumSubArray(a1, -10);
		int a2[] = {1, 4, 20, 3, 10, 5};
		findSumSubArray(a2, 33);
		int a3[] = {-10, 0, 2, -2, -20, 10};
		findSumSubArray(a3, 20);
		int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
		findSumSubArray(arr, 0);
		int a4[] = {1, -1, 1, 1, -1, 1, 1};
		findSumSubArray(a4, 0);
	}
	
	public static void findSumSubArray(int a[], int sumToFind){ /*Use this method */
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int currSum=0, maxLen=0,prevIndex=0,e=0;
		for(int i=0;i<a.length;i++){
			currSum = currSum+a[i];
			if(currSum==sumToFind){
				maxLen = i+1;
				e=i;
			}
			if(hm.containsKey(currSum-sumToFind)){
				prevIndex = hm.get(currSum-sumToFind);
				if(maxLen<(i-prevIndex)){
					maxLen = i-prevIndex;
					e = i;
				}
			}
			else{
				hm.put(currSum, i);
			}
		}
		if(maxLen>0){
			System.out.println("MaxLen="+maxLen+" Start="+(e-maxLen+1)+" end="+e);
		}else{
			System.out.println("Sum not found");
		}
	}

}
