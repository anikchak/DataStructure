/*
 * Given an array that contains both positive and negative integers, find the product of the maximum product subarray. 
 * Expected Time complexity is O(n) and only O(1) extra space can be used
 */
package geekforgeeks;

public class MaxProductArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-2, -3, 0, -2, -40};
		int maxPos=1;
		int maxNeg=1;
		int max=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				maxPos=1;
				maxNeg=1;
			}else if(arr[i]>0){
				maxPos = maxPos*arr[i];
				if(maxNeg*arr[i] < 0){
					maxNeg = maxNeg*arr[i];
				}
				max = Math.max(max, maxPos);
			}else{
				int temp = maxPos;
				maxPos = Math.max(1, maxNeg*arr[i]);
				maxNeg = temp*arr[i];
				if(maxPos != 1){
					max = Math.max(max, maxPos);
				}
						
			}
		}
		System.out.println("max product = "+max);
	}

}
