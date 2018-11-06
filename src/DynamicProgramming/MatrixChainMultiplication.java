package DynamicProgramming;

public class MatrixChainMultiplication {

	public static int minCost(int dim[], int i, int j){
		if(i == j)
			return 0;
		int min = Integer.MAX_VALUE;
		for(int k=i;k<j;k++){
			int val = minCost(dim, i, k) + minCost(dim, k+1, j) + dim[i-1]*dim[k]*dim[j];
			if(val<min){
				min = val;
			}
		}
		return min;
	}
	/*
	 * Cost of Multiplication => M[i,j] = min{M[i][k]+M[k+1][j]+dim(i-1)*dim(k_*dim(j)} where i<=k<j
	 */
	public static void minCostDP(int dim[]){
		int n = dim.length;
		int M[][] = new int[n][n]; //Keeps track of computation cost
		int S[][] = new int[n][n]; //Keeps track of the parenthesis
		for(int i=0;i<n;i++){
			M[i][i] = 0;
			S[i][i] = 0;
		}
		for(int l=2;l<n;l++){
			for(int i=1;i<=n-l;i++){
				int j = i+l-1;
				M[i][j] = Integer.MAX_VALUE;
				for(int k=i;k<j;k++){ //Checking for each combination and then putting the minimum value 
					int val = M[i][k]+M[k+1][j]+dim[i-1]*dim[k]*dim[j];
					if(val<M[i][j]){
						M[i][j] = val;
						S[i][j] = k;
					}
				}
			}
		}
		/*
		System.out.println();
		for(int i=0;i<M.length;i++){
			for(int j=0;j<M[0].length;j++){
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}
		*/
		System.out.println("DP min cost = "+M[1][n-1]);
		System.out.println("Displaying parenthesization  = ");
		inorder(S,1,M[0].length-1);
	}
	public static void inorder(int S[][],int r,int c){
		if(S[r][c]!=0){
			System.out.print("(");
			inorder(S, r,S[r][c]);
		}
		if(S[r][c] == 0){
			System.out.print("A"+c);
		}
		if(S[r][c]!=0){
			inorder(S, S[r][c]+1, c);
			System.out.print(")");
		}
	}
	public static void main(String[] args) {
		int arr[] = new int[] {2,40,2,40,5};
		System.out.println("Min Cost = "+minCost(arr, 1, arr.length-1));
		minCostDP(arr);  
	}

}
