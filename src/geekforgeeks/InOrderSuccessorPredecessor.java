package geekforgeeks;

class Node{
	int data;
	Node left;
	Node right;
	Node(int d){
		this.data = d;
	}
}

public class InOrderSuccessorPredecessor {
	
	Node pre = null, succ = null;
	
	public void inorderSuccPre(Node node, int data){
		
		if(node == null){
			System.out.println("No Node found for  = "+data+" Range Start = "+(pre==null?null:pre.data)+" End = "+(succ==null?null:succ.data));
			return;
		}else{
			if(node.data > data){
				succ = node;
				inorderSuccPre(node.left, data);
			}else if(node.data < data){
				pre = node;
				inorderSuccPre(node.right, data);
			}else if(node.data == data){
				//For successor fetch the leftmost node of the right child of the found node: IF Exists
				if(node.right != null){
					succ = findLeftMostNode(node.right);
				}
				//For predecessor fetch the rightmost node of the left child of the found node: If exists
				if(node.left != null){
					pre = findRightMostNode(node.left);
				}
				System.out.println("For node = "+node.data+" Pre = "+(pre==null?null:pre.data)+" Succ = "+(succ==null?null:succ.data));
			}
		}
	}
	public Node findLeftMostNode(Node n){
		if(n.left == null){
			return n;
		}
		return findLeftMostNode(n.left);
	}
	
	public Node findRightMostNode(Node n){
		if(n.right == null){
			return n;
		}
		return findRightMostNode(n.right);
	}
	
	public static void main(String args[]){
		InOrderSuccessorPredecessor o = new InOrderSuccessorPredecessor();
		Node n = new Node(25);
		n.left = new Node(15);
		n.right = new Node(40);
		n.left.left = new Node(10);
		n.left.right = new Node(18);
		n.right.left = new Node(35);
		n.right.right = new Node(45);
		n.left.left.left = new Node(5);
		n.left.right.left = new Node(17);
		n.left.right.right = new Node(20);
		n.right.right.left = new Node(44);
		n.right.right.right = new Node(49);
		
		o.inorderSuccPre(n, 10);
	}
}
