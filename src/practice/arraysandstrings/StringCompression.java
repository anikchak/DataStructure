package practice.arraysandstrings;

public class StringCompression {

	public int calculateSize(String str){
		int size=0,count=1;
		char last = str.charAt(0);
		for(int i=1;i<str.length();i++){
			if(last == str.charAt(i)){
				count++;
			}else{
				size = size+String.valueOf(count).length()+1;
				count=1;
				last = str.charAt(i);
			}
		}
		size = size+String.valueOf(count).length()+1;
		return size;
	}
	
	public String compress(String str){
		int size = calculateSize(str);
		if(size > str.length()){
			return str;
		}
		
		char op[] = new char[size];
		int count=1,index=0;
		char last = str.charAt(0);
		
		for(int i=1;i<str.length();i++){
			if(last == str.charAt(i)){
				count++;
			}else{
				op[index] = last;
				index++;
				last = str.charAt(i);
				char countArr[] = String.valueOf(count).toCharArray();
				for(char c:countArr){
					op[index] = c;
					index++;
				}
				count = 1;
			}
		}
		op[index] = last;
		index++;
		char countArr[] = String.valueOf(count).toCharArray();
		for(char c:countArr){
			op[index] = c;
			index++;
		}
		
		return String.valueOf(op);
	}
	
	public static void main(String args[]){
		StringCompression sc = new StringCompression();
		System.out.println("Compressed String for aaabcccccaa = "+sc.compress("aaabcccccaa"));
		System.out.println("Compressed String for abc = "+sc.compress("abc"));
	}
}
