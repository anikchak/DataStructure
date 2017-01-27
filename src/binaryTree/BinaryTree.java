package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int d){
			this.data = d;
		}
	}
	
	Node root = null;
	Queue<Node> q = new LinkedList<Node>();
	public void insertNode(int data){
		while(true){
			if(root == null){
				root = new Node(data);
				q.add(root);
				break;
			}else{
				Node n = q.peek();
				if(n.left == null){
					n.left = new Node(data);
					q.add(n.left);
					break;
				}else if(n.right == null){
					n.right = new Node(data);
					q.add(n.right);
					break;
				}else{
					q.poll();
				}
			}
		}
	}
	
	public void traverse(Node n){
		if(n == null) return;
		else{
			traverse(n.left);
			System.out.print(n.data+" ");
			traverse(n.right);
		}
	}
	
	public static void main(String args[]){
		BinaryTree bt = new BinaryTree();
		bt.insertNode(1);
		bt.insertNode(2);
		bt.insertNode(3);
		bt.insertNode(4);
		bt.insertNode(5);
		bt.traverse(bt.root);
	}
}
