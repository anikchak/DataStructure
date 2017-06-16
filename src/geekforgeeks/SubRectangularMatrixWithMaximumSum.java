/*
 * Solution:
 * Keep temp array with size as number of rows. Start left and right from 0
 * and keep adding values for each row and maintain them in this temp array.
 * Run Kadane's algorithm to find max sum subarray in temp. Now increment right by
 * 1. When right reaches last column reset right to 1 and left to 1.
 * 
 * Space complexity of this algorithm is O(row)
 * Time complexity of this algorithm is O(row*col*col)
 */
package geekforgeeks;

public class SubRectangularMatrixWithMaximumSum {
	
	class MaxSumNode{
		int sum = 0;
		int start=-1, end =-1;
		public MaxSumNode(int sum, int start,int end) {
			this.sum = sum;
			this.start = start;
			this.end = end;
		}
	}
	public MaxSumNode kadane(int a[]){
		int currMax = a[0], max = a[0];
		int s=0,end=0,start=0;
		MaxSumNode n = new MaxSumNode(-1, -1, -1);
		for(int i=1;i<a.length;i++){
			if((currMax+a[i])>a[i]){
				currMax = currMax+a[i];
			}else{
				s = i;
				currMax = a[i];
			}
			if(currMax>max){
				max = currMax;
				start = s;
				end = i;
				n.sum = max;
				n.start = start;
				n.end = end;
			}
		}
		return n;
	}

	public void maxSum(int a[][]){
		int leftBound=-1, rightBound=-1, topBound=-1,bottomBound=-1;
		int result = Integer.MIN_VALUE;
		int r = a.length;
		int c = a[0].length;
		int temp[] = new int[r];
		for(int leftCol = 0;leftCol<c;leftCol++){
			for(int k=0;k<r;k++){
				temp[k] = 0;
			}
			for(int rightCol = leftCol;rightCol<c;rightCol++){
				for(int k=0;k<r;k++){
					temp[k] = temp[k]+a[k][rightCol];
				}
				MaxSumNode maxSumFromKadane =  kadane(temp);
				if(maxSumFromKadane.sum>result){
					result = maxSumFromKadane.sum;
					leftBound = leftCol;
					rightBound = rightCol;
					topBound = maxSumFromKadane.start;
					bottomBound = maxSumFromKadane.end;
				}
			}
		}
		System.out.println("Max Sum = "+result+" LeftBound = "+leftBound+" RightBound = "+rightBound+" TopBound = "+topBound+" BottomBound = "+bottomBound);
	}
	public static void main(String[] args) {
		int input[][] = {
				{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
                };
		SubRectangularMatrixWithMaximumSum s = new SubRectangularMatrixWithMaximumSum();
		s.maxSum(input);
	}

}
