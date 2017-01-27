package practice.bitmanipulation;

public class AddingWithinRange {

	public static void main(String[] args) {
		int n = 0B10001111100;
		int m = 0B10011;
		int i=2, j =6;
		int temp = 1;
		for(int k=0;k<(j-i);k++){
			int shift = temp<<1;
			temp = temp|shift;
		}
		System.out.println("Temp = "+Integer.toBinaryString(temp));
		int mask = ~(temp<<i);
		System.out.println("mask = "+Integer.toBinaryString(mask));
		n = n&mask;
		n = n|(m<<i);
		System.out.println("Output = "+Integer.toBinaryString(n));
	}

}
