package geekforgeeks;

public class StringEncoding {

	public static void decipher(String s){
		int arr[] = new int[26];
		for(int i=0;i<26;i++){
			arr[i] = 0;
		}
		int len = s.length();
		int freq = 0;
		for(int i=len-1;i>=0;i--){
			char ch = s.charAt(i);
			if(ch == '#'){
				int pos = i;
				String letter = s.substring(pos-2,pos);
				int val = Integer.valueOf(letter);
				if(freq == 0){
					arr[val-1] = 1;
				}else{
					arr[val -1 ] = freq;
					freq = 0;
				}
				s = s.substring(0,pos-2);
				i = pos-2;
			}else if(ch == ')'){
				int pos = i;
				ch = s.charAt(--i);
				while(ch != '('){
					ch = s.charAt(--i);
				}
				String f = s.substring(i+1,pos);
				freq = Integer.valueOf(f);
				s = s.substring(0,i);
			}else{
				int val = Integer.valueOf(String.valueOf(ch));
				if(freq == 0){
				arr[val-1] = 1;
				}else{
					arr[val-1] = freq;	
					freq = 0;
				}
				s = s.substring(0,i);
			}
			if(s.length() == 0){
				break;
			}
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		decipher("1(5)226#(6)24#(8)45");

	}

}
