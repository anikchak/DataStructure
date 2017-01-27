package geekforgeeks;

import practice.tree.Node;

public class BinaryTreeMirror<T> {

	public Node<T> mirror(Node<T> n){
		if(n==null) return null;
		Node<T> left = mirror(n.getLeft());
		Node<T> right = mirror(n.getRight());
		n.setLeft(right);
		n.setRight(left);
		return n;
	}
	
	public void traverse(Node<T> n){
		if(n==null) return;
		traverse(n.getLeft());
		System.out.print(n.getData()+" ");
		traverse(n.getRight());
	}
	
	public static void main(String[] args){
		BinaryTreeMirror<Integer> b = new BinaryTreeMirror<Integer>();
		Node<Integer> n = new Node<Integer>(1);
		n.setLeft(new Node<Integer>(2));
		n.setRight(new Node<Integer>(3));
		n.getLeft().setLeft(new Node<Integer>(4));
		n.getLeft().setRight(new Node<Integer>(5));
		b.traverse(n);
		b.mirror(n);
		System.out.println();
		b.traverse(n);
		
	}
}
