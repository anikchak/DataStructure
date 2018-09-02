/*
 * Given an array of integers, find length of the largest subarray with sum equals to given integer.
 */
package geekforgeeks;

import java.util.HashMap;

public class LargestSubArrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
		int sumToFind = 0;
		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
		int currSum=0, maxLen=0;
		/*for(int i=0;i<arr.length;i++){
			currSum = currSum+arr[i];
			//System.out.println("CurrSum="+currSum);
			if(arr[i]==sumToFind && maxLen ==0){
				maxLen = 1;
			}
			if(currSum == sumToFind){
				maxLen = i+1;
			}
			if(hm.containsKey(currSum)){
				//System.out.println("Key="+currSum);
				int prevLen = hm.get(currSum);
				//System.out.println("PrevLen="+(i-prevLen));
				if((i-prevLen)>maxLen){
					//System.out.println("Inside if");
					maxLen = i-prevLen;
				//	hm.put(currSum, maxLen);
				}
			}else{
				hm.put(currSum, i);
			}
			//System.out.println("MaxLen="+maxLen);
		}*/
		System.out.println("MaxLength="+maxLen);
		int a1[] = {10,2,-2,-20,10};
		findSumSubArray(a1, -10);
		int a2[] = {1, 4, 20, 3, 10, 5};
		findSumSubArray(a2, 33);
		int a3[] = {-10, 0, 2, -2, -20, 10};
		findSumSubArray(a3, 20);
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
