package practice.arraysandstrings;

public class ZeroMatrix {

	public static void zeroMatrix(int mat[][]){
		int row = mat.length;
		int col = mat[0].length;
		boolean rowCheck[] = new boolean[row];
		boolean colCheck[] = new boolean[col];
		int posR=0,posC=0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(mat[i][j]==0){
					rowCheck[i] = true;
					colCheck[j] = true;
					break;
				}
			}
		}
		//Setting row to zero value
		for(int i=0;i<rowCheck.length;i++){
			if(rowCheck[i]){
				for(int j=0;j<col;j++){
					mat[i][j] = 0;
				}
			}
		}
		
		//Setting Column to zero value
		for(int i=0;i<colCheck.length;i++){
			if(colCheck[i])
			{
				for(int j=0;j<row;j++){
					mat[j][i] = 0;
				}
			}
		}
		System.out.println("Displaying zero matix:");
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				//if(mat[i][j] == 0)
				System.out.print(" "+mat[i][j]);
				//else
				//	System.out.print(" "+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		int arr[][] = {
				{1,1,0,1},
				{2,2,2,2},
				{3,3,3,3},
				{4,0,4,4}
		};
		zeroMatrix(arr);
	}
}
