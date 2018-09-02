/*
 * Given jobs with start and end time and the profit each job makes, find the max profit.
 */
package DynamicProgramming;

import java.util.ArrayList;

public class JobScheduling {
	class Times{
		int inTime;
		int outTime;
		int pro;
		Times(int i, int o, int p){
			this.inTime = i;
			this.outTime = o;
			this.pro = p;
		}
	}

	public void mergeSort(Times arr[], int s, int e){
		if(s<e){
		int m = (s+e)/2;
		mergeSort(arr,s,m);
		mergeSort(arr,m+1,e);
		merge(arr,s,m,e);
		}
	}
	public void merge(Times arr[], int s, int m, int e){
		int lLimit = (m-s)+1;
		int rLimit = e-m;
		Times left[] = new Times[lLimit];
		Times right[] = new Times[rLimit];
		
		for(int i=0;i<lLimit;i++){
			left[i] = arr[s+i];
		}
		for(int i=0;i<rLimit;i++){
			right[i] = arr[m+1+i];
		}
		int i=0, j=0, k=s;
		while(i<lLimit && j<rLimit){
			if(left[i].outTime<right[j].outTime){
				arr[k] = left[i];
				i++;
				k++;
			}
			else{
				arr[k] = right[j];
				j++;
				k++;
			}
		}
		while(i<lLimit){
			arr[k] = left[i];
			i++;
			k++;
		}
		while(j<rLimit){
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	
	public void maxProfit(Times arr[]){
		int result[] = new int[arr.length];
		//Initializing
		for(int i=0;i<result.length;i++){
			Times t = arr[i];
			result[i] = t.pro;
		}
		
		for(int i=1;i<result.length;i++){
			int j=0;
			Times in = arr[i];
			int currPro = result[i];
			while(j<i){
				Times out = arr[j];
				if(out.outTime<=in.inTime){
					int newPro = result[j]+currPro;
					if(newPro>result[i]){
						result[i] = newPro;
					}
				}
				j++;
			}
		}
		System.out.print("\n Result =");
		int maxPro = Integer.MIN_VALUE;
		int pos = -1;
		for(int r=0;r<result.length;r++){
			System.out.print(" "+r);
			if(maxPro<result[r]){
				maxPro = result[r];
				pos = r;
			}
		}
		System.out.println();
		System.out.println("Max Profit ="+maxPro);
		
	}
	public static void main(String[] args) {
		JobScheduling j = new JobScheduling();
		ArrayList<Times> al = new ArrayList<Times>(); 
		al.add(j.new Times(2, 5, 6));
		al.add(j.new Times(7, 9, 2));
		al.add(j.new Times(1, 3, 5));
		al.add(j.new Times(6, 7, 4));
		al.add(j.new Times(4, 6, 5));
		al.add(j.new Times(5, 8, 11));
		
	    Times arr[] = al.toArray(new Times[0]);
		//Sort the given input based on outTime in ascending order
	    j.mergeSort(arr, 0, arr.length-1);
		for(Times t: arr){
			System.out.print(" <"+t.inTime+","+t.outTime+">");
		}
		
		//Calculating maxProfit
		j.maxProfit(arr);
	}

}
