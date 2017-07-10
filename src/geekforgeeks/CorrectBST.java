/*
 * Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST.

Input Tree:
         10
        /  \
       5    8
      / \
     2   20

In the above tree, nodes 20 and 8 must be swapped to fix the tree.  
Following is the output tree
         10
        /  \
       5    20
      / \
     2   8

     Approach:
     How to Solve? We will maintain three pointers, first, middle and last. 
     When we find the first point where current node value is smaller than previous node value, 
     we update the first with the previous node & middle with the current node. 
     When we find the second point where current node value is smaller than previous node value, we update the last with the current node. 
     In case #2, we will never find the second point. So, last pointer will not be updated. 
     After processing, if the last node value is null, then two swapped nodes of BST are adjacent.
 */
package geekforgeeks;

import geekforgeeks.ConstructBTFromPostorderAndInorder.Node;

public class CorrectBST {

	class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
		}
	}
	public void correctBST(Node n){
		correctBSTUtil(n);
		
		if(first!=null && last!=null){
			//swap first and last
			int temp = first.data;
			first.data = last.data;
			last.data = temp;
		}else{
			//swap first and mid
			int temp = first.data;
			first.data = mid.data;
			mid.data = temp;
		}
		traverseTree(n);
	}
		
	Node prev=null, first=null,mid=null,last=null; 
	public void correctBSTUtil(Node n){
		if(n==null) return;
		correctBSTUtil(n.left);
		//Check if current data is smaller than previous data. If so, then this node needs to be swapped with correct node value
		if(prev!=null && prev.data>n.data){
			//Check if this is the first instance
			if(first==null){
				first = prev;
				mid = n;
			}else if(last==null){//update the last value if second instance is also found
				last = n;
			}
		}
		prev = n;
		correctBSTUtil(n.right);
	}
	public void traverseTree(Node n){
		if(n==null) return;
		traverseTree(n.left);
		System.out.print(n.data+" ");
		traverseTree(n.right);
	}
	public static void main(String[] args) {
		CorrectBST c = new CorrectBST();
		Node n = c.new Node(10);
		n.left = c.new Node(5);
		n.right = c.new Node(8);
		n.left.left = c.new Node(2);
		n.left.right = c.new Node(20);
		System.out.println("Initial Version: ");
		c.traverseTree(n);
		System.out.println();
		System.out.println("Corrected Version: ");
		c.correctBST(n);
	}

}
