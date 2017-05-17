/*
 * Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to find the least common ancestor
 */
package geekforgeeks;

import java.util.ArrayList;

public class LargestCommonAncestorBinaryTree {

	class Node{
		Node left,right;
		int data;
		Node(int d){
			this.data = d;
		}
	}
/*
 * Method 1: 
 * Traverse the tree to find node n1. Store all the nodes traversed in an array
 * Traverse the tree to find node n2. Store all the nodes traversed in an array
 * if both the nodes are present, then traverse both the arrays and till the last common node value
 */
	boolean nodePresent = false;
	public Integer lcaMethod1(Node n, int a, int b){
		//ArrayList to hold path of the nodes
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		
		//Traverse to find a
		boolean aPresent = findNodePath(n,a);
		//if NodePresent is false: then node a not found in the tree
		if(!nodePresent){
			return null;
		}
		//If a is present then storing the path to reach a
		if(aPresent){
			al1 = (ArrayList<Integer>) path.clone();
		}
		
		nodePresent = false;
		path.clear();
		
		//Traverse to find b
		boolean bPresent = findNodePath(n,b);
		//if NodePresent is false: then node b not found in the tree
		if(!nodePresent){
			return null;
		}
		//If b is present then storing the path to reach b
		if(bPresent){
			al2 = (ArrayList<Integer>) path.clone();
		}
		System.out.println(al1);
		System.out.println(al2);
		//Comparing values from both lists. The last common value will be required LCA
		int k=0;
		while((al1!=null && k<al1.size()) && (al2!=null && k<al2.size())){
			if(al1.get(k)==al2.get(k)){
				k++;
			}else{
				break;
			}
		}
		return al1.get(k-1);
	}
	
	ArrayList<Integer> path = new ArrayList<Integer>();
	public boolean findNodePath(Node n, int a){
		if(n==null){
			return false;
		}
		
		if(n.data == a){
			nodePresent = true;
			path.add(n.data);
			return true;
		}
		
		path.add(n.data);
		Boolean leftPath = findNodePath(n.left, a);
		if(leftPath) {
			return true;
		}
		else{//If current not is not contributing into the path, then remove it
			int last = path.size()-1;
			if(last>=0)
			path.remove(last);
		}
		//Re-adding the path for right traversal
		path.add(n.data);
		Boolean rightPath = findNodePath(n.right, a);
		if(rightPath) {
			return true;
		}
		else{//If current not is not contributing into the path, then remove it
			int last = path.size()-1;
			if(last>=0){
			path.remove(last);}
		}
		
		return leftPath||rightPath;
	}
/*
 * End of Method 1
 */
/*
 * Method 2:
 * The idea is to traverse the tree starting from root. 
 * If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are present). 
 * If root doesn’t match with any of the keys, we recur for left and right subtree. 
 * The node which has one key present in its left subtree and the other key present in right subtree is the LCA. 
 * If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
 */
	boolean aPresent=false, bPresent = false;
	public void lcaMethod2(Node n, int a, int b){
		aPresent = false;
		bPresent = false;
		Node res = lcaMethod2Util(n,a,b); 
//		if(res == null){
//			System.out.println("One of the nodes is not present in tree");
//		}else{
//			System.out.println("LCA2 = "+res.data);
//		}
		
		if(aPresent && bPresent){
			System.out.println("LCA2 = "+res.data);
		}else{
			System.out.println("aPresent = "+aPresent+" bPresent = "+bPresent);
		}
	}
	public Node lcaMethod2Util(Node n, int a, int b){

		if(n==null) return null;
		if(n.data == a){
			aPresent = true;
		}
		if(n.data == b){
			bPresent = true;
		}
		Node leftLCA = lcaMethod2Util(n.left, a, b);
		Node righLCA = lcaMethod2Util(n.right, a, b);
		
		if(n.data == a || n.data == b){
			return n;
		}
		
		if(leftLCA!=null && righLCA!=null){
			return n;
		}
		
		if(leftLCA != null){
			return leftLCA;
		}else{
			return righLCA;
		}
	}
	public boolean findNode(Node n, int x){
		if(n==null) return false;
		if(n.data == x) return true;
		
		boolean left = findNode(n.left, x);
		boolean right = findNode(n.right, x);
		return left||right;
	}
/*
 * End of method 2
 */
	public static void main(String args[]){
		LargestCommonAncestorBinaryTree l = new LargestCommonAncestorBinaryTree();
		Node n = l.new Node(1);
        n.left = l.new Node(2);
        n.right = l.new Node(3);
        n.left.left = l.new Node(4);
        n.left.right = l.new Node(5);
        n.right.left = l.new Node(6);
        n.right.right = l.new Node(7);
        Integer res = l.lcaMethod1(n, 2, 5);
        if(res==null){
        	System.out.println("One of the elements is not found in the tree");
        }else{
        	System.out.println("LCA = "+res);
        }
        l.lcaMethod2(n, 2, 5);
        l.lcaMethod2(n, 6, 17);
	}
}
