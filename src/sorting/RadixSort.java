package sorting;

public class RadixSort {

	public void radixSort(int a[],int sig){
		//Calculating no. of digits 
		int sigVal = -1;
		while(sig>0){
			sig = sig/10;
			sigVal++;
		}
		//System.out.println("sigVal="+sigVal);
		int tempArr[] = new int[a.length];
		int k=0;
		
		//Perform Sort till all the significant values have been sorted
		while(k<=sigVal){
			for(int i=0;i<a.length;i++){
				int val = a[i];
				val = (int) (val / Math.pow(10, k));
				int rem = (int)(val % Math.pow(10, k+1));
				//Assigning the remainder = significant value to tempArray for sorting
				tempArr[i] = rem;
			}
			k++;
			//Performing count sort
			a = countingSort(tempArr,a);
			//display(a);
		}
		
		//Displaying the result
		System.out.print("\nRadix Sort:");
		display(a);
	}
	
	//Counting Sort Algo
	public int[] countingSort(int temp[],int actual[]){
		int countSize = getMax(temp);
		int count[] = new int[countSize+1];
		int resultList[] = new int[temp.length];
		//Initializing count array
		for(int i=0;i<count.length;i++){
			count[i] = 0;
		}
		
		//Calculating frequency of each element
		for(int i=0;i<temp.length;i++){
			int val = temp[i];
			count[val] = count[val]+1;
		}
		//Summing all count values
		for(int i=1;i<count.length;i++){
			count[i] = count[i]+count[i-1];
		}
		
		//Putting the elements from a to resultList array
		for(int i = temp.length-1;i>=0;i--){
			int val = temp[i];
			int actualVal = actual[i];
			int pos = count[val];
			resultList[pos-1] = actualVal;
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
	public void display(int a[]){
		for(int result:a){
			System.out.print(" "+result);
		}
	}
	public static void main(String[] args) {
		int a[] = {911,308,398,432,516,180};
		//int a[] = {14,33,27,10,35,19,42,44};
		//int a[] = {40,20,10,80,60,50,7,30,100};
		//int a[] = {4,2,1,8,6,5,7,3,9,0};
		RadixSort r = new RadixSort();
		
		//fetching the max value from the array
		int max = 0;
		for(int i=0;i<a.length;i++){
			if(a[i]>a[max]){
				max = i;
			}
		}
		r.radixSort(a,a[max]);
	}

}
