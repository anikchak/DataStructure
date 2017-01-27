package practice.searchingsorting;

public class TwoSortedArrays {

	int totalElementCount(int arr[]){
		int count =0 ;
		for(int i=0;i<arr.length;i++){
			if(arr[i] != Integer.MIN_VALUE){
				count++;
			}else{
				break;
			}
		}
		return count;
	}
	
	public void merge(int a[], int b[]){
		int aCount = totalElementCount(a);
		int bCount = b.length;
		int totalElement = aCount+bCount-1;
		int i = aCount-1, j=bCount-1;
		while(i>=0 && j>=0){
			if(a[i]>b[j]){
				a[totalElement] = a[i];
				i--;
			}else{
				a[totalElement] = b[j];
				j--;
			}
			totalElement--;
		}
		while(j>=0){
			a[totalElement] = b[j];
			j--;
			totalElement--;
		}
		
		//Printing the result
		for(int k=0;k<a.length;k++){
			System.out.print(a[k]+" ");
		}
	}
	public static void main(String[] args) {
	int a[] = {1,3,5,9,10,11,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
	int b[] = {-2,-6,-7};
	TwoSortedArrays obj = new TwoSortedArrays();
	obj.merge(a, b);
	}

}
