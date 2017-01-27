package graphtheory.withvertexandedgeclass;

import java.util.HashMap;

public class BellmanFordAlgo {
	
	public void bellmanFord(Graph<?>g){
		HashMap<String,Integer> distance = new HashMap<String,Integer>();
		HashMap<String,String> parent = new HashMap<String,String>();
		//Initializing map distance with <key,MAX distance> and map parent<key,parent>
		for(Vertex<?> v: g.v){
			distance.put(v.getVertex().toString(), Integer.MAX_VALUE);
			parent.put(v.getVertex().toString(), null);
		}
		//Initializing source vertex
		distance.put(g.v[0].getVertex().toString(), 0);
		int noOfVertices = g.v.length;
		
		for(int i=0;i<noOfVertices-1;i++){
			for(Edge<?> e: g.e){
				if(e!=null){
				String src = e.getSrc().getVertex().toString();
				String dest = e.getDest().getVertex().toString();
				int srcDist = distance.get(src);
				int destDist = distance.get(dest);
				//Relaxation logic goes here
				if(destDist>(srcDist+e.getWeight())){
					distance.put(dest, (srcDist+e.getWeight()));
					parent.put(dest, src);
				}
			}
			}
		}
		
		//Verify if there is -ve weight loop in the graph. If loop exists then throw error
		for(Edge<?> e: g.e){
			if(e!=null){
			String src = e.getSrc().getVertex().toString();
			String dest = e.getDest().getVertex().toString();
			int srcDist = distance.get(src);
			int destDist = distance.get(dest);
			//Relaxation logic goes here
			if(destDist>(srcDist+e.getWeight())){
				System.out.println("-ve weight loop exits");
				return;
			}
			}
		}
		
		//Display result
		System.out.println("Distance from src="+distance);
	}

	public static void main(String []args){
		Graph.noOfVertices = 5;
		Graph.undirectedGraph = false;
		Graph<String> g = new Graph<String>();
		
		//initialize graph vertices
		
		g.v[0] = new Vertex<String>("A");
		g.v[1] = new Vertex<String>("B");
		g.v[2] = new Vertex<String>("C");
		g.v[3] = new Vertex<String>("D");
		g.v[4] = new Vertex<String>("E");
				
		g.addEdges("A", "B", 4);
		g.addEdges("A", "D", 8);
		g.addEdges("A", "C", 5);
		g.addEdges("B", "C", -3);
		g.addEdges("C", "E", 4);
		g.addEdges("D", "E", 2);
		g.addEdges("E", "D", 1);
		
		
		//g.display();
		/*
		g.v[0] = new Vertex<String>("A");
		g.v[1] = new Vertex<String>("B");
		g.v[2] = new Vertex<String>("C");
		g.v[3] = new Vertex<String>("D");
		
		g.addEdges("A", "B", 1);
		g.addEdges("B", "C", 3);
		g.addEdges("C", "D", 2);
		g.addEdges("D", "B", -6);
		*/
		BellmanFordAlgo ob = new BellmanFordAlgo();
		ob.bellmanFord(g);
	}
}
