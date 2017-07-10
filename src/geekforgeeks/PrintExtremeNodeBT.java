/*
 * Given a binary tree, print nodes of extreme corners of each level but in alternate order.
 */
package geekforgeeks;

import java.util.LinkedList;
import java.util.Queue;

public class PrintExtremeNodeBT {

	class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
		}
	}
	public void extremeNodes(Node n){
		if(n==null){
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		Node last = n;
		Node curr = n;
		boolean left = true;
		boolean right = false;
		q.add(curr);
		q.add(null);
		System.out.print(curr.data+" ");
		while(!q.isEmpty()){
			curr = q.poll();
			if(curr!=null){
				if(curr.left!=null){
					q.add(curr.left);
					last = curr.left;
				}
				if(curr.right!=null){
					q.add(curr.right);
					last = curr.right;
				}
			}else{
				if(q.isEmpty()) break;
				q.add(null);
				//Printing left extreme node value
				if(left){
					System.out.print(q.peek().data+" ");
					left = false;
					right = true;
				}else if(right){
					System.out.print(last.data+" ");
					right = false;
					left = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		PrintExtremeNodeBT p = new PrintExtremeNodeBT();
		Node n = p.new Node(1);
		n.left = p.new Node(2);
		n.right = p.new Node(3);
		n.left.left = p.new Node(4);
		n.left.right = p.new Node(5);
		n.right.left = p.new Node(6);
		n.right.right = p.new Node(7);
		n.left.left.left = p.new Node(8);
		n.left.left.right = p.new Node(9);
		n.left.right.left = p.new Node(10);
		n.left.right.right = p.new Node(11);
		n.right.left.left = p.new Node(12);
		n.right.left.right = p.new Node(13);
		n.right.right.left = p.new Node(14);
		n.right.right.right = p.new Node(15);
		n.left.left.left.left = p.new Node(16);
		n.left.left.left.right = p.new Node(17);
		n.left.left.right.left = p.new Node(18);
		n.left.left.right.right = p.new Node(19);
		n.left.right.left.left = p.new Node(20);
		n.left.right.left.right = p.new Node(21);
		n.left.right.right.left = p.new Node(22);
		n.left.right.right.right = p.new Node(23);
		n.right.left.left.left = p.new Node(24);
		n.right.left.left.right = p.new Node(25);
		n.right.left.right.left = p.new Node(26);
		n.right.left.right.right = p.new Node(27);
		n.right.right.left.left = p.new Node(28);
		n.right.right.left.right = p.new Node(29);
		n.right.right.right.left = p.new Node(30);
		n.right.right.right.right = p.new Node(31);
		
		p.extremeNodes(n);
	}

}
