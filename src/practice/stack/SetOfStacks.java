package practice.stack;

import java.util.ArrayList;

public class SetOfStacks extends Stack<Integer>{
	
	ArrayList<Stack<Integer>> stackSet = new ArrayList<Stack<Integer>>();
	Stack<Integer> s = new Stack<Integer>();	
	int threshold=0;
	int capacity = 0;
	public SetOfStacks(int threshold) {
		this.threshold = threshold;
	}
	
	public void push(int data){
		Stack<Integer> lastStack = getLastStack();
		if(lastStack !=null && !isFull(lastStack, threshold)){
			lastStack.push(data);
		}else{
			lastStack = new Stack<Integer>();
			lastStack.push(data);
			stackSet.add(lastStack);
		}
	}
	
	public Integer pop(){
		int setCount = stackSet.size();
		if(setCount == 0){
			System.out.println("No stack present");
			return null;
		}
		Stack<Integer> last = stackSet.get(setCount-1);
		
		int item = last.pop();
		if(last.isEmpty()){
			stackSet.remove(setCount - 1);
		}
		return item;
	}
	public Integer popAt(int index){
		if(index > stackSet.size()-1){
			System.out.println("No element to display");
			return null;
		}
		Stack<Integer> iStack = stackSet.get(index);
		int item;
		if(iStack != null){
			item = iStack.pop();
		}else{
			return null;
		}
		
		//Rolling over logic
		if(index != stackSet.size()-1){
			Stack<Integer> temp = new Stack<Integer>();
			int noOfSetsLeft = stackSet.size() - index;
			int c =1;
			
			while(c<noOfSetsLeft){
				Stack<Integer> nextStack = stackSet.get(index+1);
				while(!nextStack.isEmpty()){
					temp.push(nextStack.pop());
				}
				iStack.push(temp.pop());
				while(!temp.isEmpty()){
					nextStack.push(temp.pop());
					}
				if(nextStack.isEmpty()){
					stackSet.remove(index+1);
					break;
				}
				index++;
				c++;
				iStack = nextStack;
			}
		}else{
			if(iStack.isEmpty()){
				stackSet.remove(index);
			}
		}
		return item;
	}
	public Stack<Integer> getLastStack(){
		int lastStackIndex = stackSet.size();
		if(lastStackIndex == 0){
			return null;
		}else{
			return stackSet.get(lastStackIndex-1);
		}
	}
	public boolean isFull(Stack<Integer> s,int threshold){
		int size = 0;
		Node n = s.top;
		while(n!=null){
			n = n.next;
			size++;
		}
		if(size<threshold){
			return false;
		}else{
			return true;
		}
	}
	public static void main(String[] args) {
		SetOfStacks ss = new SetOfStacks(2);
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.push(4);
		ss.push(5);
		ss.push(6);
		//ss.push(7);
		//ss.push(8);
		//ss.push(9);
		//ss.push(10);
		//ss.push(11);
		//ss.push(12);
		System.out.println("No of stacks = "+ss.stackSet.size());
		//System.out.println("Popped = "+ss.popAt(0));
		System.out.println("Popped = "+ss.popAt(1));
		System.out.println("Popped = "+ss.popAt(0));
		System.out.println("After: Stack Set = "+ss.stackSet.size());
		System.out.println("Popped = "+ss.pop());
		//System.out.println("Popped = "+ss.pop());
		//System.out.println("Popped = "+ss.pop());
		//System.out.println("Popped = "+ss.pop());
		
		//ss.push(7);
		//System.out.println("Popped = "+ss.pop());
		//System.out.println("Popped = "+ss.pop());
		
	}

}
