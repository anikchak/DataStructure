package practice.arraysandstrings;

public class RotateImage {

	public void rotateImage(int oldImage[][]){
		int len = oldImage.length;
		int newImage[][] = new int[len][len];
		for(int r = 0;r<len;r++){
			for(int c = 0;c<len;c++){
				newImage[r][c] = oldImage[c][len-r-1];
			}
		}
		
		System.out.println("90 degree inverted image");
		for(int r = 0;r<len;r++){
			for(int c = 0;c<len;c++){
				System.out.print(" "+newImage[r][c]);
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		int arr[][]  = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		RotateImage ri = new RotateImage();
		ri.rotateImage(arr);
	}
}
