package disjointset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Node object will hold <data,parent of node and rank>

public class DisjointSet<T> {
	
	HashMap<T,Node<T>> m = new HashMap<T,Node<T>>();
	public class Node<T>{
		T data;
		int rank;
		Node<T> parent;
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public int getRank() {
			return rank;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
		public Node<T> getParent() {
			return parent;
		}
		public void setParent(Node<T> parent) {
			this.parent = parent;
		}
	}
	//Used to create individual sets
	public void makeSet(T data){
		Node<T> n = new Node<T>();
		n.setData(data);
		n.setParent(n);
		n.setRank(0);
		m.put(data, n);
	}
	
	//Used find the representative set value for the given data
	public Node<T> findSet(T data){
		Node<T> n = m.get(data);
		Node<T> p = n.getParent();
		if(p==n){
			return p;
		}
		//Applying Path Compression
		n.parent  = findSet((T)p.getData());
		return n.parent;
	}
	
	//Used to merge two sets based on the rank. Merge lower rank tree to higher rank tree
	//If the ranks are same then any tree could become representative class
	public void union(T x, T y){
		Node<T> n1 = m.get(x);
		Node<T> n2 = m.get(y);
		Node<T> rep1 = findSet(n1.getData());
		Node<T> rep2 = findSet(n2.getData());
		
		if(rep1 != rep2){
			if(rep1.getRank() >= rep2.getRank()){
				rep1.rank = (rep1.rank==rep2.rank)?(rep1.rank+1):rep1.rank;
				rep2.parent = rep1;
			}else{
				rep1.parent = rep2;
			}
		}
	}
	
	public static void main(String[] args) {
		DisjointSet<Integer> ds = new DisjointSet<Integer>();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);
        
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);
        
        System.out.println(ds.findSet(1).getData());
        System.out.println(ds.findSet(2).getData());
        System.out.println(ds.findSet(3).getData());
        System.out.println(ds.findSet(4).getData());
        System.out.println(ds.findSet(5).getData());
        System.out.println(ds.findSet(6).getData());
        System.out.println(ds.findSet(7).getData());
        
   }
}
