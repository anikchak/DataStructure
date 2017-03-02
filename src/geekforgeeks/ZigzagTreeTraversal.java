package geekforgeeks;

import geekforgeeks.LevelOrderTraverse.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigzagTreeTraversal {

	class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
		}
	}
	
	public void zigzagTraverse(Node r){
		Queue<Node> q = new LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();
		int depth = 0;
		q.add(r);
		q.add(null);
		while(!q.isEmpty()){
			Node n = q.poll();
			if(n != null){
				if(depth%2 == 0){
					s.push(n);
				}else{
					System.out.print(n.data+" ");
				}
				if(n.left != null){
					q.add(n.left);
				}
				if(n.right != null){
					q.add(n.right);
				}
			}else{
				depth++;
				while(!s.isEmpty()){
					System.out.print(s.pop().data+" ");
				}
				if(q.isEmpty()){
					break;
				}else{
					q.add(null);
				}
			}
		}
	}
	
	public static void main(String args[]){
		ZigzagTreeTraversal z = new ZigzagTreeTraversal();
		Node n = z.new Node(1);
		n.left = z.new Node(2);
		n.right = z.new Node(3);
		n.left.left = z.new Node(4);
		n.left.right = z.new Node(5);
		n.right.left = z.new Node(6);
		n.right.right = z.new Node(7);
		n.left.left.left = z.new Node(8);
		n.left.left.right = z.new Node(9);
		n.left.left.left.left = z.new Node(10);
		n.left.left.left.right = z.new Node(11);
		z.zigzagTraverse(n);
	}
}
