/*
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
       
       For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50
 */
package geekforgeeks;

public class FlatteningLL {

	class Node{
		int value;
		Node next;
		Node down;
		Node(int v)
		{
			this.value = v;
			next = null;
			down = null;
		}
	}
	public void flattenLL(Node n){
		Node a = n;
		Node b = n.next;
		while(b!=null){
			a = flatten(a,b);
			b = b.next;
		}
		traverse(a);
	}
	public Node flatten(Node a, Node b){
		if(a==null){
			return b;
		}
		if(b==null){
			return a;
		}
		Node res=null;
		Node rHead=null;
		int value;
		while(a!=null && b!=null){
			if(a.value<=b.value){
				value = a.value;
				a = a.down;
			}else{
				value = b.value;
				b = b.down;
			}
			//Result set node creation starts
			if(rHead==null){
				rHead = new Node(value);
				res = rHead;
			}else{
				res.down = new Node(value);
				//prev = res;
				res = res.down;
			}
		}
		//If more values are remaining in either of the lists then attach those values to the result list
		if(a!=null){
			res.down = a;
		}
		if(b!=null){
			res.down = b;
		}
		return rHead;
	}
	public void traverse(Node n){
		while(n!=null){
			System.out.print(n.value+" ");
			n = n.down;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		FlatteningLL f = new FlatteningLL();
		Node n = f.new Node(5);
		n.down = f.new Node(7);
		n.down.down = f.new Node(8);
		n.down.down.down = f.new Node(30);
		n.next = f.new Node(10);
		n.next.down = f.new Node(20);
		n.next.next = f.new Node(19);
		n.next.next.down = f.new Node(22);
		n.next.next.down.down = f.new Node(50);
		n.next.next.next = f.new Node(28);
		n.next.next.next.down = f.new Node(35);
		n.next.next.next.down.down = f.new Node(40);
		n.next.next.next.down.down.down = f.new Node(45);
		//f.traverse(n);
		f.flattenLL(n);
	}

}
