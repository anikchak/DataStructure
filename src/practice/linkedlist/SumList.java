package practice.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;

public class SumList {

	public void sumListBackward(LinkedListImpl<Integer> ll1, LinkedListImpl<Integer> ll2){
		LinkedListImpl<Integer> op = new LinkedListImpl<Integer>(); 
		//Fetching Integer from LL in backward order
		int num1 = fetchNumber(ll1.head,0);
		int num2 = fetchNumber(ll2.head,0);
		System.out.println("Num1 = "+num1+" Num2= "+num2);
		int sum = num1+num2;
		while(sum>0){
			int rem = sum%10;
			op.add(rem);
			sum = sum/10;
		}
		System.out.println("Backward sum list = ");
		op.traverseSLL();
	}
	
	public void sumListForward(LinkedListImpl<Integer> ll1, LinkedListImpl<Integer> ll2){
		LinkedListImpl<Integer> op = new LinkedListImpl<Integer>();
		//Fetching Integer from LL in forward order
		int num1 = fetchNumberForwardRecur(ll1.head);
		int num2 = fetchNumberForwardItr(ll2.head);
		
		System.out.println("Number Fetched (Fwd) Num1= "+num1+" num2= "+num2);
		int sum = num1+num2;
		while(sum>0){
			int rem = sum%10;
			op.addBeforeHead(rem);
			sum = sum/10;
		}
		System.out.println("Forward sum list = ");
		op.traverseSLL();
	}
	
	public int fetchNumber(Node<Integer> n, int count){
		if(n!=null){
			int depth = count;
			int retV = fetchNumber(n.next,++count);
			retV = retV + n.data*(int)Math.pow(10, depth);
			return retV;
		}else{
			return 0;
		}
	}
	
	public int fetchNumberForwardRecur(Node<Integer> n ){
		StringBuffer sb = new StringBuffer();
		if(n!=null){
			sb = sb.append(n.data);
			int retV = fetchNumberForwardRecur(n.next);
			if(retV != -1){
				sb = sb.append(retV);
			}
			return Integer.valueOf(sb.toString());
		}else{
			return -1;
		}
	}
	
	public int fetchNumberForwardItr(Node<Integer> n ){
		StringBuffer sb = new StringBuffer();
		while(n!=null){
			sb = sb.append(n.data);
			n = n.next;
		}
		return Integer.parseInt(sb.toString());
	}
	public static void main(String args[]){
		LinkedListImpl<Integer> ll1 = new LinkedListImpl<Integer>();
		LinkedListImpl<Integer> ll2 = new LinkedListImpl<Integer>();
		SumList o = new SumList();
		ll1.add(7);
		ll1.add(1);
		ll1.add(6);
		
		ll2.add(5);
		ll2.add(9);
		ll2.add(2);
		
		o.sumListBackward(ll1, ll2);
		o.sumListForward(ll1, ll2);
		
		ArrayList a = new ArrayList();
		a.add(10);
		a.add("A");
		a.add(null);
		System.out.println(a);
	}
		
}
