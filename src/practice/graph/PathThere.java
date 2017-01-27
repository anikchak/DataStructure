package practice.graph;

import practice.queue.Q;

public class PathThere<T> {

	public boolean isPathThere(Graph<T> g, T src, T dest){
		Q<Vertex<T>> q = new Q<Vertex<T>>();
		Vertex<T> vSrc = g.getVertex(src);
		Vertex<T> vDest = g.getVertex(dest);
		if(vSrc == null || vDest == null){
			return false;
		}
		q.add(vSrc);
		while(!q.isEmpty()){
			Vertex<T> v = q.remove();
			if(v.adjVertices!=null){
				for(Vertex<T> adj:v.adjVertices){
					if(vDest.data.equals(adj.data)){
						return true;
					}else{
						if(!adj.visited){
							q.add(adj);
							adj.visited = true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String args[]){
		PathThere<String> pt = new PathThere<String>();
		Graph<String> g = new Graph<String>(true);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		//System.out.println(g.vertexCount());
		
		g.addEdge("A", "B");
		g.addEdge("A", "E");
		g.addEdge("B", "E");
		g.addEdge("B", "C");
		g.addEdge("C", "D");
		g.addEdge("C", "F");
		g.addEdge("D", "E");
		g.displayGraph();
		
		System.out.println("Does Path exists? "+ pt.isPathThere(g, "A", "D"));
	}
}
