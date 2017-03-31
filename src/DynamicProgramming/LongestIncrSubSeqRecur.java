package DynamicProgramming;

public class LongestIncrSubSeqRecur {
	
	
	public static int longestIncreasingSubSuquence(int arr[], int pos,int lastNum){
		if(pos == arr.length){
			return 0;
		}
		int len1=0;
		int len2=0;
		
		if(arr[pos]>lastNum){
			len1 = 1+longestIncreasingSubSuquence(arr, pos+1, arr[pos]);
		}
		len2 = longestIncreasingSubSuquence(arr, pos+1, lastNum);
		int maxLen =  Math.max(len1, len2);
		return maxLen;
	}
	
	public static void main(String args[]){
		int arr[] = {3,4,-1,0,6,2,3};
		
		int maxLen = 0;
		for(int i=0;i<arr.length-1;i++){
		int len = longestIncreasingSubSuquence(arr, i+1, arr[i]);
		if(maxLen<len){
			maxLen = len;
		}
		}
		System.out.println("Longest Length = "+(maxLen+1));
	}

}
