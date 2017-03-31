package DynamicProgramming;

public class MatrixChainMultiplication {

	public static int minCost(int freq[], int i, int j){
		if(i == j)
			return 0;
		int min = Integer.MAX_VALUE;
		for(int k=i;k<j;k++){
			int val = minCost(freq, i, k) + minCost(freq, k+1, j) + freq[i-1]*freq[k]*freq[j];
			if(val<min){
				min = val;
			}
		}
		return min;
	}
	
	public static void minCostDP(int arr[]){
		int T[][] = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++){
			T[i][i] = 0;
		}
		for(int l=2;l<arr.length;l++){
			for(int i=0;i<arr.length-l;i++){
				int j = i+l;
				T[i][j] = Integer.MAX_VALUE;
				for(int k=i+1;k<j;k++){
					int val = T[i][k]+T[k][j]+arr[i]*arr[k]*arr[j];
					if(val<T[i][j]){
						T[i][j] = val;
					}
				}
			}
		}
		System.out.println("DP min cost = "+T[0][arr.length-1]);
	}
	public static void main(String[] args) {
		int arr[] = new int[] {2,3,6,4,5};
		System.out.println("Min Cost = "+minCost(arr, 1, arr.length-1));
		minCostDP(arr);  
	}

}
