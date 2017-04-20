/*
 * Given two linked lists which represent number. Perform addition
 * L1: 9->8->7->6 (represents no. 9876)
 * L2: 5->4 (represents no. 54) 
 */
package geekforgeeks;

public class SumOfTwoLL {

	class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
		}
	}
	
	public int calculateSize(Node n){
		int size=0;
		while(n!=null){
			size++;
			n = n.next;
		}
		return size;
	}
	int carry = 0;
	public Node findSum(Node n1, Node n2){
		int sz1 = calculateSize(n1);
		int sz2 = calculateSize(n2);
		int diff = Math.abs(sz1-sz2);
		if(diff == 0){
			Node res =  addEqualLength(n1,n2);
			if(carry>0){
				Node newNode = new Node(carry);
				newNode.next = res;
				return newNode;
			}else{
				return res;
			}
		}
		else{
			/*
			 * Method 1: Add new 0 nodes before in the smaller list 
			 */
//			
//			if(sz1<sz2){
//				for(int i=0;i<diff;i++){
//					Node newZeroNode = new Node(0);
//					newZeroNode.next = n1;
//					n1 = newZeroNode;
//				}
//				
//			}else{
//				for(int i=0;i<diff;i++){
//					Node newZeroNode = new Node(0);
//					newZeroNode.next = n2;
//					n2 = newZeroNode;
//				}
//			}
//			return addEqualLength(n1, n2);
//			
			/*
			 * End of Method 1
			 */
			/*
			 * Method 2: Add new 0 nodes before in the smaller list 
			 */
			if(sz1>sz2){
				return addDiff(n1,n2,diff,0);
			}else{
				return addDiff(n2,n1,diff,0);
			}
			/*
			 * End of Method 2 
			 */
		}
	}
	
	public Node addEqualLength(Node n1, Node n2){
		if(n1==null &&  n2==null){
			return null;
		}
		Node x = addEqualLength(n1.next, n2.next);
		int sum = n1.data+n2.data+carry;
		int rem = sum%10;
		carry = sum/10;
		Node newNode = new Node(rem);
		if(x!=null){
			newNode.next = x;
		}else{
			newNode.next = null;
		}
		return newNode;
	}
	
	public Node addDiff(Node n1, Node n2, int diff, int moved){
		Node res = null;
		if(diff>moved){
			res = addDiff(n1.next,n2,diff,moved+1);
		}else{
			res = addEqualLength(n1, n2);
			return res;
		}
		int sum = carry+n1.data;
		int rem = sum%10;
		carry = sum/10;
		Node newNode = new Node(rem);
		newNode.next = res;
		return newNode;
	}
	
	public void traverse(Node n){
		while(n!=null){
			System.out.print(n.data+"->");
			n = n.next;
		}
		System.out.println("Null");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfTwoLL s = new SumOfTwoLL();
		Node n1 = s.new Node(9);
		n1.next = s.new Node(8);
		n1.next.next = s.new Node(7);
		n1.next.next.next = s.new Node(6);
		Node n2 = s.new Node(5);
		n2.next = s.new Node(4);
		Node res = s.findSum(n2, n1);
		s.traverse(res);
	}

}
