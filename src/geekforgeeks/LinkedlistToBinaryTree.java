package geekforgeeks;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedlistToBinaryTree {

	class LLNode{
		int data;
		LLNode next;
		public LLNode(int d) {
			this.data = d;
		}
	}
	class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		public TreeNode(int d) {
			this.data = d;
		}
	}
	public TreeNode createTree(LLNode n){
		TreeNode root = null;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if(n==null) return null;
		
		while(n!=null){
			TreeNode tn = new TreeNode(n.data);
			if(q.isEmpty() && root==null){
				root = tn;
				q.add(tn);
			}else{
				TreeNode curr = q.peek();
				if(curr.left==null){
					curr.left = tn;
				}else if(curr.right==null){
					curr.right = tn;
					q.poll();
				}
				q.add(tn);
			}
			n = n.next;
		}
		return root;
	}
	public void traverseTree(TreeNode n){
		if(n==null) return;
		
		traverseTree(n.left);
		System.out.print(n.data+" ");
		traverseTree(n.right);
	}
	public static void main(String[] args) {
		LinkedlistToBinaryTree lb = new LinkedlistToBinaryTree();
		LLNode n = lb.new LLNode(10);
		n.next = lb.new LLNode(12);
		n.next.next = lb.new LLNode(15);
		n.next.next.next = lb.new LLNode(25);
		n.next.next.next.next = lb.new LLNode(30);
		n.next.next.next.next.next = lb.new LLNode(36);
		
		TreeNode root = lb.createTree(n);
		lb.traverseTree(root);

	}

}
