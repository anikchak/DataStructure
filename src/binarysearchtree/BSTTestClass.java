/**
 * This Test class can be used for
 * Tree creation - Iteratively
 * Tree creation - Recursively
 * Level Order Tree Traversal
 * findMaxIteratively
 * findMaxRecursively
 * findMinIteratively
 * findMinRecursively
 * deleteNode
 * findHeightOfRootNOde
 * findHeightOfNode
 * findDepthOfNode
 * findNodesAtADistance
 */
package binarysearchtree;

public class BSTTestClass {

	public static void main(String[] args) {
		int arr[] = {15,8,25,3,10,20,30,2,5,17,23,28,35,1,4,18,0};
		char arrChar[] = {'P','G','W','A','H','R','D'};
		String strArr[] = {"Ani","Ami","Chak","Zo","Oyo","Flip","Ama"};
		BSTOperations<Object> op = new BSTOperations<Object>();
		
		for(int a: arr){
			op.insertNodeIteratively(a);
			//op.insertNodeRecusively(a);
		}
		
		//op.findHeightOfRoot();
		//op.findHeightOfNode(20);
		//op.depthOfNode(23);
		op.findNodesAtDistance(0);
		/*
		op.traverseTree();
		op.findMaxIteratively();
		op.findMinIteratively();
		op.findMaxRecursively();
		op.findMinRecursively();
		op.deleteNode(25);
		op.deleteNode(15);
		op.deleteNode(8);
		op.deleteNode(28);
		op.deleteNode(35);
		op.deleteNode(30);
		op.deleteNode(23);
		op.deleteNode(10);
		op.deleteNode(5);
		op.deleteNode(18);
		op.deleteNode(20);
		op.deleteNode(4);
		op.deleteNode(17);
		op.deleteNode(2);
		op.deleteNode(1);
		op.deleteNode(3);
		op.traverseTree();
		*/
	}
}
