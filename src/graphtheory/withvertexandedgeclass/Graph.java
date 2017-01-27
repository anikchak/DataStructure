package graphtheory.withvertexandedgeclass;

import graphtheory.withoutusinginbuildLinkedList.StackGraph;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Vertex<T>{
	T vertex;
	List<T> adjList = new ArrayList<T>();
	public List<T> getAdjList() {
		return adjList;
	}
	public void setAdjList(List<T> adjList) {
		this.adjList = adjList;
	}
	Vertex(T v){
		this.vertex = v;
	}
	public T getVertex() {
		return vertex;
	}

	public void setVertex(T vertex) {
		this.vertex = vertex;
	}
	
}

class Edge<T>{
	Vertex<T> src;
	Vertex<T> dest;
	int weight = 1;
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	Edge(Vertex<T> s, Vertex<T> d, int weight){
		this.src =  s;
		this.dest = d;
		this.weight = weight;
	}
	public Vertex<T> getSrc() {
		return src;
	}
	public void setSrc(Vertex<T> src) {
		this.src = src;
	}
	public Vertex<T> getDest() {
		return dest;
	}
	public void setDest(Vertex<T> dest) {
		this.dest = dest;
	}
	
}
class GraphStrc{
	Vertex v[];
	Edge e[];
	
	GraphStrc(int size){
		v = new Vertex[size];
		e = new Edge[1];
	}
}

class Node<T>{
	T edge;
	int weight;
	Node(T ed, int wt){
		this.edge = ed;
		this.weight = wt;		
	}
	public T getEdge() {
		return edge;
	}
	public void setEdge(T edge) {
		this.edge = edge;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
public class Graph<T> {

	public static boolean undirectedGraph = true;
	public static int noOfVertices = 0;
	public int noOfEdges = 0;
	Vertex<T> v[];
	Edge<T> e[];
	
	public Graph(){
		v = new Vertex[noOfVertices];
		e = new Edge[1];
	}
	public int findPosition(T node){
		
		for(int i=0;i<noOfVertices;i++){
			if(node == v[i].getVertex()){
				return i;
			}
		}
		return -1;
	}
	
	//Adding edges
	public void addEdges(T src,T dest,int weight){
		int srcIndex = findPosition(src);
		int destIndex = findPosition(dest);
		v[(int) srcIndex].getAdjList().add(v[(int) destIndex].getVertex());
		//checking if array of Edge has sufficient space
		if(noOfEdges>=e.length){
			increaseEdgeArrayCapacity();
		}
		e[noOfEdges] = new Edge(v[(int)srcIndex],v[(int)destIndex],weight);
		noOfEdges++;
		if(undirectedGraph){
			v[(int) destIndex].getAdjList().add(v[(int) srcIndex].getVertex());
			if(noOfEdges>=e.length){
				increaseEdgeArrayCapacity();
			}
			e[noOfEdges] = new Edge(v[(int)destIndex],v[(int)srcIndex],weight);
			noOfEdges++;
		}
	}
	
	//Method to increase array capacity of Edge
	public void increaseEdgeArrayCapacity(){
		Edge[] temp = e;
		int newSize = temp.length*2;
		e = new Edge[newSize];
		System.arraycopy(temp, 0, e, 0, temp.length);
		temp = null;
	}
	
	//Display Graph
	public void display(){
		for(int i=0;i<noOfVertices;i++){
			System.out.print(v[i].getVertex()+"");
			
			if(v[i].getAdjList() != null){
			int sz = v[i].getAdjList().size();
			for(int j=0;j<sz;j++){
				System.out.print("->"+v[i].getAdjList().get(j));
			}
			}
			System.out.println();
		}
		showEdges();
	}
	
	//Display Edges
	public void showEdges(){
		System.out.println();
		for(int i=0;i<noOfEdges;i++){
			if(e[i]!=null){
				System.out.println("Edge "+(i+1)+" = <"+e[i].getSrc().getVertex()+","+e[i].getDest().getVertex()+">"+"["+e[i].getWeight()+"]");
			}
		}
	}
	
	//DFS Recursive
	public void topologySort(){
		boolean visitedNodes[] = new boolean[noOfVertices];
		for(int i=0;i<noOfVertices;i++){
			visitedNodes[i]=false;
		}
		StackGraph sg = new StackGraph(noOfVertices);
		for(int i=0;i<noOfVertices;i++){
			topologySortRecursionUtil(i,visitedNodes,sg);
		}
		System.out.print("\nTravesed = ");
		while(!sg.isStackEmpty()){
			System.out.print(" "+sg.pop());
		}
	}
	//topologySort Recusrion Util
	public void topologySortRecursionUtil(int src,boolean visited[],StackGraph sg){
		if(visited[src]==false){
			//System.out.println("Traversed = "+v[src].getVertex());
			visited[src] = true;
			if(v[src].getAdjList()!=null){
				int sz = v[src].getAdjList().size();
				for(int i=0;i<sz;i++){
					int nextNodePos = findPosition(v[src].getAdjList().get(i));
					topologySortRecursionUtil(nextNodePos,visited,sg);
				}
			}
			sg.push(v[src].getVertex());
			
		}
	}
	
	//Fetch all the edges
	public ArrayList<Edge> getAllEdges(){
		ArrayList<Edge> edgeWtList =new ArrayList<Edge>();
		for(int i=0;i<noOfEdges;i++){
			if(e[i]!=null){
				edgeWtList.add(e[i]);
			}
		}
		return edgeWtList;
	}
	
	//Fetch all edges in asc order of weights
	public ArrayList<Edge> getSortedWeightEdgesAsc(){
		ArrayList<Edge> edgeWtList = getAllEdges();
		Collections.sort(edgeWtList,new Comparator<Edge>(){

			@Override
			public int compare(Edge n1, Edge n2) {
				// TODO Auto-generated method stub
				if (n1.getWeight() > n2.getWeight()) {
					return 1;
				} else if (n1.getWeight() < n2.getWeight()) {
					return -1;
				} else {
					return 0;
				}
			}
			
		});
		return edgeWtList;
	}
	
	//Get Edges and its weight
	public Edge<?> findWeightOnEdge(T src,T dest){
		int srcIndex = findPosition(src);
		int destIndex = findPosition(dest);
		for(int i=0;i<e.length;i++){
			if(v[srcIndex] == e[i].getSrc() && v[destIndex] == e[i].getDest()){
				return (Edge<?>) e[i];
			}
		}
		return null;
	}
	
	public int findPosition(String node){
		for(int i=0;i<v.length;i++){
			if(node == v[i].getVertex()){
				return i;
			}
		}
		return -1;
	}
public static void main(String []args){
	Graph.noOfVertices = 6;
	Graph.undirectedGraph = false;
	
	Graph<Integer> g = new Graph<Integer>();
	
	//initialize graph vertices
	for(int i=0;i<g.noOfVertices;i++){
		//System.out.println(i);
		g.v[i] = new Vertex<Integer>(i);
	}
	g.addEdges(5, 0, 2);
	g.addEdges(5, 2, 1);
	g.addEdges(4, 0, 4);
	g.addEdges(4, 1, 2);
	g.addEdges(2, 3, 8);
	g.addEdges(3, 1, 9);
	//System.out.println("Edge array length="+g.e.length+" no ofEdges="+g.noOfEdges);
	g.display();
	
	g.topologySort();
	
	ArrayList<Edge> edgeWtList = g.getSortedWeightEdgesAsc();
	System.out.println("Sorted Edge List:");
	for(Edge e:edgeWtList){
		System.out.println(e.getSrc().getVertex()+""+e.getDest().getVertex()+"("+e.getWeight()+")");
	}
}
}
