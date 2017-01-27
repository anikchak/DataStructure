package practice.tree;

public class Node<K> {

	K data;
	Node<K> left;
	Node<K> right;
	
	public Node(K val){
		this.data = val;
	}
	
	public K getData() {
		return data;
	}
	public void setData(K data) {
		this.data = data;
	}
	public Node<K> getLeft() {
		return left;
	}
	public void setLeft(Node<K> left) {
		this.left = left;
	}
	public Node<K> getRight() {
		return right;
	}
	public void setRight(Node<K> right) {
		this.right = right;
	}
}
