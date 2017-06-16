/*
 * Given an n x n matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the given 2D array.

For example, consider the following 2D array.

        10, 20, 30, 40
        15, 25, 35, 45
        24, 29, 37, 48
        32, 33, 39, 50
The 3rd smallest element is 20 and 7th smallest element is 30

Approach:
The idea is to use min heap. Following are detailed step.
1) Build a min heap of elements from first row. A heap entry also stores row number and column number.
2) Do following k times.
…a) Get minimum element (or root) from min heap.
…b) Find row number and column number of the minimum element.
…c) Replace root with the next element from same column and min-heapify the root.
3) Return the last extracted root.
 */
package geekforgeeks;

public class KthSmallestElementRowwiseColWiseSorted2DArray {

	class HeapNode{
		int data;
		int rowId;
		int colId;
		HeapNode(int d, int rid, int cid){
			this.data = d;
			this.rowId = rid;
			this.colId = cid;
		}
	}
	public void buildHeap(HeapNode a[], int size){
		for(int i=size/2;i>=0;i--){
			minHeap(a,i,size);
		}
	}
	public void minHeap(HeapNode a[], int pos, int size){
		int left = 2*pos+1;
		int right = 2*pos+2;
		int min = pos;
		if(left<=size && a[left].data<a[min].data){
			min = left;
		}
		if(right<=size && a[right].data<a[min].data){
			min = right;
		}
		if(min != pos){
			HeapNode temp = a[min];
			a[min] = a[pos];
			a[pos] = temp;
			minHeap(a, min, size);
		}
	}
	public void findKthSmallest(int a[][],int k){
		int r = a.length;
		int c = a[0].length;
		HeapNode hn[] = new HeapNode[c];
		if(k>(r*c)){
			System.out.println("Outside 2D array range");
		}
		for(int i=0;i<c;i++){
			hn[i] = new HeapNode(a[0][i],0,i);
		}
		//build min heap
		buildHeap(hn, hn.length-1);
		//printHeap(hn);
		//Iterate k times 
		HeapNode min = null;
		for(int i=1;i<k;i++){
			min = hn[0];
			int minRow = min.rowId;
			int colRow = min.colId;
			if((minRow+1)<a.length){
				hn[0].data = a[minRow+1][colRow];
				hn[0].rowId = minRow+1;
			}else{
				hn[0].data = Integer.MAX_VALUE;
			}
			minHeap(hn, 0, hn.length-1);
		//	printHeap(hn);
		}
		System.out.println("Min Kth (k= "+k+") value = "+hn[0].data);
	}
	public void printHeap(HeapNode hn[]){
		for(int i=0;i<hn.length;i++){
			System.out.print(hn[i].data+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int a[][] = {
				 {10, 20, 30, 40},
			     {15, 25, 35, 45},
			     {24, 29, 37, 48},
			     {32, 33, 39, 50}
		};
		KthSmallestElementRowwiseColWiseSorted2DArray k = new KthSmallestElementRowwiseColWiseSorted2DArray();
		for(int i=1;i<=(a.length*a[0].length);i++){
			k.findKthSmallest(a, i);
		}
	}
}
