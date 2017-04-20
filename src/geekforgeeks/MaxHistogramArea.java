/*
 * Given an array whose elements represents histogram height of unit width.
 * Problem: Find the max hitogram area
 * Approach: Use a stack to keep track of the area. 
 */
package geekforgeeks;

import java.util.Stack;

public class MaxHistogramArea {

	public static void findMaxArea(int arr[]){
		Stack<Integer> s = new Stack<Integer>();
		int area = 0; int maxArea = -1, i=0;
		for(i=0;i<arr.length;i++){
			//If the stack is empty or the element value of stack top is lesser than current element value; then add the array index to stack
			if(s.isEmpty() || (arr[s.peek()]<=arr[i])){
				s.push(i);
			}else{
				//Pop the stack till either stack is empty or stack top element is greater than current element value. Calculate area accordingly
				while(!s.isEmpty() && arr[s.peek()]>arr[i]){
					int top = s.pop();
					if(s.isEmpty()){
						area = arr[top]*i;
					}else{
						area = arr[top]*(i-s.peek()-1);
					}
					if(area>maxArea){
						maxArea = area;
					}
				}
				s.push(i);
			}
		}
		while(!s.isEmpty()){
			int top = s.pop();
			if(s.isEmpty()){
				area = arr[top]*i;
			}else{
				area = arr[top]*(i-s.peek()-1);
			}
			if(area>maxArea){
				maxArea = area;
			}
		}
		System.out.println("Max Area = "+maxArea);
	}
	public static void main(String[] args) {
		int arr[] = {2,1,2,3,1};
		findMaxArea(arr);
	}

}
