/*
 * Given an array that contains both positive and negative integers, find the product of the maximum product subarray. 
 * Expected Time complexity is O(n) and only O(1) extra space can be used
 */
package geekforgeeks;

public class MaxProductArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {-2, -3, 0, -2, -40};
		int arr[] = {-1,-2,-3,4};
		int positive=1, negetive=1, ans=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0){
				positive = positive*arr[i];
				negetive = Math.min(1,negetive*arr[i]);
			}else if(arr[i]==0){
				positive = 0;
				negetive = 1;
			}else if(arr[i]<0){
				int prePos = positive;
				positive = negetive*arr[i];
				negetive = prePos*arr[i];
			}
			ans = Math.max(ans, positive);
			if(positive<=0){
				positive=1;
			}
		}
		System.out.println("Max Product = "+ans);
	}

}
