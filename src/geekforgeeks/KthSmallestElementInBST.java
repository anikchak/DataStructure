package geekforgeeks;

public class KthSmallestElementInBST {

	class Node{
		int data;
		int leftChildCount = 0;
		Node left;
		Node right;
		Node(int d){
			this.data = d;
		}
	}
	//Node root = null;
	public Node insertNode(Node root, int d){
		Node newNode = new Node(d);
		if(root==null){
			root = newNode;
		}else{
			Node n = root;
			Node prev = null;
			while(n!=null){
				prev = n;
				if(n.data>d){
					n.leftChildCount++;
					n = n.left;
				}else{
					n = n.right;
				}
			}
			if(prev.data>d){
				prev.left = newNode;
			}else{
				prev.right = newNode;
			}
		}
		return root;
	}
	public Node kthSmallestElement(Node node, int k){
		if(node == null) return null;
		while(node!=null){
			//System.out.println(node.data+" "+node.leftChildCount);
			if(node.leftChildCount+1 == k){
				return node;
			}
			if(node.leftChildCount>=k){
				node = node.left;
			}
			else{
				k = k - (node.leftChildCount+1);
				node = node.right;
			}
		}
		return node;
	}
	public void traverseTree(Node n){
		if(n==null) return;
		traverseTree(n.left);
		System.out.print(n.data+"["+n.leftChildCount+"] ");
		traverseTree(n.right);
	}
	public static void main(String[] args) {
		KthSmallestElementInBST k  = new KthSmallestElementInBST();
		int a[] = { 20, 8, 22, 4, 12, 10, 14 };
		Node root = null;
		for(int i=0;i<a.length;i++){
			root = k.insertNode(root, a[i]);
		}
		k.traverseTree(root);
		System.out.println();
		
		//Finding kth smallest element
		for(int i=0;i<a.length;i++){
			Node kthSmallest = k.kthSmallestElement(root, i+1);
			System.out.println("Smallest Element when k = "+(i+1)+" is = "+(kthSmallest!=null ? kthSmallest.data: null) );
		}
	}

}
