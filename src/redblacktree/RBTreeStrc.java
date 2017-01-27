package redblacktree;

public class RBTreeStrc {

	private int data;
	private RBTreeStrc leftNode;
	private RBTreeStrc rightNode;
	private RBTreeStrc parentNode;
	private String color;
	public RBTreeStrc(int data) {
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
		this.parentNode = null;
		this.color = "RED";
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public RBTreeStrc getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(RBTreeStrc leftNode) {
		this.leftNode = leftNode;
	}
	public RBTreeStrc getRightNode() {
		return rightNode;
	}
	public void setRightNode(RBTreeStrc rightNode) {
		this.rightNode = rightNode;
	}
	public RBTreeStrc getParentNode() {
		return parentNode;
	}
	public void setParentNode(RBTreeStrc parentNode) {
		this.parentNode = parentNode;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
