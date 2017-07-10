package geekforgeeks;

public class NutsAndBoltsProblem {
	
	public void matchPattern(int nuts[],int bolts[], int low,int high){
		if(low<high){
			int pIndex = partition(bolts,low,high,nuts[(low+high)/2]);
			partition(nuts,low,high,bolts[pIndex]);
			matchPattern(nuts, bolts, low, pIndex-1);
			matchPattern(nuts, bolts, pIndex+1, high);
		}
	}

	public void display(int a[]){
		for(int i:a){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public int partition(int a[],int low,int high,int pivot){
		int pivotIndex = low;
		for(int i=low;i<high;i++){
			if(a[i]<pivot){
				int temp = a[i];
				a[i] = a[pivotIndex];
				a[pivotIndex] = temp;
				pivotIndex++;
			}else if(a[i]==pivot){
				int temp = a[high];
				a[high] = a[i];
				a[i] = temp;
				i--;
			}
		}
		int temp = a[high];
		a[high] = a[pivotIndex];
		a[pivotIndex] = temp;
		return pivotIndex;
	}
	public static void main(String[] args) {
		int nuts[] = {5,1,2,3,6,4};
		int bolts[] = {2,3,4,6,5,1};
		NutsAndBoltsProblem nb = new NutsAndBoltsProblem();
		nb.matchPattern(nuts, bolts, 0, nuts.length-1);
		System.out.println("result");
		nb.display(nuts);
		nb.display(bolts);
	}

}
