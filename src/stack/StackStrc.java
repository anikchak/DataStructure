package stack;

public class StackStrc<T> {

	private T element = null;
	StackStrc<T> nextElement = null;
	StackStrc<T> prevElement = null;
	public StackStrc<T> getPrevElement() {
		return prevElement;
	}

	public void setPrevElement(StackStrc<T> prevElement) {
		this.prevElement = prevElement;
	}

	StackStrc(T data){
		this.element = data;
		this.nextElement = null;
		this.prevElement  = null;
	}
	
	public StackStrc<T> getNextElement() {
		return nextElement;
	}
	public void setNextElement(StackStrc<T> nextElement) {
		this.nextElement = nextElement;
	}
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	
}
