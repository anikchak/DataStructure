package practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class ConvertTreeToLL {

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
	
	public static void main(String args[]){
		ConvertTreeToLL tl = new ConvertTreeToLL();
		
		BinaryTreeNode t1 = new BinaryTreeNode(10);
		t1.left = new BinaryTreeNode(20);
		t1.right = new BinaryTreeNode(30);
		t1.left.left = new BinaryTreeNode(40);
		t1.left.right = new BinaryTreeNode(50);
		t1.right.left = new BinaryTreeNode(60);
		
		ArrayList<LinkedList<BinaryTreeNode>> result = tl.convertTreeToLL(t1);
		
		//Display
		for(LinkedList<BinaryTreeNode> l: result){
			for(BinaryTreeNode n: l){
				System.out.print(n.data +" -> ");
			}
			System.out.println("NULL");
		}
	}
}
