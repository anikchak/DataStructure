/*
 * Perform tree boundary traversal in anti-clockwise direction.
 * 					1
 * 				   / \
 * 				  2   3
 * 				 /\	  /	
 * 				4  5 6
 * OUTPUT: 1,2,4,5,6,3 
 */
package geekforgeeks;

public class TreeBoundaryTraversal {

	class Node{
		Node left;
		Node right;
		int data;
		Node(int d){
			this.data = d;
		}
	}
	public void leftBoundary(Node n){
		if(n==null){
			return;
		}
		if(n.left!=null || n.right!=null){
			System.out.print(n.data+" ");
			if(n.left!=null){
				leftBoundary(n.left);
			}else if(n.right!=null){
				leftBoundary(n.right);
			}
		}
	}
	public void rightBoundary(Node n){
		if(n==null){
			return;
		}
		if(n.left!=null || n.right!=null){
			System.out.print(n.data+" ");
			if(n.right!=null){
				rightBoundary(n.right);
			}else if(n.left!=null){
				rightBoundary(n.left);
			}
		}
	}
	public void leaves(Node n){
		if(n.left==null && n.right==null){
			System.out.print(n.data+" ");
			return;
		}
		if(n.left != null){
			leaves(n.left);
		}
		if(n.right != null){
			leaves(n.right);
		}
	}
	public void boundaryTraversal(Node n){
		System.out.print(n.data+" ");
		leftBoundary(n.left);
		leaves(n);
		rightBoundary(n.right);
	}
	public static void main(String[] args) {
		TreeBoundaryTraversal t = new TreeBoundaryTraversal();
//		Node n = t.new Node(1);
//		n.left = t.new Node(2);
//		n.right = t.new Node(3);
//		n.left.left = t.new Node(4);
//		n.left.right = t.new Node(5);
//		n.right.left = t.new Node(6);
//		n.right.right = t.new Node(7);
		
		Node n = t.new Node(20);
        n.left = t.new Node(8);
        n.left.left = t.new Node(4);
        n.left.right = t.new Node(12);
        n.left.right.left = t.new Node(10);
        n.left.right.right = t.new Node(14);
        n.right = t.new Node(22);
        n.right.right = t.new Node(25);
        n.right.right.left = t.new Node(30);
        n.right.right.left.right = t.new Node(40);
		t.boundaryTraversal(n);
	}

}
