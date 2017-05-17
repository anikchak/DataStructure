package geekforgeeks;

import java.util.LinkedList;

public class DetectCycleInDirectedGraph {

	class Vertex{
		int value;
		LinkedList<Edge> adjEdge = null;
		LinkedList<Vertex> adjVertex = null;
		Vertex(int d){
			this.value = d;
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
	
	int noOfVertices = 0;
	Vertex vertex[] = null;
	public DetectCycleInDirectedGraph(int v){
		this.noOfVertices = v;
		vertex = new Vertex[v];
		for(int i=0;i<v;i++){
			vertex[i] = new Vertex(i);
		}
	}
	
	public void addEdges(int s, int d){
		Vertex vSrc = vertex[s];
		Vertex vDest = vertex[d];
		Edge e = new Edge(vSrc, vDest);
		vSrc.adjEdge.add(e);
		vSrc.adjVertex.add(vDest);
	}

	public void isDirectedGraphCyclic() {
		boolean visited[] = new boolean[noOfVertices];
		boolean path[] = new boolean[noOfVertices];
		
		for (int i = 0; i < noOfVertices; i++) {
			visited[i] = false;
			path[i] = false;
		}
		for (int i = 0; i < noOfVertices; i++) {
			if (!visited[i]) {
				boolean res = isDirectedGraphCyclic(i, visited,path);
				if (res) {
					System.out.println("Graph is cyclic");
					return;
				}
			}
		}
		System.out.println("Graph is acyclic");
	}
	public boolean isDirectedGraphCyclic(int v,boolean visited[],boolean path[]){
		if(!visited[v]){
			visited[v] = true;
			LinkedList<Vertex> list = vertex[v].adjVertex;
			for(Vertex vr:list){
				path[v] = true;
				boolean res = isDirectedGraphCyclic(vr.value, visited,path);
				if(res){
					return true;
				}
				path[v] = false;
			}
			return false;
		}else{
			if(path[v]){
				return true;
			}else{
				return false;
			}
		}
	}
	public static void main(String[] args) {
		DetectCycleInDirectedGraph d = new DetectCycleInDirectedGraph(3);
		d.addEdges(0, 1);
		//d.addEdges(1, 0);
		d.addEdges(1, 2);
		//d.addEdges(2, 2);
		d.isDirectedGraphCyclic();
		
		DetectCycleInDirectedGraph d1 = new DetectCycleInDirectedGraph(5);
		d1.addEdges(1, 2);
		d1.addEdges(2, 0);
		d1.addEdges(0, 1);
		d1.addEdges(0, 3);
		d1.addEdges(3, 4);
		d1.isDirectedGraphCyclic();
	}

}
