package heaps;

public class Heaps {

	static int arr[] = {0,4,7,8,3,2,6,5};
	public void max_heap(int arr[], int pos,int size){
		int l = 2*pos;
		int r = 2*pos+1;
		//int size = arr.length;
		int max;
		if(l<size && arr[l]>arr[pos]){
			max = l;
		}else{
			max = pos;
		}
		if(r<size && arr[r]>arr[max]){
			max = r;
		}
		if(max != pos){
			int temp = arr[pos];
			arr[pos] = arr[max];
			arr[max] = temp;
			max_heap(arr, max,size);
		}
	}
	
	public void displayArr(int ar[]){
		for(int a = 1 ; a <ar.length;a++ ){
			System.out.print(ar[a]+" ");
		}
	}
	
	public void build_heap(int a[]){
		int size = a.length;
		for(int i = (size/2); i>=1;i--){
			max_heap(a, i,size);
		}
		System.out.println("");
		displayArr(a);
	}
	
	public void heapSort(int a[]){
		int size = a.length;
		build_heap(a);
		System.out.println("\nHeap Sort: Ascending order");
		for(int i=1;i<a.length;i++){
			int temp  = a[1];
			a[1] = a[size-1];
			a[size-1] = temp;
			size = size-1;
			max_heap(a, 1, size);
		}
		displayArr(a);
	}
	public static void main(String args[])
	{
		Heaps h = new Heaps();
		for(int i=1;i<arr.length;i++)
		h.max_heap(arr, i,arr.length);
		h.displayArr(arr);
		
		//building heap
		int a[] = {0,1,4,3,7,8,9,10};
		h.build_heap(a);
		
		//Heap Sort
		int ar[] = {0,8,4,7,1,3,5};
		h.heapSort(ar);
	}
}
