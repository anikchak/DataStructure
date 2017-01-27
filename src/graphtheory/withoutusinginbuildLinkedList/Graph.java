/*
 * This file is used to create graph data strc without using in-built Linked List
 */
package graphtheory.withoutusinginbuildLinkedList;

class GraphStrc{
	private int vertex;
	private GraphStrc adjList;
	
	public GraphStrc(int v, GraphStrc g){
		this.vertex = v;
		this.adjList = g;
	}
	
	public GraphStrc getAdjList() {
		return adjList;
	}
	public void setAdjList(GraphStrc adjList) {
		this.adjList = adjList;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	
}

public class Graph {
	
	public int noOfVertices = 6;
	boolean unDirectedGraph = false;
	GraphStrc g[] = new GraphStrc[noOfVertices];
	
	int count = 0;
	public void initializeVertex(int val){
		if(count<noOfVertices){
			g[count] = new GraphStrc(val, null);
			count++;
		}else{
			System.out.println("Vertex limit reached. Modify no. of vertices to add more vertex.");
		}
	}
	
	public void addEdges(int src,int dest){
		int srcPos = findPosition(src);
		int destPos = findPosition(dest);
		g[srcPos].setAdjList(new GraphStrc(dest, g[srcPos].getAdjList()));
		if(unDirectedGraph){
		g[destPos].setAdjList(new GraphStrc(src, g[destPos].getAdjList()));
		}
	}
	
	public int findPosition(int node){
		for(int i=0;i<noOfVertices;i++){
			if(node == g[i].getVertex()){
				return i;
			}
		}
		System.out.println("Node "+node+" not found");
		return -1;
	}
		
	public void display(){
		System.out.println();
		for(int i=0;i<g.length;i++){
			System.out.print(g[i].getVertex());
			GraphStrc gS = g[i].getAdjList();
			
			while(gS!=null){
				System.out.print("->"+gS.getVertex());
				gS = gS.getAdjList();
			}
			System.out.println();
		}
	}
	StackGraph sg = new StackGraph(noOfVertices);
	Queue q = new Queue(noOfVertices);
	Boolean[] visited = new Boolean[noOfVertices];
	
	//Iterative method
	
	public void dfs(int src){
		int srcPos = findPosition(src);
		System.out.println("Traversed = "+g[srcPos].getVertex());
		sg.push(g[srcPos]);
		visited[srcPos] = true;
		GraphStrc node = g[srcPos].getAdjList();
		while(!sg.isStackEmpty()){
			while(node!=null){
			int nPos = findPosition(node.getVertex());
			if(visited[nPos]==false){
				visited[nPos] = true;
				System.out.println("Traversed = "+node.getVertex());
				sg.push(node);
				node = g[nPos].getAdjList();
			}else{
				node = node.getAdjList();
			}
			}
			node = (GraphStrc) sg.pop();
		}
	}
	
	//Recursive Method
	public void dfsRecursive(int src){
		int pos = findPosition(src);
		GraphStrc gs = g[pos];
		if(visited[pos]==false){
			System.out.println("Traversed(Recursion) = "+gs.getVertex());
			visited[pos] = true;
			gs = gs.getAdjList();
			while(gs!=null){
				dfsRecursive(gs.getVertex());
				gs = gs.getAdjList();
			}
		}
	}
	
	//BFS Iterative Method
	public void bsfIterative(int src){
		int pos = findPosition(src);
		GraphStrc node = g[pos];
		visited[pos] = true;
		q.enqueue(node);
		System.out.println("Node Traversed = "+node.getVertex());
		//node = node.getAdjList();
		
		while(!q.isQEmpty()){
			node = (GraphStrc)q.dequeue();
			int dQPos = findPosition(node.getVertex());
			node = g[dQPos];
			while(node!=null){
				int nPos = findPosition(node.getVertex());
				if(visited[nPos] == false){
				q.enqueue(node);
				visited[nPos] = true;
				System.out.println("Node Traversed = "+node.getVertex());
				node = node.getAdjList();
				}else{
					node = node.getAdjList();
				}
			}
		}
	}
	
	//Topological Sort  - Iterative
	public void topologySortIterative(){
		StackGraph stack = new StackGraph(noOfVertices);
		Boolean visitedNodes[] = new Boolean[noOfVertices];
		//initializing all visited nodes to false
		for(int i=0;i<visitedNodes.length;i++){
			visitedNodes[i] = false;
		}
		
		for(int i=0;i<noOfVertices;i++){
			if(visitedNodes[i]==false){
				GraphStrc node = g[i];
				visitedNodes[i] = true;
				while(node.getAdjList()!=null){
					node = node.getAdjList();
					int nodePos = findPosition(node.getVertex());
					if(visitedNodes[nodePos]==false){
					visitedNodes[nodePos] = true;
					stack.push((Integer)node.getVertex());
					}
				}
				
				stack.push((Integer)g[i].getVertex());
			}
		}
		System.out.println("");
		System.out.println("Topological Sort - Iterative");
		while(!stack.isStackEmpty()){
			System.out.print(stack.pop()+" ");
		}
	}
	
	//Topological Sort -  Recursive
	public void topologicalSortRecursive(){
		StackGraph S = new StackGraph(noOfVertices);
		Boolean []visitedVertex = new Boolean[noOfVertices];
		
		for(int i=0;i<noOfVertices;i++){
			visitedVertex[i] = false;
		}
		
		for(int i=0;i<noOfVertices;i++){
			if(visitedVertex[i]==false){
				topologicalSortRecusiveUtil(S,visitedVertex,i);
			}
		}
		
		System.out.println("\n\nTopological Sort - Recursive");
		while(!S.isStackEmpty()){
			System.out.print(S.pop()+" ");
		}
	}
	
	public void topologicalSortRecusiveUtil(StackGraph S, Boolean[] v,int i){
		
		v[i] = true;
		GraphStrc node = g[i];
		
		while(node.getAdjList()!=null){
			node = node.getAdjList();
			int pos = findPosition(node.getVertex());
			if(v[pos]==false){
			topologicalSortRecusiveUtil(S, v, pos);
			}
		}
		S.push((Integer)g[i].getVertex());
	}
	public static void main(String args[]){
		//initializing vertex
		Graph g  = new Graph();
		g.unDirectedGraph = false;
		for(int i=0;i<g.noOfVertices;i++){
			g.initializeVertex(i);
			g.visited[i] = false;
		}
		
		g.addEdges(5, 2);
		g.addEdges(5, 0);
		g.addEdges(4, 0);
		g.addEdges(4, 1);
		g.addEdges(2, 3);
		g.addEdges(3, 1);
		
		System.out.println("Graph structure:");
		g.display();
		
		//DFS
		//g.dfs(1);
		//g.dfsRecursive(1);
		
		//BFS
		//g.bsfIterative(0);
		
		//Topological Sort
		g.topologySortIterative();
		g.topologicalSortRecursive();
	}
}
