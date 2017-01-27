package sorting;

public class QuickSort {
	
	public void quickSort(int arr[])
	{
		quickSortUtil(arr,0,arr.length-1);
	}
	
	public void quickSortUtil(int a[],int low,int high){
		int i=low,j=high;
		//Choosing pivot - which is median element of the array
		int pivot = a[(low+high)/2];
		
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
			quickSortUtil(a, i, high);
		}
		if(low<j){
			quickSortUtil(a, low, j);
		}
	}

	public static void main(String[] args) {
		//int arr[] = {14,33,27,10,35,19,42,44};
		int arr[] = {40,20,10,80,60,50,7,30,100};
		QuickSort ob = new QuickSort();
		ob.quickSort(arr);
		System.out.print("\nQuick Sort[Asc]: ");
		for(int a:arr){
			System.out.print(" "+a);
		}
	}

}
