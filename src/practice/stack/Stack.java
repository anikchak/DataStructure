package practice.stack;

public class Stack<K> {

	class Node{
		K data;
		Node next;
		Node(K val){
			this.data = val;
		}
	}
	
	Node top = null;
	int size = 0;
	
	public void push(K data){
		Node newN = new Node(data);
		newN.next = top;
		top = newN;
		size++;
	}
	
	public K pop(){
		if(isEmpty()){
			System.out.println("Stack is empty. Nothing to pop");
			return null;
		}else{
			K item = top.data;
			top = top.next;
			size--;
			return item;
		}
	}
	
	public K top(){
		if(isEmpty()){
			System.out.println("Stack is empty. No top element present");
			return null;
		}
		else{
			return top.data;
		}
	}
	
	public boolean isEmpty(){
		if(top==null){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String args[]){
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.isEmpty());
		System.out.println("size="+s.size);
		System.out.println(s.pop());
		//System.out.println(s.pop());
		//System.out.println(s.pop());
		System.out.println(s.top());
	}
}
