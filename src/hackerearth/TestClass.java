package hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//
*/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);

        //Scanner
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String str = br1.readLine();
        
        System.out.println(str);
        //System.out.println(n*2);
        /*
        if(n<0 || n>10){
        	return;
        }
        if(str.length()<1 || str.length()>15){
        	return;
        }
        */
	
        System.out.println(n*2);
        

        System.out.println(str);
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
}
