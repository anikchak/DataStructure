package geekforgeeks;

import java.util.HashMap;

public class Rearrange {

	public static void main(String[] args) {
		//String s = "bbbaaabacd";
		//String s = "geeksforgeeks";
		String s = "axiqenxohssbtwwwwwwwwwwwwwww";
		char ch[] = s.toCharArray();
		int maxFreq = 0;
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i=0;i<ch.length;i++){
		    if(!hm.containsKey(ch[i])){
		        int sum = 1;
		        for(int j=i+1;j<ch.length;j++){
		            if(ch[i]==ch[j]){
		                sum = sum+1;
		            }
		        }
		        hm.put(ch[i],sum);
		        if(sum>maxFreq){
		            maxFreq = sum;
		        }
		    }
		}
		System.out.println(hm);
		System.out.println(maxFreq);
		System.out.println(s.length());
		
		if(ch.length == 1){
		    System.out.println(1);
		}
		else if((ch.length%2 == 0) && (maxFreq<ch.length/2)){
		    System.out.println(1);
		}else if((ch.length%2 != 0) && (maxFreq<=(ch.length/2 + 1))){
		    System.out.println(1);
		}else{
		    System.out.println(0);
		}
	}

}
