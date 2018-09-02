 package geekforgeeks;

import java.util.Stack;

public class SortStack {

	public static Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		int temp=-1;
		if(s.isEmpty()){
		    return s;
		}
		if(!s.isEmpty()){
		    temp = s.pop();
		    sort(s);
		}
		return sortStack(s, temp);
	}
	
	public static Stack<Integer> sortStack(Stack<Integer> s, int temp){
	    if(s.isEmpty() || s.peek()<=temp){
	        s.push(temp);
	    }else if(s.peek()>temp){
	        int temp1 = s.pop();
	        sortStack(s,temp);
	        s.push(temp1);
	    }
	    return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		s.push(11);
		s.push(2);
		s.push(32);
		s.push(3);
		s.push(41);
		
		s = sort(s);
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}

}
