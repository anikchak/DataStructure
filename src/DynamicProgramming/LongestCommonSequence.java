package DynamicProgramming;

public class LongestCommonSequence {
	
	public static void LCS(String x,String y){
		int xLen = x.length();
		int yLen = y.length();
		int t[][] = new int[xLen+1][yLen+1];
		for(int i=0;i<=xLen;i++){
			t[i][0] = 0;
		}
		for(int i=0;i<=yLen;i++){
			t[0][i] = 0;
		}
		
		for(int i=1;i<t.length;i++){
			for(int j=1;j<t[0].length;j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					t[i][j] = 1+t[i-1][j-1];
				}else{
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}
		
		int maxLen = t[xLen][yLen];
		System.out.println("Longest Common SubSequence is of length = "+maxLen);
		
		//For longest common subsequence
		char result[] = new char[maxLen];
		int len = maxLen, val = maxLen;
		int i = xLen, j = yLen;
		while(0<=len-1){
			if(Math.max(t[i-1][j], t[i][j-1]) == val){
				if(t[i-1][j] == val){
					i--;
				}else if(t[i][j-1] == val){
					j--;
				}
			}else if((t[i-1][j-1]+1) == val){
				result[len-1] = x.charAt(i-1);
				val = t[i-1][j-1];
				i--;
				j--;
				len--;
			}
		}
		System.out.print("Sequence = ");
		for(char c: result){
			System.out.print(c);
		}
		/*
		System.out.println();
		for(int iLoop=0;iLoop<t.length;iLoop++){
			for(int jLoop=0;jLoop<t[0].length;jLoop++){
				System.out.print(t[iLoop][jLoop]+" ");
			}
			System.out.println();
		}
		*/
	}

	public static void main(String[] args) {
	
		String x = "AGGTAB";
		String y = "GXTXAYB";
		LCS(x,y	);
		
	}

}
