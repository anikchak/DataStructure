/*
 * GIven A abd B
 */
package geekforgeeks;

public class CountBitsFlipped {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 73;
		int b = 21;
		int count=0;
		while(a>0){
			if((a&1) != (b&1)){
				count++;
			}
			a = a>>>1;
			b = b>>>1;
		}
		System.out.println(count);
	}

}
