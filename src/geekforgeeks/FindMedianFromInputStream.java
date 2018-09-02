package geekforgeeks;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromInputStream {

	public void addValue(int element, Queue<Integer> left, Queue<Integer> right){
		//If size(right) = 0; it means this is the first element. Hence put it in right queue
		if(right.size()==0){
			right.add(element);
		}
		else if(left.size() == right.size()){
			if(element >= right.peek()){
				right.add(element);
			}else{
				right.add(left.poll());
				left.add(element);
			}
		}else{
			if(element<=right.peek()){
				left.add(element);
			}else{
				left.add(right.poll());
				right.add(element);
			}
		}
	}
	public void fetchMedian(Queue<Integer> left, Queue<Integer> right){
		if(left.size()==right.size()){
			//System.out.println("left Peek = "+left.peek()+" Right peek = "+right.peek());
			float m = (float)(left.peek()+right.peek())/2;
			System.out.println("Median = "+m);
		}else{
			System.out.println("Median = "+right.peek());
		}
	}
	
	public static void main(String[] args) {
		FindMedianFromInputStream s = new FindMedianFromInputStream();
		Queue<Integer> left = new PriorityQueue<Integer>(Collections.reverseOrder()); //Will hold values as MaxHeap. 
		Queue<Integer> right = new PriorityQueue<Integer>(); //Will hold values as MinHeap. 
		int a[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4,16};
		//Find median for every element traversed
		for(int i=0;i<a.length;i++){
			s.addValue(a[i],left,right);
			s.fetchMedian(left, right);
		}
	}

}
