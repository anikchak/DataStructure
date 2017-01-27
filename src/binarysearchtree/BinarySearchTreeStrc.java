package binarysearchtree;

public class BinarySearchTreeStrc<T> {

	public BinarySearchTreeStrc(T data) {
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}
	T data;
	BinarySearchTreeStrc<T> leftNode=null;
	BinarySearchTreeStrc<T> rightNode=null;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinarySearchTreeStrc<T> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinarySearchTreeStrc<T> leftNode) {
		this.leftNode = leftNode;
	}
	public BinarySearchTreeStrc<T> getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinarySearchTreeStrc<T> rightNode) {
		this.rightNode = rightNode;
	}
}
