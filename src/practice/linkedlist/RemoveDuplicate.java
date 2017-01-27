package practice.linkedlist;

import java.util.Hashtable;

public class RemoveDuplicate<K> {

	public void removeDuplicateWithoutBuffer(LinkedListImpl<K> ll){
		Node<K> curr = ll.head;
		while(curr!=null){
			Node<K> n = curr.next;
			while(n!=null){
				if(n.data == curr.data){
					curr.next = n.next;
				}
				n = n.next;
			}
			curr = curr.next;
		}
	}
	public void removeDuplicateWithBuffer(LinkedListImpl<K> ll){
		Hashtable<K, Boolean> ht = new Hashtable<K, Boolean>();
		Node<K> curr = ll.head;
		Node<K> prev = null;
		while(curr!=null){
			if(ht.containsKey(curr.data)){
				prev.next = curr.next;
			}else{
				ht.put(curr.data, true);
				prev = curr;
			}
			curr = curr.next;
		}
	}
	
	public static void main(String args[]){
		LinkedListImpl<Integer> ll = new LinkedListImpl<Integer>();
		RemoveDuplicate<Integer> rd = new RemoveDuplicate<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(5);
		ll.add(5);
		ll.add(3);
		ll.add(5);
		ll.add(4);
		ll.traverseSLL();
		//rd.removeDuplicateWithoutBuffer(ll);
		rd.removeDuplicateWithBuffer(ll);
		System.out.println("After Removing duplicate nodes");
		ll.traverseSLL();
	}
}
