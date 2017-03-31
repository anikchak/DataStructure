package learning;

import java.util.Arrays;
import java.util.Scanner;

public class inputs {

	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
            return bytes / MEGABYTE;
    }
    
	public static void main(String[] args) {
		
	       Scanner s = new Scanner(System.in);
			int tests = s.nextInt();
		//	System.out.println("Tests="+tests);
			for(int i=0;i<tests;i++){
			int bottles = s.nextInt();
		//	System.out.println("Bottles="+bottles);
			int capacity = s.nextInt();
			//System.out.println("Capacity="+c);
			int bCap[] = new int[bottles];
			int bottleNum = 0,index=0;
		
			while(s.hasNextLine() && index<bottles){
				bCap[index] = s.nextInt();
				index++;
			}
			for(int k=0;k<bCap.length;k++){
				//System.out.println(bCap[k]);
			}
			long startTime = System.currentTimeMillis();
			int maxFilled = 1,count=1;
			int cap = 0;
			Arrays.sort(bCap);
			cap = capacity;
			//System.out.println(bCap[bCap.length-1]);
			//System.out.println(bCap[0]);
			for(int k=0;k<bCap.length;k++){
				cap = cap - bCap[k];
				if(cap>0 && cap>bCap[0]){
					//System.out.println("cap="+cap);
					maxFilled++;					
				}else{
					break;
				}
			}

	    
	    
			 System.out.println(maxFilled);
			// Get the Java runtime
             Runtime runtime = Runtime.getRuntime();
             // Run the garbage collector
             runtime.gc();
             // Calculate the used memory
             long memory = runtime.totalMemory() - runtime.freeMemory();
             System.out.println("Used memory is bytes: " + memory);
             System.out.println("Used memory is megabytes: "
                             + bytesToMegabytes(memory));
             long stopTime = System.currentTimeMillis();
             long elapsedTime = stopTime - startTime;
             System.out.println(elapsedTime);
	}
	}

}
