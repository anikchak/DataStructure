package graphtheory;

import java.util.LinkedList;

import queue.QueueOperation;
import queue.QueueStrc;
import stack.StackOperation;

class Graph{
	private String vertex;
	private Boolean visited;
	Graph(String ver){
		this.vertex = ver;
		this.visited = false;
	}
	public String getVertex() {
		return vertex;
	}
	public void setVertex(String vertex) {
		this.vertex = vertex;
	}
	public Boolean getVisited() {
		return visited;
	}
	public void setVisited(Boolean visited) {
		this.visited = visited;
	}
	
}


public class GraphCreationAdjList {
	
	
	static LinkedList<Graph> adjList[] ;
	int c = 0;
	public void initiateVetices(String v){
		if(c<adjList.length){
		
		Graph g = new Graph(v);
		adjList[c] = new LinkedList();
		adjList[c].add(g);
		c++;
		}
	}
	
	public void add_edges(String u, String v){
		LinkedList uNode = null, vNode = null;
		int uPosition = findPosition(u);
		int vPosition = findPosition(v);
		if(vPosition != -1 && uPosition!= -1){
			//Fetching graph object at uPosition and vPosition
			Graph gU = (Graph)adjList[uPosition].get(0);
			Graph gV = (Graph)adjList[vPosition].get(0);
			
			adjList[uPosition].add(gV);
			adjList[vPosition].add(gU);
		}
		
	}
	
	public int findPosition(String node){
		for(int i=0;i<adjList.length;i++){
			Graph g = (Graph)adjList[i].get(0);
			if(node.equalsIgnoreCase(g.getVertex())){
				return i;
			}
		}
		return -1;
	}
	
	public void displayNodes(){
		for(int i=0;i<adjList.length;i++){
			System.out.println("");
			for(int j=0;j<adjList[i].size();j++){
				Graph g = (Graph)adjList[i].get(j);
				System.out.print(g.getVertex()+"("+g.getVisited()+") -> ");
			}
		}
	}
	
	
	//Iterative method
	public void DFS(String src){
		System.out.println("\n\nDFS graph traversal");
		int pos = findPosition(src);
		if(pos == -1){
			System.out.println("Source element not found");
			return;
		}
		Graph srcObj = (Graph)adjList[pos].get(0);
		StackOperation<Graph> op = new StackOperation<Graph>();
		srcObj.setVisited(true);
		
		System.out.println("\nNode = "+srcObj.getVertex()+" visited");
		op.push(srcObj);
		while(!op.isStackEmpty()){
			int c = 0;
			for(int i=0;i<adjList[pos].size();i++){
				Graph gObj = (Graph)adjList[pos].get(i);
				if(!gObj.getVisited()){
					gObj.setVisited(true);
					op.push(gObj);
					System.out.println("Node = "+gObj.getVertex()+" visited");
					c--;
				}else{
					c++;
				}
			}
			if(c == adjList[pos].size()){
				op.pop();
			}
			if(!op.isStackEmpty()){
			Graph g = op.top().getElement();
			pos = findPosition(g.getVertex());
			}
		}
	}
	
	//BFS 
	public void BFS(String s){
		System.out.println("\nBFS graph traversal starts\n");
		int pos = findPosition(s);
		if(pos == -1){
			System.out.println("Source element not found");
			return;
		}
		Graph g = (Graph)adjList[pos].get(0);
		g.setVisited(true);
		QueueOperation<Object> op = new QueueOperation<Object>();
		op.enqueue(g);
		
		while(!op.isQueueEmpty()){
			QueueStrc<?> q= (QueueStrc<?>) op.dequeue();
			Graph gObj = (Graph)q.getELement();
			System.out.println("Node visited = "+gObj.getVertex());
			pos = findPosition(gObj.getVertex());
			for(int i = 1;i<adjList[pos].size();i++){
				Graph node = (Graph)adjList[pos].get(i);
				if(!node.getVisited()){
					node.setVisited(true);
					op.enqueue(node);
				}
			}
		}
	}
	public static void main(String [] args){
		int noOfVertices = 8;
		adjList = new LinkedList[noOfVertices];
		GraphCreationAdjList adList = new GraphCreationAdjList();
	//	adList.initiateVetices("S");
		adList.initiateVetices("A");
		adList.initiateVetices("B");
		adList.initiateVetices("C");
		adList.initiateVetices("D");
		adList.initiateVetices("E");
		adList.initiateVetices("F");
		adList.initiateVetices("G");
		adList.initiateVetices("H");
		
		
		adList.add_edges("A", "B");
		adList.add_edges("B", "C");
		adList.add_edges("C", "E");
		adList.add_edges("C", "D");
		adList.add_edges("E", "H");
		adList.add_edges("E", "G");
		adList.add_edges("E", "F");
		
		/*
		adList.add_edges("S", "A");
		adList.add_edges("S", "B");
		adList.add_edges("S", "C");
		adList.add_edges("C", "D");
		adList.add_edges("B", "D");
		adList.add_edges("A", "D");
		*/
		System.out.println("Graph Nodes:");
		adList.displayNodes();
		
	//	adList.DFS("S");
		adList.BFS("S");
	}
}
