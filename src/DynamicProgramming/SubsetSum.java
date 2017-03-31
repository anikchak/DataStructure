/*
 * Given a total and a set of numbers (an array of numbers). Find if the set elements sum up to the given total
 */
package DynamicProgramming;

public class SubsetSum {

	/*
	 * Recursive Method
	 */
	public static boolean sumSubset(int arr[], int total, int index){
		if(total == 0){
			return true;
		}
		if(index == arr.length){
			return false;
		}
		
		boolean retVal = false;
		for(int i=index;i<arr.length;i++){
			if(total >= arr[i]){
				retVal = sumSubset(arr, total-arr[i], i+1);
				if(retVal){
					return retVal;
				}
			}
		}
		return retVal;
	}
	/*
	 * End of Recursive method
	 */
	/*
	 * DP method
	 */
	public static void sumSubsetDP(int arr[], int total){
		int r = arr.length;
		int c = total;
		
		boolean T[][] = new boolean[r+1][c+1];
		
		for(int i=0;i<=r;i++){
			T[i][0] = true;
		}
		for(int i=1;i<=c;i++){
			T[0][i] = false;
		}
		
		//Populating grid
		for(int i=1;i<=r;i++){
			for(int j=1;j<=c;j++){
				if(j<arr[i-1]){
					T[i][j] = T[i-1][j];
				}else{
					if(T[i-1][j]){
						T[i][j] = T[i-1][j];
					}else{
						T[i][j] = T[i-1][j-arr[i-1]];
					}
				}
			}
		}
		
		boolean result = T[r][c];
		System.out.println("Result DP = "+result);
		
		//Tracing the path: Elements responsible for total
		int row =r, col =c;
		if(result){
			while(row!=0){
				if(T[row-1][col]){
					row = row-1;
				}else{
					System.out.print(arr[row-1]+" ");
					col = col-arr[row-1];
					row = row -1;
				}
			}
		}
		
	}
	/*
	 * End of DP Method
	 */
	public static void main(String[] args) {
		int a[] = {7,2,3,6};
		System.out.println("Is Sum present = "+sumSubset(a, 6, 0));
		sumSubsetDP(a, 13);
	}

}
