package practice.linkedlist;

public class SortToThird {

	public LinkedListImpl<Integer> sortToThirdLL(LinkedListImpl<Integer> l1, LinkedListImpl<Integer> l2){
		LinkedListImpl<Integer> op = new LinkedListImpl<Integer>();
		Node<Integer> n1 = l1.head;
		Node<Integer> n2 = l2.head;
		Node<Integer> prev = null, newNode = null;
		
		while(n1!=null && n2!=null){
			newNode = null;
			if(n1.data<n2.data){
				newNode = new Node<Integer>(n1.data);
				n1 = n1.next;
			}else{
				newNode = new Node<Integer>(n2.data);
				n2 = n2.next;
			}
			
			if(op.head == null){
				op.head = newNode;
				prev = op.head;
			}else{
				prev.next = newNode;
				prev = newNode;
			}
		}
		
		while(n1!=null){
			newNode = new Node<Integer>(n1.data);
			prev.next = newNode;
			prev = newNode;
			n1 = n1.next;
		}
		while(n2!=null){
			newNode = new Node<Integer>(n2.data);
			prev.next = newNode;
			prev = newNode;
			n2 = n2.next;
		}
		
		System.out.println("Sorted LL=");
		op.traverseSLL();
		return op;
	}
	public static void main(String[] args) {
		LinkedListImpl<Integer> ll1 = new LinkedListImpl<Integer>();
		LinkedListImpl<Integer> ll2 = new LinkedListImpl<Integer>();
		SortToThird o = new SortToThird();
		ll1.add(1);
		ll2.add(2);
		ll1.add(3);
		ll2.add(4);
		ll1.add(5);
		ll2.add(6);
		//ll1.add(7);
		System.out.println("LL1:");
		ll1.traverseSLL();
		System.out.println("LL2:");
		ll2.traverseSLL();
		
		o.sortToThirdLL(ll1, ll2);
	}

}
