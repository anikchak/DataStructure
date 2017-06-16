/*
 * Priority Queue is an extension of queue with following properties.
1) Every item has a priority associated with it.
2) An element with high priority is dequeued before an element with low priority.
3) If two elements have the same priority, they are served according to their order in the queue.

A typical priority queue supports following operations.
insert(item, priority): Inserts an item with given priority.
peek(): Returns the highest priority item.
deleteHighestPriority(): Removes the highest priority item.
 */
package queue;

import java.util.Vector;

public class PriorityQueue {

	class Node{
		int data;
		int priority;
		Node(int d, int p){
			this.data = d;
			this.priority = p;
		}
	}
	
	int heapSize = 0;
	Node nodeArr[] = new Node[1];
			
	public void insert(int d, int p){
		Node newNode = new Node(d,p);
		//If heapsize is less than capacity of Node array then add the node and perform insert operation
		//Else increase the capacity and then perform insert operation
		if(heapSize>=nodeArr.length)
		{
			Node temp[] = nodeArr;
			nodeArr = new Node[nodeArr.length*2];
			for(int i=0;i<temp.length;i++){
				nodeArr[i] = temp[i];
			}
			temp = null;
		}
		nodeArr[heapSize] = newNode;
		//MaxHeapify
		if(nodeArr.length>1){
			maxHeapifyInsert(nodeArr,heapSize);
		}
		heapSize++;
	}
	public Node peek(){
		return nodeArr[0];
	}
	public Node remove(){
		Node nodeToReturn = nodeArr[0];
		//System.out.println(nodeToReturn.data);
		if(heapSize==0){
			return null;
		}
		//System.out.println("heapsize="+heapSize+" nodeArr len="+nodeArr.length);
		nodeArr[0] = nodeArr[heapSize-1];
		nodeArr[heapSize-1] = null;
		heapSize--;
		//MaxHeapify
		maxHeapifyRemove(nodeArr,0,heapSize);
		return nodeToReturn;
	}
	public void maxHeapifyInsert(Node n[],int currPos){
		
		while((currPos/2)>=0 && n[currPos].priority>n[currPos/2].priority){
			Node temp = n[currPos/2]; //Parent Node identified by currPos/2
			n[currPos/2] = n[currPos];
			n[currPos] = temp;
			currPos = currPos/2;
		}
	}
	public void maxHeapifyRemove(Node n[],int pos, int size){
		int left = 2*pos+1;
		int right = 2*pos+2;
		int max = pos;
		if(left<size && n[left].priority>n[max].priority){
			max = left;
		}
		if(right<size && n[right].priority>n[max].priority){
			max = right;
		}
		if(max!=pos){
			Node temp = n[max];
			n[max] = n[pos];
			n[pos] = temp;
			maxHeapifyRemove(n, max, size);
		}
	}
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.insert(4, 4);
		pq.insert(8, 8);
		pq.insert(1, 1);
		pq.insert(7, 7);
		pq.insert(3, 3);
		Node peek = null;
		Node remove = null;
		peek = pq.peek()==null?null:pq.peek();
		remove = pq.remove();
		System.out.println("Peek="+(peek==null?null:peek.data));
		System.out.println("Remove="+(remove==null?null:remove.data));
		peek = pq.peek()==null?null:pq.peek();
		remove = pq.remove();
		System.out.println("Peek="+(peek==null?null:peek.data));
		System.out.println("Remove="+(remove==null?null:remove.data));
		peek = pq.peek()==null?null:pq.peek();
		remove = pq.remove();
		System.out.println("Peek="+(peek==null?null:peek.data));
		System.out.println("Remove="+(remove==null?null:remove.data));
		peek = pq.peek()==null?null:pq.peek();
		remove = pq.remove();
		System.out.println("Peek="+(peek==null?null:peek.data));
		System.out.println("Remove="+(remove==null?null:remove.data));
		peek = pq.peek()==null?null:pq.peek();
		remove = pq.remove();
		System.out.println("Peek="+(peek==null?null:peek.data));
		System.out.println("Remove="+(remove==null?null:remove.data));
		peek = pq.peek()==null?null:pq.peek();
		remove = pq.remove();
		System.out.println("Peek="+(peek==null?null:peek.data));
		System.out.println("Remove="+(remove==null?null:remove.data));
		peek = pq.peek()==null?null:pq.peek();
		remove = pq.remove();
		System.out.println("Peek="+(peek==null?null:peek.data));
		System.out.println("Remove="+(remove==null?null:remove.data));
		pq.insert(10, 10);
		peek = pq.peek()==null?null:pq.peek();
		remove = pq.remove();
		System.out.println("Peek="+(peek==null?null:peek.data));
		System.out.println("Remove="+(remove==null?null:remove.data));
		peek = pq.peek()==null?null:pq.peek();
		remove = pq.remove();
		System.out.println("Peek="+(peek==null?null:peek.data));
		System.out.println("Remove="+(remove==null?null:remove.data));
	}
}
