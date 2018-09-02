/*
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, 
 * vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 */
package geekforgeeks;

import java.util.LinkedList;
import java.util.Stack;

class GraphTopo{
	class Vertex{
		int value;
		LinkedList<Vertex> adjVertex = null;
		LinkedList<Edge> adjEdge = null;
		Vertex(int v){
			this.value = v;
			adjVertex = new LinkedList<Vertex>();
			adjEdge = new LinkedList<Edge>();
		}
	}
	class Edge{
		Vertex src=null;
		Vertex dest=null;
		Edge(Vertex s, Vertex d){
			this.src = s;
			this.dest = d;
		}
	}
	
	Vertex vertex[]=null;
	GraphTopo(int n){
		vertex = new Vertex[n];
		for(int i=0;i<n;i++){
			vertex[i] = new Vertex(i);
		}
	}
	
	public void addEdge(int s, int d)
	{
		Vertex src = vertex[s];
		Vertex dest = vertex[d];
		Edge e = new Edge(src,dest);
		src.adjEdge.add(e);
		src.adjVertex.add(dest);
	}
}
public class TopologySort {
	public void topologySort(GraphTopo g){
		boolean visited[] = new boolean[g.vertex.length];
		for(int i=0;i<visited.length;i++){
			visited[i] = false;
		}
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				topologySort(g,i,visited,s);
			}
		}
		while(!s.isEmpty()){
			System.out.print(s.pop()+" ");
		}
	}
	public void topologySort(GraphTopo g, int v, boolean[] visited, Stack<Integer> s){
		if(!visited[v]){
			visited[v] = true;
			LinkedList<GraphTopo.Vertex> list = g.vertex[v].adjVertex;
			for(GraphTopo.Vertex vt:list){
				topologySort(g, vt.value, visited, s);
			}
			s.add(v);
		}
	}
	
	public static void main(String[] args) {
		TopologySort t = new TopologySort();
		GraphTopo g = new GraphTopo(6);
		g.addEdge(5, 0);
		g.addEdge(5, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(4, 1);
		g.addEdge(4, 0);
		t.topologySort(g);

	}
}
