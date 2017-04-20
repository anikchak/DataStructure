/*
 * Convert Binary Tree to Binary Search Tree
 * Restriction: The structure of the binary tree should be maintained. That is, both BT and BST should have the same structure.
 */
package geekforgeeks;

import java.util.Arrays;

public class BTToBST {
	
	class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
		}
	}
	public int countTreeNodes(Node n){
		if(n==null){
			return 0;
		}
		int leftSz = countTreeNodes(n.left);
		int rightSz = countTreeNodes(n.right);
		return leftSz+rightSz+1;
	}
	public int inorderTraverse(Node n, int a[], int index){
		if(n == null){
			return index;
		}
		index = inorderTraverse(n.left, a, index);
		a[index] = n.data;
		index++;
		index = inorderTraverse(n.right, a, index);
		return index;
	}
	
	public int buildBST(Node n, int a[],int index){
		if(n==null){
			return index;
		}
		index = buildBST(n.left, a, index);
		n.data = a[index];
		index++;
		index = buildBST(n.right, a, index);
		return index;
	}
	public void traverseBST(Node n){
		if(n==null){
			return;
		}
		traverseBST(n.left);
		System.out.print(n.data+" ");
		traverseBST(n.right);
	}
	public void buildBSTFromBT(Node n){
		int countNodes = countTreeNodes(n);
		int a[] = new int[countNodes];
		inorderTraverse(n, a, 0);
		for(int i: a){
			System.out.print(i+" ");
		}
		Arrays.sort(a);
		buildBST(n,a,0);
		System.out.println("\nBST traversal: ");
		traverseBST(n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTToBST b = new BTToBST();
		Node n = b.new Node(10);
		n.left = b.new Node(2);
		n.right = b.new Node(7);
		n.left.left = b.new Node(8);
		n.left.right = b.new Node(4);
//		Node n = b.new Node(10);
//		n.left = b.new Node(30);
//		n.left.left = b.new Node(20);
//		n.right = b.new Node(15);
//		n.right.right = b.new Node(5);
		b.buildBSTFromBT(n);
	}

}
