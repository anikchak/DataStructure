package graphtheory.withvertexandedgeclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class PrimsMSTBruteForce {

	ArrayList<String> resultList = new ArrayList<String>(); //To hold result set for Prim's MST
	HashMap<String,Integer> vertexWt = new HashMap<String,Integer>(); //To hold Vertex in key and corresponding edge weight as value
	HashMap<String,String> vertexEdge = new HashMap<String,String>(); //To hold vertex as key and edge between src to dest
	
	//This method does not use Map+Heap DS
	public void primsMSTBruteForceLogic(Graph<?> g){
		//Initializing vertexWt map<Vertex,Weight>
		for(Vertex<?> v : g.v){
			vertexWt.put(v.getVertex().toString(), Integer.MAX_VALUE);
		}
		
		//Initializing source vertex to weight 0
		vertexWt.put("A",0);
		
			
		/*After vertex with minimum node is identified; iterate over the vertexWt map
		 * Iteratively keep finding the min weight corresponding to each node and then extract that node
		 * the corresponding min wt edge is added to vertexEdge map
		 * */  
		while(!vertexWt.isEmpty()){
			
			//Check for the node with minimum weight in map
			int minWeight = Integer.MAX_VALUE;
			String minNode = null;
			
			for(HashMap.Entry<String, Integer> mapSet: vertexWt.entrySet()){
				if(minWeight>mapSet.getValue()){
					minWeight = mapSet.getValue();
					minNode = mapSet.getKey();
				}
			}
			//Finding the position for node with min weight
			int minIndex = findPosition(g, minNode);
			int size = g.v[minIndex].adjList.size();
			//Iterate over the adjacent list of the min weight vertex
			for(int i =0;i<size;i++){
				String adjNode = (String) g.v[minIndex].adjList.get(i);
				//After fetching adj node value; search for the weight on the connecting edge
				Edge edge = findWeightOnEdge(g,minNode,adjNode);
				//If the adjacent vertex is present in the map; then check if the edge weight found is lesser than the existing value;
				//if so then update both the maps 
				if(vertexWt.containsKey(adjNode)){
					if(vertexWt.get(adjNode)>edge.getWeight()){
					vertexWt.put(adjNode, edge.getWeight());
					vertexEdge.put(adjNode,edge.getSrc().getVertex().toString().concat(edge.getDest().getVertex().toString()+"("+edge.getWeight()+")"));
					}
				}
			}
			//Remove the min node after each iteration
			vertexWt.remove(minNode);
			// Min weight edge is added to result list
			if(vertexEdge.containsKey(minNode)){
				resultList.add(vertexEdge.get(minNode));
			}
			
			//Find the new minimum node after 
			minWeight = Integer.MAX_VALUE;
		}
		System.out.println("Prim's MST - Brute Force method = "+resultList);
	}
	
	public Edge findWeightOnEdge(Graph g, String src,String dest){
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
	public static void main(String []args){
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
		
		//g.display();
		
		PrimsMSTBruteForce pMST = new PrimsMSTBruteForce();
		pMST.primsMSTBruteForceLogic(g);
	}
}
