package practice.linkedlist;

public class ReverseInBlock {

	public void reverseInBlock(LinkedListImpl<Integer> ll, int k) {
		Node<Integer> n = ll.head;
		Node<Integer> prev = null;
		int count = 0;

		while (n != null) {
			int remItemsCount = calculateRemainingItems(n);
			if (remItemsCount < k) {
				return;
			} else {
				Node<Integer> nextStart = kPlus1Element(n, k);
				Node<Integer> next = reverseList(n, nextStart, k);

				if (count == 0) {
					ll.head = next;
					count++;
					prev = n;
				} else {
					prev.next = next;
					prev = n;
					count++;
				}

				n = nextStart;
			}
		}
	}

	public int calculateRemainingItems(Node<Integer> n) {
		int c = 0;
		if (n == null) {
			return 0;
		}
		while (n != null) {
			n = n.next;
			c++;
		}
		return c;
	}

	public Node<Integer> kPlus1Element(Node<Integer> n, int k) {
		int c = 0;
		while (c < k) {
			if (n != null) {
				n = n.next;
				c++;
			} else {
				return null;
			}
		}
		return n;
	}

	public Node<Integer> reverseList(Node<Integer> n, Node<Integer> p, int k) {
		int c = 0;
		Node<Integer> prev = p;
		while (c < k) {
			Node<Integer> next = n.next;
			n.next = prev;
			prev = n;
			n = next;
			c++;

		}
		return prev;
	}

	public static void main(String args[]) {
		LinkedListImpl<Integer> ll = new LinkedListImpl<Integer>();
		ReverseInBlock r = new ReverseInBlock();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		// ll.add(7);
		ll.traverseSLL();

		r.reverseInBlock(ll, 1);

		System.out.println("After block reversal:");
		ll.traverseSLL();

	}
}
