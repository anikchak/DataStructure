/*
 * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. 
 * Given a binary tree, print the top view of it. The output nodes can be printed in any order. Expected time complexity is O(n)

A node x is there in output if x is the topmost node at its horizontal distance. 
Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6
 */
package geekforgeeks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfBTHorizontalDistanceMethod {

	class Node{
		int data;
		Node left;
		Node right;
		int hd; //Horizontal Distance
		Node(int d){
			this.data = d;
		}
	}
	public void diplayTopView(Node n){
		HashMap<Integer,Node> hm = new HashMap<Integer,Node>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while(!q.isEmpty()){
			Node node = q.poll();
			if(!hm.containsKey(node.hd)){
				System.out.print(node.data+"["+node.hd+"]"+" ");
				hm.put(node.hd, node);
			}
			if(node.left!=null){
				node.left.hd = node.hd-1;
				q.add(node.left);
			}
			if(node.right!=null){
				node.right.hd = node.hd+1;
				q.add(node.right);
			}
		}
	}
	
	public static void main(String args[]){
		TopViewOfBTHorizontalDistanceMethod t = new TopViewOfBTHorizontalDistanceMethod();
		Node n = t.new Node(1);
		n.left = t.new Node(2);
		n.right = t.new Node(3);
		n.left.right = t.new Node(4);
		n.left.right.right = t.new Node(5);
		n.left.right.right.right = t.new Node(6);
		t.diplayTopView(n);
	}
}
