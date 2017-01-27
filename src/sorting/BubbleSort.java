package sorting;

public class BubbleSort {

	public static void bubbleSort(int arr[]){
		int sz = arr.length;
		boolean swapped = false;
		for(int i=0;i<sz-1;i++){
			swapped = false;
			for(int j=0;j<sz-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped){
				break;
			}
		}
		
		System.out.print("\nBubble Sort[Asc Order]:");
		for(Integer a: arr){
			System.out.print(" "+a);
		}
	}
	public static void main(String[] args) {
		int arr[] = {14,33,27,35,10};
		bubbleSort(arr);
	}
}
