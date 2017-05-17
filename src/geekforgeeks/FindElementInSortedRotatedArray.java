/*
 * An element in a sorted array can be found in O(log n) time via binary search. 
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.  
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
 */
package geekforgeeks;

public class FindElementInSortedRotatedArray {

	public int searchElement(int a[],int low, int high, int x){
		if(low>high) return -1;
		
		int mid = low + (high-low)/2;
		if(a[mid]==x) return mid;
		if(a[low]<=a[mid]){
			if(x>=a[low] && x<=a[mid]){
				return searchElement(a, low, mid-1, x);
			}else{
				return searchElement(a, mid+1, high, x);
			}
		}else{
			if(x>=a[mid] && x<=a[high]){
				return searchElement(a, mid+1, high, x);
			}else{
				return searchElement(a, low, mid-1, x);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindElementInSortedRotatedArray o = new FindElementInSortedRotatedArray();
		int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
		//int index = o.searchElement(arr, 0, arr.length-1, 3);
		System.out.println("Element present at index = "+o.searchElement(arr, 0, arr.length-1, 3));
		System.out.println("Element present at index = "+o.searchElement(arr, 0, arr.length-1, 13));
		System.out.println("Element present at index = "+o.searchElement(arr, 0, arr.length-1, 6));
	}

}
