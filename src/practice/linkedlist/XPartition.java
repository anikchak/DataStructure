package practice.linkedlist;

import java.util.Comparator;

public class XPartition<K> implements Comparator<K>{

	public void partition(LinkedListImpl<K> ll, K x ){
		Node<K> prev = null, newNodePrev = null;
		Node<K> newNode = new Node<K>(x);
		newNode.next = ll.head;
		prev = newNode;
		Node<K> n = ll.head;
		
		
		
		while(n!=null){
			int diff  = compare(n.data,newNode.data);
			if(diff<=0){
				if(newNodePrev == null){
					prev.next = n.next;
					n.next = newNode;
					newNodePrev = n;
					n = prev.next;
					ll.head = newNodePrev;
				}else{
					prev.next = n.next;
					n.next = newNodePrev.next;
					newNodePrev.next = n;
					newNodePrev = newNodePrev.next;
					n = prev.next;
				}
			}
			else{
				prev = n;
				n = n.next;
			}
		}
		
		if(newNodePrev == null){
			prev = null;
			newNode.next = null;
		}else{
			newNodePrev.next = newNode.next;
		}
	}
	public static void main(String args[]){
		LinkedListImpl<Integer> ll = new LinkedListImpl<Integer>();
		XPartition<Integer> o = new XPartition<Integer>();
		ll.add(7);
		ll.add(2);
		ll.add(8);
		ll.add(1);
		ll.add(9);
		ll.add(10);
		ll.add(11);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(12);
		ll.add(6);
		ll.traverseSLL();
		o.partition(ll, 6);
		ll.traverseSLL();
		
	}
	
	
	@Override
	public int compare(K arg0, K arg1) {
		
		return ((Integer)arg0).compareTo((Integer)arg1);
	}
	
}
