package geekforgeeks;

import java.util.Hashtable;

public class LRUCache {
	
	int limit=0;
	public LRUCache(int l) {
		this.limit = l;
	}	
	
	class Node{
		int data;
		String key;
		Node prev;
		Node next;
		
		Node(String k,int d){
			this.data = d;
			this.key = k;
			this.prev = null;
			this.next = null;
		}
	}

	Node head = null, tail = null;
	Hashtable<String,Node> ht = new Hashtable<String, Node>();
	
	/*
	 * This method is used to set the cache values
	 */
	public void set(String key, int value){
		//Check if the key is already present
		if(ht.containsKey(key)){
			Node n = ht.get(key);
			n.data = value;
			n.prev.next = n.next;
			n.next = head;
			n.prev = null;
			head = n;
		}else if(ht.size() == limit){
			//Remove the least used node
			String tailKey = tail.key;
			tail = tail.prev;
			tail.next = null;
			ht.remove(tailKey);
			//Add the recent node
			Node newNode = new Node(key,value);
			newNode.next = head;
			newNode.prev = null;
			head.prev = newNode;
			head = newNode;
			ht.put(key, newNode);
		}else{
			if(ht.size() == 0){
				head = new Node(key, value);
				tail = head;
				ht.put(key, head);
			}else{
				Node newNode = new Node(key, value);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
				ht.put(key,newNode);
			}
		}
	}
	/*
	 * End of Set 
	 */
	
	/*
	 * This method is used to get value corresponding to a passed key. 
	 * If the key is present then the value will returned and this will become the most recent accessed node 
	 */
	public Integer get(String key) {
		if (ht.containsKey(key)) {
			Node n = ht.get(key);
			if (n == tail) {
				System.out.println("yes");
				tail = n.prev;
				tail.next = null;
			} else if (n == head) {
				return head.data;
			} else {
				n.prev.next = n.next;
				n.next.prev = n.prev;
			}
			n.prev = null;
			n.next = null;
			n.next = head;
			head.prev = n;
			head = n;

			return head.data;
		} else {
			return null;
		}
	}
	
	public void traverse() {
		System.out.println("Current Head = " + head.key + " Current Tail = "
				+ tail.key);
		Node n = head;
		System.out.println("Head Traversal:");
		while (n != null) {
			System.out.print("<" + n.key + "," + n.data + ">" + " -> ");
			n = n.next;
		}
		System.out.println("NULL");

		System.out.println("Tail Traversal");
		Node t = tail;
		while (t != null) {
			System.out.print("<" + t.key + "," + t.data + ">" + " -> ");
			t = t.prev;
		}
		System.out.println("NULL");

	}
	public static void main(String[] args) {
		LRUCache o = new LRUCache(5);
		o.set("a", 1);
		o.set("b", 2);
		o.set("c", 3);
		o.set("d", 4);
		o.set("e", 5);
		o.traverse();
		
		o.get("c");
		o.traverse();
		
		o.set("f", 6);
		o.traverse();
		
		o.get("d");
		o.traverse();
		
		o.get("d");
		o.traverse();
		
		o.get("a");
		o.traverse();
		
		o.set("g",7);
		o.traverse();
		
		o.get("c");
		o.traverse();
	}

}
