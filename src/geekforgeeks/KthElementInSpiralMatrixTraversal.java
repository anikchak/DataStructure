package geekforgeeks;

public class KthElementInSpiralMatrixTraversal {
	
	public static void traverse(int a[][], int r,int c,int sRow,int sCol){
		for(int i=sRow;i<=r;i++){
			for(int j=sCol;j<=c;j++){
				System.out.print(a[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
		};
		int row = a.length;
		int col = a[0].length;
		traverse(a,row-1,col-1,0,0);
		System.out.println();
		traverse(a, row-2, col-2,1,1);
		System.out.println();
		traverse(a, row-3, col-3,2,2);
	}

}
