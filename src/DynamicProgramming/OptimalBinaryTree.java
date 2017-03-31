package DynamicProgramming;

public class OptimalBinaryTree {
	
	public static int optimalBinaryTreeRecur(int input[], int freq[], int low, int high, int depth){
		if(low>high) return 0;
		int min = Integer.MAX_VALUE;
		for(int i=low; i<=high;i++){
			int val = optimalBinaryTreeRecur(input, freq, low, i-1, depth+1)+
					optimalBinaryTreeRecur(input, freq, i+1, high, depth+1)+ freq[i]*depth;
			if(val<min){
				min = val;
			}
		}
		return min;
	}
	
	public static void optimalBinaryTreeDP(int input[], int freq[]){
		int T[][] = new int[input.length][input.length];
		
		for(int i=0;i<input.length;i++){
			T[i][i] = freq[i];
		}
		for(int l=2;l<=input.length;l++){
			for(int i=0;i<=input.length-l;i++){
				int j = i+l-1;
				T[i][j] = Integer.MAX_VALUE;
				int sum = getSum(i,j,freq);
				for(int k=i;k<=j;k++){
					int val = sum+((k-1<i)?0:T[i][k-1])+((k+1>j)?0:T[k+1][j]);
					if(val<T[i][j]){
						T[i][j] = val;
					}
				}
			}
		}
		System.out.println("Min Cost DP = "+T[0][input.length-1]);
	}
	
	public static int getSum(int i, int j, int freq[]){
		int sum=0;
		for(int k=i;k<=j;k++){
			sum = sum+freq[k];
		}
		return sum;
	}

	public static void main(String[] args) {
		int input[] = {10,12,16,21};
        int freq[] = {4,2,6,3};
        int minCost = optimalBinaryTreeRecur(input, freq, 0, input.length-1, 1);
        System.out.println("Min Cost(Recur) = "+minCost);
        optimalBinaryTreeDP(input, freq);
	}

}
