package queue;

public class QTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,20,9,18,6,1,3};
		char arrChar[] = {'A','D','G','X','Z','U','E'};
		QueueOperation<Object> op = new QueueOperation<Object>();
		
		for(int a: arr){
			op.enqueue(a);
		}
		System.out.println("Dequeued:");
		
		for(int a: arr){
			QueueStrc<?> q= (QueueStrc<?>) op.dequeue();
			if(q!=null)
			System.out.print(q.getELement()+"->");
			else{
				System.out.println("NULL");
			}
		}
		//System.out.print("NULL\n");
		QueueStrc<?> qu= (QueueStrc<?>) op.dequeue();
		if(qu==null){
			System.out.println("Empty Q");
		}
		
		for(char a: arrChar){
			op.enqueue(a);
		}
		System.out.println("Dequeued:");
		
		for(char a: arrChar){
			QueueStrc<?> q= (QueueStrc<?>) op.dequeue();
			if(q!=null)
			System.out.print(q.getELement()+"->");
			else{
				System.out.println("NULL");
			}
		}
	//	System.out.print("NULL\n");
		//op.dequeue();
		
	}

}
