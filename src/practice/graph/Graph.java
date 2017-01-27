package practice.graph;

import java.util.ArrayList;

class Vertex<T>{
	T data;
	ArrayList<Vertex<T>> adjVertices = new ArrayList<Vertex<T>>();
	boolean visited = false;
	Vertex(T data){
		this.data = data;
	}
}

class Edge<T>{
	Vertex<T> src;
	Vertex<T> dest;
	int weight;
	Edge(Vertex<T> s, Vertex<T> d){
		this.src = s;
		this.dest = d;
		this.src.adjVertices.add(dest);
	}
	
	Edge(Vertex<T> s, Vertex<T> d, int w){
		this.src = s;
		this.dest = d;
		this.weight = w;
		this.src.adjVertices.add(dest);
	}
}
public class Graph<T> {

	Vertex<T> vertex[];
	Edge<T> edge[];
	boolean undirectedGraph;
	int vSize = 0, eSize = 0;
	Graph(){
		undirectedGraph = true;
		vertex = new Vertex[1];
		edge = new Edge[1];
	}
	
	Graph(boolean direction){
		undirectedGraph = false;
		vertex = new Vertex[1];
		edge = new Edge[1];
	}
	
	public void addVertex(T data){
		Vertex<T> v = new Vertex<T>(data);
		if(vSize<vertex.length){
			vertex[vSize] = v;
			vSize++;
		}else{
			Vertex<T> temp[] = vertex;
			/*
			 * Incrementing the array length by 1. If we increment the array length by twice the array length, then for empty indices
			 * the value will be null and hence we need to put additional null checks.
			 * In case the number of vertices in the graph is large then we can multiply the array length by a factor of 2
			 */
			vertex = new Vertex[vertex.length+1];
			System.arraycopy(temp, 0, vertex, 0, temp.length);
			vertex[vSize] = v;
			vSize++;
		}
	}
	
	public void addEdge(T src, T dest){
		Vertex<T> sVert = getVertex(src);
		Vertex<T> dVert = getVertex(dest);
		if(sVert!=null && dVert!=null){
			if(eSize>=edge.length){
				increaseEdgeArraySize();
			}
			edge[eSize] = new Edge<T>(sVert, dVert);
			eSize++;
			if(undirectedGraph){
				if(eSize>=edge.length){
					increaseEdgeArraySize();
				}
				edge[eSize] = new Edge<T>(dVert, sVert);
				eSize++;
			}
		}
	}
	
	public void addEdge(T src, T dest, int wt){

		Vertex<T> sVert = getVertex(src);
		Vertex<T> dVert = getVertex(dest);
		if(sVert!=null && dVert!=null){
			if(eSize>=edge.length){
				increaseEdgeArraySize();
			}
			edge[eSize] = new Edge<T>(sVert, dVert,wt);
			eSize++;
			if(undirectedGraph){
				if(eSize>=edge.length){
					increaseEdgeArraySize();
				}
				edge[eSize] = new Edge<T>(dVert, sVert,wt);
				eSize++;
			}
		}
	
	}

	public void increaseEdgeArraySize(){
		Edge<T> temp[] = edge;
		/*
		 * Incrementing the array length by 1. If we increment the array length by twice the array length, then for empty indices
		 * the value will be null and hence we need to put additional null checks.
		 * In case the number of vertices in the graph is large then we can multiply the array length by a factor of 2
		 */
		edge = new Edge[edge.length+1];
		System.arraycopy(temp, 0, edge, 0, temp.length);
		
	}
	public Vertex<T> getVertex(T data){
		for(Vertex<T> v: vertex){
			if(data.equals(v.data)){
				return v;
			}
		}
		return null;
	}
	public int vertexCount(){
		return vertex.length;
	}
	
	public void displayGraph(){
		System.out.println("Displaying each vertex with its adjacent vertices");
		for(Vertex<T> v : vertex){
			System.out.print(v.data);
			for(int i=0;i<v.adjVertices.size();i++){
				System.out.print(" -> "+v.adjVertices.get(i).data);
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		Graph<String> g = new Graph<String>();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		System.out.println(g.vertexCount());
		
		g.addEdge("A", "B");
		g.addEdge("A", "E");
		g.addEdge("B", "E");
		g.addEdge("B", "C");
		g.addEdge("C", "D");
		g.addEdge("C", "F");
		g.addEdge("D", "E");
		g.displayGraph();
		
	}
}
