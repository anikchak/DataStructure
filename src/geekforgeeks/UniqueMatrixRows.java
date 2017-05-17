/*
 * Given a binary matrix, print all unique rows of the given matrix.

Input:
		{0, 1, 0, 0, 1}
        {1, 0, 1, 1, 0}
        {0, 1, 0, 0, 1}
        {1, 1, 1, 0, 0}
Output:
	0 1 0 0 1 
	1 0 1 1 0 
	1 1 1 0 0 
 */
package geekforgeeks;

import java.util.HashMap;

public class UniqueMatrixRows {

	/*
	 * Method 1: Convert each row values into decimal equivalent and then compare the values
	 */
	public void findUniqueRow(int [][]a){
		int row = a.length;
		int col = a[0].length;
		HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();
		for(int i=0;i<row;i++){
			int decimalVal = findDecimalEquivalent(a,i,col);
			if(!m.containsKey(decimalVal)){
				m.put(decimalVal, i);
				for(int j=0;j<col;j++){
					System.out.print(a[i][j]+",");
				}
				System.out.println();
			}
		}
	}
	public int findDecimalEquivalent(int a[][],int r,int c){
		int p=0,n=0;
		for(int j=c-1;j>=0;j--){
			n = n+(a[r][j]*(int)Math.pow(2, p));
			p++;
		}
		return n;
	}
	/*
	 * End of Method 1
	 */
	/*
	 * Method 2: Using Trie like structure
	 */
	class Node{
		boolean end;
		Node child[] = new Node[2];
		Node(){
			this.end = false;
			child[0] = null;
			child[1] = null;
		}
	}
	public void findUniqueRowMathod2(int a[][]){
		int r = a.length;
		int c = a[0].length;
		Node root = new Node();
		for(int i=0;i<r;i++){
			Node curr = root;
			for(int j=0;j<c;j++){
				int index = a[i][j];
				if(curr.child[index] == null){
					curr.child[index] = new Node();
				}
				curr = curr.child[index];
			}
			if(!curr.end){
				//Unique row
				curr.end = true;
				for(int j=0;j<c;j++){
					System.out.print(a[i][j]+",");
				}
				System.out.println();
			}
		}
	}
	/*
	 * End of Method 2
	 */
	public static void main(String[] args) {
		UniqueMatrixRows u = new UniqueMatrixRows();
		int a[][] = {
				{0, 1, 0, 0, 1},
		        {1, 0, 1, 1, 0},
		        {0, 1, 0, 0, 1},
		        {1, 1, 1, 0, 0}
		};
		System.out.println("Method 1 output:");
		u.findUniqueRow(a);
		int b[][] = {
				{0, 1, 0, 0, 1},
		        {1, 0, 1, 1, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 1, 1, 0}
		};
		System.out.println();
		System.out.println("Method 2 output:");
		u.findUniqueRowMathod2(b);
	}

}
