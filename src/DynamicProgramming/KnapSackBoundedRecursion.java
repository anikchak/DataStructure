/*
 * This code is used to solve the knapsack problem using Recursion
 */
package DynamicProgramming;

public class KnapSackBoundedRecursion {

	public static int knapsack(int w[],int v[],int limit,int wt, int index){
		if(index < w.length){
			int v1=0, v2=0;
			int newWt = w[index]+wt;
			if(newWt <= limit){
				v1 = knapsack(w, v, limit, newWt, index+1);
				v1 = v1+v[index];
			}else{
				return 0;
			}
			v2 = knapsack(w, v, limit, wt, index+1);
			return Math.max(v1, v2);
		}
		return 0;
	}
	
	public static void main(String args[]){
		/*
		int w[]={1,2,2,2,2};
		int v[]={1,2,3,4,5};
		
		System.out.println(knapsack(w, v, 1, 0, 0));
		System.out.println(knapsack(w, v, 2, 0, 0));
		System.out.println(knapsack(w, v, 3, 0, 0));
		System.out.println(knapsack(w, v, 4, 0, 0));
		System.out.println(knapsack(w, v, 5, 0, 0));
		System.out.println(knapsack(w, v, 6, 0, 0));
		System.out.println(knapsack(w, v, 7, 0, 0));
		System.out.println(knapsack(w, v, 8, 0, 0));
		System.out.println(knapsack(w, v, 9, 0, 0));
		*/
//		int w[]={10,20,30};
//		int v[]={60,100,120};
		
		int w[]={8,5,4,3,2};
		int v[]={1,1,1,1,1};
		System.out.println(knapsack(w, v, 10, 0, 0));
	}
}
