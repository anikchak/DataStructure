package DynamicProgramming;

public class OptimalBinaryTree {
	
	class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
			this.left = null;
			this.right = null;
		}
	}
	Node root = null;
	public int optimalBinaryTreeRecur(int input[], int freq[], int low, int high, int depth){
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
	/*
	 * Cost of optimal bst = min{cost[i,k-1]+cost[k+1,j]+weight} where i<k<=j
	 */
	public void optimalBinaryTreeDP(int input[], int freq[]){
		int n = input.length;
		int T[][] = new int[n][n];
		int S[][] = new int[n][n]; //This matrix is used to track the keys which will be used to form optimal BST 
		
		for(int i=0;i<input.length;i++){
			T[i][i] = freq[i];
			S[i][i] = i;
		}
		for(int l=2;l<=input.length;l++){
			for(int i=0;i<=input.length-l;i++){
				int j = i+l-1;
				T[i][j] = Integer.MAX_VALUE;
				int wt = getSum(i,j,freq); //For each range of [i,j] calculate the weight = sum of frequencies of nodes under consideration
				for(int k=i;k<=j;k++){
					int val = wt/*sum of frequencies*/+((k-1<i)?0:T[i][k-1])/*for range cost[i][k-1]*/+((k+1>j)?0:T[k+1][j])/*for range cost[k+1][j]*/;
					// The above formula is inspired by recursion based method.
					if(val<T[i][j]){
						T[i][j] = val;
						S[i][j] = k;
					}
				}
			}
		}
		System.out.println("Min Cost DP = "+T[0][input.length-1]);
		System.out.println("Printing tree structure");
		root = generateTree(S,0,n-1,input);
		traverseTree(root);
	}
	public Node generateTree(int S[][],int low,int high,int input[]){
		if(low>high) return null;
		int key = S[low][high];
		Node newNode = new Node(input[key]);

		if(newNode.left==null){
			newNode.left = generateTree(S, low, key-1, input);
		}
		if(newNode.right==null){
			newNode.right = generateTree(S, key+1, high, input);
		}
		return newNode;
	}
	public void traverseTree(Node n){
		if(n==null) return;
		traverseTree(n.left);
		System.out.print(n.data+" ");
		traverseTree(n.right);
	}
	public int getSum(int i, int j, int freq[]){
		int sum=0;
		for(int k=i;k<=j;k++){
			sum = sum+freq[k];
		}
		return sum;
	}

	public static void main(String[] args) {
		int input[] = {10,12,16,21};
        int freq[] = {4,2,6,3};
        OptimalBinaryTree obst = new OptimalBinaryTree();
        int minCost = obst.optimalBinaryTreeRecur(input, freq, 0, input.length-1, 1);
        System.out.println("Min Cost(Recur) = "+minCost);
        obst.optimalBinaryTreeDP(input, freq);
	}

}
