/*
 * An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest to zero.
 */
package geekforgeeks;

import java.util.Arrays;

public class SumClosestToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 60, -10, 70, -80, 85};
		int sum =0, minSum = Integer.MAX_VALUE;
		int left=0,right=arr.length-1;
		int minLeft=0,minRight=0;
		Arrays.sort(arr);
		while(left<right){
			sum = arr[left]+arr[right];
			if(Math.abs(sum)<Math.abs(minSum)){
				minSum = sum;
				minLeft = arr[left];
				minRight = arr[right];
			}
			if(sum>0){
				right--;
			}else{
				left++;
			}
		}
		System.out.println("Min Sum = "+minSum+" is given by <"+minLeft+","+minRight+">");
	}

}
