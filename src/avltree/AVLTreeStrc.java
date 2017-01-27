package avltree;

public class AVLTreeStrc<T> {
	private T data;
	private AVLTreeStrc<T> leftNode;
	private AVLTreeStrc<T> rightNode;
	
	public AVLTreeStrc(T value) {
		this.data = value;
		this.leftNode = null;
		this.rightNode = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public AVLTreeStrc<T> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(AVLTreeStrc<T> leftNode) {
		this.leftNode = leftNode;
	}
	public AVLTreeStrc<T> getRightNode() {
		return rightNode;
	}
	public void setRightNode(AVLTreeStrc<T> rightNode) {
		this.rightNode = rightNode;
	}
	
}
