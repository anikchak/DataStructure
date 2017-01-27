package hackerearth;
import java.lang.Exception;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class optimusPrime {
    public static void main(String args[] ) throws Exception {
    try {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line=null;
			
				line = br.readLine();
			
	        int T = Integer.parseInt(line);

if(T==0){
	System.exit(0);
}
	        //Scanner
	        for(int i=0;i<T;i++){
	        Scanner s = new Scanner(System.in);
	        int N = s.nextInt();
	        findOptimus(N);
	}
    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	} catch (Exception e){
		e.printStackTrace();
	}
			
		
	}
	public static void findOptimus(int n){
		int max = (int)Math.pow(10, 18);
			
		for(int i=1; i<= max;i++){
			if(!isPrime(i)){
			// Calculate sum of Prime factors for each no.
			int primePowerCount = calculateSumOfPrimeFactors(i);
			int divisorCount = countDivisors(i);
			if((primePowerCount == n ) && (primePowerCount+1) == divisorCount){
				System.out.println(i);
				break; 
			}
			}
		}
	}
	public static boolean isPrime(int num){
		for(int i=2;i<num;i++){
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}
	public static int countDivisors(int num){
		int count = 0;
		for(int i=1;i<=num;i++){
			if((num%i) == 0){
				count++;
			}
		}
		return count;
	}
	public static int calculateSumOfPrimeFactors(int n){
		Map m = new HashMap();
		int key;
		while(n%2 == 0){
			 key = 2;
			if(m.containsKey(key)){
				int val = (int) m.get(key);
				m.put(key, ++val);
			}else{
				m.put(key, 1);
			}
			n = n/2;
		}
		for (int i = 3; i <= (int)Math.sqrt(n); i = i+2)
	    {
			if(m.containsKey(i)){
				int val = (int) m.get(i);
				m.put(i, ++val);
			}else{
				m.put(i, 1);
			}
			n = n/i;
			
	    }
		if(n>2){
			if(m.containsKey(n)){
				int val = (int) m.get(n);
				m.put(n, ++val);
			}else{
				m.put(n, 1);
			}
		}
		
		//Sum of powers
		int powerSum = 0;
		Iterator entries = m.entrySet().iterator();
		while (entries.hasNext()) {
			Entry e = (Entry) entries.next();
			powerSum = powerSum+(int)e.getValue();
		}
		return powerSum;
	}
}
