package graphtheory.withoutusinginbuildLinkedList;

public class Queue {
	
	Object q[] = null;
	int top = -1,head = 0;
	Queue(int capacity){
		q = new Object[capacity];
	}
	public void enqueue(Object data){
		if(isQFull()){
			System.out.println("Q is full.");
			return;
		}else{
			q[++top] = data; 
		}
	}
	public Object dequeue(){
		if(isQEmpty()){
			return null;
		}else{
			Object retVal = q[0];
			Object temp[] = q;
			System.arraycopy(temp, 1, q, 0, temp.length-1);
			top--;
			temp = null;
			return retVal;
		}
		
	}
	public boolean isQFull(){
		if(top<q.length-1){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isQEmpty(){
		if(top==-1){
			System.out.println("Q is empty");
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue qObj = new Queue(5);
		for(int i=0;i<5;i++){
			qObj.enqueue(i);
		}
		System.out.println("DeQueued explicit= "+(Integer)qObj.dequeue());
		System.out.println("DeQueued explicit= "+(Integer)qObj.dequeue());
		qObj.enqueue(10);
		
		
		for(int i=0;i<5;i++){
			Integer qVal = (Integer)qObj.dequeue(); 
			if(qVal != null){
			System.out.println("DeQueued = "+qVal);
			}
		}
		
		qObj.dequeue();
		qObj.dequeue();
	}

}
