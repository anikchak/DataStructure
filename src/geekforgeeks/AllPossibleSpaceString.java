/*
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them.
 */
package geekforgeeks;

public class AllPossibleSpaceString {

	public static void allPossibleStrings(char ch[],char result[],int i, int j){
		if(i==ch.length){
			//Print
			for(int k=0;k<j;k++){
				System.out.print(result[k]);
			}
			System.out.println();
			return;
		}
		result[j] = ch[i];
		allPossibleStrings(ch,result,i+1,j+1);
		result[j] = ' ';
		result[j+1] = ch[i];
		allPossibleStrings(ch,result,i+1,j+2);
	}
	public static void main(String[] args) {
		String a = "ABCD";
		char ch[] = a.toCharArray();
		char result[] = new char[2*ch.length]; 
		result[0] = ch[0];
		allPossibleStrings(ch,result,1,1);
	}

}
