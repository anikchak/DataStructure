package geekforgeeks;

public class LinkedListMergeSort {

	class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	public void mergeSort(Node n){
		 n = mergeSortUtil(n);
		 System.out.println("\nList After Sorting");
		 traverseList(n);
	}
	public Node mergeSortUtil(Node start){
		if(start==null || (start!=null && start.next==null)){
			return start;
		}
				
		Node mid = findMid(start);
		Node secondHalf = mid.next;
		mid.next = null;
		
		start = mergeSortUtil(start);
		secondHalf = mergeSortUtil(secondHalf);
		return  merge(start, secondHalf);
	}
	public Node merge(Node s, Node e){
		Node resultHead = null;
		Node temp = null;
		int value = 0;
		while(s!=null && e!=null){	
			if(s.data<=e.data){
				value = s.data;
				s = s.next;
			}else{
				value = e.data;
				e = e.next;
			}
			//Assigning nodes appropriately
			if(resultHead==null){
				resultHead = new Node(value);
				temp = resultHead;
			}else{
				temp.next = new Node(value);
				temp = temp.next;
			}
		}
		
		if(s!=null){
			if(resultHead==null){
				return s;
			}else{
				temp.next = s;
			}
		}
		if(e!=null){
			if(resultHead==null){
				return e;
			}else{
				temp.next = e;
			}
		}
		return resultHead;
	}
	public Node findMid(Node n){
		Node s = n;
		Node f = n.next;
		while(f!=null && f.next!=null){
			s = s.next;
			f = f.next.next;
		}
		return s;
	}
	
	public void traverseList(Node n){
		while(n!=null){
			System.out.print(n.data+" ");
			n = n.next;
		}
	}
	public static void main(String[] args) {
		LinkedListMergeSort l = new LinkedListMergeSort();
		Node n = l.new Node(5);
		n.next = l.new Node(7);
		n.next.next = l.new Node(30);
		n.next.next.next = l.new Node(10);
		n.next.next.next.next = l.new Node(20);
		n.next.next.next.next.next = l.new Node(40);
		System.out.println("List Before Sorting");
		l.traverseList(n);
		l.mergeSort(n);
	}

}
