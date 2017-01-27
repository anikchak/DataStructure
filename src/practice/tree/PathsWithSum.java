/*
 * This 
 */
package practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class PathsWithSum {
	
	/*
	 * METHOD 1: 
	 * Step1: Perform in order traversal to reach each node.
	 * Step2: For each node, perform traversal to its left and right subtrees to check if sum is found
	 * Step3: If sum found -> Create a new LinkedList and keep adding the nodes as we iterate back 
	 * 
	 *   DRAWBACK: As soon as the required sum is found, tree traversal for that node will stop. 
	 */

	public void pathWithSum(BinaryTreeNode n,int targetSum){
		if(n == null){
			return;
		}
		pathWithSum(n.left,targetSum);
		ArrayList<LinkedList<BinaryTreeNode>> result = findPathWithSum(n, targetSum, 0);
		if(result != null){
			//Display
			for(LinkedList<BinaryTreeNode> l: result){
				for(BinaryTreeNode node: l){
					System.out.print(node.data +" -> ");
				}
				System.out.println("NULL");
			}
		}
		pathWithSum(n.right,targetSum);
	}
	public ArrayList<LinkedList<BinaryTreeNode>> findPathWithSum(BinaryTreeNode n, int targetSum, int nodeSum){
		if(n==null){
			return null;
		}else{
			nodeSum  = nodeSum+n.data;
			
			if(nodeSum == targetSum){
				LinkedList<BinaryTreeNode> ll = new LinkedList<BinaryTreeNode>();
				ll.add(n);
				ArrayList<LinkedList<BinaryTreeNode>> al = new ArrayList<LinkedList<BinaryTreeNode>>();
				al.add(ll);
				return al;
			}
			ArrayList<LinkedList<BinaryTreeNode>> result = new ArrayList<LinkedList<BinaryTreeNode>>();
			ArrayList<LinkedList<BinaryTreeNode>> left = findPathWithSum(n.left, targetSum, nodeSum);
			ArrayList<LinkedList<BinaryTreeNode>> right = findPathWithSum(n.right, targetSum, nodeSum);
			if(left != null){
				for(LinkedList<BinaryTreeNode> l: left){
					l.addFirst(n);
					result.add(l);
				}
			}
			if(right != null){
				for(LinkedList<BinaryTreeNode> l: right){
					l.addFirst(n);
					result.add(l);
				}
			}
			return result;
		}
	}
	
	/*
	 * End of Method 1
	 */
	
	/*
	 * Method 2: In this method, for each node, get all the paths.
	 * From the resultant list; iterate over each element (which is a LinkedList) and calculate sum. 
	 * If the sum is found then keep that element else; remove it.
	 */
	
	public ArrayList<LinkedList<BinaryTreeNode>> convertTreeToLL(BinaryTreeNode n){
		if(n==null){
			return null;
		}
		if(n.left == null && n.right ==null){
			LinkedList<BinaryTreeNode> ll = new LinkedList<BinaryTreeNode>();
			ll.add(n);
			ArrayList<LinkedList<BinaryTreeNode>> al = new ArrayList<LinkedList<BinaryTreeNode>>();
			al.add(ll);
			return al;
		}
		else{
			ArrayList<LinkedList<BinaryTreeNode>> result = new ArrayList<LinkedList<BinaryTreeNode>>();
			ArrayList<LinkedList<BinaryTreeNode>> resultantLeft = convertTreeToLL(n.left);
			ArrayList<LinkedList<BinaryTreeNode>> resultantRight = convertTreeToLL(n.right);
			if(resultantLeft!=null){
			for(LinkedList<BinaryTreeNode> l : resultantLeft){
				l.addFirst(n);
				result.add(l);
			}
			}
			if(resultantRight !=null){
			for(LinkedList<BinaryTreeNode> l : resultantRight){
				l.addFirst(n);
				result.add(l);
			}
			}
			return result;
		}
		
	}
	
	public ArrayList<LinkedList<BinaryTreeNode>> traverseEachNode(BinaryTreeNode n, ArrayList<LinkedList<BinaryTreeNode>> traversalList){
		if(n == null){
			return null;
		}
		traverseEachNode(n.left,traversalList);
		ArrayList<LinkedList<BinaryTreeNode>> nodeTreeToLL = convertTreeToLL(n);
		for(LinkedList<BinaryTreeNode> l: nodeTreeToLL){
			traversalList.add(l);
		}
		traverseEachNode(n.right,traversalList);
		return traversalList;
	}
	
	public void findSumPath(BinaryTreeNode n, int targetSum){
		ArrayList<LinkedList<BinaryTreeNode>> resultList = traverseEachNode(n, new ArrayList<LinkedList<BinaryTreeNode>>());
		ArrayList<LinkedList<BinaryTreeNode>> finalList = new ArrayList<LinkedList<BinaryTreeNode>>();
		for(LinkedList<BinaryTreeNode> l: resultList){
			int sum = 0;
			for(BinaryTreeNode node: l){
				sum = sum + node.data;
			}
			if(sum == targetSum){
				finalList.add(l);
			}
		}
		
		//Displaying the result
		for(LinkedList<BinaryTreeNode> l: resultList){
			for(BinaryTreeNode node: l){
				System.out.print(node.data + " -> ");
			}
			System.out.println("Null");
		}
	}
	/*
	 * End of Method 2
	 */
	public static void main(String args[]){
		PathsWithSum p = new PathsWithSum();
		BinaryTreeNode n = new BinaryTreeNode(5);
		n.left = new BinaryTreeNode(3);
		n.right = new BinaryTreeNode(2);
		n.left.left = new BinaryTreeNode(3);
		n.left.right = new BinaryTreeNode(-2);
		n.right.right = new BinaryTreeNode(1);
		//n.left.right.left = new BinaryTreeNode(2);
		//ArrayList<LinkedList<BinaryTreeNode>> result = p.findPathWithSum(n, 3, 0);
		//p.pathWithSum(n, 8);
		p.findSumPath(n, 8);
	}
}
