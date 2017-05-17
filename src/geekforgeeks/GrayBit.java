/*
 * Given a number n, generate bit patterns from 0 to 2^n-1 such that successive patterns differ by one bit.
 * Following is 3-bit sequence (n = 3)
 * 000 001 011 010 110 111 101 100
 */
package geekforgeeks;

public class GrayBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =3;
		int len = 1<<n;
		int a[] = new int[len];
		for(int i=0;i<len;i++){
			a[i] = (i>>1)^i;
		}
		for(int i:a){
			System.out.println(Integer.toBinaryString(i));
		}
	}

}
