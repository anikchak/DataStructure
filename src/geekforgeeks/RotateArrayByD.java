package geekforgeeks;

public class RotateArrayByD {

	public static int gcd(int a, int b){
		if(b==0){
			return a;
		}
		return gcd(b, a%b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6,7,8,9,10,11,12};
			//{1, 2, 3, 4, 5, 6, 7,8}; 
			//{1,2,3,4,5,6,7,8,9,10,11,12};
		int d = 3;
		int len = a.length;
		int gcd = gcd(a.length,d);
		//int k=0;
		for(int i=0;i<gcd;i++){
			int temp = a[i];
			int j = i;
			while(true){
				int k = j+d;
				if(k>=len){
					k = k-len;
				}
				if(k==i){
					break;
				}
				a[j] = a[k];
				j = k;
			}
			a[j] = temp;
		}
		System.out.println("Rotated Array = ");
		for(int i:a){
			System.out.print(i+" ");
		}
		
	}

}
