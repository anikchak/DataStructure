/*
 * Given a binary tree, we need to find maximum value we can get by subtracting value of node B from value of node A, 
 * where A and B are two nodes of the binary tree and A is an ancestor of B. Expected time complexity is O(n).

For example, consider below binary tree

		8
	   / \
	  3  10
	 / \   \
	1   6   14
	   / \  /
	  4  7 13
	   
We can have various ancestor-node difference, some of which are given below :
8 – 3 = 5
3 – 7 = -4
8 – 1 = 7
10 – 13 = -3
. . . .

But among all those differences maximum value is 7 obtained by subtracting 1 from 8, which we need to return as result.
 */
package geekforgeeks;

public class MaxDiffBetweenNodeAndAncestorBT {

	class Node {
		int data;
		Node left;
		Node right;

		Node(int d) {
			this.data = d;
		}
	}

	class MinDiffNode {
		Node ancestor;
		Node minNode;
		int maxDiff;
	}

	public MinDiffNode findMaxDiff(Node n) {
		if (n == null)
			return null;
		MinDiffNode min = new MinDiffNode();
		if (n.left == null && n.right == null) {
			min.ancestor = null;
			min.minNode = n;
			min.maxDiff = 0;
			return min;
		}
		MinDiffNode left = findMaxDiff(n.left);
		MinDiffNode right = findMaxDiff(n.right);
		//System.out.println(left + " " + right);
		if (left == null) {
			min = right;
		} else if (right == null) {
			min = left;
		} else {
			if (left.minNode.data < right.minNode.data) {
				min = left;
			} else {
				min = right;
			}
		}
		int diff = n.data - min.minNode.data;
		if (diff > min.maxDiff) {
			min.maxDiff = diff;
			min.ancestor = n;
			min.minNode = min.minNode;
		}
		return min;
	}

	public static void main(String[] args) {
		MaxDiffBetweenNodeAndAncestorBT m = new MaxDiffBetweenNodeAndAncestorBT();
		Node n = m.new Node(8);
		n.left = m.new Node(3);
		n.right = m.new Node(10);
		n.left.left = m.new Node(1);
		n.left.right = m.new Node(6);
		n.left.right.left = m.new Node(4);
		n.left.right.right = m.new Node(7);
		n.right.right = m.new Node(14);
		n.right.right.left = m.new Node(13);
		MinDiffNode min = m.findMaxDiff(n);
		System.out.println("Max Diff = "+min.maxDiff+ "\nNodes = <"+min.ancestor.data+","+min.minNode.data+">");
	}

}
