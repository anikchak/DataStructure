package practice.stack;

public class MinStack {

	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int data){
		int min = min();
		if(min >= data ){
			minStack.push(data);
		}
		s.push(data);
	}
	
	public Integer pop(){
	int item = s.pop();
	int min = min();
	if(min == item){
		minStack.pop();
	}
	return item;
	}
	
	public Integer min(){
		if(minStack.isEmpty()){
			System.out.println("Min stack is empty");
			return Integer.MAX_VALUE;
		}else{
			return minStack.top();
		}
	}
	
	public static void main(String args[]){
		MinStack ms = new MinStack();
		ms.push(6);
		ms.push(3);
		ms.push(1);
		ms.push(0);
		System.out.println(ms.min());
		System.out.println("Popped = "+ms.pop());
		System.out.println(ms.min());
		System.out.println("Popped = "+ms.pop());
		System.out.println(ms.min());
		System.out.println("Popped = "+ms.pop());
		System.out.println(ms.min());
		System.out.println("Popped = "+ms.pop());
		System.out.println(ms.min());
	}
}
