/*
 * This program is used to create linked lists for elements at each depth; i.e, 
 * if the depth of the tree is D then number of linked lists to be formed will be D 
 */
package practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class CreateLL<T> {

	ArrayList<LinkedList<Node<T>>> al = new ArrayList<LinkedList<Node<T>>>();
	
	public void createLL(Node<T> n, int level){
		if(n==null){
			return;
		}
		LinkedList<Node<T>> ll = null;
		if(al.size() == level){
			ll = new LinkedList<Node<T>>();
			al.add(ll);
		}else{
			ll = al.get(level);
		}
		ll.add(n);
		createLL(n.left,level+1);
		createLL(n.right,level+1);
	}
	
	public static void main(String args[]){
		CreateLL<Integer> cll = new CreateLL<Integer>();
		Node<Integer> n = new Node<Integer>(4);
		n.left = new Node<Integer>(2);
		n.right = new Node<Integer>(6);
		n.left.left = new Node<Integer>(1);
		n.left.right = new Node<Integer>(3);
		n.right.left = new Node<Integer>(5);
		n.right.right = new Node<Integer>(7);
		n.right.right.right = new Node<Integer>(8);
		
		cll.createLL(n, 0);
		System.out.println("No of LinkedList Created = "+cll.al.size());
		
		//Iterating through all the linked lists
		for(LinkedList<Node<Integer>> l:cll.al){
			for(Node<Integer> node : l){
				System.out.print(node.data+" -> ");
			}
			System.out.print("Null");
			System.out.println();
		}
	}
}
