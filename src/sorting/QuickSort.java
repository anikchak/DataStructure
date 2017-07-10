/*
 * Quick Sort:
 * This program has been done in three ways
 * 1. Choose - Pivot as the Mid element
 * 2. Choose - Pivot as First element
 * 3. Choose - Pivot as Last element
 * 4. Generic Method
 */
package sorting;

public class QuickSort {
	
	/*
	 * CHOICE 1: Middle element is chosen as pivot - Starts
	 */
	public void quickSortMiddleElementPivot(int arr[])
	{
		quickSortMiddleElementPivot(arr,0,arr.length-1);
	}
	
	public void quickSortMiddleElementPivot(int a[],int low,int high){
		int i=low,j=high;
		//Choosing pivot - which is middle element of the array
		int pivot = a[(low+high)/2];
		int pivotIndex = (low+high)/2;
		while(i<=j){
			//comparing LHS value with pivot
			while(a[i]<pivot){
				i++;
			}
			//comparing RHS value with pivot
			while(pivot<a[j]){
				j--;
			}
			//A value greater than pivot has been found in LHS of pivot and a value smaller than pivot has been 
			//found in the RHS of pivot. Hence swap the values; subjected the left(i) and right(j) indexes have not cris-crossed
			if(i<=j){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		
		//If the left-right indexes have criss-cross; then recurse 
		if(i<high){
			quickSortMiddleElementPivot(a, i, high);
		}
		if(low<j){
			quickSortMiddleElementPivot(a, low, j);
		}
	}
	/*
	 * CHOICE 1: Middle element is chosen as pivot - Ends
	 */
	/*
	 * CHOICE 2: First Element is chosen as pivot - Starts
	 */
	public void quickSortFirstElementPivot(int a[]){
		quickSortFirstElementPivot(a, 0, a.length-1);
	}
	public void quickSortFirstElementPivot(int a[],int low, int high){
		if(low<high){
			int pivotIndex = partitionFirstElementPivot(a,low, high);
			quickSortFirstElementPivot(a, low, pivotIndex-1);
			quickSortFirstElementPivot(a, pivotIndex+1, high);
		}
	}
	public int partitionFirstElementPivot(int a[], int low, int high){
		int pivot = a[low];
		int pivotIndex = low;
		for(int i=low+1;i<=high;i++){
			if(a[i]<=pivot){
				//Swap elements
				int temp = a[i];
				a[i] = a[pivotIndex];
				a[pivotIndex] = temp;
				pivotIndex++;
			}
		}
		//Move the pivot to its actual position
		int temp = a[low];
		a[low] = a[pivotIndex];
		a[pivotIndex] = temp;
		return pivotIndex;
	}
	/*
	 * CHOICE 2: First Element is chosen as pivot - Ends
	 */
	/*
	 * CHOCE 3: Last Element is chosen as pivot - Starts
	 */
	public void quickSortLastElementPivot(int a[]){
		quickSortLastElementPivotUtil(a,0,a.length-1);
	}
	public void quickSortLastElementPivotUtil(int a[],int low, int high){
		if(low<high){
			int pivotIndex = partitionLastElementPivot(a,low,high);
			quickSortLastElementPivotUtil(a, low, pivotIndex-1);
			quickSortLastElementPivotUtil(a, pivotIndex+1, high);
		}
	}
	public int partitionLastElementPivot(int a[], int low, int high){
		int pivot = a[high];
		int pivotIndex = low;
		for(int i=low;i<=high-1;i++){
			if(a[i]<=pivot){
				int temp = a[i];
				a[i] = a[pivotIndex];
				a[pivotIndex] = temp;
				pivotIndex++;
			}
		}
		int temp = a[pivotIndex];
		a[pivotIndex] = a[high];
		a[high] = temp;
		return pivotIndex;
	}
	/*
	 * CHOICE 3: Last Element is chosen as pivot - Ends
	 */
	/*
	 * CHOICE 4: Generic Solution - Starts
	 */
	public void quickSortGenericMethod(int a[]){
		quickSortGenericMethodUtil(a, 0, a.length-1);
	}
	public void quickSortGenericMethodUtil(int a[], int low, int high){
		if(low<high){
			int pIndex = partitionGenericMethod(a, low, high);
			quickSortGenericMethodUtil(a, low, pIndex-1);
			quickSortGenericMethodUtil(a, pIndex+1, high);
		}
	}
	public int partitionGenericMethod(int a[], int low, int high){
		//int pivot = a[low];
		//int pivot = a[high];
		int pivot = a[(low+high)/2];
		int pIndex = low;
		for(int i=low;i<high;i++){
			if(a[i]<pivot){
				int temp = a[pIndex];
				a[pIndex] = a[i];
				a[i] = temp;
				pIndex++;
			}else if(a[i]==pivot){
				int temp = a[high];
				a[high] = a[i];
				a[i] = temp;
				i--;
			}
		}
		int temp = a[high];
		a[high] = a[pIndex];
		a[pIndex] = temp;
		return pIndex;
	}
	/*
	 * CHOICE 4: Generic Solution - Ends
	 */
	public static void main(String[] args) {
		//int arr[] = {14,33,27,10,35,19,42,44};
		//int arr[] = {40,20,10,80,60,50,7,30,100};
		
		QuickSort ob = new QuickSort();
		
		//Middle element pivot
		int arr[] = {2,3,4,6,5,1};
		ob.quickSortMiddleElementPivot(arr);
		System.out.print("Quick Sort[Asc] (Pivot = Middle Element): ");
		for(int a:arr){
			System.out.print(" "+a);
		}
		System.out.println();
		
		//First element Pivot
		int arr1[] = {2,3,4,6,5,1};
		ob.quickSortMiddleElementPivot(arr1);
		System.out.print("Quick Sort[Asc] (Pivot = First Element): ");
		for(int a:arr1){
			System.out.print(" "+a);
		}
		System.out.println();
		
		// Last element Pivot
		int arr2[] = { 2, 3, 4, 6, 5, 1 };
		ob.quickSortMiddleElementPivot(arr2);
		System.out.print("Quick Sort[Asc] (Pivot = Last Element): ");
		for (int a : arr2) {
			System.out.print(" " + a);
		}
		System.out.println();
		
		//Generic Method
		int arr3[] = { 2, 3, 4, 6, 5, 1 };
		ob.quickSortGenericMethod(arr3);
		System.out.print("Quick Sort[Asc] (Generic Method): ");
		for (int a : arr3) {
			System.out.print(" " + a);
		}
		System.out.println();
	}

}
