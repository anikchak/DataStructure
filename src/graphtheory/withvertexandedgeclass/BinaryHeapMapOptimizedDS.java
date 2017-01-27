package graphtheory.withvertexandedgeclass;

import java.util.HashMap;

public class BinaryHeapMapOptimizedDS {
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
	
	HashMap<String,Integer> keyWtMap = new HashMap<String,Integer>();
	HashMap<String,Integer> keyPosMap = new HashMap<String,Integer>();
	Node []heapArray = new Node[1];
	int count = 0;
	
	//Function to add key, wt/loc in newly create DS 
	public void add(String key, int wt){
		Node n = new Node(key,wt);
		int cIndex = 0;
		//Add the <key,wt> pair to map
		keyWtMap.put(key, wt);
		//Adding <key,wt> object to heap array
		if(heapArray.length>count){
			heapArray[count] = n;
			cIndex = count;
			count++;
		}else{
			int capacity = heapArray.length;
			capacity = capacity*2;
			Node temp[] = heapArray;
			heapArray = new Node[capacity];
			System.arraycopy(temp, 0, heapArray, 0, temp.length);
			heapArray[count] = n;
			cIndex = count;
			count++;
			temp = null;
		}
		//Add the <key,position> pair to map
		keyPosMap.put(key, cIndex);

		int parentIndex = (cIndex-1)/2;
		while(parentIndex>=0){
			Node pNode = heapArray[parentIndex];
			Node cNode = heapArray[cIndex];
			//creating binary heap using weight
			if(pNode.getWeight()>cNode.getWeight()){
				//Swap node positions in heapArray
				heapArray = swapPositions(pNode, parentIndex, cNode, cIndex);
				//update key positions in map
				updateMapWithPositions(pNode, cIndex, cNode, parentIndex);
				cIndex = parentIndex;
				parentIndex = (cIndex-1)/2;
				
			}
			else{
				break;
			}
		}
	}
	
	//Decrease weight for a particular key
	public void decrease(String key, int newWt){

		if(keyWtMap.containsKey(key)){
			keyWtMap.put(key, newWt);
			int pos = keyPosMap.get(key);
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
			keyPosMap.remove(minNode.getKey());
			keyWtMap.remove(minNode.getKey());
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
				if(heapArray[i]!=null && keyPosMap.containsKey(heapArray[i].getKey())){
					keyPosMap.put(heapArray[i].getKey(), i);
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
		keyPosMap.put(parentNode.getKey(), newParentIndex);
		keyPosMap.put(currentNode.getKey(), newCurrentIndex);
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
	public void displayLocationMap(){
		System.out.println("\nLocation Map Display:");
		System.out.println(keyPosMap);
	}
	public void displayWtMap(){
		System.out.println("\nWeight Map Display:");
		System.out.println(keyWtMap);
	}
	public boolean isLocationMapEmpty(){
		if(keyPosMap.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	public boolean isWeightMapEmpty(){
		if(keyWtMap.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public int getWeightFromWtMap(String key){
		if(keyWtMap.containsKey(key)){
			return keyWtMap.get(key);
		}
		return Integer.MAX_VALUE;
	}
	
	public boolean isKeyPresent(String key){
		return keyWtMap.containsKey(key);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryHeapMapOptimizedDS heap = new BinaryHeapMapOptimizedDS();
		heap.add("B",1);
	    heap.add("A",3);
	    heap.add("D",1);
	    heap.add("E",5);
	    heap.add("F",4);
	  //  heap.add(6, "NTF");
	 //   heap.add(2,"AFR");
	    
	    heap.decrease("E",0);
	    //heap.displayMap();
	   // heap.extractMin();
	   // heap.extractMin();
	    heap.displayHeap();
	    heap.displayLocationMap();
	    heap.displayWtMap();
	    /*
	    Node n = heap.extractMin();
	    if(n!=null){
	    	System.out.println("\nExtracted Min = "+n.getKey()+"["+n.getWeight()+"]");
	    	//System.out.println("\nExtracted Min = "+n);
	    }
	    //heap.decrease("NTF",1);
	    //heap.add(21,"SIN");
	    heap.displayHeap();
	    heap.displayLocationMap();
	    heap.displayWtMap();
*/
	}

}
