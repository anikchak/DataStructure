package sorting;

public class HeapSort {

	public int[] maxHeap(int arr[],int size, int parentPos){
		int lIndex = 2*parentPos+1;
		int rIndex = 2*parentPos+2;
		int max=parentPos;
		//checking if left child is greater than parent element
		if(lIndex<size && arr[max]<arr[lIndex]){
			max = lIndex;
		}else{
			max = parentPos;
		}
		//check if the right child element is greater than parent or left child
		if(rIndex<size && arr[max]<arr[rIndex]){
			max = rIndex;
		}
		
		if(max!=parentPos){
			int temp = arr[max];
			arr[max] = arr[parentPos];
			arr[parentPos] = temp;
			maxHeap(arr, size, max);
		}
		
		return arr;
	}
	
	public int[] buildHeap(int arr[], int size){
		for(int i=size/2;i>=0;i--){
			maxHeap(arr, size, i);
		}
		return arr;
	}
	
	public void heapSort(int arr[]){
		//build max to fetch max element
		buildHeap(arr, arr.length);
		int size = arr.length;
		//extract the max element and swap it with last element of the array
		//also reduce the size of the array each time after an element is extracted
		for(int i=0;i<arr.length;i++){
			int maxElement = arr[0];
			arr[0] = arr[size-1];
			arr[size-1] = maxElement;
			size-- ;
			//buildHeap(arr,size);
			maxHeap(arr, size, 0);
		}
		
		System.out.print("\nHeap Sort[Asc]:");
		for(int a:arr){
			System.out.print(" "+a);
		}
	}
	public static void main(String[] args) {
		int arr[] = {14,33,27,10,35,19,42,44};
		HeapSort h = new HeapSort();
		h.heapSort(arr);
	}

}
