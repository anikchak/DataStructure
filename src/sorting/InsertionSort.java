package sorting;

public class InsertionSort {

	public static void insertionSort(int arr[]){
		int sz = arr.length;
		for(int i=0;i<sz-1;i++){
			if(arr[i]>arr[i+1]){
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				for(int j=i;j>0;j--){
					if(arr[j]<arr[j-1]){
						int temp1 = arr[j];
						arr[j] = arr[j-1];
						arr[j-1] = temp1;
					}
				}
			}
		}
		System.out.print("\n Insertion Sort: ");
		for(int a:arr){
			System.out.print(" "+a);
		}
	}
	
	public static void main(String args[]){
		int arr[] = {14,33,27,10,35,19,42,44};
		insertionSort(arr);
	}
}
