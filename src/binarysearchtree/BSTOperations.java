package binarysearchtree;

import queue.QueueOperation;
import queue.QueueStrc;


public class BSTOperations<T> implements Comparable<Object>{

	BinarySearchTreeStrc<T> rootNode=null;
	
	public void insertNodeIteratively(T value){
		//check if the root node is present. If its not present then create the root node
		if(rootNode ==null){
			/*rootNode = new BinarySearchTreeStrc<T>();
			rootNode.setData(value);
			rootNode.setLeftNode(null);
			rootNode.setRightNode(null);*/
			rootNode = new BinarySearchTreeStrc<T>(value);
			System.out.println("Root Node inserted");
		}else{
			//Inserting node at appropriate location
			BinarySearchTreeStrc<T>node = rootNode;
			while(true){
				int diff = ((Comparable<T>) node.getData()).compareTo(value);
				
				if(diff>0){
					if(node.getLeftNode()==null){
						
						System.out.println("Node with value= "+value+" inserted to left of = "+node.getData());
						node.setLeftNode(new BinarySearchTreeStrc<T>(value));
						/*newNode.setData(value);
						newNode.setLeftNode(null);
						newNode.setRightNode(null);
						node.setLeftNode(newNode);*/
						break;
					}else {
						node = node.getLeftNode();
					}
				}
				else if(diff<0){
					
					if(node.getRightNode()==null){
						//BinarySearchTreeStrc<T>newNode = new BinarySearchTreeStrc<T>();
						System.out.println("Node with value="+value+" inserted to right of = "+node.getData());
						node.setRightNode(new BinarySearchTreeStrc<T>(value));
						/*newNode.setData(value);
						newNode.setLeftNode(null);
						newNode.setRightNode(null);
						node.setRightNode(newNode);*/
						break;
					}else {
						node = node.getRightNode();
					}
				}
			}
			
			
		}
		
	}
	//Recursive Insertion
	public void insertNodeRecusively(T value){
		rootNode = insertNodeRecusivelyHelper(rootNode,value);
	}
	public BinarySearchTreeStrc<T> insertNodeRecusivelyHelper(BinarySearchTreeStrc<T>node,T value){
		if(node==null){
			node = new BinarySearchTreeStrc<T>(value);
		}else{
			int diff = ((Comparable<T>) node.getData()).compareTo(value);
			if(diff>0){
			    node.leftNode = insertNodeRecusivelyHelper(node.leftNode,value);
			}else if(diff<0){
				node.rightNode = insertNodeRecusivelyHelper(node.rightNode,value);
			}
		}
		return node;
		
	}
	//Level Order traversal
	public void traverseTree(){
		System.out.println("Tree traversal");
		if(rootNode==null){
			System.out.println("Tree does not exist");
		}else{
			QueueOperation<Object> op = new QueueOperation<Object>();
			op.enqueue(rootNode);
			while(!op.isQueueEmpty()){
				QueueStrc<BinarySearchTreeStrc<T>> q = (QueueStrc<BinarySearchTreeStrc<T>>)op.dequeue();
				BinarySearchTreeStrc<T>currNode = (BinarySearchTreeStrc<T>)q.getELement();
			
				System.out.print(currNode.getData()+"->");
				if(currNode.getLeftNode()!=null){
					op.enqueue(currNode.getLeftNode());
				}
				if(currNode.getRightNode()!=null){
					op.enqueue(currNode.getRightNode());
				}
			}
		}
	}
	
	public void findMaxIteratively(){
		System.out.println("Finding Max element");
		BinarySearchTreeStrc<T> currNode = rootNode;
		while(true){
			if(currNode.getRightNode()==null){
				break;
			}else{
				currNode = currNode.getRightNode();
			}
		}
		System.out.println("Max Element="+currNode.getData());
	}
	
	public void findMinIteratively(){
		System.out.println("Finding Min element");
		BinarySearchTreeStrc<T> currNode = rootNode;
		while(true){
			if(currNode.getLeftNode()==null){
				break;
			}else{
				currNode = currNode.getLeftNode();
			}
		}
		System.out.println("Min Element="+currNode.getData());
	}
	
	public void findMaxRecursively(){
		rootNode = findMaxElementRecursivelyHelper(rootNode);
		System.out.println("RootNode Verification after finding Max="+rootNode.getData());
	}
	
	public void findMinRecursively(){
		rootNode = findMinElementRecursivelyHelper(rootNode);
		System.out.println("RootNode Verification after finding Min="+rootNode.getData());
	}
	/**
	 * This method is used to return max element in a BST. The final return value is the root node of the tree.
	 * @param node
	 * @return
	 */
	public BinarySearchTreeStrc<T> findMaxElementRecursivelyHelper(BinarySearchTreeStrc<T> node){
		
		if(node!=null && node.getRightNode()!=null){
			node.rightNode = findMaxElementRecursivelyHelper(node.rightNode);
		}else if(node.getRightNode()==null){
			System.out.println("Max Element(Recursively)="+node.getData());
		}
		return node;
	}
	/**
	 * This method is used to return Max Element NODE. The final return value is the max element node BST object.
	 * @param node
	 * @return
	 */
public BinarySearchTreeStrc<T> findMaxNodeRecursively(BinarySearchTreeStrc<T> node){
		
		if(node!=null && node.getRightNode()!=null){
			node = findMaxNodeRecursively(node.rightNode);
		}else if(node.getRightNode()==null){
			System.out.println("Max Element Node Value(Recursively for given tree)="+node.getData());
			return node;
		}
		System.out.println("-->"+node.getData());
		return node;
	}
public BinarySearchTreeStrc<T> findMinElementRecursivelyHelper(BinarySearchTreeStrc<T> node){
		
		if(node!=null && node.getLeftNode()!=null){
			node.leftNode = findMinElementRecursivelyHelper(node.leftNode);
		}else if(node.getLeftNode()==null){
			System.out.println("Min Element(Recursively)="+node.getData());
		}
		//System.out.println(node.getData());
		return node;
	}

public void deleteNode(T valueToDelete){
	//Recursive deletion
	rootNode = deleteNodeRecursively(rootNode,valueToDelete);
	if(rootNode!=null)
	System.out.println("RootNode post deletion="+rootNode.getData());
}

public BinarySearchTreeStrc<T> deleteNodeRecursively(BinarySearchTreeStrc<T> node,T valueToDelete){
	if(node==null){
		System.out.println("Tree does not exist");
	}
	else if((((Comparable<T>) node.getData()).compareTo(valueToDelete))>0){
		node.leftNode = deleteNodeRecursively(node.getLeftNode(), valueToDelete);
	}else if((((Comparable<T>) node.getData()).compareTo(valueToDelete))<0){
		node.rightNode = deleteNodeRecursively(node.getRightNode(), valueToDelete);
	}else{
		if(node.getRightNode() == null && node.getLeftNode()==null){
			node = null;
		}else if(node.getRightNode()==null)//If only one child is present. Right Node is not present
		{
			node = node.leftNode;
		}else if(node.getLeftNode()==null){//If only one child is present. Left Node is not present
			node = node.rightNode;
		}else{
			BinarySearchTreeStrc<T> tempFindMaxInLeft = findMaxNodeRecursively(node.getLeftNode());
			System.out.println(tempFindMaxInLeft.getData());
			node.data = tempFindMaxInLeft.getData();
			tempFindMaxInLeft = null;
			node.leftNode = deleteNodeRecursively(node.leftNode, node.getData());
			
		}
	}
	return node;
}

public void findHeightOfRoot(){
	int ht = findHeightHelper(rootNode);
	if(ht==-1){
		System.out.println("Tree is empty");
	}else{
		System.out.println("Height of root node = "+ht);
	}
}

public void findHeightOfNode(T data){
	BinarySearchTreeStrc<T> dataNode = searchPassedDataNode(rootNode,data);
	if(dataNode !=null){
		System.out.print("Node with value = "+dataNode.getData()+" found.");
		int ht = findHeightHelper(dataNode);
		System.out.println(" Height of which is = "+ht);
	}else{
		System.out.println("Node not found.");
	}
}
public BinarySearchTreeStrc<T> searchPassedDataNode(BinarySearchTreeStrc<T> node,T data){
	if(node == null){
		return null;
	}else{
		int diff = ((Comparable<T>) node.getData()).compareTo(data);
		System.out.println("Differnce="+diff);
		if(diff>0){
			System.out.println("Going left of = "+node.getData());
			node = searchPassedDataNode(node.leftNode,data);
		}else if(diff<0){
			System.out.println("Going right of = "+node.getData());
			node = searchPassedDataNode(node.rightNode,data);
		}else{
			return node;
		}
	}
	return node;
}

public int findHeightHelper(BinarySearchTreeStrc<T> node){
	if(node == null){
		return -1;
	}else{
		int leftHt = findHeightHelper(node.getLeftNode());
		int rightHt = findHeightHelper(node.getRightNode());
		return Math.max(leftHt, rightHt)+1;
	}
}

public void depthOfNode(T data){
	Integer depth = depthOfNodeHelper(rootNode,data);
	if(depth == null){
		System.out.println("Node not found");
	}else{
		System.out.println("Depth of node with value = "+data+" ="+depth);
	}
}

public Integer depthOfNodeHelper(BinarySearchTreeStrc<T> node, T data){
	Integer depth = 0;
	if(node == null){
		return (Integer) null;
	}else{
		int diff = ((Comparable<T>) node.getData()).compareTo(data);
		if(diff>0){
			System.out.println("Depth: Going left of = "+node.getData());
			depth = depthOfNodeHelper(node.leftNode,data);
		}else if(diff<0){
			System.out.println("Depth: Going right of = "+node.getData());
			depth = depthOfNodeHelper(node.rightNode,data);
		}else{
			return 0;
		}
	}
	if(depth!=null){
		return depth+1;
	}else{
		return null;
	}
}

public void findNodesAtDistance(int dist){
	findNodesAtDistanceHelper(rootNode,dist);
}

public void findNodesAtDistanceHelper(BinarySearchTreeStrc<T> node,int dist){
	if(node!=null){
		if(dist==0){
			System.out.print(" "+node.getData());
		}else{
			dist--;
			findNodesAtDistanceHelper(node.leftNode,dist);
			findNodesAtDistanceHelper(node.rightNode,dist);
		}
	}
}
	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
