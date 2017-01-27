/*
 * In this algorithm calculate hash of the pattern to be found. Now in the text - calculate rolling hash corresponding to the length of the pattern. 
 * If the hash for pattern and text portion matches then we compare each character. Else we move on to the next set of characters of the text.
 * To calculate hash: choose a big prime no like 101, then hash = hash + asciiForChar*(int)Math.pow(prime,i) where i = 0 to patternLength
 * To calculate rolling hash: capture ascii value for previous character and next character then 
 * oldHash = (oldHash - asciiForPreviousChar)/prime
 * newHash = oldHash + asciiForNewChar*(int)Math.pow(prime,patternLength-1) 
 */
package stringpattern;

import java.util.ArrayList;

public class RobinKarpAlgo {

	int prime = 101;
	public int patternMatch(String text, String pattern){
		int tLen = text.length();
		int pLen = pattern.length();
		char[] t = text.toCharArray();
		char[] p = pattern.toCharArray();
		int pHash = createHash(pattern);
		int tHash = 0;
		for(int i=0;i<(tLen-pLen)+1;i++){
			//If hash for input has not been calculated then calculate the value else recalculate hash
			if(tHash==0){
				String sString = text.substring(i,i+pLen);
				tHash = createHash(sString);
			}else{
				int oldValueAscii = (int)text.charAt(i-1);
				int newValAscii = (int)text.charAt(i+pLen-1);
				tHash = recalculateHash(tHash,oldValueAscii,newValAscii,prime,pLen);
			}
			
			if(tHash == pHash && checkPattern(text,pattern,i,pLen)){
				return i;
			}
		}
		return -1;
	}
	
	public int createHash(String p){
		int pLen = p.length();
		int pHash = 0;
		for(int i=0;i<pLen;i++){
			int ascii = (int)p.charAt(i);
			pHash = pHash+ ascii*(int)Math.pow(prime,i);
		}
		return pHash;
	}
	
	public int recalculateHash(int oldHash,int oldValue,int newValue,int prime,int pLength){
		oldHash = (oldHash - oldValue)/prime;
		int newHash = oldHash + (int)(newValue*Math.pow(prime,pLength-1));
		return newHash;
	}
	
	public boolean checkPattern(String t, String p,int tIndex,int pLength){
		int i=0;
		while(pLength>0){
			if(p.charAt(i) != t.charAt(tIndex)){
				return false;
			}else{
				i++;
				tIndex++;
				pLength--;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		String text = "abcdefgh";
		String pattern = "fgh";
		RobinKarpAlgo ob = new RobinKarpAlgo();
		int index = ob.patternMatch(text, pattern);
		if(index!= -1){
			System.out.println("Pattern found at index = "+index);
		}else{
			System.out.println("Pattern not found");
		}
		
	}
}
