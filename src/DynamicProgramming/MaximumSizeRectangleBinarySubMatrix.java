/*
 * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.

Input :   0 1 1 0
          1 1 1 1
          1 1 1 1
          1 1 0 0

Output :  1 1 1 1
          1 1 1 1
          or max output
Approach:
Create an aux. array having all the row values and calculate the max histogram value . This will give the area of that region
Once done; move to next row, the row will be modified as: if a[i][j]=0, then T[i][j]=0. Else, add up T[i][j] = T[i-1][j]+1         
 */
package DynamicProgramming;

import java.util.Stack;

public class MaximumSizeRectangleBinarySubMatrix {
	
	public int computeMaxHistogramArea(int a[]){
		Stack<Integer> s = new Stack<Integer>();
		int currArea = 0, maxArea = 0,i=0;
		for(i=0;i<a.length;i++){
			if(s.isEmpty() || a[s.peek()]<=a[i]){
				s.push(i);
			}
			else{
				while(!s.isEmpty() && a[s.peek()]>a[i]){
					int top = s.pop();
					if(s.isEmpty()){
						currArea = a[top]*i;
					}else{
						currArea = a[top]*(i-s.peek()-1);
					}
					if(currArea>maxArea){
						maxArea = currArea;
					}
				}
				s.push(i);
			}
		}
		while(!s.isEmpty()){
			int top = s.pop();
			if(s.isEmpty()){
				currArea = a[top]*i;
			}else{
				currArea = a[top]*(i-s.peek()-1);
			}
			if(currArea>maxArea){
				maxArea = currArea;
			}
		}
		System.out.println("Histogram Max Area = "+maxArea);
		return maxArea;
	}
	public static void main(String[] args) {
		int arr[][] = {
				  {0, 1, 1, 0},
		          {1, 1, 1, 1},
		          {1, 1, 1, 1},
		          {1, 1, 0, 0}
		};
		int temp[] = new int[arr[0].length];
		MaximumSizeRectangleBinarySubMatrix m = new MaximumSizeRectangleBinarySubMatrix();
		//aux array to store each row value
		int maxArea = 0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				if(arr[i][j]==0){
					temp[j] = 0;
				}else{
					temp[j] = temp[j]+arr[i][j];
				}
			}
			int result = m.computeMaxHistogramArea(temp);
			maxArea = Math.max(result, maxArea);
		}
		System.out.println("Max Size Rectangle Binary Sub Matrix Area = "+maxArea);
	}

}
