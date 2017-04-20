/*
 * CASE 1:
 * ======
 * Given an array where every element occurs three times, except one element which occurs only once. 
 * Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.
 * Case 2:
 * ======
 * If in a given array every element was repeated twice except for one element which occurs only once . Then to find the non repeating element
 * perform XOR of all array elements.
 * 
 */
package geekforgeeks;

public class ElementOnceInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,2,2,1,4,4,4};
		int ones = 0,twos = 0, threes = 0;
		for(int i=0;i<a.length;i++){
			twos = twos |(ones & a[i]);
			ones = ones^a[i];
			threes = ~(ones&twos);
			ones = ones&threes;
			twos = twos&threes;
		}
		System.out.println(ones);
	}

}
