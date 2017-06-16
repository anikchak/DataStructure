/*
 * Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). 
 * If the complete Binary Tree is BST, then return the size of whole tree.
 * Example
 * Input: 
       50
     /    \
  30       60
 /  \     /  \ 
5   20   45    70
              /  \
            65    80
Output: 5
The following subtree is the maximum size BST subtree 
      60
     /  \ 
   45    70
        /  \
      65    80
 */
package geekforgeeks;

public class LargestBSTInGivenBT {

	class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
		}
	}
	class BST{
		int size=0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean isBST=false;
	}
	int maxBSTSize = 0;
	Node maxBSTNode = null;
	public BST findBST(Node n){
		BST b = new BST();
		if(n==null){
			b.size = 0;
			b.isBST = true;
			return b;
		}
		
		if(n.left==null && n.right==null){
			b.size = 1;
			b.isBST = true;
			b.max = n.data;
			b.min = n.data;
		}else{
			BST left = findBST(n.left);
			BST right = findBST(n.right);
			
			if(left.isBST && right.isBST){
				if(left.max<n.data && right.min>n.data){
					b.isBST = true;
					b.size = 1+left.size+right.size;
					b.min = left.min;
					b.max = right.max;
					if(maxBSTSize<b.size){
						maxBSTSize = b.size;
						maxBSTNode = n;
					}
				}else{
					b.isBST = false;
				}
			}else{
				b.isBST = false;
			}
		}
		return b;
	}
	public void traverse(Node n){
		if(n==null) return ;
		traverse(n.left);
		System.out.print(n.data+" ");
		traverse(n.right);
	}
	public static void main(String[] args) {
		LargestBSTInGivenBT l = new LargestBSTInGivenBT();
		Node n = l.new Node(50);
		n.left = l.new Node(30);
		n.right = l.new Node(60);
		n.left.left = l.new Node(5);
		n.left.right = l.new Node(20);
		n.right.left = l.new Node(45);
		n.right.right = l.new Node(70);
		n.right.right.left = l.new Node(65);
		n.right.right.right = l.new Node(80);
		l.findBST(n);
		System.out.println("Largest BST subtree has size = "+l.maxBSTSize);
		System.out.println("Largest BST Subtree = ");
		l.traverse(l.maxBSTNode);
		
		System.out.println();
		l.maxBSTNode = null;
		l.maxBSTSize = 0;
		Node n1 = l.new Node(50);
		n1.right = l.new Node(60);
		n1.right.left = l.new Node(55);
		n1.right.right = l.new Node(70);
		n1.right.right.left = l.new Node(65);
		n1.right.right.right = l.new Node(80);
		l.findBST(n1);
		System.out.println("Largest BST subtree has size (Root without left subtree) = "+l.maxBSTSize);
		System.out.println("Largest BST Subtree = ");
		l.traverse(l.maxBSTNode);
		
		System.out.println();
		l.maxBSTNode = null;
		l.maxBSTSize = 0;
		Node n2 = l.new Node(50);
		n2.left = l.new Node(30);
		n2.right = l.new Node(60);
		n2.left.left = l.new Node(5);
		n2.left.right = l.new Node(40);
		n2.right.left = l.new Node(55);
		n2.right.right = l.new Node(70);
		n2.right.right.left = l.new Node(65);
		n2.right.right.right = l.new Node(80);
		l.findBST(n2);
		System.out.println("Largest BST subtree has size (complete tree is BST) = "+l.maxBSTSize);
		System.out.println("Largest BST Subtree = ");
		l.traverse(l.maxBSTNode);
		
		System.out.println();
		l.maxBSTNode = null;
		l.maxBSTSize = 0;
		Node n3 = l.new Node(50);
		n3.left = l.new Node(30);
		n3.left.left = l.new Node(5);
		n3.left.right = l.new Node(40);
		l.findBST(n3);
		System.out.println("Largest BST subtree has size (Root without right subtree) = "+l.maxBSTSize);
		System.out.println("Largest BST Subtree = ");
		l.traverse(l.maxBSTNode);
		
		System.out.println();
		l.maxBSTNode = null;
		l.maxBSTSize = 0;
		Node n4 = l.new Node(50);
		n4.right = l.new Node(60);
		n4.right.right = l.new Node(70);
		n4.right.right.right = l.new Node(80);
		l.findBST(n4);
		System.out.println("Largest BST subtree has size (Right Skewed Tree) = "+l.maxBSTSize);
		System.out.println("Largest BST Subtree = ");
		l.traverse(l.maxBSTNode);
		
		System.out.println();
		l.maxBSTNode = null;
		l.maxBSTSize = 0;
		Node n5 = l.new Node(50);
		n5.left = l.new Node(40);
		n5.left.left = l.new Node(30);
		n5.left.left.left = l.new Node(20);
		l.findBST(n5);
		System.out.println("Largest BST subtree has size (Left skewed tree) = "+l.maxBSTSize);
		System.out.println("Largest BST Subtree = ");
		l.traverse(l.maxBSTNode);
	}

}
