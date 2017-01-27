package practice.queue;

public class Q<K> {

	class Node{
		K data;
		Node next;
		Node(K val){
			this.data = val;
		}
	}
	
	Node head = null,tail = null;
	public void add(K data){
		Node newN = new Node(data);
		if(head == null){
			head = newN;
			tail = head;
		}else{
			tail.next = newN;
			tail = newN;
		}
	}
	
	public K remove(){
		if(isEmpty()){
			System.out.println("Empty Q");
			return null;
		}
		K data = head.data;
		head = head.next;
		return data;
	}
	
	public K peek(){
		if(isEmpty()){
			System.out.println("Q is empty. No peek.");
			return null;
		}else{
			return head.data;
		}
	}
	
	public boolean isEmpty(){
		if(head==null){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
	
		Q<Integer> q = new Q<Integer>();
		System.out.println("Q Empty = "+q.isEmpty());
		q.add(1);
		q.add(2);
		q.add(3);
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		q.add(4);
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.remove());
	}

}
