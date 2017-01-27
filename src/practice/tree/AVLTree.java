package practice.tree;

import java.util.Comparator;

public class AVLTree<K> implements Comparator<K>{

	Node<K> rootNode = null;
	
	public void insertNode(K data){
		rootNode = insertNodeUtil(rootNode,data);
	}
	
	public Node<K> insertNodeUtil(Node<K> node,K data){
		if(node == null){
			node = new Node<K>(data);
			return node;
		}else{
			int diff = ((Comparable<K>)data).compareTo(node.data);
			//if diff>0 then move right. else move left
			//Data is smaller than node data. Hence moving to left sub-tree
			if(diff<0){
				node.left = insertNodeUtil(node.left, data);
				//Tree Balancing - Starts
				//Find the left and right sub tree heights for this node
				int leftHt = findTreeHeight(node.left);
				int rightHt = findTreeHeight(node.right);
				int heightDiff = Math.abs(leftHt-rightHt);
				//If (heightDiff > 1) then balancing is needed
				if(heightDiff > 1){
					//Deciding rotation based on data entered with respect to node
					int insertDiff = ((Comparable<K>)data).compareTo(node.getLeft().getData());
					if(insertDiff<0){
						//Perform Single Rotation - Right
						System.out.println("RR"+node.data);
						node = singleRightRotation(node);
					}else{
						//Perform Double Rotation - Left -> Right
						System.out.println("DRLR"+node.data);
						node = doubleRotateLR(node);
					}
				}
				//Tree Balancing - Ends				
			}else{//Data is greater than node data. Hence moving to right sub-tree
				node.right = insertNodeUtil(node.right, data);
				//Tree Balancing - Starts
				//Find the left and right sub tree heights for this node
				int leftHt = findTreeHeight(node.left);
				int rightHt = findTreeHeight(node.right);
				int heightDiff = Math.abs(leftHt-rightHt);
				//If (heightDiff > 1) then balancing is needed
				if(heightDiff > 1){
					//Deciding rotation based on data entered with respect to node
					int insertDiff = ((Comparable<K>)data).compareTo(node.getRight().getData());
					if(insertDiff<0){
						//Perform Double Rotation - Right -> Left
						System.out.println("DRRL"+node.data);
						node = doubleRotateRL(node);
					}else{
						//Perform Single Rotation - Right
						System.out.println("LR"+node.data +" "+data);
						node = singleLeftRotation(node);
					}
				}
				//Tree Balancing - Ends
			}
		}
		return node;
	}
	
	public Node<K> balanceTree(Node<K> node){
		int lHt = findTreeHeight(node.left);
		int rHt = findTreeHeight(node.right);
		//Check if tree balancing is needed
		if(Math.abs(lHt-rHt)>1){
			//check which tree needs rotation
			if(lHt>rHt){
				//Find what type of rotation is needed
				lHt = findTreeHeight(node.left.left);
				rHt = findTreeHeight(node.left.right);
				if(lHt >= rHt){
					node = singleRightRotation(node);
				}else{
					node = doubleRotateLR(node);
				}
			}else{
				lHt = findTreeHeight(node.right.left);
				rHt = findTreeHeight(node.right.right);
				if(lHt > rHt){
					node = doubleRotateRL(node);
				}else{
					node = singleLeftRotation(node);
				}
			}
		}
		return node;
	}
	public Node<K> singleRightRotation(Node<K> n){
		System.out.println("RR invoked on node="+n.data);
		Node<K> temp = n.left;
		n.left = temp.right;
		temp.right = n;
		return temp;
	}
	
	public Node<K> singleLeftRotation(Node<K> n){
		System.out.println("LR invoked on node="+n.data);
		Node<K> temp = n.right;
		n.right = temp.left;
		temp.left = n;
		return temp;
	}
	
	public Node<K> doubleRotateLR(Node<K> n){
		System.out.println("DRLR invoked on node="+n.data);
		n.left = singleLeftRotation(n.left);
		return singleRightRotation(n);
	}
	
	public Node<K> doubleRotateRL(Node<K> n){
		System.out.println("DRRL invoked on node="+n.data);
		n.right = singleRightRotation(n.right);
		return singleLeftRotation(n);
	}
	
	public int findTreeHeight(Node<K> n){
		if(n == null){
			return -1;
		}else{
			int lHt = findTreeHeight(n.left);
			int rHt = findTreeHeight(n.right);
			return Math.max(lHt, rHt)+1;
		}
	}
	
	public void traverseTree(){
		traverseTreeUtil(rootNode);
	}
	
	public void traverseTreeUtil(Node<K> n){
		if(n==null){
			return;
		}
		traverseTreeUtil(n.left);
		System.out.print(n.data+" ");
		traverseTreeUtil(n.right);
	}
	
	public void deleteNode(K data){
		rootNode = deleteNodeUtil(rootNode,data);
	}
	
	public Node<K> deleteNodeUtil(Node<K> node, K data){
		if(node == null){
			System.out.println("Data to delete not found");
			return null;
		}else{
			int diff = ((Comparable<K>)data).compareTo(node.data);
			if(diff<0){
				node.left = deleteNodeUtil(node.left, data);
				node = balanceTree(node);
			}else if(diff>0){
				node.right = deleteNodeUtil(node.right, data);
				node = balanceTree(node);
			}else{
				//Element to be deleted is found
				if(node.left == null && node.right ==null){
					node = null;
				}else if(node.left == null){
					node = node.right;
				}else if(node.right == null){
					node = node.left;
				}else{
					//Node to be deleted has both left and right child/subtree. Find the max element in the left subtree and replace it with this node
					Node<K> tempLeftMax = findMaxInLeftSubTree(node.left);
					node.data = tempLeftMax.data;
					tempLeftMax = null;
					node.left = deleteNodeUtil(node.left, node.data);
				}
				if(node!=null){
					node = balanceTree(node);
				}
			}
		}
		return node;
	}
	
	public Node<K> findMaxInLeftSubTree(Node<K> n){
		if(n!=null && n.right!=null){
			n = findMaxInLeftSubTree(n.right);
		}
		return n;
	}
	
	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.insertNode(14);
		tree.insertNode(17);
		tree.insertNode(11);
		tree.insertNode(7);
		tree.insertNode(53);
		tree.insertNode(4);
		tree.insertNode(13);
		tree.insertNode(12);
		tree.insertNode(8);
		
		/*
		tree.insertNode(20);
		tree.insertNode(30);
		tree.insertNode(40);
		*/
		tree.traverseTree();
		
		System.out.println("\nAfter deletion:");
		tree.deleteNode(53);
		tree.deleteNode(11);
		tree.deleteNode(8);
		tree.traverseTree();
	}

	@Override
	public int compare(K arg0, K arg1) {
		return 0;
	}

}
