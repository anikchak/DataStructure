package geekforgeeks;

public class ReverseList {

	class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	/*
	 * Method 1 : Iterative
	 */
	public Node reverseIterative(Node n){
		Node prev = null;
		while(n!=null){
			Node nextNode = n.next;
			n.next = prev;
			prev = n;
			n = nextNode;
		}
		return prev;
	}
	/*
	 * Method 1: End
	 */
	/*
	 * Method 2: Recursive Method
	 */
	Node head = null;
	public Node reverseRecursive(Node n){
		if(n.next == null){
			return n;
		}
		Node x = reverseRecursive(n.next);
		x.next = n;
		n.next = null;
		
		if(head == null){
			head = x;
		}
		return x.next;
	}
	/*
	 * Method 2: Ends
	 */
	public void traverseList(Node n){
		while(n!=null){
			System.out.print(n.data+" ");
			n = n.next;
		}
	}
	public static void main(String[] args) {
		ReverseList r = new ReverseList();
		Node n = r.new Node(1);
		n.next = r.new Node(2);
		n.next.next = r.new Node(3);
		n.next.next.next = r.new Node(4);
		n.next.next.next.next = r.new Node(5);
		System.out.print("Before Reverse = ");
		r.traverseList(n);
		n = r.reverseIterative(n);
		System.out.print("\nAfter Reverse = ");
		r.traverseList(n);
		System.out.print("\nAfter Reverse Recursively = ");
		r.reverseRecursive(n);
		r.traverseList(r.head);
	}
}
