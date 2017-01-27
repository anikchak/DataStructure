package avltree;

public class AVLTreeTest {

	public static void main(String[] args) {
		int a[] = {14,17,11,7,53,4,13,12};
		AVLTreeOperations<Object> op = new AVLTreeOperations<Object>();
		for(int node : a){
			op.insertNodeInAVLTree(node);
		}
		
		op.treeTraversal();
	}

}
