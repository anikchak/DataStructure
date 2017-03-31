package DynamicProgramming;

import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
*/
        //Scanner
      
    	/*
    	Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        
        if(T<1 || T>100000){
        	return;
        }
		
        for (int i = 0; i < T; i++) {
        	int N = s.nextInt(); 
        	if(N>=0 && N<=100000){
        	int fact[] = new int[N+1];
        	for(int j=2;j<fact.length;j++){
        		fact[j] = -1;
        	}
        	fact[0] = 1;
        	fact[1] = 1;
        	int result = calculate(N,fact);
        	System.out.println(result);
        }
        	
        }
        */
int n=6;
        if(n>=1 && n<=100){
            n=6;
            for(int i=0;i<n;i++){
                for(int j=n-1;j>i;j--){
                    System.out.print(" ");
                }
                for(int k=0;k<i+1;k++){
                System.out.print("#");
                }
                System.out.println();
            }
        }
    }
        
        public static int calculate(int n, int fact[]){
        	/*
        	if(n==0 || n==1){
        		return fact[n];
        	}*/
        	if(fact[n]!= -1){
        		return fact[n];
        	}
        	fact[n] = (int) ((n*calculate(n-1,fact))%(Math.pow(10,9)+7));
        	return fact[n];
        	
        	
        	

        }

    
}

