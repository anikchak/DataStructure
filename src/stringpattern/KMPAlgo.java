package stringpattern;

public class KMPAlgo {
	public int kmpAlgo(String text, String pat){
		char t[] = text.toCharArray();
		char p[] = pat.toCharArray();
		int prefixArray[] = generatePrefixArr(p);
		int i=0,j=0;
		//Matching the text characters with pattern characters
		while(i < t.length){
			if(t[i] == p[j]){
				j++;
				i++;
				if(j==p.length){
					return i-j;
				}
			}else{
				if(j-1 < 0){
					i++; j=0;
				}else{
					j = prefixArray[j-1];
				}
			}
		}
		return -1;
	}
	
	public int[] generatePrefixArr(char p[]){
		int i=1,j=0,k=1;
		int pre[] = new int[p.length];
		//Initializing prefix array
		for(int index=0;index<pre.length;index++){
			pre[index] = 0;
		}
		int pLen = p.length;
		
		while(j<pLen && i<pLen){
			if(p[j]==p[i]){
				pre[k] = j+1;
				k++;i++;j++;
			}else{
				if((j-1)<=0){
					pre[k] = 0;
					k++;i++;j=0;
				}else{
					j = pre[j-1];
				}
			}
		}
		return pre;
	}
	
	public static void main(String []args){
		//String text = "abxabcabcaby";
		String text = "aabaabaaabbaaabababababaaaaab";
		//String pattern = "abcaby";
		String pattern = "baba";
		
		KMPAlgo ob = new KMPAlgo();
		int retVal = ob.kmpAlgo(text, pattern);
		if(retVal!= -1){
			System.out.println("Pattern found at location = "+retVal);
		}else{
			System.out.println("Pattern not found");
		}
	}
}
