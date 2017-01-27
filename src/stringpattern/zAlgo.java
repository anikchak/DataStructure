package stringpattern;

import java.util.ArrayList;
import java.util.List;

public class zAlgo {

	public int[] calculateZArray(String str){
		char a[] = str.toCharArray();
		int z[] = new int[a.length];
		int l = 0,r = 0;
		
		for(int i=1;i<a.length;i++){
			if(i>r){
				l=r=i;
				while(r<a.length && a[r]==a[r-l]){
					r++;
				}
				z[i] = r-l;
				r--;
			}else{
				int k = i-l;
				if(z[k] < r-i+1 ){
					z[i] = z[k];
				}else{
					l = i;
					while(r<a.length && a[r]==a[r-l]){
						r++;
					}
					z[i] = r-l;
					r--;
				}
			}
		}
		return z;
	}
	
	public List<Integer> zAlgo(String str,String pat){
		
		String zStr = pat+"$"+str;
		int z[] = calculateZArray(zStr);
		List<Integer> result = new ArrayList<Integer>();
		int pLen = pat.length();
		for(int i=0;i<z.length;i++){
			if(z[i]==pLen){
				result.add(i-(pLen+1));
			}
		}
		return result;
	}
	public static void main(String []args){
		zAlgo o = new zAlgo();
		String s = "abaxabab";
		String pat = "axa";
		System.out.println("Pattern is found at locations=");
		for(Integer i:o.zAlgo(s, pat)){
			System.out.print(" "+i);
		}
	}
}
