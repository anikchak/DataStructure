package graphtheory.withvertexandedgeclass;

import graphtheory.withvertexandedgeclass.BinaryHeapMapOptimizedDS.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class PrimsMSTHeapMapOptimizedDS {

	public void primsMST(Graph<String> g){
		ArrayList<String> resultList = new ArrayList<String>();
		HashMap<String,String> vertexEdgeMap = new HashMap<String,String>();
		
		//Add vertex to HeapMapDS
		BinaryHeapMapOptimizedDS obj = new BinaryHeapMapOptimizedDS();
		for(int i =0;i<g.v.length;i++){
			obj.add(g.v[i].getVertex(), Integer.MAX_VALUE);
		}
		//Set the source vertex
		obj.decrease(g.v[0].getVertex(), 0);
		while(!obj.isWeightMapEmpty()){
			//Extract min weight node
			Node n = obj.extractMin();
			int minNodeIndex = findPosition(g, n.getKey());
			ArrayList<String> adjListForExtractedNode = (ArrayList<String>) g.v[minNodeIndex].getAdjList();
			
			//Set the new weights
			for(int i=0;i<adjListForExtractedNode.size();i++){
				if(obj.isKeyPresent(adjListForExtractedNode.get(i))){
					Edge e = findWeightOnEdge(g, n.getKey(), adjListForExtractedNode.get(i));
					String destVertex = e.getDest().getVertex().toString();
					if(e.getWeight() < obj.getWeightFromWtMap(destVertex)){
						obj.decrease(destVertex, e.getWeight());
						String finalVal = n.getKey()+""+destVertex+"("+e.getWeight()+")";
						vertexEdgeMap.put(destVertex, finalVal);
					}
				}
			}
			if(vertexEdgeMap.containsKey(n.getKey())){
				resultList.add(vertexEdgeMap.get(n.getKey()));
			}
		}
		System.out.println("Prims MST heap map DS(optimized) = "+resultList);
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
		// TODO Auto-generated method stub
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
		PrimsMSTHeapMapOptimizedDS obj = new PrimsMSTHeapMapOptimizedDS();
		obj.primsMST(g);
	}

}
