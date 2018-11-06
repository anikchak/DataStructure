/*
 * Given two sorted arrays, find the median for the combined arrays
 */
package geekforgeeks;

public class MedianForTwoSortedArray {
/*
 * Lets say the two matrices are as follows:
 * X = x1,x2,x3,x4
 * Y = y1,y2,y3,y4,y5,y6
 * Brute force method would be two merge both these arrays and then calculate the median. Time complexity for this method = O(X+Y), space complexity = O(m+n)
 * Other way would be to,
 * partition the arrays such that value of elements on left side of the partition for both arrays will be lesser that values on the right side
 * When 
 * - the length of X+Y will be even then both the partitions should contain equal number of elements on each side
 * - the length of X+Y will be odd then left partition will contain 1 extra element than right partition
 * If we take X and Y  mentioned above, then lenX+lenY is even so partitions should have equal number of elements
 * Lets say we partition after 2 elements for X, then Y must be partitioned after 3 elements. The partitions will have following values
 * Left partition: x1,x2 [Data from X]..... y1,y2,y3[data from Y]
 * Right partition: x3,x4 [Data from X]..... y4,y5,y6[data from Y]
 * To compute median: x2 < y4 and x3 < y3
 * Then compute the median as per lengths
 * Refer: https://www.youtube.com/watch?v=LPFhl65R7ww 
 *     
 */
	public void computeMedian(int X[], int Y[]){
		/* 
		 * To compute median we will consider the array with lesser elements and then apply binary search for determining partition
		 */
		double median = 0;
		if(X.length > Y.length){
			//for our ease, we want to annotate X with array having lesser values and Y as array having more values
			computeMedian(Y, X);
			return;
		}
		int xLen = X.length;
		int yLen = Y.length;
		int start = 0;
		int end = X.length-1;
		while(start<=end){
			//Compute partition for X
			int Px =  (start+end)/2;
			// For partition of Py = [(x+y+1)/2] - Px; We are adding 1 to handle odd length cases
			int Py = (xLen+yLen+1)/2 - Px;
			//Compute max and min elements of each array for both partitions
			// Px == 0 and Px==xLen are corner cases where left or right partition does not have any element, the we assign dummy values
			int xLeftMax = (Px == 0) ? Integer.MIN_VALUE : X[Px-1]; //Max X value in Left partition
			int xRightMin = (Px == xLen) ? Integer.MAX_VALUE : X[Px]; //Min X value in right partition
			//Similarly for Y
			int yLeftMax = (Py == 0) ? Integer.MIN_VALUE : Y[Py-1];
			int yRightMin = (Py == yLen) ? Integer.MAX_VALUE : Y[Py];
			/*
			System.out.println("start " +start );
			System.out.println("end = "+end);
			System.out.println("Px = "+Px);
			System.out.println("Py = "+Py);
			System.out.println("xLeftMax = "+xLeftMax);
			System.out.println("xRightMin = "+xRightMin);
			System.out.println("yLeftMax = "+yLeftMax);
			System.out.println("yRightMin = "+yRightMin);
			System.out.println();
			*/
			//Now check for median condition
			if(xLeftMax <= yRightMin && yLeftMax <= xRightMin){
				if((xLen+yLen)%2 == 0){
					median = (Math.max(xLeftMax,yLeftMax) + Math.min(xRightMin, yRightMin))/2;
				}else{
					median = Math.max(xLeftMax,yLeftMax);
				}
				break;
			}else if(xLeftMax > yRightMin){
				end = Px-1;
			}else{
				start = Px+1;
			}
		}//end of while
		System.out.println("Median = "+median);
	}
	
	public static void main(String args[]){
		MedianForTwoSortedArray m = new MedianForTwoSortedArray();
		int X[] = {1,3,8,9,15};
		int Y[] = {7,11,18,19,21,25};
		m.computeMedian(X, Y);
		
		int X1[] = {23,26,31,35};
		int Y1[] = {3,5,7,9,11,16};
		m.computeMedian(X1, Y1);
	}
}
