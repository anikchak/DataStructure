package practice.linkedlist;

import java.util.Hashtable;

public class FindLoop {

	public void findLoop(LinkedListImpl<Integer> ll){
		//Checking if loop is present
		Node<Integer> slow = ll.head;
		Node<Integer> fast = ll.head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				System.out.println("LL has loop");
				break;
			}
		}
		if(fast == null || fast.next == null){
			System.out.println("No loop present");
			return;
		}
		//Find the beginning position for the loop
		slow = ll.head;
		while(fast!=slow){
			slow = slow.next;
			fast = fast.next;
		}
		
		System.out.println("Loop start with node having data = "+fast.data);
		//Code to calculate the length of the loop
		Node<Integer> start = fast.next;
		int count = 0;
		while(start != fast){
			count++;
			start = start.next;
		}
		
		System.out.println("Loop Length="+(count+1));
	}
	
	public void findLoopUsingHashTable(LinkedListImpl<Integer> ll){
		Node<Integer> n = ll.head;
		Hashtable<Node<Integer>,Boolean> ht = new Hashtable<Node<Integer>,Boolean>();
		while(n!=null){
			if(ht.containsKey(n)){
				System.out.println("Loop at node = "+n.data);
				return;
			}else{
				ht.put(n, true);
				n = n.next;
			}
		}
		if(n == null){
			System.out.println("No Loop found");
		}
	}
	public static void main(String args[]){
		LinkedListImpl<Integer> ll = new LinkedListImpl<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		ll.add(8);
		Node<Integer> n = ll.head;
		Node<Integer> node = null;
		//Creating LL loop
		
		while(n!=null){
			if(n.data == 4){
				node = n;
			}
			else if(n.data == 8){
				n.next = node;
				break;
			}
			n  = n.next;
		}
		
		FindLoop fl = new FindLoop();
		fl.findLoop(ll);
		fl.findLoopUsingHashTable(ll);
	}
}
