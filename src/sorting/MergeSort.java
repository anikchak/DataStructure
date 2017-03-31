package sorting;

public class MergeSort {
	
	int merge = 0;
	int split = 0;
	int comp = 0;
	public void mergeSort(int arr[],int start, int end){
		if(start<end){
			split++;
		int mid = (start+end)/2;
		//Divide the list into two halves
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		
		//Merge the sorted halves
		merge(arr,start,mid,end);
		}
	}
	public void merge(int a[], int s, int m, int e){
		merge++;
		int lIndex = (m-s)+1;
		int rIndex = e-m;
		//Creating left/right arrays
		int lArr[] = new int[lIndex];
		int rArr[] = new int[rIndex];
		
		//Assigning values to left-right arrays
		for(int i=0;i<lIndex;i++){
			lArr[i] = a[s+i];
		}
		for(int i=0;i<rIndex;i++){
			rArr[i] = a[m+1+i];
		}
		
		//Compare the values from left/right array
		int i=0,j=0,k=s;
		while(i<lIndex && j<rIndex){
			if(lArr[i] < rArr[j]){
				comp++;
				a[k] = lArr[i];
				i++;
			}else{
				a[k] = rArr[j];
				j++;
			}
			k++;
		}
		
		//Assigning remaining values if present to the array
		while(i<lIndex){
			a[k] = lArr[i];
			i++;
			k++;
		}
		
		while(j<rIndex){
			a[k] = rArr[j];
			j++;
			k++;
		}
		
		//return a;
	}
	public void print(int arr[]){
		System.out.println();
		for(int a: arr){
			System.out.print(" "+a);
		}
	}
	public static void main(String[] args) {
	//	int arr[] = {14,33,27,10,35,19,42,44};
		int arr[] = {1,2,3,4,5};
		MergeSort obj = new MergeSort();
		obj.mergeSort(arr, 0, arr.length-1);
		System.out.print("\nMerge Sort[Asc]: ");
		for(int a: arr){
			System.out.print(" "+a);
		}
		System.out.println("\nMerges ="+obj.merge);
		System.out.println("\nSplits ="+obj.split);
		System.out.println("Comp ="+obj.comp);
	}

}
