package sorting;

import java.util.ArrayList;

public class BucketSort {

	public void bucketSort(float a[]){
		int sz = a.length;
		ArrayList<ArrayList<Float>> bucket = new ArrayList<ArrayList<Float>>();
		
		for(int i=0;i<sz;i++){
			bucket.add(new ArrayList<Float>());
		}
		//Assigning values to buckets
		for(int i=0;i<sz;i++){
			int index = (int) (sz*a[i]);
			bucket.get(index).add(a[i]);
		}
		
		//Perform sorting over buckets
		float resultList[] = new float[a.length];
		int counter = 0;
		for(int i=0;i<bucket.size();i++){
			float bucketArr[] = new float[bucket.get(i).size()];
			int count=0;
			for(int j=0;j<bucket.get(i).size();j++){
				bucketArr[count] = bucket.get(i).get(j);
				count++;
			}
			//Sort bucketArray and put the sorted value in resultList
			int bSz = bucketArr.length;
			//Insertion Sort
			for(int i1=0;i1<bSz-1;i1++){
				if(bucketArr[i1]>bucketArr[i1+1]){
					float temp = bucketArr[i1];
					bucketArr[i1] = bucketArr[i1+1];
					bucketArr[i1+1] = temp;
					for(int j=i1;j>0;j--){
						if(bucketArr[j]<bucketArr[j-1]){
							float temp1 = bucketArr[j];
							bucketArr[j] = bucketArr[j-1];
							bucketArr[j-1] = temp1;
						}
					}
				}
			}
			for(float ar:bucketArr){
			resultList[counter] = ar;
			counter++;
			}
		}
		System.out.print("\nBucket Sort[Asc]:");
		for(float result: resultList){
			System.out.print(" "+result);
		}
	}
	public static void main(String[] args) {
	float arr[] = {0.78F,.72F,.12F,.19F,.26F,.65F,.66F,.40F};
	BucketSort b = new BucketSort();
	b.bucketSort(arr);
	}

}
