/*Longest common substring - The substring needs to be CONTINUOUS*/
package DynamicProgramming;

public class LongestCommonSubstring {

	public static void longestCommonSubString(String s1, String s2){
		int r = s1.length();
		int c = s2.length();
		int T[][] = new int[r+1][c+1];
		for(int i=0;i<T.length;i++){
			T[i][0] = 0;
		}
		for(int i=0;i<T[0].length;i++){
			T[0][i] = 0;
		}
		for(int i=1;i<T.length;i++){
			for(int j=1;j<T[0].length;j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					T[i][j] = 1+T[i-1][j-1];
				}else{
					T[i][j] = 0;
				}
			}
		}
		//to find the longest common substring -> Search the max value in 2D-array
		int max = -1, row=-1,col=-1;
		for(int i=1;i<T.length;i++){
			for(int j=1;j<T[0].length;j++){
				if(T[i][j]>max){
					max = T[i][j];
					row = i;
					col = j;
				}
			}
		}
		System.out.println("Longest Common Substring is of length = "+max);
		System.out.println("Longest common SubString is:"+row+" "+col);
		int index = row - max;
		while(max>0){
			System.out.print(" "+s1.charAt(index));
			row--;
			col--;
			index++;
			max = T[row][col];
		}
	}
	public static void main(String[] args) {
		String s1 = "zbcdf";
		String s2 = "abcdaf";
		longestCommonSubString(s1, s2);
	}

}
