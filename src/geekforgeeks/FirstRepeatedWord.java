package geekforgeeks;

public class FirstRepeatedWord {

	public static void firstNonRepeat(String s){
		String str[] = s.split("\\s|\\t|,|:|\\;|-|\\.",-1);
		boolean visited[] = new boolean[str.length];
		for(int i=0;i<visited.length;i++){
			visited[i]=false;
		}
		for(int i=0;i<str.length;i++){
			for(int j=i+1;j<str.length;j++){
				if(str[i].equals(str[j])){
					visited[i] = true;
					break;
				}
			}
		}
		for(boolean b: visited){
			//System.out.print(b+" ");
		}
		System.out.println();
		for(int i=0;i<visited.length;i++){
			if(visited[i]){
				System.out.println(str[i]);
				break;
			}
		}
	}
	
	public static void main(String args[]){
		firstNonRepeat("He had.had quite enough of this onsene. He");
		firstNonRepeat("and.:and.and");
	}
}
