package geekforgeeks;

public class Bomber {

	public static void bomb(String s) {
		int len = s.length();
		int count = 1;
		char pChar;
		int charCount = 1;
		int start = 0;

		while (count < len) {
			char currChar = s.charAt(count);
			pChar = s.charAt(count - 1);
			if (currChar == pChar) {
				if (charCount == 1) {
					start = count-1;
				}// end of charCount==1 if
				//pChar = currChar;
				charCount++;
			} else {
				System.out.println("else");
				if (charCount >= 3) {
					s = s.substring(0, start)
							+ s.substring(start + charCount, s.length());
					System.out.println(s);
					len = s.length();
					count = 1;
				} 
				//else if (charCount < 3) {
					charCount = 1;
				//}// end of else if
			}// end of else
			count++;
		}// end of While
		if(charCount >= 3){
			System.out.println("Null");
			return;
		}
		System.out.println("Bomb String = " + s);
	}//end of bomb method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//bomb("abcdeeeeddcbfgf");
		bomb("aaaa");
	}

}
