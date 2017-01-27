package graphtheory.withvertexandedgeclass;

import java.util.HashMap;

public class BinaryHeapMapDS {
public class Node{
	String key;
	int weight;
	Node(String key, int wt){
		this.key = key;
		this.weight = wt;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
//The map to hold key and its position in heapArray
HashMap<String,Integer> m = new HashMap<String,Integer>();
Node []heapArray = new Node[1];
int count = 0;
public void add(int wt,String key){
	int currIndex = 0;
	//Create a node object which will hold the key and weight
	Node n  = new Node(key, wt);
	if(heapArray.length>count){
		heapArray[count] = n;
		currIndex = count;
		count++;
	}else{
		int capacity = heapArray.length;
		capacity = capacity*2;
		Node temp[] = heapArray;
		heapArray = new Node[capacity];
		System.arraycopy(temp, 0, heapArray, 0, temp.length);
		heapArray[count] = n;
		currIndex = count;
		count++;
		temp = null;
	}
	//Add the <key,position> pair to map
	m.put(key, currIndex);
	
	int parentIndex = (currIndex-1)/2;
	while(parentIndex>=0){
		Node pNode = heapArray[parentIndex];
		Node cNode = heapArray[currIndex];
		//creating binary heap using weight
		if(pNode.getWeight()>cNode.getWeight()){
			//Swap node positions in heapArray
			heapArray = swapPositions(pNode, parentIndex, cNode, currIndex);
			//update key positions in map
			updateMapWithPositions(pNode, currIndex, cNode, parentIndex);
			currIndex = parentIndex;
			parentIndex = (currIndex-1)/2;
			
		}
		else{
			break;
		}
	}
}

//Used to set new weights corresponding to key
public void decrease(String key,int newWt){
	if(m.containsKey(key)){
		int pos = m.get(key);
		Node n = heapArray[pos];
		n.setWeight(newWt);
		int parentIndex = (pos-1)/2;
		while(parentIndex>=0){
			Node pNode = heapArray[parentIndex];
			Node cNode = heapArray[pos];
			if(pNode.getWeight()>cNode.getWeight()){
				heapArray = swapPositions(pNode, parentIndex, cNode, pos);
				updateMapWithPositions(pNode, pos, cNode, parentIndex);
				pos = parentIndex;
				parentIndex = (pos-1)/2;
			}else{
				break;
			}
		}
	}
}

//extractMin
public Node extractMin(){
	if(heapArray.length>0){
		Node minNode  = heapArray[0];
		m.remove(minNode.getKey());
		//Reducing the count value as well
		count--;
		//Re-size and rearrange heapArray and map as per min weight
		Node temp[] = heapArray;
		//Reduce heapArray size;
		int size = heapArray.length - 1;
		//System.out.println("length="+size);
		heapArray = new Node[size];
		System.arraycopy(temp, 1, heapArray, 0, temp.length-1);
		//Update Map with latest Array positions
		for(int i=0;i<heapArray.length;i++){
			if(heapArray[i]!=null && m.containsKey(heapArray[i].getKey())){
				m.put(heapArray[i].getKey(), i);
			}
		}
		//Re-create binary heap using heapArray
		for(int i=size/2;i>=0;i--){
			minHeap(i);
		}
		
		return minNode;
	}
	return null;
}

public Node findMin(){
	return heapArray[0];
}

//minHeap calculator
public void minHeap(int pos){
	//displayHeap();
	int l = 2*pos+1;
	int r = 2*pos+2;
	int size = heapArray.length;
	//System.out.println("\n dims="+l+" "+r+" "+size);
	int min;
	if(l<size && heapArray[pos]!=null && heapArray[l]!=null &&
			heapArray[pos].getWeight()>heapArray[l].getWeight()){
		min = l;
	}else{
		min = pos;
	}
	if(r<size && heapArray[min]!=null && heapArray[r]!=null && 
			heapArray[r].getWeight()<heapArray[min].getWeight()){
		min = r;
	}
	
	if(min!=pos){
		heapArray = swapPositions(heapArray[pos], pos, heapArray[min], min);
		updateMapWithPositions(heapArray[min], min, heapArray[pos], pos);
		//heapArray = swapPositions(heapArray[pos], pos, heapArray[min], min);
		minHeap(pos);
	}
}
//Swap node positions in array
public Node[] swapPositions(Node parentNode, int parentIndex, Node currentNode, int currentIndex){
	Node tempNode = parentNode;
	heapArray[parentIndex] = currentNode;
	heapArray[currentIndex] = tempNode;
	return heapArray;
}

//Update key positions in map
public void updateMapWithPositions(Node parentNode, int newParentIndex, Node currentNode, int newCurrentIndex){
	//System.out.println("1="+parentNode.getKey()+" 2="+newParentIndex+" 3="+currentNode.getKey()+" 4="+newCurrentIndex);
	m.put(parentNode.getKey(), newParentIndex);
	m.put(currentNode.getKey(), newCurrentIndex);
	//System.out.println("now");displayMap();
}

public void displayHeap(){
	System.out.println("\nHeap Display:");
	for(int i=0;i<heapArray.length;i++){
		Node n = heapArray[i];
		if(n!=null){
		System.out.print(" "+n.getKey()+"["+n.getWeight()+"]");
		}
	}
}
public void displayMap(){
	System.out.println("\nMap Display:");
	System.out.println(m);
}

public boolean isMapEmpty(){
	if(m.isEmpty()){
		return true;
	}else{
		return false;
	}
}
public static void main(String args[]){
	BinaryHeapMapDS heap = new BinaryHeapMapDS();
	heap.add(1, "B");
    heap.add(3, "A");
    heap.add(1, "D");
    heap.add(5, "E");
    heap.add(4, "F");
  //  heap.add(6, "NTF");
 //   heap.add(2,"AFR");
    
 //   heap.decrease("Pramila",1);
    //heap.displayMap();
   // heap.extractMin();
   // heap.extractMin();
    Node n = heap.extractMin();
    if(n!=null){
    	System.out.println("\nExtracted Min = "+n.getKey()+"["+n.getWeight()+"]");
    	//System.out.println("\nExtracted Min = "+n);
    }
    //heap.decrease("NTF",1);
    //heap.add(21,"SIN");
    heap.displayHeap();
    heap.displayMap();
}
}
