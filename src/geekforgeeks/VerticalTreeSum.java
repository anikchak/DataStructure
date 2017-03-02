package geekforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalTreeSum {
	
	public class Node{
		int data;
		Node left;
		Node right;
		//Horizontal Distance
		int hd;
		public Node(int d){
			this.data = d;
		}
	}
	
	/*
	 * Method 1: 
	 * Calculate horizontal distance for each node
	 * Re-traverse the tree and order nodes as per the calculated horizontal distances
	 */
	public void vertical(Node n){
		calculateHD(n,0);
		traverse(n);
		HashMap<Integer,ArrayList<Integer>> result = new HashMap<Integer,ArrayList<Integer>>();
		populateResult(n,result);
		System.out.println(result);
	}
	
	public void populateResult(Node n, HashMap<Integer,ArrayList<Integer>> result){
		if(n == null) return;
		populateResult(n.left, result);
		if(result.containsKey(n.hd)){
			ArrayList<Integer> al = result.get(n.hd);
			al.add(n.data);
			result.put(n.hd, al);
		}else{
			ArrayList<Integer> al = new ArrayList<Integer>();
			al.add(n.data);
			result.put(n.hd, al);
		}
		populateResult(n.right, result);
	}
	public void calculateHD(Node n, int depth){
		if(n== null)
			return;
		
		calculateHD(n.left, --depth);
		depth++;
		n.hd = depth;
		calculateHD(n.right, ++depth);
		depth--;
	}
	/*
	 * End of Method 1
	 */
	
	/*
	 * Method 2: Instead of re-iterating over the tree again to find horizontal distance, we can associate nodes with HD
	 */
	class VerticalHelper{
		int sum = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
	}
	public void verticalOpti(Node n){
		HashMap<Integer,VerticalHelper> result = new HashMap<Integer,VerticalHelper>();
		verticalOptiUtil(n, 0, result);
		System.out.println("Vertical Opti Result:");
		for(Map.Entry<Integer,VerticalHelper> m: result.entrySet()){
			VerticalHelper vhObj = m.getValue();
			System.out.println("HD = "+m.getKey()+" Nodes = "+vhObj.al+ " Sum = "+vhObj.sum);
		}
	}
	public void verticalOptiUtil(Node n, int depth, HashMap<Integer,VerticalHelper> result){
		if(n == null) return;
		verticalOptiUtil(n.left, --depth, result);
		depth++;
		n.hd = depth;
		int key = n.hd;
		VerticalHelper obj = null;
		if(result.containsKey(key)){
			obj = result.get(key);
			obj.sum = obj.sum + n.data;
		}
		else{
			obj = new VerticalHelper();
			obj.sum = obj.sum + n.data;
		}
		obj.al.add(n.data);
		result.put(key, obj);
		verticalOptiUtil(n.right, ++depth, result);
		depth--;
	}
	/*
	 * End of Method 2
	 */
	public void traverse(Node n){
		if(n== null) return;
		traverse(n.left);
		System.out.println("Node = "+n.data+" HD = "+n.hd);
		traverse(n.right);
	}
	public static void main(String[] args) {

		VerticalTreeSum v = new VerticalTreeSum();
		Node n = v.new Node(1);
		n.left = v.new Node(2);
		n.right = v.new Node(3);
		n.left.left = v.new Node(4);
		n.left.right = v.new Node(5);
		n.right.left = v.new Node(6);
		n.right.right = v.new Node(7);
		//v.vertical(n);
		
		v.verticalOpti(n);
		System.out.println("Traversal:");
		v.traverse(n);
	}

}
