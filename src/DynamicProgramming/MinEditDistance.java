package DynamicProgramming;

public class MinEditDistance {
	
	public static int minEditDistanceRecur(String s1, String s2, int m,int n){
		if(m == 0) return n;
		if(n == 0) return m;
		
		if(s1.charAt(m) == s2.charAt(n)){
			return minEditDistanceRecur(s1, s2, m-1, n-1);
		}
		else{
			int min = 1 + 
					Math.min(minEditDistanceRecur(s1, s2, m, n-1), 
							Math.min(minEditDistanceRecur(s1, s2, m-1, n), minEditDistanceRecur(s1, s2, m-1, n-1)));
			return min;
		}
	}
	public static void minEditDistanceDP(String s1, String s2){
		int T[][] = new int[s1.length()+1][s2.length()+1];
		
		for(int i=0;i<T.length;i++){
			T[i][0] = i;
		}
		
		for(int i=0;i<T[0].length;i++){
			T[0][i] = i;
		}
		
		for(int i=1;i<T.length;i++){
			for(int j=1;j<T[0].length;j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					T[i][j] = T[i-1][j-1];
				}else{
					T[i][j] = 1 + Math.min(T[i-1][j-1], Math.min(T[i-1][j],T[i][j-1]));
				}
			}
		}
		
		System.out.println("Min Edits needed = "+T[s1.length()][s2.length()]);
		
		//Determining Edit pattern
		int edits = T[s1.length()][s2.length()];
		int i = s1.length();
		int j = s2.length();
		while(edits>0){
			int curr = T[i][j];
			//Diagonal + 1
			if(T[i-1][j-1]+1 == curr){
				if(s1.charAt(i-1) != s2.charAt(j-1)){
					System.out.println("Replace = "+s1.charAt(i-1)+" with = "+s2.charAt(j-1));
					edits--;
					i--;
					j--;
				}
			}else if(T[i][j-1]+1 == curr){
					System.out.println("Delete = "+s2.charAt(j-1));
					j--;
					edits--;
			}else if(T[i-1][j]+1 == curr){
					System.out.println("Add = "+s1.charAt(i-1));
					i--;
					edits--;
			}else if(T[i-1][j-1] == curr){
				i--;
				j--;
			}
			}
		}
		
	public static void main(String[] args) {
	
		minEditDistanceDP("geek", "gesek");
		String s1 = "azced";
		String s2 = "abcdef";
		System.out.println("Recur Edit Distance = "+minEditDistanceRecur(s1, s2,s1.length()-1 , s2.length()-1));
	}

}
