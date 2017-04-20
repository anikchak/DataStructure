package geekforgeeks;

import java.util.Scanner;

public class FirstFirstAndLastOccurenceOfX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//code
		Scanner sc  = new Scanner(System.in);
		int test = sc.nextInt();
		while(test>0){
		    test--;
		    int len = sc.nextInt();
		    int a[] = new int[len];
		    for(int i=0;i<len;i++){
		        a[i] = sc.nextInt();
		    }
		    int x = sc.nextInt();
		    int low =0, high=len-1,first =-1,last =-1;
		    //Finding first occurence
		    while(low<=high){
		        int mid = low+(high-low)/2;
		        if((mid==0 || x>a[mid-1]) && (a[mid]==x)){
		            first = mid;
		            break;
		        }
		        else if(x>a[mid]){
		            low = mid+1;
		        }else{
		            high = mid-1;
		        }
		    }
		    System.out.println(first);
		    //Finding last occurence
		    low = 0;
		    high = len-1;
		    while(low<=high){
		        int mid = low+(high-low)/2;
		        if((mid==(len-1) || x<a[mid+1]) && (a[mid]==x)){
		            last = mid;
		            break;
		        }
		        else if(x<a[mid]){
		            high = mid-1;
		        }else{
		            low = mid+1;
		        }
		    }
		    if(high==-1 && low==-1){
    	        System.out.println(-1);
		    }else{
		        System.out.println(first+" "+last);
		    }
		}
	

	}

}
