package geekforgeeks;

import java.util.ArrayList;

public class FindSubString {
	@SuppressWarnings({ "rawtypes", "unchecked" }) 
	public static void main(String[] args) {

		 int a[] = {1,2,3};
		 int len = a.length;
		 int count = (len*(len+1))/2;
		    ArrayList sub[] = new ArrayList[count];
		    //ArrayList al = new ArrayList();
		    int k=0;
		    for(int i=0;i<a.length;i++){
		         ArrayList<Integer> al = new ArrayList<Integer>();
		         al.add(a[i]);
		         sub[k] = al;
		         k++;
		        for(int j=i+1;j<a.length;j++){
		            ArrayList<Integer> temp = new ArrayList<Integer>();
		            temp.addAll(sub[k-1]);
		          temp.add(a[j]);
		            sub[k] = temp;
		            k++;
		        }
		    }
		    for(int i=0;i<sub.length;i++){
		        System.out.print(sub[i]+" ");
		    }
		
	}
	

}
