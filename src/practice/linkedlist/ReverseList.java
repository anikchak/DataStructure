package practice.linkedlist;

public class ReverseList {
	
	public LinkedListImpl<Integer> reverseLLItr(LinkedListImpl<Integer> ll){
		Node<Integer> n = ll.head;
		Node<Integer> prev = null;
		while(n!=null){
			Node<Integer> next = n.next;
			n.next = prev;
			prev = n;
			n = next;
		}
		ll.head = prev;
		return ll;
	}
	
	public LinkedListImpl<Integer> reverseLLRecur(LinkedListImpl<Integer> ll){
		ll = reverseRecurseUtil(ll,ll.head,null);
		return ll;
	}

	public LinkedListImpl<Integer> reverseRecurseUtil(LinkedListImpl<Integer> ll, Node<Integer> n, Node<Integer> prev){
		if(n!=null){
			Node<Integer> next = n.next;
			n.next = prev;
			prev = n;
			ll = reverseRecurseUtil(ll,next, prev);
		}else{
			ll.head = prev;
		}
		return ll;
	}
	public static void main(String[] args) {
		LinkedListImpl<Integer> ll = new LinkedListImpl<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		ll.add(8);
		
		System.out.println("Before Reversing:");
		ll.traverseSLL();
		
		ll = new ReverseList().reverseLLItr(ll);
		System.out.println("After reversing iteratively: ");
		ll.traverseSLL();
		
		System.out.println("After Reversing Recursively: ");
		ll = new ReverseList().reverseLLRecur(ll);
		ll.traverseSLL();
	}

}
