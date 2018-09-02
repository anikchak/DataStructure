/*
 * Find the distance between two keys in a binary tree, no parent pointers are given. 
 * Distance between two nodes is the minimum number of edges to be traversed to reach one node from other
 * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 
'n1' and 'n2' are the two given keys
'root' is root of given Binary Tree.
'lca' is lowest common ancestor of n1 and n2
Dist(n1, n2) is the distance between n1 and n2.
 */
package geekforgeeks;

public class DistanceBetweenTwoNodesInBinaryTree {

	class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
		}
	}
	int d1=-1, d2=-1, dist = -1;
	public int findDistance(Node n, int n1, int n2){
		d1 = -1;
		d2 = -1;
		dist = -1;
		Node lca = findDistanceUtil(n,n1,n2,0);
		if(d1!=-1 && d2!=-1){
			return dist;
		}
		if((d1!=-1 && findNode(n,n2,0)!=-1)){
			return findNode(lca,n2,0);
		}
		if((d2!=-1 && findNode(n,n1,0)!=-1)){
			return findNode(lca,n1,0);
		}
		return -1;
	}
	public Node findDistanceUtil(Node n, int n1, int n2, int level){
		if(n==null) return null;
		if(n.data == n1){
			d1 = level;
			return n;
		}
		if(n.data == n2){
			d2 = level;
			return n;
		}
		
		Node leftLCA = findDistanceUtil(n.left, n1, n2, level+1);
		Node rightLCA = findDistanceUtil(n.right, n1, n2, level+1);
		if(leftLCA!=null && rightLCA!=null){
			dist = d1+d2 - 2*level;
			return n;
		}
		if(leftLCA!=null){
			return leftLCA;
		}else{
			return rightLCA;
		}
	}
	public int findNode(Node node, int val, int level){
		if(node==null) return -1;
		if(node.data == val){
			return level;
		}
		int leftDist = findNode(node.left, val, level+1);
		if(leftDist != -1){
			return leftDist;
		}else{
			return findNode(node.right, val, level+1);
		}
	}
	public static void main(String[] args) {
		DistanceBetweenTwoNodesInBinaryTree l = new DistanceBetweenTwoNodesInBinaryTree();
		Node n = l.new Node(1);
		n.left = l.new Node(2);
		n.right = l.new Node(3);
		n.left.left = l.new Node(4);
		n.left.right = l.new Node(5);
		n.right.left = l.new Node(6);
		n.right.right = l.new Node(7);
		n.right.left.right = l.new Node(8);
		System.out.println("Distance Between 4,5 = "+l.findDistance(n, 4, 5));
		System.out.println("Distance Between 4,6 = "+l.findDistance(n, 4, 6));
		System.out.println("Distance Between 4,3 = "+l.findDistance(n, 4, 3));
		System.out.println("Distance Between 2,5 = "+l.findDistance(n, 2, 5));
		System.out.println("Distance Between 1,8 = "+l.findDistance(n, 1, 8));
		System.out.println("Distance Between 1,8 = "+l.findDistance(n, 1, 18));
	}

}
