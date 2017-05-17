/*
 * Rearrange a linked list in such a way that all odd position nodes are together and all even positions node are together,

Examples:

Input:   1->2->3->4
Output:  1->3->2->4

Input:   10->22->30->43->56->70
Output:  10->30->56->22->43->70
 */
package geekforgeeks;

public class RearrangeLinkedList {

	class LLNode{
		int data;
		LLNode next;
		public LLNode(int d) {
			this.data = d;
			this.next = null;
		}
	}
	public void reArrange(LLNode node){
		if(node == null) return;
		LLNode odd = node;
		LLNode even = odd.next;
		LLNode evenHead = even;
		
		while((odd!=null && odd.next!=null)||(even!=null && even.next!=null))
		{
			if(odd.next!=null){
				odd.next = even.next;
				if(odd.next!=null){
					odd = odd.next;
				}
			}
			if(even.next!=null){
				even.next = odd.next;
				if(even.next!=null){
					even = even.next;
				}
			}
		}
		odd.next = evenHead;
		traverseList(node);
	}
	public void traverseList(LLNode n){
		while(n!=null){
			System.out.print(n.data+"->");
			n = n.next;
		}
		System.out.println("Null");
	}
	public static void main(String[] args) {
		RearrangeLinkedList r = new RearrangeLinkedList();
		LLNode n = r.new LLNode(1);
		n.next = r.new LLNode(2);
		n.next.next = r.new LLNode(3);
		n.next.next.next = r.new LLNode(4);
		n.next.next.next.next = r.new LLNode(5);
		r.reArrange(n);
	}

}
