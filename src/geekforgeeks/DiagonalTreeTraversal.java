/*
 * 				8
 * 			   / \
 * 			  3   10
 *           /\    \
 *          1  6    14
 *             /\   /
 *            4  7 13
 *   Given a tree, print all diagonal elements in a binary tree belonging to same line.
 *   Output : 
		Diagonal Traversal of binary tree : 
 		8 10 14
 		3 6 7 13
 		1 4
 */
package geekforgeeks;

import java.util.ArrayList;
import java.util.Vector;

public class DiagonalTreeTraversal {

	class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
		}
	}
	ArrayList<Vector<Node>> al = new ArrayList<Vector<Node>>();
	public void diagonalTraversal(Node n, int diagVal){
		if(n==null) return;
		//Logic to hold values which are lying on same diagonal
		Vector<Node> v = null;
		if(al.size() == diagVal){
			v = new Vector<Node>();
		}else{
			v = al.get(diagVal);
			al.remove(diagVal);
		}
		v.add(n);
		al.add(diagVal, v);
		
		diagonalTraversal(n.left, diagVal+1);
		diagonalTraversal(n.right, diagVal);
	}
	public static void main(String args[]) {
		DiagonalTreeTraversal d = new DiagonalTreeTraversal();
		Node n = d.new Node(8);
		n.left = d.new Node(3);
		n.right = d.new Node(10);
		n.left.left = d.new Node(1);
		n.left.right = d.new Node(6);
		n.left.right.left = d.new Node(4);
		n.left.right.right = d.new Node(7);
		n.right.right = d.new Node(14);
		n.right.right.left = d.new Node(13);
		d.diagonalTraversal(n, 0);
		if(d.al.size()>0){
			for(Vector<Node> v:d.al){
				for(Node node:v){
					System.out.print(node.data+" ");
				}
				System.out.println();
			}
		}
	}
}
