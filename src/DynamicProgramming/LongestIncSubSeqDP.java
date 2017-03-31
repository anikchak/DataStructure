package DynamicProgramming;

public class LongestIncSubSeqDP {
	
	public static void longestIncSubSequence(int arr[]){
		int lenArr[] = new int[arr.length];
		int result[] = new int[arr.length];
		for(int i=0;i<lenArr.length;i++){
			lenArr[i] = 1;
			result[i] = i;
		}
		
		int j=0,i=1;
		while(i<arr.length){
			if(i==j){
				j=0;
				i++;
			}else{
				if(arr[j]<arr[i]){
					if(lenArr[i]<lenArr[j]+1){
						lenArr[i] = lenArr[j]+1;
						result[i] = j;
					}
				}
				j++;
			}
		}
		int maxlen = 0;
		int pos = -1;
		for(int a=0;a<lenArr.length;a++){
			//System.out.print(a+" ");
			if(lenArr[a]>maxlen){
				maxlen = lenArr[a];
				pos = a;
			}
		}
		System.out.println("Longest Increasing Subsequence length = "+maxlen);
		
		//Fetching the longest increasing substring
		int count =0;
		System.out.println("Elements in Reverse order = ");
		while(count<maxlen){
			int element = arr[pos];
			System.out.print(element+" ");
			pos = result[pos];
			count++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,4,-1,0,6,2,3};
		longestIncSubSequence(arr);
	}

}
