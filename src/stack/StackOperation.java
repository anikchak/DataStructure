package stack;

public class StackOperation<T> {

	StackStrc<T> startNode = null;
	
	public void push(T data){
		if(startNode == null){
			startNode = new StackStrc<T>(data);
		}else{
			StackStrc<T> nextNode = startNode.getNextElement();
			StackStrc<T> currNode = startNode; 
			while(nextNode != null){
				currNode = nextNode;
				nextNode = nextNode.getNextElement();
			}
			StackStrc<T> newNode = new StackStrc<T>(data);
			currNode.setNextElement(newNode);
			newNode.setPrevElement(currNode);
		}
	}
	
	public StackStrc<T> pop(){
		if(startNode == null){
		//	System.out.println("Stack is empty");
			return null;
		}else{
			StackStrc<T> currNode = top();
			StackStrc<T> prevNode = currNode.getPrevElement();
	//		System.out.println("Poping = "+currNode.getElement());
			//System.out.println("Prev="+prevNode);
			if(prevNode!=null){
				prevNode.setNextElement(null);
				//currNode = null;
			}else{
				startNode = null;
			}
			return prevNode;
		}
	 }
	
	public StackStrc<T> top(){
		if(startNode == null){
		//	System.out.println("Top: Stack is empty");
			return null;
		}else{
			StackStrc<T> nextNode = startNode.getNextElement();
			StackStrc<T> prevNode = startNode; 
			while(nextNode != null){
				prevNode = nextNode;
				nextNode = nextNode.getNextElement();
			}
			return prevNode;
		}
	}
	
	public boolean isStackEmpty(){
		if(startNode == null){
			return true;
		}else{
			return false;
		}
	}
}
