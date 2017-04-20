package geekforgeeks;

class Node1{
	Node1 left;
	Node1 right;
	int data;
	Node1(int d){
		this.data = d;
	}
}
public class LongestConsecutiveSeqBinaryTree {
	
	public static int longestConSeq(Node1 node){
		if(node == null) return 0;
		int l1=0,l2=0;
		if(node.left!=null){
			if(node.data+1 == node.left.data){
				l1 = 1+longestConSeq(node.left);
			}else{
				l1 = longestConSeq(node.left);
			}
		}
		if(node.right!=null){
			if(node.data+1 == node.right.data){
				l2 = 1+longestConSeq(node.right);
			}else{
				l2 = longestConSeq(node.right);
			}
		}
		return Math.max(l1, l2);
	}

	public static void main(String[] args) {
//		Node1 n = new Node1(6);
//		n.right = new Node1(9);
//		n.right.left = new Node1(7);
//		n.right.right = new Node1(10);
//		n.right.right.right = new Node1(11);
//		Node1 n = new Node1(1);
//		n.left = new Node1(2);
//		n.right = new Node1(4);
//		n.left.left = new Node1(3);
//		n.right.left = new Node1(5);
//		n.right.right = new Node1(6);
//		n.right.right.left = new Node1(7);
		Node1 n = new Node1(10);
		n.left = new Node1(20);
		n.right = new Node1(30);
		n.left.left = new Node1(40);
		n.left.right = new Node1(60);
		n.right.left = new Node1(90);
		int len = longestConSeq(n);
		if(len>0){
			System.out.println("Longest Consecutive Sequence = "+(len+1));
		}else{
			System.out.println("Longest Consecutive Sequence = "+(len-1));
		}
	}

}
