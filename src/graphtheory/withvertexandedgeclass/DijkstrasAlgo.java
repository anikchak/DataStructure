package graphtheory.withvertexandedgeclass;

import java.util.HashMap;
import java.util.List;

public class DijkstrasAlgo {
	
	public void dijkstrasAlgo(Graph<String> g){
		
		HashMap<String,String> vertexParent = new HashMap<String,String>();
		HashMap<String,Integer> vertexDist = new HashMap<String,Integer>();
		
		BinaryHeapMapOptimizedDS dsObj = new BinaryHeapMapOptimizedDS();
		
		//Add all the vertices to the DS
		for(Vertex<?> v: g.v){
			dsObj.add(v.getVertex().toString(), Integer.MAX_VALUE);
		}
		
		//Initializing the source location
		dsObj.decrease(g.v[0].getVertex().toString(), 0);
		//Add the source point to vertexParent map with <src,null>
		vertexParent.put(g.v[0].getVertex().toString(), null);
		
		//Calculate each vertex distance from the source till all the vertices have been traversed
		while(!dsObj.isWeightMapEmpty()){
			BinaryHeapMapOptimizedDS.Node n = dsObj.extractMin();
			int nodeIndex = findPosition(g, n.getKey());
			if(g.v[nodeIndex].getAdjList()!=null){
				List adjList = g.v[nodeIndex].getAdjList();
				int sz = adjList.size();
				//Find Adjacency List of the node
				for(int i=0;i<sz;i++){
					String adjNode = adjList.get(i).toString();
					if(dsObj.isKeyPresent(adjNode)){
						Edge<?> e = findWeightOnEdge(g, n.getKey(), adjNode);
						if(dsObj.getWeightFromWtMap(adjNode)>(e.getWeight()+n.getWeight())){
							vertexParent.put(e.getDest().getVertex().toString(),e.getSrc().getVertex().toString());
							dsObj.decrease(adjNode, e.getWeight()+n.getWeight());
						}
					}
				}
			}
			
		//Update the vertex-distance map with extracted values distance 	
			String parent = vertexParent.get(n.getKey());
			String current = n.getKey();
			//System.out.println("Parent="+parent + "for="+n.getKey());
			int newWt = 0;
				while(parent!=null){
					Edge<?> e = findWeightOnEdge(g, parent, current);
					newWt = newWt + e.getWeight();
					current = parent;
					parent = vertexParent.get(parent);
				}
				//System.out.println("key="+n.getKey()+" wt="+n.getWeight());
				vertexDist.put(n.getKey(),newWt);
				//System.out.println("Distance="+vertexDist);
		}
		System.out.println("Vertex Parent Map = "+vertexParent);
		System.out.println("Vertex Distance Map = "+vertexDist);
	}
	
	public Edge<String> findWeightOnEdge(Graph<String> g, String src,String dest){
		int srcIndex = findPosition(g, src);
		int destIndex = findPosition(g, dest);
		for(int i=0;i<g.e.length;i++){
			if(g.v[srcIndex] == g.e[i].getSrc() && g.v[destIndex] == g.e[i].getDest()){
				return g.e[i];
			}
		}
		return null;
	}
	
	public int findPosition(Graph g, String node){
		for(int i=0;i<g.v.length;i++){
			if(node == g.v[i].getVertex()){
				return i;
			}
		}
		return -1;
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
		
		g.addEdges("A", "B", 5);
		g.addEdges("A", "D", 9);
		g.addEdges("A", "E", 2);
		g.addEdges("B", "C", 2);
		g.addEdges("C", "D", 3);
		g.addEdges("D", "F", 2);
		g.addEdges("E", "F", 3);
		
		//g.display();
		
		DijkstrasAlgo obj = new DijkstrasAlgo();
		obj.dijkstrasAlgo(g);
	}

}
