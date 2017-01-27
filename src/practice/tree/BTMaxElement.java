/*
 * This program is used to find the max element in Binary Tree
 */
package practice.tree;
class BinaryTreeNode{
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	public BinaryTreeNode(int d) {
		this.data = d;
	}
}

public class BTMaxElement {

	public int findMaxElement(BinaryTreeNode n, int max){
		if(n==null){
			return max;
		}
		else{
			if(n.data > max){
				max = n.data;
			}
			max = findMaxElement(n.left, max);
			max = findMaxElement(n.right, max);
			return max;
		}
	}
	
	public static void main (String args[]){
		BTMaxElement bt = new BTMaxElement();
		int max = Integer.MIN_VALUE;
		BinaryTreeNode n = new BinaryTreeNode(10);
		n.left = new BinaryTreeNode(5);
		n.right = new BinaryTreeNode(20);
		n.left.left = new BinaryTreeNode(1);
		n.left.right = new BinaryTreeNode(80);
		
		System.out.println("Max Element = "+bt.findMaxElement(n, max));
		
	}
}
