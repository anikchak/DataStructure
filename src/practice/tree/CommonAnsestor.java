package practice.tree;

public class CommonAnsestor<T> {

	public Node<T> commonAnsestor(Node<T> n, T a, T b){
		if(n == null){
			return null;
		}
		if(n.data == a || n.data == b){
			return n;
		}
		boolean isaOnLeft = isLeft(n.left, a);
		boolean isbOnLeft = isLeft(n.left, b);
		
		if(isaOnLeft && isbOnLeft){
			return commonAnsestor(n.left, a, b);
		}else if(!isaOnLeft && !isbOnLeft){
			return commonAnsestor(n.right, a, b);
		}else if(isaOnLeft != isbOnLeft){
			//System.out.println("Common Ansestor["+a+","+b+"] = "+n.data);
			return n;
		}
		return n;
	}
	
	public boolean isLeft(Node<T>n, T data){
		if(n == null){
			return false;
		}
		if( n.data == data){
			return true;
		}
		boolean l = isLeft(n.left,data);
		boolean r = isLeft(n.right,data);
		return l||r;
	}
	
	public static void main(String args[]){
		CommonAnsestor<Integer> ca = new CommonAnsestor<Integer>();
		Node<Integer> n = new Node<Integer>(20);
		n.left = new Node<Integer>(50);
		n.right = new Node<Integer>(10);
		n.left.left = new Node<Integer>(31);
		n.left.right = new Node<Integer>(18);
		n.left.left.right = new Node<Integer>(15);
		n.left.right.right = new Node<Integer>(8);
		n.left.right.right.right = new Node<Integer>(90);
		
		int a = 31;
		int b = 15211;
		Node<Integer> node = ca.commonAnsestor(n, a, b);
		if(node != null){
			System.out.println("Common Ansestor["+a+","+b+"] = "+node.data);
		}
	}
}
