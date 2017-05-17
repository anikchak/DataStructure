/*
 * 
 * Given an array that represents a tree in such a way that array indexes are values in tree nodes and 
 * array values give the parent node of that particular index (or node). 
 * The value of the root node index would always be -1 as there is no parent for root. 
 * Construct the standard linked representation of given Binary Tree from this given representation.

Input: parent[] = {1, 5, 5, 2, 2, -1, 3}
Output: root of below tree
          5
        /  \
       1    2
      /    / \
     0    3   4
         /
        6 
Explanation: 
Index of -1 is 5.  So 5 is root.  
5 is present at indexes 1 and 2.  So 1 and 2 are
children of 5.  
1 is present at index 0, so 0 is child of 1.
2 is present at indexes 3 and 4.  So 3 and 4 are
children of 2.  
3 is present at index 6, so 6 is child of 3.
 */
package geekforgeeks;

public class BinaryTreeFromParentArray {

	class Node{
		Node left;
		Node right;
		int data;
		Node(int d){
			this.data = d;
		}
	}
	public void createNode(int a[]){
		Node created[] = new Node[a.length];
		for(int i=0;i<a.length;i++){
			created[i] = null;
		}
		for(int i=0;i<a.length;i++){
			createNode(a,i,created);
		}
	}
	Node root=null;
	public void createNode(int a[], int i, Node created[]){
		if(created[i]!=null){
			return;
		}
		created[i] = new Node(i);
		//If the value is -1, then it is root
		if(a[i]==-1){
			root = created[i];
			return;
		}
		//Check if the parent is already created or not. If not created the create parent node first
		if(created[a[i]]==null){
			createNode(a,a[i],created);
		}
		Node parent = created[a[i]];
		if(parent.left == null){
			parent.left = created[i];
		}else if(parent.right == null){
			parent.right = created[i];
		}
	}
	public void traverse(Node n){
		if(n==null) return;
		traverse(n.left);
		System.out.print(n.data+" ");
		traverse(n.right);
	}
	public static void main(String[] args) {
		BinaryTreeFromParentArray b = new BinaryTreeFromParentArray();
		int a[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
		b.createNode(a);
		b.traverse(b.root);
	}

}
