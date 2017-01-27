package practice.stack;

public class SortStack {

	public static Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> temp = new Stack<Integer>();
		int size = s.size;
		int c =1;
		while(c<size){
			int max = s.pop();
			while(!s.isEmpty()){
				if(s.top()>max){
					temp.push(max);
					max = s.pop();
				}else{
					temp.push(s.pop());
				}
			}
			s.push(max);
			while(!temp.isEmpty()){
				s.push(temp.pop());
			}
			c++;
		}
		return s;
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(4);
		stack = sortStack(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

}
