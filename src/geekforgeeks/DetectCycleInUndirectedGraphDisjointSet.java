/*
 * This program is used to find if there is cycle in undirected graph using Disjoint Set technique.
 * We need to maintain all unique edges for this method
 */
package geekforgeeks;

import java.util.LinkedList;

import disjointset.DisjointSet;

public class DetectCycleInUndirectedGraphDisjointSet {

	class Vertex{
		int value;
		LinkedList<Vertex> adjVertex = null;
		LinkedList<Edge> adjEdge = null;
		Vertex(int d){
			this.value = d;
			adjVertex = new LinkedList<Vertex>();
			adjEdge = new LinkedList<Edge>();
		}
	}
	class Edge{
		Vertex v1;
		Vertex v2;
		Edge(Vertex a, Vertex b){
			this.v1 = a;
			this.v2 = b;
		}
	}
	Vertex vertex[];
	LinkedList<Edge> uniqueEdge = new LinkedList<Edge>();
	DetectCycleInUndirectedGraphDisjointSet(int n){
		vertex = new Vertex[n];
		for(int i=0;i<n;i++){
			vertex[i] = new Vertex(i);
		}
	}
	public void addVertex(int a, int b){
		Vertex vA = vertex[a];
		Vertex vB = vertex[b];
		Edge e = new Edge(vA,vB);
		vA.adjVertex.add(vB);
		vA.adjEdge.add(e);
		vB.adjVertex.add(vA);
		vB.adjEdge.add(e);
		uniqueEdge.add(e);
	}
	public void isCyclic(){
		geekforgeeks.DisjointSet ds = new geekforgeeks.DisjointSet();		
		for(int i=0;i<vertex.length;i++){
			ds.makeSet(vertex[i].value);
		}
		for(Edge e: uniqueEdge){
			int rep1 = ds.findSetUtil(e.v1.value);
			int rep2 = ds.findSetUtil(e.v2.value);
			if(rep1 == rep2){
				System.out.println("Graph is cyclic");
				return;
			}
			ds.union(rep1, rep2);
		}
		System.out.println("Graph is acyclic");
	}
	public static void main(String[] args) {
		DetectCycleInUndirectedGraphDisjointSet d = new DetectCycleInUndirectedGraphDisjointSet(3);
		d.addVertex(0, 1);
		d.addVertex(1, 2);  
		d.addVertex(1, 0);
		d.isCyclic();
		DetectCycleInUndirectedGraphDisjointSet d1 = new DetectCycleInUndirectedGraphDisjointSet(2);
		d1.addVertex(0, 1);
		d1.isCyclic();
	}

}
