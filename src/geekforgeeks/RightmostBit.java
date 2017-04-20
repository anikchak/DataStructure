package geekforgeeks;

public class RightmostBit {

	public static void main(String[] args) {
		int a = 95,index=1;
		while(a!=0){
			if((a&1) == 1){
				System.out.println(index);
				break;
			}else{
				index++;
				a = a>>>1;
			}
		}
	}

}
