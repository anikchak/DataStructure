/*
 * Kadane's algo is used to find max contiguous sum of elements in an array. 
 */
package geekforgeeks;

public class KadanesAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-10,-2,-3,-4,-1};
		//int a[] = {-2,-3,4,-1,-2,1,5,-3};
		//int a[] = {-33, 34, 0, 69, 24, -22, 58, 62, -36, 5, 45, -19, -73, 61, -9, 95, 42, -73, -64, 91, -96, 2, 53, -8, 82, -79, 16, 18, -5, -53 ,26 ,71, 38, -31, 12, -33, -1 ,-65, -6, 3, -89, 22};
		int max = a[0], currMax = a[0];
		int s=0,e=0, start = 0;
		for(int i=1;i<a.length;i++){
			if(currMax+a[i] > a[i]){
				currMax = currMax+a[i];
			}else{
				currMax = a[i];
				s=i;
			}
			if(currMax>max){
				max = currMax;
				e=i;
				start = s;
			}
		}
		System.out.println("Max Sum = "+max+" Data Range Index: <"+start+", "+e+">");
	}

}
