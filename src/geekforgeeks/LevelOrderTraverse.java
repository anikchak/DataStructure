package geekforgeeks;

import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderTraverse {

	class Node{
		int data;
		Node left;
		Node right;
		public Node(int d){
			this.data = d;
			this.left = null;
			this.right = null;
		}
	}
		/*
		 * This method is used to perform level order traversal and print the node values level-wise in separate lines
		 */
		public void levelOrderTraversal(Node root){
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			q.add(null);
			while(!q.isEmpty()){
				Node n = q.poll();
				if(n == null){
					System.out.println();
					if(q.isEmpty()){
						break;
					}else{
						q.add(null);
					}
				}else{
					System.out.print(n.data+" ");
					if(n.left != null){
						q.add(n.left);
					}
					if(n.right != null){
						q.add(n.right);
					}
				}
			}
		}
	
	public static void main(String[] args) {
		LevelOrderTraverse o = new LevelOrderTraverse();
		Node n = o.new Node(1);
		n.left = o.new Node(2);
		n.right = o.new Node(3);
		n.left.left = o.new Node(4);
		n.left.right = o.new Node(5);
		n.right.left = o.new Node(6);
		n.right.right = o.new Node(7);
		o.levelOrderTraversal(n);
	}
}
