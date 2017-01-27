package practice.linkedlist;

public class MiddleElement {

	public static void main(String[] args) {
		LinkedListImpl<Integer> ll = new LinkedListImpl<Integer>();
		ll.add(1);
		ll.add(2);
		//ll.add(3);
		//ll.add(4);
		//ll.add(5);
		//ll.add(6);
		//ll.add(7);
		//ll.add(8);
		ll.traverseSLL();
		
		Node<Integer> s = ll.head;
		Node<Integer> f = ll.head.next;
		
		while(f!=null && f.next!=null)
		{
			f = f.next.next;
			s = s.next;
		}
		
		System.out.println("Middle Element is = "+s.data);

	}

}
