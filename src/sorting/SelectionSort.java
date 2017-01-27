package sorting;

public class SelectionSort {

	public static void selectionSort(int arr[]){
		int sz = arr.length;
		int min = 0;
		for(int i=0;i<sz-1;i++){
			min = i;
			for(int j=i+1;j<sz;j++){
				if(arr[j]<arr[min]){
					min = j;
				}
			}
			if(min!=i){
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		System.out.print("\nSelection Sort[Asc]: ");
		for(int a:arr){
			System.out.print(" "+a);
		}
	}
	public static void main(String[] args) {
		int arr[] = {14,33,27,10,35,19,42,44};
		selectionSort(arr);
	}

}
