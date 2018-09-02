package geekforgeeks;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostFix {
	
	public static String infixToPostfix(String exp){
		//Declaring precedence
		HashMap<Character,Integer> precedence = new HashMap<Character, Integer>();
		precedence.put('*', 3);
		precedence.put('/', 3);
		precedence.put('+', 2);
		precedence.put('-', 2);
		precedence.put('(', 1);
		precedence.put(')', 1);
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<Character>();
		for(int i=0;i<exp.length();i++){
			char ch = exp.charAt(i);
			if(ch == ' '){
				
			}
			else if(precedence.containsKey(ch)){
				if(ch == '('){
					s.push(ch);
				}else if( ch == ')'){
					char op = s.pop();
					while(op != '('){
						sb.append(op);
						//System.out.println(s);
						op = s.pop();
					}
				}else{
					/*Check if the incoming operator has lesser precedence than the stack.top operator
					 *  if so, then pop out operators which have higher and equal precedence
					 *  else, simply push
					 */
					if(!s.isEmpty()){
					//int opPrecedence = precedence.get(s.peek());
					int currentOpPreced = precedence.get(ch);
					while(!s.isEmpty() && currentOpPreced <= precedence.get(s.peek())){
						//char op = s.pop();
						//opPrecedence = precedence.get(ch);
						sb.append(s.pop());
						//System.out.println("stack="+s);
					}
					}
					s.push(ch);
				}
			}else{
				sb.append(ch);
			}
		}
		while(!s.isEmpty()){
			sb.append(s.pop());
		}
		
		System.out.println("Infix= "+exp+"\nPostfix= "+sb.toString());
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		infixToPostfix("(a+b+c+d)");
		infixToPostfix("(a+b*c+d)");
		infixToPostfix("a+(b*c)");
		infixToPostfix("a*(b+c)*d");
		infixToPostfix("(a+b)*(c+d)");
		infixToPostfix("a+b+c+d");
		infixToPostfix("(A + B) * C - (D - E) * (F + G)");
	}

}
