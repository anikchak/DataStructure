/*
 * This program is used to find if there is a cycle in an undirected graph or not usng DFS
 */
package geekforgeeks;

import java.util.LinkedList;

public class DetectCycleInUndirectedGraphDFS {

	class Vertex{
		int value;
		LinkedList<Edge> adjEdge = null;
		LinkedList<Vertex> adjVertex = null;
		Vertex(int v){
			this.value = v;
			adjEdge = new LinkedList<Edge>();
			adjVertex = new LinkedList<Vertex>();
		}
	}
	class Edge{
		Vertex src;
		Vertex dest;
		Edge(Vertex s, Vertex d){
			this.src = s;
			this.dest = d;
		}
	}
	int noOfVertex = 0;
	Vertex vertex[] = null;
	DetectCycleInUndirectedGraphDFS(int n){
		this.noOfVertex = n;
		vertex = new Vertex[n];
		for(int i=0;i<n;i++){
			vertex[i] = new Vertex(i);
		}
	}
	LinkedList<Edge> uniqueEdges = new LinkedList<Edge>();
	public void addEdge(int s, int d){
		Vertex src = vertex[s];
		Vertex dest = vertex[d];
		Edge e = new Edge(src,dest);
		src.adjEdge.add(e);
		src.adjVertex.add(dest);
		dest.adjEdge.add(e);
		dest.adjVertex.add(src);
		uniqueEdges.add(e);
	}
	public void getAllEdges(){
		for(int i=0;i<noOfVertex;i++){
			Vertex vCurr = vertex[i];
			System.out.println("For Vertex: "+vCurr.value);
			for(Edge e:vCurr.adjEdge){
				System.out.println("Edge="+e.src.value+" "+e.dest.value);
			}
		}
		for(Edge e: uniqueEdges){
			System.out.println("Unique Edge="+e.src.value+" "+e.dest.value);
		}
	}
	public void isCyclic(){
		boolean visited[] = new boolean[noOfVertex];
		for(int i=0;i<noOfVertex;i++){
			visited[i] = false;
		}
		for(int i=0;i<noOfVertex;i++){
			if(!visited[i]){
				boolean res = isCyclic(i,visited,-1);
				if(res){
					System.out.println("Graph is cyclic");
					return;
				}
			}
		}
		System.out.println("Graph is acyclic");
	}
	public boolean isCyclic(int v, boolean visited[],int parent){
		if(!visited[v]){
			visited[v] = true;
			LinkedList<Vertex> list = vertex[v].adjVertex;
			for(Vertex vt:list){
				if(vt.value != parent){
					boolean res = isCyclic(vt.value, visited, v);
					if(res){
						return true;
					}
				}
			}
		}else{
			//If current vertex v is not coming from previous vertex, then it signifies that there is cycle in graph
			if(v!=parent){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		DetectCycleInUndirectedGraphDFS d = new DetectCycleInUndirectedGraphDFS(3);
		d.addEdge(0, 1);
		d.addEdge(1, 0);
		d.addEdge(1, 2);
		d.addEdge(2, 2);
		d.isCyclic();
		DetectCycleInUndirectedGraphDFS d1 = new DetectCycleInUndirectedGraphDFS(3);
		d1.addEdge(0, 1);
		d1.addEdge(1, 2);
		d1.addEdge(2, 0);
		d1.isCyclic();
	}

}
