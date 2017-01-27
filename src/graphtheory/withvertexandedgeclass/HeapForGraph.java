package graphtheory.withvertexandedgeclass;

public class HeapForGraph {

	public void min_heap(int srcPt,int arr[],int size){
		int left = 2*srcPt+1;
		int right = 2*srcPt+2;
		int min;
		if(left<size && arr[left]<arr[srcPt]){
			min = left;
		}else{
			min = srcPt;
		}
		if(right<size && arr[right]<arr[min]){
			min = right;
		}
		
		if(min!=srcPt){
			swap(arr,srcPt,min);
			min_heap(min,arr,size);
		}
	}
	
	public void swap(int arr[],int src,int dest){
		int temp = arr[src];
		arr[src] = arr[dest];
		arr[dest] = temp;
	}
	
	public void build_heap(int arr[]){
		int size = arr.length;
		for(int i=size/2;i>=0;i--){
			min_heap(i, arr, size);
		}
		System.out.println("Value from build heap(Min) : ");
		display(arr);
	}
	
	public void display(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(" "+arr[i]);
		}
	}
	
	public void heapSort(int arr[]){
		int size = arr.length;
		build_heap(arr);
		for(int i=0;i<arr.length;i++){
			int temp = arr[0];
			arr[0] = arr[size-1];
			arr[size-1] = temp;
			min_heap(0, arr, --size);
		}
		System.out.println("\n\nHeap Sort (Descending Order)");
		display(arr);
	}
	
	public void extractMin(int arr[]){
		System.out.println("Min is ="+arr[0]);
	}
	public int[] deleteMin(int arr[]){
		build_heap(arr);
		int minVal = arr[0];
		int temp[] = arr;
		//System.out.println("\nlen="+arr.length);
		if(arr.length!=1){
			arr = new int[arr.length-1];
		System.arraycopy(temp, 1, arr, 0, temp.length-1);
		}else{
			arr = null;
		}
		temp = null;
		System.out.println("\nMin Value - Delete = "+minVal);
		return arr;
	}
	public static void main(String []args){
		HeapForGraph h = new HeapForGraph();
		int a[] = {10,9,8,7,3,4,1};
		//h.build_heap(a);
		//h.heapSort(a);
		//while(a!=null){
			a = h.deleteMin(a);
			h.heapSort(a);
		//}
	}
}
