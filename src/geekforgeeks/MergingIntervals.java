/*
 * Given a set of time intervals in any order, merge all overlapping intervals into one and 
 * output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. 
The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. 
 * Similarly {5, 7} and {6, 8} should be merged and become {5, 8}
 * 
 * Approach
 * Sort the array based on their starting time.
 * Create a stack
 * Push the first interval
 * Now check if stack.top.end >= input.start; then check if stack.top.end < input.end -> If true, update the interval and donot push this input.
 * Else push the input  
 */
package geekforgeeks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergingIntervals{

	class Interval{
		int start;
		int end;
		Interval(int s, int e){
			this.start = s;
			this.end = e;
		}
	}
	public static void main(String[] args) {
		MergingIntervals mi = new MergingIntervals();
		Interval i[] = {
			mi.new Interval(5, 7),
			mi.new Interval(2, 4),
			mi.new Interval(1, 3),
			mi.new Interval(6, 8),
			mi.new Interval(1, 9)
		};
		Arrays.sort(i, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
		System.out.println("Sorted order");
		for(Interval o:i){
			System.out.println(o.start+" "+o.end);
		}
		
		//Create a stack
		Stack<Interval> s = new Stack<Interval>();
		s.push(i[0]);
		for(int k=1;k<i.length;k++){
			Interval top = s.peek();
			if(top.end>i[k].start){
				if(top.end<i[k].end){
					top.end = i[k].end;
				}
			}else{
				s.push(i[k]);
			}
		}
		System.out.println("Set after merging intervals = ");
		while(!s.isEmpty()){
			Interval it = s.pop();
			System.out.println(it.start+" "+it.end);
		}
	}

}
