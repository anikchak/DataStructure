/*
 * Given an array in which all numbers except two are repeated once.. Find the 2 non-repeating numbers
 */
package geekforgeeks;

public class TwoNonRepeatingElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 4, 7, 9, 2, 4};
		int xor =0;
		for(int i=0;i<arr.length;i++){
			xor = xor^arr[i];
		}
		int rightmostSetBit = xor & ~(xor-1);
		int x=0;
		int y=0;
		for(int i=0;i<arr.length;i++){
			if((arr[i]&rightmostSetBit)>0){
				x = x^arr[i];
			}else{
				y = y^arr[i];
			}
		}
		System.out.println(x);
		System.out.println(y);
	}

}
