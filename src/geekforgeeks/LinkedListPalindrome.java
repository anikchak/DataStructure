/*
 * GIven a singly linked list. Find if the linked list is a palindrome or not
 */
package geekforgeeks;

public class LinkedListPalindrome {
	class Node{
		Integer data;
		Node next;
		Node(Integer d){
			this.data = d;
		}
	}
	public Node reverseLL(Node n){
		Node prev = null;
		while(n!=null){
			Node next = n.next;
			n.next = prev;
			prev = n;
			n = next;
		}
		return prev;
	}
	public void isPalindrome(Node n){
		Node head1 = n;
		System.out.println("Traverse List before computation = ");
		traverseList(n);
		//Find the mid-point of the linked list
		Node slow = head1;
		Node fast = head1.next;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		Node midPoint = slow;
		Node head2 = reverseLL(midPoint.next);
		
		//Comparing Logic
		midPoint.next = new Node(null);
		Node h2 = head2;
		boolean flag = true;
		while(head1!=null && h2!=null){
			if(head1.data == h2.data){
				head1 = head1.next;
				h2 = h2.next;
			}else{
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println("Linked list is palindrome");
		}else{
			System.out.println("Linked list is not palindrome");
		}
		
		// Rearranging the list to the original list
		head2 = reverseLL(head2);
		midPoint.next = head2;
		System.out.println("Traverse List after computation = ");
		traverseList(n);
	}
	
	public void traverseList(Node n){
		while(n!=null){
			System.out.print(n.data+"->");
			n = n.next;
		}
		System.out.println("NULL");
	}
	public static void main(String[] args) {
		LinkedListPalindrome p = new LinkedListPalindrome();
		Node n = p.new Node(1);
		n.next = p.new Node(2);
		n.next.next = p.new Node(3);
		n.next.next.next = p.new Node(2);
		n.next.next.next.next = p.new Node(1);
		p.isPalindrome(n);
	}

}
