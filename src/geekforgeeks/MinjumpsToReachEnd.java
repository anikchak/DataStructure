/*
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element. 
 * Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). 
 * If an element is 0, then cannot move through that element.

Example:

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9)
First element is 1, so can 
 */
package geekforgeeks;

import java.util.Stack;

public class MinjumpsToReachEnd {

	public static void main(String[] args) {
		int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int jumps[] = new int[a.length];
		int moves[] = new int[a.length];
		jumps[0] = 0;
		for(int i=1;i<jumps.length;i++){
			jumps[i] = Integer.MAX_VALUE;
		}
		moves[0] = -1;
		//DP approach
		for(int i=1;i<a.length;i++){
			for(int j=0;j<i;j++){
				if((j+a[j])>= i){
					int minSteps = 1+jumps[j];
					if(minSteps<jumps[i]){
						jumps[i] = minSteps;
						moves[i] = j;
					}
				}
			}
		}
		int n = jumps.length;
		System.out.println("Min no. of steps needed = "+jumps[n-1]);
		System.out.println("Moves = ");
		int c=0;
		int step = n-1;
		Stack<Integer> s = new Stack<Integer>();
		while(c<=jumps[n-1]){
			s.push(a[step]);
			step = moves[step];
			c++;
		}
		while(!s.isEmpty()){
			System.out.print(s.pop()+"->");
		}
		System.out.println("Done");
	}

}
