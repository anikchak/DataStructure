package geekforgeeks;

import java.util.LinkedList;

public class GraphStructure {

	class Vertex{
		int value;
		LinkedList<Edge> adjEdge = null;
		LinkedList<Vertex> adjVertex = null;
		Vertex(int i){
			this.value = i;
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
	
	Vertex vertex[] = null;
	int noOfVerticies = 0;
	
	public GraphStructure(int n) {
		this.noOfVerticies = n;
		vertex = new Vertex[n];
		for(int i=0;i<n;i++){
			vertex[i] = new Vertex(i); 
		}
	}
	public void addEdge(int src, int dest){
		Edge e = new Edge(vertex[src], vertex[dest]);
		vertex[src].adjEdge.add(e);
		vertex[src].adjVertex.add(vertex[dest]);
	}
	
	public void graphStructurePrint(){
		for(int i=0;i<noOfVerticies;i++){
			Vertex v = vertex[i];
			System.out.println("For vertex: "+v.value);
			System.out.print("Adjacent verticies are: <");
			for(Vertex aV:v.adjVertex){
				System.out.print(aV.value+" ");
			}
			System.out.print(">\n");
			System.out.println("Adjacent edges are: ");
			for(Edge e:v.adjEdge){
				Vertex s = e.src;
				Vertex d = e.dest;
				System.out.println("Edge<"+s.value+"->"+d.value+">");
			}
		}
	}
	public static void main(String[] args) {
		GraphStructure gs = new GraphStructure(6);
		gs.addEdge(5, 0);
		gs.addEdge(5, 2);
		gs.addEdge(4, 0);
		gs.addEdge(4, 1);
		gs.addEdge(2, 3);
		gs.addEdge(3, 1);
		gs.graphStructurePrint();
	}

}
