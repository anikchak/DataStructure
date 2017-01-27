package graphtheory.withvertexandedgeclass;

import graphtheory.withvertexandedgeclass.BinaryHeapMapDS.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrimsMSTHeapMapDS {

	ArrayList<String> resultList = new ArrayList<String>();
	HashMap<String,String> vertexEdgeMap = new HashMap<String,String>();
	
	public void primsMSTHeapMapDSLogic(Graph<String> g){
		BinaryHeapMapDS heapMapObj = new BinaryHeapMapDS();
		for(int i=0;i<g.v.length;i++){
			heapMapObj.add(Integer.MAX_VALUE, g.v[i].getVertex());
		}
		heapMapObj.decrease(g.v[4].getVertex(), 0);
		//heapMapObj.displayHeap();
		//heapMapObj.displayMap();
		while(!heapMapObj.isMapEmpty()){
			Node minWtVertex = heapMapObj.extractMin();
			int minVertexIndex = findPosition(g, minWtVertex.getKey());
			List adjList = g.v[minVertexIndex].getAdjList();
			for(int i=0;i<adjList.size();i++){
				Edge e = findWeightOnEdge(g, minWtVertex.getKey(), adjList.get(i).toString());
				//System.out.println("Extracted="+minWtVertex.getKey());
				if((heapMapObj.m.containsKey(e.getDest().getVertex().toString()))){
					//heapMapObj.displayHeap();
					//heapMapObj.displayMap();
					int destPos = heapMapObj.m.get(e.getDest().getVertex().toString());
					Node n = heapMapObj.heapArray[destPos];
					//System.out.println("e wt="+e.getDest().getVertex()+e.getWeight()+" n wt="+n.getKey()+n.getWeight());
					if(e.getWeight()<n.getWeight()){
						heapMapObj.decrease(e.getDest().getVertex().toString(), e.getWeight());
						String finalVal = e.getSrc().getVertex().toString()+""+e.getDest().getVertex().toString()+"("+e.getWeight()+")";
						vertexEdgeMap.put(e.getDest().getVertex().toString(), finalVal);
					}
				//System.out.println(vertexEdgeMap);
				}
			}
			//System.out.println("min"+minWtVertex.getKey());
			if(vertexEdgeMap.containsKey(minWtVertex.getKey())){
				resultList.add(vertexEdgeMap.get(minWtVertex.getKey()));
			}
		//	Node n1 = heapMapObj.extractMin();
		//	System.out.println("Removed="+n1.getKey());
		}
		System.out.println("Prims MST HeapMap DS = "+resultList);
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
	public static void main(String args[]){
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
		PrimsMSTHeapMapDS obj = new PrimsMSTHeapMapDS();
		obj.primsMSTHeapMapDSLogic(g);
	}
}
