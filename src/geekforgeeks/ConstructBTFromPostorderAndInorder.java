/*
 * Given Postorder and Inorder traversals, construct the tree.

Examples:

Input : 
in[]   = {2, 1, 3}
post[] = {2, 3, 1}

Output : Root of below tree
      1
    /   \
   2     3 


Input : 
in[]   = {4, 8, 2, 5, 1, 6, 3, 7}
post[] = {8, 4, 5, 2, 6, 7, 3, 1} 

Output : Root of below tree
          1
       /     \
     2        3
   /    \   /   \
  4     5   6    7
    \
      8
 */
package geekforgeeks;

public class ConstructBTFromPostorderAndInorder {

	class Node{
		int data;
		Node left;
		Node right;
	}
	int index = 0;
	public Node constructTree(int inorder[], int postorder[], int start, int end){
		if(start>end) return null;
		Node n = new Node();
		//System.out.println("index = "+index+ " start = "+start+" end = "+end);
		n.data = postorder[index];
		index--;
		if(start==end){
			return n;
		}
		//Find this last element from postorder, in inorder array
		int i=0;
		for(i=start;i<=end;i++){
			if(n.data == inorder[i]){
				break;
			}
		}
		//Element is found at ith index in inorder traversal
		//Since this is a post order traversal hence we will first encounter Node; then right child and then left child. 
		//Hence we will first compute right child and then left child
		n.right = constructTree(inorder, postorder, i+1, end);
		n.left = constructTree(inorder, postorder, start, i-1);
		
		return n;
	}
	public void traverseTree(Node n){
		if(n==null) return;
		traverseTree(n.left);
		System.out.print(n.data+" ");
		traverseTree(n.right);
	}
	public static void main(String[] args) {
		ConstructBTFromPostorderAndInorder c  = new ConstructBTFromPostorderAndInorder();
		int in[]   = {4, 8, 2, 5, 1, 6, 3, 7};
		int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
		c.index = post.length-1;
		Node n = c.constructTree(in, post, 0, in.length-1);
		c.traverseTree(n);
	}

}
