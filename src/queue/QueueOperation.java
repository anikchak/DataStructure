package queue;

public class QueueOperation<T> {
	QueueStrc<T> startElement = null;

	public void enqueue(T passedElement) {
		if (startElement == null) {
			//System.out.println("Q is empty. Hence creating new node");
			startElement = new QueueStrc<T>();
			startElement.setELement(passedElement);
			startElement.setNextNode(null);
		} else {
			QueueStrc<T> newNode = startElement;
			while (true) {
				if (newNode.getNextNode() == null) {
					QueueStrc<T> currNode = new QueueStrc<T>();
					currNode.setELement(passedElement);
					currNode.setNextNode(null);
					newNode.setNextNode(currNode);
					break;
				} else {
					newNode = newNode.getNextNode();
				}
			}
			//System.out.println("New node inserted");
		}
	}
	
	public T dequeue(){
		QueueStrc<T> deQueuedNode = null;;
		if(startElement!=null){
			deQueuedNode = startElement;
			startElement = startElement.getNextNode();
		}
		else{
			deQueuedNode = null;
		}
		return (T) deQueuedNode;
	}
	
	public boolean isQueueEmpty(){
		if(startElement==null){
			System.out.println("Queue is empty");
			return true;
		}else{
			return false;
		}
	}
}
