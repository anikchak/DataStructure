/*
 * Given an Integer array. The element values of array denotes the number of steps which can be moved forward.
 * Problem: Find the minimum no. of steps that might be need to reach the end
 * Approach: For each element, calculate the min. number of steps it can move. 
 */
package DynamicProgramming;

public class MinJumpsToReachEnd {

	public static void minSteps(int arr[]){
		int len = arr.length;
		int steps[] = new int[len];
		int moves[] = new int[len];
		for(int i=0;i<steps.length;i++){
			steps[i] = Integer.MAX_VALUE;
			moves[i] = -1;
		}
		steps[0] = 0;
		for(int i=0;i<arr.length;i++){
			int val = arr[i];
			int index = i+1;
			while(val>0 && index<arr.length){
				int res = steps[i]+1;
		//		System.out.println("When i="+i+" res="+res);
				if(steps[index]>res){
					steps[index] = res;
					moves[index] = i;
				}
				val--;
				index++;
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(" "+steps[i]+"["+moves[i]+"]");
		}
		System.out.println("\nMin. no. of steps needed to reach the end of array = "+steps[len-1]);
		System.out.println("Moves = ");
		int pos = moves[len-1];
		while(pos != -1){
			System.out.print(" "+ arr[pos]);
			pos = moves[pos];
		}
	}
	public static void main(String[] args) {
		int arr[] = {2,3,1,1,2,4,2,0,1,1};
		minSteps(arr);
	}

}
