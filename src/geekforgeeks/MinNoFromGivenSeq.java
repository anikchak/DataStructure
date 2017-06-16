/*
 * Given a pattern containing only I’s and D’s. 
 * I for increasing and D for decreasing. Devise an algorithm to print the minimum number 
 * following that pattern. Digits from 1-9 and digits can’t repeat.

Examples:

   Input: D        Output: 21
   Input: I        Output: 12
   Input: DD       Output: 321
   Input: II       Output: 123
   Input: DIDI     Output: 21435
   Input: IIDDD    Output: 126543
   Input: DDIDDIID Output: 321654798 
   Approach:
   1. Iterate for str.length()+1 times
   2. for each iteration; keeping adding (i+1)th element into the stack
   3. Check if i==str.length() or str.charAt(i)==I, then empty the stack and print all the integer elements 
 */
package geekforgeeks;

import java.util.Stack;

public class MinNoFromGivenSeq {

	public void formNumber(String str){
		Stack<Integer> s = new Stack<Integer>();
		StringBuffer result  = new StringBuffer(); 
		for(int i=0;i<=str.length();i++){
			s.add(i+1);
			//check if the string char is I or i==str.length()
			if(i==str.length() || str.charAt(i)=='I'){
				//pop all the elements from stack
				while(!s.isEmpty()){
					result = result.append(s.pop().toString());
				}
			}
		}
		System.out.println("Result = "+result.toString());
	}
	public static void main(String[] args) {
		MinNoFromGivenSeq m = new MinNoFromGivenSeq();
		m.formNumber("I");
		m.formNumber("D");
		m.formNumber("DD");
		m.formNumber("II");
		m.formNumber("DIDI");
		m.formNumber("IIDDD");
		m.formNumber("DDIDDIID");
	}

}
