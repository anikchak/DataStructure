/*
 * Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 
 * as descendants (where we allow a node to be a descendant of itself).
 */
package geekforgeeks;

import practice.linkedlist.FindLoop;

public class LowestCommonAncestorInBinaryTree {
 
	class Node{
	 int data;
	 Node left;
	 Node right;
	 Node(int d){
		 this.data = d;
	 }
	}
	boolean n1Found = false;
	boolean n2Found = false;
	public Node findLCA(Node root, int n1, int n2){
		n1Found = false;
		n2Found = false;
		 Node lcaNode = findLCAUtil(root,n1,n2);
		 System.out.println(lcaNode.data);
		 /*
		  * If both the nodes are found then, the returned node is the LCA
		  * If one of the node is found and the other is not, then it is possible that the other unfound node is present in the subtree of the lca 
		  */
		 if(
			(n1Found && n2Found) || 
			(n1Found && findNode(lcaNode, n2)) || 
			(n2Found && findNode(lcaNode, n1))
			){
			 return lcaNode;
		 }
		 return null;
	 }
	
	public Node findLCAUtil(Node n,int n1, int n2){
		if(n==null){
			return null;
		}
		if(n1 == n.data){
			n1Found = true;
			return n;
		}
		if(n2 == n.data){
			n2Found = true;
			return n;
		}
		Node leftLCA = findLCAUtil(n.left, n1, n2);
		Node rightLCA = findLCAUtil(n.right, n1, n2);
		
		if(leftLCA!=null && rightLCA!=null){
			return n;
		}
		if(leftLCA != null){
			return leftLCA;
		}else{
			return rightLCA;
		}
	}
	public boolean findNode(Node n, int val){
		if(n==null) return false;
		if(n.data == val || findNode(n.left, val) || findNode(n.right, val)){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		LowestCommonAncestorInBinaryTree l = new LowestCommonAncestorInBinaryTree();
		Node n = l.new Node(1);
		n.left = l.new Node(2);
		n.right = l.new Node(3);
		n.left.left = l.new Node(4);
		n.left.right = l.new Node(5);
		n.right.left = l.new Node(6);
		n.right.right = l.new Node(7);
		Node lca1 = l.findLCA(n, 4, 5);
		System.out.println("LCA(4,5) = "+(lca1!=null?lca1.data:null));
		Node lca2 = l.findLCA(n, 4, 6);
		System.out.println("LCA(4,6) = "+(lca2!=null?lca2.data:null));
		Node lca3 = l.findLCA(n, 3, 4);
		System.out.println("LCA(3,4) = "+(lca3!=null?lca3.data:null));
		Node lca4 = l.findLCA(n, 4, 2);
		System.out.println("LCA(4,2) = "+(lca4!=null?lca4.data:null));
		Node lca5 = l.findLCA(n, 7, 1);
		System.out.println("LCA(7,1) = "+(lca5!=null?lca5.data:null));
		Node lca6 = l.findLCA(n, 4, -5);
		System.out.println("LCA(4,-5) = "+(lca6!=null?lca6.data:null));
	}

}
