package queue;

public class QueueStrc<T> {

	T ELement=null;
	QueueStrc<T> nextNode = null;
	public T getELement() {
		return ELement;
	}
	public void setELement(T eLement) {
		ELement = eLement;
	}
	public QueueStrc<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(QueueStrc<T> nextNode) {
		this.nextNode = nextNode;
	}
}
