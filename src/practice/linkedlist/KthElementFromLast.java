package practice.linkedlist;

public class KthElementFromLast<K> {

	public void findKthElementFromLastItr(LinkedListImpl<K> ll, int k){
		int size = ll.size,c=0;
		Node<K> n = ll.head;
		if(size-k < 0){
			System.out.println(k+" elements does not exist in LL");
			return;
		}
		while(c< (size-k)){
			if(n!=null){
				c++;
				n = n.next;
			}else{
				System.out.println(k+" elements does not exist in LL");
			}
		}
		System.out.println(k+" th element from last in LL is = "+n.data);
	}
	
	public void findKthElementRecursion(LinkedListImpl<K> ll, int k){
		System.out.println("Kth element through recurssion");
		Node<K> n = ll.head;
		
		if((ll.size - k)<0){
			System.out.println(k+" elements does not exist in LL");
			return;
		}
		findKthElementRecursionHelper(n,0,ll.size,k);
	}
	
	public void findKthElementRecursionHelper(Node<K> n, int count, int llSize, int k){
		int runTill = llSize - k;
		if(count<runTill){
			if(n!=null){
				count++;
				findKthElementRecursionHelper(n.next, count, llSize, k);
			}else{
				System.out.println(k+" elements does not exist in LL");
			}
		}else{
			System.out.println(k+" th element from last in LL is = "+n.data);
		}
	}
	
	public static void main(String args[]){
		LinkedListImpl<Integer> ll = new LinkedListImpl<Integer>();
		KthElementFromLast<Integer> o = new KthElementFromLast<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		ll.traverseSLL();
		// Restriction: value of k>=1
		o.findKthElementFromLastItr(ll, 4);
		o.findKthElementRecursion(ll, 4);
	}
}
