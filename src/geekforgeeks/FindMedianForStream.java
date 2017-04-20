package geekforgeeks;

public class FindMedianForStream {

	public void heapSort(int a[], int len){
		int size = len;
		buildMinHeap(a,size);
		for(int i=0;i<len;i++){
			int maxElement = a[0];
			a[0] = a[size-1];
			a[size-1] = maxElement;
			size--;
			maxHeapify(a,0,size);
		}
		System.out.print("Sorted Array=");
		for(int i: a){
			System.out.print(i+" ");
		}
		System.out.println();
		//For calculating median
		System.out.println("Calculated Median = "+findMedian(a,len));
	}
	public void buildMinHeap(int a[], int size){
		for(int i = size/2;i>=0;i--){
			maxHeapify(a,i,size);
		}
	}
	public void maxHeapify(int a[],int pos, int size){
		int lIndex = 2*pos+1;
		int rIndex = 2*pos+2;
		int max = pos;
		if(lIndex<size && a[lIndex]>a[max]){
			max = lIndex;
		}
		if(rIndex<size && a[rIndex]>a[max]){
			max = rIndex;
		}
		if(max != pos){
			int temp = a[max];
			a[max] = a[pos];
			a[pos] = temp;
			maxHeapify(a, max, size);
		}
	}
	
	//Method to calculated Median
	public int findMedian(int a[], int size){
		if(size == 1){
			return a[size-1];
		}else{
			int median = -1;
			if((size%2) == 0){
				int mid = size/2;
				median = (a[mid]+a[mid-1])/2;
			}else{
				median = a[size/2];
			}
			return median;
		}
	}
	public static void main(String[] args) {
		FindMedianForStream s = new FindMedianForStream();
		int a[] = {5,15,1,3};
		s.heapSort(a, 1);
		s.heapSort(a, 2);
		s.heapSort(a, 3);
		s.heapSort(a, 4);
	}

}
