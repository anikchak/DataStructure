package practice.linkedlist;


class Node<K>{
	K data;
	Node<K> next;
	Node(K d){
		this.data = d;
		this.next = null;
	}
}
public class LinkedListImpl<K> {

	Node<K> head = null;
	int size = 0;
	public void add(K data){
		if(head == null){
			head = new Node<K>(data);
			size++;
			return;
		}
		Node<K> n = head; Node<K> prev = null;
		while(n!=null){
			prev = n;
			n = n.next;
		}
		Node<K> newNode = new Node<K>(data);
		prev.next = newNode;
		size++;
	}
	
	public void addBeforeHead(K data){
		if(head == null){
			head = new Node<K>(data);
			size++;
			return;
		}
		Node<K> newNode = new Node<K>(data);
		newNode.next = head;
		head = newNode;
		size++;
	}
	public Node<K> delete(K data){
		if(head == null){
			System.out.println("LL does not exist");
			return null;
		}
		Node<K> prev = null, curr = head;
		while(curr!=null){
			if(curr.data == data){
				break;
			}else{
				prev = curr;
				curr = curr.next;
			}
		}
		
		if(curr == null){
			System.out.println("Data not found");
			return null; // data no found
		}else{
			//Head Element is getting deleted
			if(prev == null){
				head = curr.next;
			}else{
			prev.next = curr.next;
			}
			size--;
			return curr;
		}
	}
	
	public void traverseSLL(){
		if(isEmpty()){
			System.out.println("Singlely LinkedList is empty");
		}else{
			Node<K> n = head;
			while(n != null){
				System.out.print(n.data+"->");
				n = n.next;
			}
			System.out.println("NULL");
		}
	}
	public int sizeSLL(){
		return size;
	}
	public boolean isEmpty(){
		if(head == null){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		LinkedListImpl<Integer> ll = new LinkedListImpl<Integer>();
		ll.addBeforeHead(1);
		ll.addBeforeHead(2);
		ll.addBeforeHead(3);
		ll.addBeforeHead(4);
		ll.addBeforeHead(5);
		ll.addBeforeHead(6);
		ll.add(7);
		ll.traverseSLL();
		
		//ll.delete(5);
		/*ll.delete(1);
		ll.delete(6);
		ll.delete(2);
		ll.delete(4);
		Node<Integer> n = ll.delete(3);
		if(n !=null){
			System.out.println("Deleted Node = "+n.data);
		}
		ll.traverseSLL();
		*/
		System.out.println("LL Size="+ll.sizeSLL());
	}

}
