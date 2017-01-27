package graphtheory.withvertexandedgeclass;

import java.util.ArrayList;

import disjointset.DisjointSet;

public class KruskalMSTAlgo {
	
	public void kruskalMST(Graph<String> g){
		ArrayList<Edge> edgeWtList = g.getSortedWeightEdgesAsc();
		ArrayList<String> resultList = new ArrayList<String>();
		DisjointSet<String> ds = new DisjointSet<String>();
		//MakeSet corresponding to each vertex
		for(int i=0;i<g.v.length;i++){
			ds.makeSet(g.v[i].getVertex());
		}
		/*
		 * Find and merge all the vertices having separate sets. Also add all such nodes to resultList.
		 * Vertices having same representative set will be simply discarded 
		 */
		for(Edge e:edgeWtList){
			DisjointSet<String>.Node<String> srcNode = ds.findSet(e.getSrc().getVertex().toString());
			DisjointSet<String>.Node<String> dest = ds.findSet(e.getDest().getVertex().toString());
			if(!srcNode.getData().equalsIgnoreCase(dest.getData())){
				String finalResult = e.getSrc().getVertex().toString()+e.getDest().getVertex().toString()+"("+e.getWeight()+")";
				resultList.add(finalResult);
				ds.union(srcNode.getData(), dest.getData());
			}
		}
		System.out.println("\nKruskal's MST="+resultList);
	}

	public static void main(String[] args) {
		Graph.noOfVertices = 6;
		Graph.undirectedGraph = true;
		Graph<String> g = new Graph<String>();
		
		//initialize graph vertices
		g.v[0] = new Vertex<String>("A");
		g.v[1] = new Vertex<String>("B");
		g.v[2] = new Vertex<String>("C");
		g.v[3] = new Vertex<String>("D");
		g.v[4] = new Vertex<String>("E");
		g.v[5] = new Vertex<String>("F");
		
		g.addEdges("A", "D", 1);
		g.addEdges("A", "B", 3);
		g.addEdges("B", "D", 3);
		g.addEdges("B", "C", 1);
		g.addEdges("C", "D", 1);
		g.addEdges("C", "E", 5);
		g.addEdges("C", "F", 4);
		g.addEdges("D", "E", 6);
		g.addEdges("E", "F", 2);	
		
		KruskalMSTAlgo mstObj = new KruskalMSTAlgo();
		mstObj.kruskalMST(g);
	}

}
