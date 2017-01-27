package sorting;

public class ShellSort {

	public static void shellSort(int arr[]){
		int interval = 1;
		while (interval<(arr.length/3)){
			interval = 3*interval+1;
		}
		
		while(interval>0){
			for(int i=0;i<arr.length-1;i++){
				if((i+interval) < arr.length){
					if(arr[i+interval] < arr[i]){
						int temp = arr[i+interval];
						arr[i+interval] = arr[i];
						arr[i] = temp;
						for(int j=i;j>=0;j--){
							if((j-interval) >= 0 && arr[j] < arr[j-interval]){
								int temp1 = arr[j-interval];
								arr[j-interval] = arr[j];
								arr[j] = temp1;
							}
						}
					}
				}else{
					break;
				}
			}
			interval = (interval-1)/3;
		}
	}
	public static void main(String[] args) {
		int arr[] = {14,33,27,10,35,19,42,44};
		shellSort(arr);
		System.out.print("\nShell Sort[Asc]:");
		for(int a: arr){
			System.out.print(" "+a);
		}
	}

}
