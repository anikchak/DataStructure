/*
 * Given k sorted lists of integers of size n each, find the smallest range that includes at least element from each of the k lists. If more than one smallest ranges are found, print any one of them.

Example :

Input:
K = 3
arr1[] : [4, 7, 9, 12, 15]
arr2[] : [0, 8, 10, 14, 20]
arr3[] : [6, 12, 16, 30, 50]
Output:
The smallest range is [6 8] 
Explanation: Smallest range is formed by 
number 7 from first list, 8 from second
list and 6 from third list.
 */
package geekforgeeks;

public class SmallestRangeContainingElementsFromKList {

	class HeapNode{
		int data;
		int listId;
		int pos;
		HeapNode(int d, int id, int p){
			this.data = d;
			this.listId = id;
			this.pos = p;
		}
	}
	public void findRange(int a[][], int k){
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, range = Integer.MAX_VALUE;
		int start=-1,end=-1;
		HeapNode h[] = new HeapNode[k];
		for(int i=0;i<k;i++){
			h[i] = new HeapNode(a[i][0], i, 0);
			if(max<a[i][0]){
				max = a[i][0];
			}
		}
		//buildHeap
		buildHeap(h,h.length-1);
		while(true){

			HeapNode node = h[0];
			min = node.data;
			//Find range
			if(range>(max-min+1)){
				range = max-min+1;
				start = min;
				end = max;
			}
			//Replace min/h[0] with next element of the list and perform minHeapify
			//This process will continue till end of one the list is reached
			if((node.pos+1) < (a[node.listId].length))
			{
				h[0].data = a[node.listId][node.pos+1];
				h[0].pos = node.pos+1;
				if(max<h[0].data){
					max = h[0].data;
				}
			}else{
				break;
			}
			minHeapify(h,0,k-1);
		}
		System.out.println("Range = ["+start+","+end+"]");
	}
	public void buildHeap(HeapNode[] h, int size){
		for(int i= size/2;i>=0;i--){
			minHeapify(h,i,size);
		}
	}
	public void minHeapify(HeapNode []h,int pos,int size){
		int left = 2*pos+1;
		int right = 2*pos+2;
		int min = pos;
		if(left<=size && h[left].data<h[min].data){
			min = left;
		}
		if(right<=size && h[right].data<h[min].data){
			min = right;
		}
		if(min!=pos){
			HeapNode temp = h[min];
			h[min] = h[pos];
			h[pos] = temp;
			minHeapify(h, min, size);
		}
	}
	public static void main(String[] args) {
		int a[][] = {
				{4,7,9,12,15},
				{0,8,10,14,20},
				{6,12,16,30,50}
		};
		SmallestRangeContainingElementsFromKList s = new SmallestRangeContainingElementsFromKList();
		s.findRange(a, a.length);
	}

}
