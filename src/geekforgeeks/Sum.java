package geekforgeeks;

public class Sum {

	public static void sum(int n, int k){
		int maxSum = 0;
	    int sum[] = new int[n+1];   
        int count =0;
        while(count<n){
            int s = 0;
            if(sum[count]!=0){
            	s = sum[count];
            }
            for(int i=count+1;i<=n;i++){
                if(s+i != k){
                    s = s+i;
                    sum[i-1]= s;
                }
            }
            
            if(s>maxSum){
                maxSum = s;
                sum[count]= maxSum;
            }
            count++;
        }
          
System.out.println(maxSum%(int)(Math.pow(10,9)+7)); 
		//System.out.println(max);
for(int i: sum){
	System.out.print(i+" ");
}
System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
sum(300,30);
sum(2,1);
sum(2,2);
	}

}
