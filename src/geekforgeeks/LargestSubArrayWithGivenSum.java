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
		for(int i=0;i<arr.length;i++){
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
		}
		System.out.println("MaxLength="+maxLen);
	}

}
