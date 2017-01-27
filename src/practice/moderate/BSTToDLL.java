package practice.moderate;

class Node<T>{
	T data;
	Node<T> left;
	Node<T> right;
	Node(T d){
		this.data = d; 
	}
}

class DLLNode<T>{
	T data;
	DLLNode<T> next;
	DLLNode<T> prev;
	DLLNode(T d){
		this.prev = null;
		this.next = null;
		this.data = d;
	}
}
public class BSTToDLL<T> {

	DLLNode<T> head = null, tail = null;
	public void convertBSTToDLL(Node<T> n){
		if(n==null) return;
		
		convertBSTToDLL(n.left);
		if(n != null){
			createDLL(n);
		convertBSTToDLL(n.right);
	}
	}
	
	public void createDLL(Node<T> n){
		if(head == null){
			head = new DLLNode<T>(n.data);
			tail = head;			
		}else{
			DLLNode<T> newNode = new DLLNode<T>(n.data);
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void traverseFwd(){
		System.out.println("Traverse Fwd:");
		DLLNode<T> n = head;
		while(n != null){
			System.out.print(n.data+"->");
			n = n.next;
		}
		System.out.println("Null");
	}
	
	public void traverseBck(){
		System.out.println("Traverse Back:");
		DLLNode<T> n = tail;
		while(n != null){
			System.out.print(n.data+"->");
			n = n.prev;
		}
		System.out.println("Null");
	}
	
	public static void main(String args[]){
		BSTToDLL<Integer> o = new BSTToDLL<Integer>();
		Node<Integer> node = new Node<Integer>(4);
		node.left = new Node<Integer>(2);
		node.right = new Node<Integer>(5);
		node.left.left = new Node<Integer>(1);
		node.left.right = new Node<Integer>(3);
		node.right.right = new Node<Integer>(6);
		node.left.left.left = new Node<Integer>(0);
		o.convertBSTToDLL(node);
		o.traverseFwd();
		o.traverseBck();
	}
}
