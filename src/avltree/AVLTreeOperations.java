package avltree;

public class AVLTreeOperations<T> implements Comparable<T> {

	AVLTreeStrc<T> rootNode = null;
	public void insertNodeInAVLTree(T data){
		rootNode = insertNodeHelper(rootNode,data);
	}
	public AVLTreeStrc<T> insertNodeHelper(AVLTreeStrc<T> node,T data){
		if(node==null){
			node = new AVLTreeStrc<T>(data);
		}else{
			int diff = ((Comparable<T>)node.getData()).compareTo(data);
			if(diff>0){
				node.setLeftNode(insertNodeHelper(node.getLeftNode(), data));
				
				//AVL Tree Condition: tree balancing factor should not be greater than 1
				int leftSubtreeHeight = height(node.getLeftNode());
				int rightSubtreeHeight = height(node.getRightNode());
				if(Math.abs((leftSubtreeHeight-rightSubtreeHeight)) >1){
					if( ((Comparable<T>)node.getLeftNode().getData()).compareTo(data) > 0){
						node = singleLeftRotate(node);
					}else{
						node = doubleLeftRotate(node);
					}
				}
				
			}else if(diff<0){
				node.setRightNode(insertNodeHelper(node.getRightNode(), data));
				
				//AVL Tree Condition: tree balancing factor should not be greater than 1
				int leftSubtreeHeight = height(node.getLeftNode());
				int rightSubtreeHeight = height(node.getRightNode());
				if(Math.abs((leftSubtreeHeight-rightSubtreeHeight)) >1){
					if( ((Comparable<T>)node.getRightNode().getData()).compareTo(data) < 0){
						node = singleRightRotate(node);
					}else{
						node = doubleRightRotate(node);
					}
				}
				
			}
		}
		return node;
	}
	
	//Left Rotation
	public AVLTreeStrc<T> singleLeftRotate(AVLTreeStrc<T> node){
		AVLTreeStrc<T> tempNode = node.getLeftNode();
		node.setLeftNode(tempNode.getRightNode());
		tempNode.setRightNode(node);
		return tempNode;
	}
	
	//Double Left Rotate
	public AVLTreeStrc<T> doubleLeftRotate(AVLTreeStrc<T> node){
		System.out.println("LR hit");
		node.setLeftNode(singleRightRotate(node.getLeftNode()));
		return singleLeftRotate(node);
	}
	
	//Right Rotation
	public AVLTreeStrc<T> singleRightRotate(AVLTreeStrc<T> node){
		AVLTreeStrc<T> temp = node.getRightNode();
		node.setRightNode(temp.getLeftNode());
		temp.setLeftNode(node);
		return temp;
	}
	//Double Right Rotation
	public AVLTreeStrc<T> doubleRightRotate(AVLTreeStrc<T> node){
		System.out.println("RL hit");
		node.setRightNode(singleLeftRotate(node.getRightNode()));
		return singleRightRotate(node);
	}
	
	public int height(AVLTreeStrc<T> node){
		if(node == null){
			return -1;
		}else{
			int leftHt = height(node.getLeftNode());
			int rightHt = height(node.getRightNode());
			return Math.max(leftHt, rightHt)+1;
		}
	}
	
	public void treeTraversal(){
		//Inorder tree traversal
		rootNode = treeTraversalHelper(rootNode);
	}
	
	public AVLTreeStrc<T> treeTraversalHelper(AVLTreeStrc<T> node){
		
		if(node == null){
			return node;
		}else{
			treeTraversalHelper(node.getLeftNode());
			System.out.print(node.getData()+" ");
			treeTraversalHelper(node.getRightNode());
			return node;
		}
	}
	@Override
	public int compareTo(T arg0) {
		return 0;
	}
}
