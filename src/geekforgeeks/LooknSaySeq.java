/*
 * Find the n’th term in Look-and-say (Or Count and Say) Sequence. The look-and-say sequence is the sequence of below integers:
*  1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, …
 */
package geekforgeeks;

import java.util.ArrayList;

public class LooknSaySeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nthTerm = 8;
		ArrayList<String> al = new ArrayList<String>();
		al.add("1");
		al.add("11");
		if(nthTerm<=2){
			System.out.println(al.get(nthTerm-1));
			return;
		}
		for(int i=2;i<nthTerm;i++){
			String s = al.get(i-1);
			int count = 1;
			StringBuffer newString = new StringBuffer("");
			int j;
			for(j=1;j<s.length();j++){
				if(s.charAt(j-1) == s.charAt(j)){
					count++;
				}else{
					newString = newString.append(count).append(s.charAt(j-1));
					count =1;
				}
			}
			newString = newString.append(count).append(s.charAt(j-1));
			al.add(newString.toString());
		}
		System.out.println(al);
		System.out.println("nthTerm = "+al.get(nthTerm-1));
	}

}
