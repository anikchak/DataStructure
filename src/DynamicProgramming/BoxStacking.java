/*
 * Given a set of n types of rectangular 3-D boxes, create a stack of boxes which is as tall as possible, 
 * but you can only stack a box on top of another box if the dimensions of the 2-D base of the lower box are each 
 * strictly larger than those of the 2-D base of the higher box. Of course, you can rotate a box so that any side functions as its base. 
 * It is also allowable to use multiple instances of the same type of box.
 * 
 * Logic:
 * Given length l/width w/height h of a 3D rectangle
 * Rotate the box thrice such that h1 = l / h2 = w / h3 = h
 * Accordingly set the l = max(w,h) w = min(w,h). Here we are assuming that l will always be greater than w
 * Once we have rotation for all the boxes, calculate base area = l*w and arrange them in decreasing order
 * After that apply longest increasing subsequence algo over height 
 */
package DynamicProgramming;

import geekforgeeks.MaxHistogramArea;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Box{
	int length;
	int width;
	int height;
	Box(int l, int w, int h){
		this.length = l;
		this.width = w;
		this.height = h;
	}
}
public class BoxStacking{

	public void maxHeight(Box[] box){
		//Each box can have three rotations
		//For generality we will keep length always greater than width
		Box boxRotateArr[] = new Box[box.length*3];
		int k=0;
		for(int i=0;i<box.length;i++){
			//First Rotation
			int h1 = box[i].length;
			int l1 = Math.max(box[i].width, box[i].height);
			int w1 = Math.min(box[i].width, box[i].height);
			boxRotateArr[k] = new Box(l1, w1, h1);
			k++;
			//Second Rotation
			int h2 = box[i].width;
			int l2 = Math.max(box[i].length, box[i].height);
			int w2 = Math.min(box[i].length, box[i].height);
			boxRotateArr[k] = new Box(l2, w2, h2);
			k++;
			//Third Rotation
			int h3 = box[i].height;
			int l3 = Math.max(box[i].length, box[i].width);
			int w3 = Math.min(box[i].length, box[i].width);
			boxRotateArr[k] = new Box(l3, w3, h3);
			k++;
		}
		
		//Sort the base area (l*w) in desc order
		sortArea(boxRotateArr,0,boxRotateArr.length-1);
		//Once sorted, find longest increasing subsequence
		int max[] = new int[boxRotateArr.length];
		int result[] = new int[boxRotateArr.length];
		for(int i=0;i<max.length;i++){
			max[i] = boxRotateArr[i].height;
			result[i] = i;
		}
		
		for(int i=1;i<max.length;i++){
			int lBox1 = boxRotateArr[i].length;
			int wBox1 = boxRotateArr[i].width;
			for(int j=0;j<i;j++){
				int lBox2 = boxRotateArr[j].length;
				int wBox2 = boxRotateArr[j].width;
				if(lBox2 > lBox1 && wBox2 > wBox1){
					if(max[i]<max[j]+boxRotateArr[i].height){
						max[i] = max[j]+boxRotateArr[i].height;
						result[i] = j;
					}
				}
			}
		}
		int maxHt = 0,pos = -1;
		for(int i=0;i<max.length;i++){
			if(max[i]>maxHt){
				maxHt = max[i];
				pos = i;
			}
		}
		System.out.println("Max Ht that can be achieved by strict box stacking = "+maxHt);
		System.out.println("Stack boxes in order: ");
		int temp = 0;
		while(temp<maxHt){
			int l = boxRotateArr[pos].length;
			int w = boxRotateArr[pos].width;
			int h = boxRotateArr[pos].height;
			System.out.println(l+" "+w+" "+h);
			temp = temp+h;
			pos = result[pos];
		}
		
	}
	public void sortArea(Box []b,int s, int e){
		if(s<e){
			int m = (s+e)/2;
			sortArea(b, s, m);
			sortArea(b, m+1, e);
			sort(b,s,m,e);
		}
	}
	public void sort(Box []b,int s, int m, int e){
		int lArr = m-s+1;
		int rArr = e-m;
		Box lBoxArr[] = new Box[lArr];
		Box rBoxArr[] = new Box[rArr];
		for(int i=0;i<lArr;i++){
			lBoxArr[i] = b[s+i];
		}
		for(int i=0;i<rArr;i++){
			rBoxArr[i] = b[m+1+i];
		}
		int i=0,j=0,k=s;
		while(i<lArr && j<rArr){
			int a1 = lBoxArr[i].length*lBoxArr[i].width;
			int a2 = rBoxArr[j].length*rBoxArr[j].width;
			if(a1>a2){
				b[k] = lBoxArr[i];
				k++;
				i++;
			}else{
				b[k] = rBoxArr[j];
				k++;
				j++;
			}
		}
		while(i<lArr){
			b[k] = lBoxArr[i];
			k++;
			i++; 
		}
		while(j<rArr){
			b[k] = rBoxArr[j];
			k++;
			j++;
		}
	}
	public static void main(String[] args) {
		Box box[] = {new Box(1,2,4),new Box(3,2,5)};
		BoxStacking bs = new BoxStacking();
		bs.maxHeight(box);
	}

}
