package practice.tree;

public class ContainsTree {

	public boolean containsTree(BinaryTreeNode T1, BinaryTreeNode T2){
		if(T2 == null && T1 != null) return true;
		if(T1 == null && T2 != null) return false;
		if(T1 == null && T2 == null) return false;
		if(T1.data == T2.data){
			return treeMatching(T1, T2);
		}else{
			boolean leftTree = containsTree(T1.left, T2);
			boolean rightTree = containsTree(T1.right, T2);
			return leftTree||rightTree;
		}
	}
	
	public boolean treeMatching(BinaryTreeNode T1, BinaryTreeNode T2){
		if(T1 == null && T2 == null) return true;
		if(T1 == null || T2 == null) return false;
		if(T1.data == T2.data){
			boolean leftMatch = treeMatching(T1.left, T2.left);
			boolean rightMatch = treeMatching(T1.right, T2.right);
			return (leftMatch && rightMatch); 
		}else{
			return false;
		}
	}
	
	public static void main (String args[]){
		BinaryTreeNode t1 = new BinaryTreeNode(10);
		t1.left = new BinaryTreeNode(20);
		t1.right = new BinaryTreeNode(30);
		t1.left.left = new BinaryTreeNode(40);
		t1.left.right = new BinaryTreeNode(50);
		t1.right.left = new BinaryTreeNode(60);
		
		BinaryTreeNode t2 = new BinaryTreeNode(20);
		t2.left = new BinaryTreeNode(40);
		t2.right = new BinaryTreeNode(50);
		
		ContainsTree ct = new ContainsTree();
		System.out.println("Is T2 contained in T1 = "+ct.containsTree(t1, t2));
	}
}
