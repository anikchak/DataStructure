package geekforgeeks;

public class MatricSpiralTraversal {
	public void spiral(int arr[][], int totalElements, int elementCount, int r, int c, int rLimit, int cLimit, boolean rInc, boolean cInc, boolean rowMove){
		if(elementCount < totalElements){
			int n = 0;
			//Column traversal
			if(!rowMove){
				//column increment
				if(cInc){
					while(n<cLimit){
						System.out.print(arr[r][c]+" ");
						n++; 
						elementCount++;
						c++;
					}
					c--;
					r++;
					rInc = true;
				}
				//column decrement
				else{
					while(n<cLimit){
						System.out.print(arr[r][c]+" ");
						elementCount++;
						n++;
						c--;
					}
					c++;
					rInc = false;
					r--;
				}
				rLimit --;
				rowMove = true;
				cInc = false;
			}//end of rowMove if block 
			//Row traversal
			else if(rowMove){
				//row increment
				if(rInc){
					while(n<rLimit){
						System.out.print(arr[r][c]+" ");
						n++;
						elementCount++;
						r++;
					}
					cInc = false;
					r--;
					c--;
				}
				else{
					//row decrement
					while(n<rLimit){
						System.out.print(arr[r][c]+" ");
						elementCount++;
						n++;
						r--;
					}
					r++;
					cInc = true;
					c++;
				}
				cLimit--;
				rowMove = false;
				rInc = false;
			}
			spiral(arr, totalElements, elementCount, r, c, rLimit, cLimit, rInc, cInc, rowMove);
		}
	}
	
	public static void main (String args[]){
		MatricSpiralTraversal m = new MatricSpiralTraversal();
		int arr[][] = 
			{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
			};
		int tElements = arr.length*arr[0].length;
		m.spiral(arr, tElements, 0, 0, 0, arr.length, arr[0].length, false, true, false);
		}
}
