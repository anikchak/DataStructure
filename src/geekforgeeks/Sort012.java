/*
 * Given: Randomly arranged array having values 0,1,2. Perform sort. 
 * This probem is similar to Dutch Flag problem
 */
package geekforgeeks;

public class Sort012 {

	public static void sort012(int[] arr){
		int lo=0, mid=0, temp=0, high = arr.length-1;
		while(mid<=high){
			if(arr[mid]==0){
				//swap mid and low
				if(arr[mid]!=arr[lo]){ //This is done to prevent swapping of values which are same 
				temp = arr[mid];
				arr[mid] = arr[lo];
				arr[lo] = temp;
				}
				mid++;
				lo++;
			}else if(arr[mid]==1){
				mid++;
			}else if(arr[mid]==2){
				if(arr[mid]!=arr[high]){ //This is done to prevent swapping of values which are same
				temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				}
				high--;
			}
		}
	}
	public static void main(String args[]){
		int arr[] = {1,0,2,0,1,2,2,1,0};
		sort012(arr);
		for(int a:arr){
			System.out.print(a+" ");
		}
	}
}
