/*
 * This program creates a Height Balanced tree using a sorted array (in ascending order).
 */
package practice.tree;

import java.util.ArrayList;

public class MinimalHtTree<T> {
	public Node<T> createMinimalHtBST(T arr[], int start, int end){
		if(end<start){
			return null;
		}
		int mid = (start+end)/2;
		Node<T> n = new Node<T>(arr[mid]);
		n.left = createMinimalHtBST(arr, start, mid-1);
		n.right = createMinimalHtBST(arr, mid+1, end);
		return n;
		
	}

	public void traverseTree(Node<T> node){
		if(node == null){
			return;
		}
		traverseTree(node.left);
		System.out.print(node.data +" ");
		traverseTree(node.right);
	}
	public static void main(String[] args) {
		Integer arr[] = {1,2,3,4,5,6,7,8};
		MinimalHtTree<Integer> mht = new MinimalHtTree<Integer>();
		Node<Integer> root = mht.createMinimalHtBST(arr, 0, arr.length-1);
		mht.traverseTree(root);
		
		ArrayList al = new ArrayList();
		System.out.println("\n\n"+al.size());
		
	}

}
