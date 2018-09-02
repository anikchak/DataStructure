package geekforgeeks;

public class DecodeDigitSequence {

	/*
	 * This method will calculate sequence from left to right that is moving from 0 to n
	 */
	public void decodeSequenceLeftToRight(int digits[]){
		decodeSequenceLeftToRight(digits,"",0);
	}
	public void decodeSequenceLeftToRight(int d[],String dSeq,int index){
		
		if(d.length == index ){
			System.out.println(dSeq);
			return;
		}
		if(d[index] > 0){
			char s = (char)(d[index]-1+'A');
			decodeSequenceLeftToRight(d, dSeq+s, index+1);
		}
		//System.out.println(index+" "+dSeq);
		if((index+1 < d.length)&&(d[index]<2 || ( d[index]==2 && d[index+1]<7))){
			int val = (d[index]*10)+d[index+1];
			char s = (char)(val-1+'A');
			decodeSequenceLeftToRight(d, dSeq+s, index+2);
		}
	}
	/*
	 * This method will calculate sequence from right to left that is moving from n to 0
	 */
	public void decodeSequenceRightToLeft(int digits[]){
		decodeSequenceRightToLeft(digits,"",digits.length-1);
	}
	public void decodeSequenceRightToLeft(int d[],String dSeq,int index){
		//System.out.println(index);
		if(-1 == index ){
			System.out.println(dSeq);
			return;
		}
		if(d[index] > 0){
			char s = (char)(d[index]-1+'A');
			decodeSequenceRightToLeft(d, s+dSeq, index-1);
		}
		//System.out.println(index+" "+dSeq);
		if((index-1 >= 0)&&(d[index-1]<2 || ( d[index-1]==2 && d[index]<7))){
			int val = (d[index-1]*10)+d[index];
			char s = (char)(val-1+'A');
			decodeSequenceRightToLeft(d, s+dSeq, index-2);
		}
	}
	public static void main(String[] args) {
			DecodeDigitSequence ds = new DecodeDigitSequence();
			int d[] = {1,2,0,3};
			System.out.println("Decode(Recursion): Left to Right");
			ds.decodeSequenceLeftToRight(d);
			System.out.println("Decode(Recursion): Right to Left");
			ds.decodeSequenceRightToLeft(d);
	  }
	}

