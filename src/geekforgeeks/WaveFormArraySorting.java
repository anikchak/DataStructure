/*
 * Given an unsorted array of integers, sort the array into a wave like array. 
 * An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..

Examples:

 Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
 Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
                 {20, 5, 10, 2, 80, 6, 100, 3} OR
                 any other array that is in wave form

 Input:  arr[] = {20, 10, 8, 6, 4, 2}
 Output: arr[] = {20, 8, 10, 4, 6, 2} OR
                 {10, 8, 20, 2, 6, 4} OR
                 any other array that is in wave form

 Input:  arr[] = {2, 4, 6, 8, 10, 20}
 Output: arr[] = {4, 2, 8, 6, 20, 10} OR
                 any other array that is in wave form

 Input:  arr[] = {3, 6, 5, 10, 7, 20}
 Output: arr[] = {6, 3, 10, 5, 20, 7} OR
                 any other array that is in wave form
 */
package geekforgeeks;

public class WaveFormArraySorting {

	public static void main(String[] args) {
		int arr[] = {2, 4, 6, 8, 10, 20};
		//int arr[] = {10, 5, 6, 3, 2, 20, 100, 110};
		int n = arr.length;
		System.out.println("Before Sort = ");
		for(int i:arr){
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i=1;i<n;i=i+2){
			if((i-1>=0) && arr[i]>arr[i-1]){
				int temp = arr[i-1];
				arr[i-1] = arr[i];
				arr[i] = temp;
			}else if((i+1<=n-1) && arr[i+1]<arr[i]){
				int temp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
		}
		System.out.println("After Sort = ");
		for(int i:arr){
			System.out.print(i+" ");
		}
	}

}
