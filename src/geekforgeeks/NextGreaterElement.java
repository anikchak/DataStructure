/*
 * Given an array, print the Next Greater Element (NGE) for every element. 
 * The Next greater Element for an element x is the first greater element on the right side of x in array. 
 * Elements for which no greater element exist, consider next greater element as -1.
 * Example: array = {4,5,2,25};
 * Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
 */
package geekforgeeks;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[] = {4,5,2,25};
		int a[] = {13,7,6,12};
		int max[] = new int[a.length];
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		for(int i=1;i<a.length;i++){
			while(!s.isEmpty()){
				if(a[s.peek()]<a[i]){
					max[s.pop()] = a[i];
				}else{
					break;
				}
			}
			s.push(i);
		}
		while(!s.isEmpty()){
			max[s.pop()] = -1;
		}
		//Printing Next Greater Element
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]+" -> "+max[i]);
		}
	}

}
