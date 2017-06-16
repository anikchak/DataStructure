/*
 * Find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 * Approach: Use Kadane's Algorithm
 */
package geekforgeeks;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int currMax = a[0], max = a[0];
		int s=0,end=0,start=0;
		for(int i=1;i<a.length;i++){
			if((currMax+a[i])>a[i]){
				currMax = currMax+a[i];
			}else{
				currMax = a[i];
				s=i;
			}
			System.out.println(max+" "+currMax);
			if(max<currMax){
				max = currMax;
				start = s;
				end = i;
			}
		}
		System.out.println("Max contiguous sum = "+max+" Range= <"+start+","+end+">");
	}

}
