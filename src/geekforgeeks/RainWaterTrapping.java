/*
 * Given an array having only positive integers. Each element of array denotes height of tower having width 1.
 * Calculate the amount of rain water that gets trapped
 */
package geekforgeeks;

import java.util.Stack;

public class RainWaterTrapping {
/*
 * Primary logic for this problem:
 * for any tower x: find left_max_tower and right_max_tower
 * water stored on each tower = min(left_max_tower,right_max_tower) - height of tower x
 * sum all these values to get required value
 */
	//Method 1: Using stacks
	public void waterTrappedUsingStack(int ht[]){
		Stack<Integer> s = new Stack<Integer>(); //Stack will hold the index for each tower
		int ans = 0;
		for(int i=0;i<ht.length;i++){
			while(!s.empty() && ht[i]>ht[s.peek()]){
				//If the current tower height is greater than height of tower at top of stack, then there is a possibility of storing water on stak top tower
				int t = s.pop();
				int d = i-s.peek()-1; //Distance between current tower and previous high tower
				int bd = Math.min(ht[i]/*Current height*/, ht[s.peek()]) - ht[t]; // This calculates the min. tower height between current and stack top. This will be boundary height
				ans = ans+d*bd;
			}
			s.push(i);
		}
		System.out.println("Method 1 (Stack Based): Units of water trapped = "+ans);
	}
	
	/*
	 * Method 2: In this method, we traverse from start and end of array, and then apply the primary logic
	 */
	public void waterTrappedWithoutStack(int ht[]){
		int left = 0;
		int right = ht.length-1;
		int ans = 0;
		int leftMax=0, rightMax = 0;
		while(left<right){
			if(ht[left]>ht[right]){
				if(ht[right]>rightMax){
					rightMax = ht[right];
				}else{
					ans = ans+rightMax-ht[right]; //Calculates the units of water that can be stored on the current tower with reference to max ht right tower
				}
				right--;
			} else {
				if (ht[left] > leftMax) {
					leftMax = ht[left];
				} else {
					ans = ans + leftMax - ht[left]; // Calculates the units of
														// water that can be
														// stored on the current
														// tower with reference
														// to max ht left tower
				}
				left++;
			}
		}
		System.out.println("Method 2: Units of water trapped = "+ans);
	}
	public static void main(String args[]){
		RainWaterTrapping r = new RainWaterTrapping();
		int a[] = {9,1,4,0,2,8,6,3,5};
		r.waterTrappedUsingStack(a);
		r.waterTrappedWithoutStack(a);
	}
}
