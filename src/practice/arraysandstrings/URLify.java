package practice.arraysandstrings;

public class URLify {

	public void urlify(String str){
		char ip[] = str.toCharArray();
		int ipLen = ip.length;
		int spCount = 0;
		for(char c: ip){
			if(c==' '){
				spCount++;
			}
		}
		
		if(spCount == 0){
			System.out.println("No space found in input String");
			return;
		}
		
		char replace[] = {'%','2','0'};
		char op[] = new char[(replace.length*spCount)+ipLen -1];
		int k=0;
		for(char ch: ip){
			if(ch == ' '){
				int c = 0;
				while(c<replace.length){
					op[k] = replace[c];
					c++;
					k++;
				}
			}else{
				op[k] = ch;
				k++;
			}
		}
		
		System.out.println("After URLified = "+new String(op));
	}
	
	public static void main(String args[]){
		URLify u = new URLify();
		u.urlify("Mr John Smith");
	}
}
