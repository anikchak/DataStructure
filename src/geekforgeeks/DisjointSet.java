package geekforgeeks;

import java.util.HashMap;

public class DisjointSet {
	
	class Node{
		int data;
		Node parent;
		int rank;
		Node(int d){
			this.data = d;
			this.rank = 0;
			this.parent = null;
		}
	}
	HashMap<Integer,Node> hm = new HashMap<Integer,Node>();
	public void makeSet(int d){
		Node n = new Node(d);
		n.parent = n;
		hm.put(d, n);
	}
	public Integer findSetUtil(int d){
		Node n = findSet(d);
		return n.data;
	}
	public Node findSet(int d){
		Node n = hm.get(d);
		Node parent = n.parent;
		if(parent == n){
			return parent;
		}else{
			//Path Compression
			n.parent = findSet(n.parent.data);
			return n.parent;
		}
	}
	public void union(int a, int b){
		Node parentA = findSet(a);
		Node parentB = findSet(b);
		//Node nA = hm.get(parentA);
		//Node nB = hm.get(parentB);
		//System.out.println(a+" "+b+" "+parentA.data+" "+parentB.data+" "+parentA.rank+" "+parentB.rank);
		if(parentA!=null && parentB!=null){
			if(parentA!=parentB){
				if(parentA.rank>=parentB.rank){
					//System.out.println("here");
					parentA.rank = (parentA.rank==parentB.rank)?(parentA.rank+1):parentA.rank;
					parentB.parent = parentA;
					//System.out.println(parentB.data+" "+parentB.parent.data);
				}else{
					parentA.parent = parentB;
				}
			}
		}
	}
	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet();
		ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);
        
        ds.union(1, 2);
        System.out.println(ds.findSet(1).data);
        System.out.println(ds.findSet(2).data);
        ds.union(3, 4);
        System.out.println(ds.findSet(3).data);
        System.out.println(ds.findSet(4).data);
        ds.union(7, 5);
        System.out.println(ds.findSet(5).data);
        System.out.println(ds.findSet(7).data);
        ds.union(6, 5);
        System.out.println(ds.findSet(6).data);
        System.out.println(ds.findSet(5).data);
        ds.union(3, 6);
        System.out.println(ds.findSet(3).data);
        System.out.println(ds.findSet(6).data);
        ds.union(1, 3);
        System.out.println(ds.findSet(1).data);
        System.out.println(ds.findSet(3).data);
        
        System.out.println(ds.findSet(1).data);
        System.out.println(ds.findSet(2).data);
        System.out.println(ds.findSet(3).data);
        System.out.println(ds.findSet(4).data);
        System.out.println(ds.findSet(5).data);
        System.out.println(ds.findSet(6).data);
        System.out.println(ds.findSet(7).data);
        System.out.println(ds.findSetUtil(7));
	}

}
