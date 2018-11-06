/*
 * Given two integers ‘n’ and ‘m’, find all the stepping numbers in range [n, m]. 
 * A number is called stepping number if all adjacent digits have an absolute difference of 1. 321 is a Stepping Number while 421 is not.

Examples:

Input : n = 0, m = 21
Output : 0 1 2 3 4 5 6 7 8 9 10 12 21

Input : n = 10, m = 15
Output : 10, 12
 */
package geekforgeeks;

import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumbers {

	/*
	 * Approach: For each number, find its neighbor using the last digit. So there can be 2 cases
	 * case 1: 10*num + lastDigit - 1
	 * case 2: 10*num + lastDigit + 1
	 * Edge case: 
	 * If lastDigit = 0; then case 1 will give -1 and case 2 will give 1. Hence we ignore case 1
	 * If lastDigit = 9; then case 1 will give 8 and case 2 will give 10. Hence we ignore case 2
	 * Each num generated will be part of stepping number if they fall in the range provided.
	 * Steps: 
	 * 1. Iterate from 0 to 9 
	 * 2. For each i: Push i into queue
	 * 3. While q is not empty
	 * 4. pop the first element -> Check if element is in range provided then print
	 * 5. Then calculate lastDigit -> Compute neighbor and push the values i queue  
	 */
	public void steppingNumbers(int start, int end, int num){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		
		while(!q.isEmpty()){
			int stepNum = q.poll();
			//Checking if stepnum is in range
			if(stepNum>=start && stepNum<=end){
				System.out.print(stepNum+" ");
			}
			//if stepnum is out of range or equal to 0 then ignore
			if(stepNum==0 || stepNum>end) continue;
			
			int lastDigit = stepNum%10;
			int stepNumA = stepNum*10 + lastDigit - 1;
			int stepNumB = stepNum*10 + lastDigit + 1;
			
			//Check the edge cases and add proper values queue
			if(lastDigit==0){
				q.add(stepNumB);
			}else if(lastDigit==9){
				q.add(stepNumA);
			}else{
				q.add(stepNumA);
				q.add(stepNumB);
			}
		}
	}
	
	public void steppingNumbers(int start, int end){
		for(int i=0;i<=9;i++){
			steppingNumbers(start, end, i);
		}
	}
	public static void main(String[] args) {
		SteppingNumbers s = new SteppingNumbers();
		s.steppingNumbers(0, 15);
	}

}
