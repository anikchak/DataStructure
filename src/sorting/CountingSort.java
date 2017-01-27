package sorting;

public class CountingSort {

	public int[] countingSort(int a[]){
		int countSize = getMax(a);
		int count[] = new int[countSize+1];
		int resultList[] = new int[a.length];
		//Initializing count array
		for(int i=0;i<count.length;i++){
			count[i] = 0;
		}
		
		//Calculating frequency of each element
		for(int i=0;i<a.length;i++){
			int val = a[i];
			count[val] = count[val]+1;
		}
		//Summing all count values
		for(int i=1;i<count.length;i++){
			count[i] = count[i]+count[i-1];
		}
		
		//Putting the elements from a to resultList array
		for(int i = a.length-1;i>=0;i--){
			int val = a[i];
			int pos = count[val];
			resultList[pos-1] = val;
			count[val] = count[val] - 1;
		}
		return resultList;
	}
	
	public int getMax(int a[]){
		int max = 0;
		for(int i=0;i<a.length;i++){
			if(a[i]>a[max]){
				max = i;
			}
		}
		return a[max];
	}
	public static void main(String[] args) {
		//int arr[] = {5,2,4,3,3,5,5,2,1};
		int arr[] = {14,33,27,10,35,19,42,44};
		CountingSort ob = new CountingSort();
		int resultList[] = ob.countingSort(arr);
		System.out.print("\nCounting Sort[Asc]:");
		for(int a:resultList){
			System.out.print(" "+a);
		}
	}

}
