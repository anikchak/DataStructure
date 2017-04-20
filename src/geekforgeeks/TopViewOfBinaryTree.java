package geekforgeeks;

import java.util.LinkedList;
import java.util.Queue;


public class TopViewOfBinaryTree {

	class Node{
		Node left;
		Node right;
		int data;
		Node(int d){
			this.data = d;
		}
	}
	public static void topView(Node n){
		Queue<Node> q = new LinkedList<Node>();
		int l=0;
		q.add(n);
		q.add(null);
		while(!q.isEmpty()){
			Node node = q.poll();
			if(node == null){
				l++;
			}else{
				if(l==0){
					System.out.print(node.data+" ");
					if(node.left != null){
						q.add(node.left);
					}
					if(node.right != null){
						q.add(node.right);
					}
				}else{
					System.out.print(node.data+" ");
					Node n1 = q.poll();
					if(node.left != null){
						q.add(node.left);
					}
					if(n1!=null){
						System.out.print(n1.data+" ");
						if(n1.right!=null){
							q.add(n1.right);
						}
					}
				}
				q.add(null);
			}
		}
	}
	public static void main(String[] args) {
		TopViewOfBinaryTree t = new TopViewOfBinaryTree();
		Node n = t.new Node(1);
		n.left = t.new Node(2);
		n.right = t.new Node(3);
		n.left.left = t.new Node(4);
		n.left.right = t.new Node(5);
		n.right.left = t.new Node(6);
		n.right.right = t.new Node(7);
		topView(n);
		System.out.println();
		Node n1 = t.new Node(10);
		n1.left = t.new Node(20);
		n1.right = t.new Node(30);
		n1.left.left = t.new Node(40);
		n1.left.right = t.new Node(60);
		n1.right.left = t.new Node(90);
		topView(n1);
	}

}
