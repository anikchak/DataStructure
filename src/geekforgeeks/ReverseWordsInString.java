/*
 * Reverse words in a given string
Example: Let the input string be “i like this program very much”. The function should change the string to “much very program this like i”
 */
package geekforgeeks;

public class ReverseWordsInString {

	public void reverseString(String s){
		char ch[] = s.toCharArray();
		int start=0;
		for(int i=0;i<ch.length;i++){
			if(ch[i]!=' '){
				//System.out.println(i);
				start = i;
				i++;
				while(i<ch.length && ch[i]!= ' '){
					i++;
				}
				ch = reverseWord(ch,start,i-1);
			}
			}
//		for(char c: ch){
//			System.out.print(c);
//		}
		//Printing the reversed String
		System.out.println();
		System.out.print("Reversed word in string =");
		for(int i=ch.length-1;i>=0;i--){
			System.out.print(ch[i]);
		}
		System.out.println("END");
		}
	
	public char[] reverseWord(char[] ch, int s, int e){
		if(s==e){
			return ch;
		}else{
			//System.out.println(s);
			int m = (s+e)/2;
			for(int i=s;i<=m;i++){
				char temp = ch[i];
				ch[i] = ch[e];
				ch[e] = temp;
				e--;
			}
			return ch;
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  I like this program very much";
		//s = "like";
		ReverseWordsInString r = new ReverseWordsInString();
		System.out.println("Actual String = "+s);
		r.reverseString(s);
	}

}
