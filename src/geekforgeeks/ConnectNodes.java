/*
 * Write a function to connect all the adjacent nodes at the same level in a binary tree.
 * Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F


Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL
   
 */
package geekforgeeks;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodes {

	class Node{
		int data;
		Node left;
		Node right;
		Node nextRight;
		
		Node(int d){
			this.data = d;
			left = right = nextRight = null;
		}
	}
	public void connectNodes(Node n){
		Queue<Node> q  = new LinkedList<Node>();
		q.add(n);
		q.add(null);
		while(!q.isEmpty()){
			Node temp = q.poll();
			if(temp!=null){
				temp.nextRight = q.peek();
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
			}else{
				if(q.isEmpty()){
					break;
				}else{
					q.add(null);
				}
			}
			//System.out.println(q);
		}
	}
	public void traversePostOrder(Node n){
		if(n==null){
			return;
		}
		System.out.println("Node = "+n.data+" NextRight = "+(n.nextRight==null?"Null":n.nextRight.data));
		traversePostOrder(n.left);
		traversePostOrder(n.right);
	}
	public static void main(String[] args) {
		ConnectNodes cn = new ConnectNodes();
		Node n = cn.new Node(1);
		n.left = cn.new Node(2);
		n.right = cn.new Node(3);
		n.left.left = cn.new Node(4);
		//n.left.right = cn.new Node(5);
		//n.right.left = cn.new Node(6);
		n.right.right = cn.new Node(7);
		cn.connectNodes(n);
		cn.traversePostOrder(n);
		
	}

}
