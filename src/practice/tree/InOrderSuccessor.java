package practice.tree;

class TreeNode<T>{
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	TreeNode<T> parent;
	TreeNode(T d){
		this.data = d;
	}
}

public class InOrderSuccessor<T>{

	//finding in-order successor WITHOUT USING parent node
	Node<T> rootNode = null;
	public void inorderSuccessor(Node<T> root, Node<T> dNode){
		if(root == null){
			System.out.println("Node "+dNode.data+" for which in-order successor is to be found is not present in the tree");
			return;
		}
		int diff = (int) ((Comparable<T>)dNode.data).compareTo(root.data);
		if(diff>0){
			inorderSuccessor(root.right,dNode);
		}else if(diff<0){
			inorderSuccessor(root.left, dNode);
		}else if(diff==0){
			inorderSuccessorUtil(root);
			return;
		}
	}
	public void inorderSuccessorUtil(Node<T> n){
		Node<T> successor = null;
		if(n.right != null){
			successor = fetchLeftMostNode(n.right);
		}
		else{
			Node<T> rNode = rootNode;
			int diff = (int) ((Comparable<T>)n.data).compareTo(rNode.data); 
			while(diff != 0 && rNode != null){
				if(diff<0){
					successor = rNode;
					rNode = rNode.left;
				}else{
					rNode = rNode.right;
				}
				diff = (int) ((Comparable<T>)n.data).compareTo(rNode.data);
			}
		}
		if(successor!=null){
			System.out.println("In-order Successor for Node = "+n.data+ " is = "+successor.data);
		}
		else{
			System.out.println("In-order Successor for Node = "+n.data+ " is = "+successor);
		}
	}
	
	public Node<T> fetchLeftMostNode(Node<T> n){
		if(n.left==null){
			return n;
		}else{
			n = fetchLeftMostNode(n.left);
		}
		return n;
	}
	
	//finding in-order successor WITH USING parent node -- Starts
	// This data structure has been created to accommodate parent node as well
		
	public void inOrderSuccessorWithParent(TreeNode<T> node){
		TreeNode<T> s = null;
		if(node.right!=null){
			s = fetchLeftMostNodeWithParent(node.right);
		}else{
			TreeNode<T> p = node.parent;
			TreeNode<T> curr = node;
			
			while(p!=null && p.left!= curr){
				curr = p;
				p = curr.parent;
			}
			s = p;
		}
		if(s!=null){
			System.out.println("WITH PARENT: In-order Successor for Node = "+node.data+ " is = "+s.data);
		}else if(s == null){
			System.out.println("WITH PARENT: In-order Successor for Node = "+node.data+ " is = "+s);
		}
	}
	
	public TreeNode<T> fetchLeftMostNodeWithParent(TreeNode<T> n){
		if(n.left == null){
			return n;
		}
		else{
			n = fetchLeftMostNodeWithParent(n.left);
		}
		return n;
	}
	//finding in-order successor WITH USING parent node --ends
	public static void main(String args[]){
		InOrderSuccessor<Integer> ios = new InOrderSuccessor<Integer>();
		Node<Integer> n = new Node<Integer>(20);
		ios.rootNode = n;
		n.left = new Node<Integer>(8);
		n.right = new Node<Integer>(22);
		n.left.left = new Node<Integer>(4);
		n.left.right = new Node<Integer>(12);
		n.left.right.left = new Node<Integer>(10);
		n.left.right.right = new Node<Integer>(14);
		
		Node<Integer> dummy = new Node<Integer>(19);
		ios.inorderSuccessor(n, n.left);
		ios.inorderSuccessor(n, n.left.right);
		ios.inorderSuccessor(n, n.left.right.left);
		ios.inorderSuccessor(n, n.left.right.right);
		ios.inorderSuccessor(n, n.right);
		ios.inorderSuccessor(n, dummy);
		
		TreeNode<Integer> tn = new TreeNode<Integer>(20);
		tn.parent = null;
		tn.left = new TreeNode<Integer>(8);
		tn.right = new TreeNode<Integer>(22);
		tn.left.parent = tn;
		tn.right.parent = tn;
		tn.left.left = new TreeNode<Integer>(4);
		tn.left.right = new TreeNode<Integer>(12);
		tn.left.left.parent = tn.left;
		tn.left.right.parent = tn.left;
		tn.left.right.left = new TreeNode<Integer>(10);
		tn.left.right.right = new TreeNode<Integer>(14);
		tn.left.right.left.parent = tn.left.right;
		tn.left.right.right.parent = tn.left.right;
		
		System.out.println();
		
		ios.inOrderSuccessorWithParent(tn.left);
		ios.inOrderSuccessorWithParent(tn.left.right);
		ios.inOrderSuccessorWithParent(tn.left.right.left);
		ios.inOrderSuccessorWithParent(tn.left.right.right);
		ios.inOrderSuccessorWithParent(tn.right);
		ios.inOrderSuccessorWithParent(tn);
		
		TreeNode<Integer> tnDummy = new TreeNode<Integer>(19);
		ios.inOrderSuccessorWithParent(tnDummy);
	}
}
