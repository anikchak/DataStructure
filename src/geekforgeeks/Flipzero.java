package geekforgeeks;

public class Flipzero {

	public void flipZero(int[] arr, int m){
		int wL=0, wR=0, zC=0, prevLen=0, k=0;
		int[] result = new int[m];
		int bestResult[] = new int[m];
		while(wR<arr.length){
			if(zC < m){
				if(arr[wR] == 0){
					zC++;
					result[k] = wR;
					k++;
				}
				wR++;
			}else{
				if(arr[wR] == 0){
					if(prevLen < (wR-wL)){
						prevLen = wR - wL;
						System.arraycopy(result, 0, bestResult, 0, result.length);
					}
					//System.out.println("R[0]="+result[0]++);
					//wL++;
					wL = ++result[0];
					wR = wL;
					zC = 0; k=0;
				}else{
					wR++;
				}
			}
		}
		
		//This check is needed in case where the array ends with 1.
		if(prevLen < (wR-wL)){
			System.arraycopy(result, 0, bestResult, 0, result.length);
		}
		
		//Printing result
		System.out.println("0s to be replaced");
		for(int i:bestResult){
			System.out.print(i+" ");
		}
		//System.out.println();
		//System.out.println("PrevLen="+prevLen);
		//System.out.println("CurrLen="+(wR-wL));
		System.out.println("\nMax Sequence of 1 = "+ Math.max(prevLen,(wR-wL)));
	}
	
	public static void main(String args[]){
		int arr[] = {1,0,1,1,0,1,1,0,1,1,0,1,1,0,0};
		int m = 2;
		Flipzero z = new Flipzero();
		z.flipZero(arr, m);
	}
}
