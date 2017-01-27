package practice.arraysandstrings;

public class OneEdit {

	public int[] getCharacterFrequency(char[] ip) {
		// int a = Character.getNumericValue('a');
		// int z = Character.getNumericValue('z');
		int[] freq = new int[26];
		for (int i = 1; i < freq.length; i++) {
			freq[i] = 0;
		}
		for (char c : ip) {
			int index = Character.getNumericValue(c)
					- Character.getNumericValue('a');
			freq[index]++;
		}
		return freq;
	}

	public void editCount(String str1,String str2) {
		//Check which arrays length is small
		char max[], min[];
		if (str1.toCharArray().length >= str2.toCharArray().length) {
			max = str1.toCharArray();
			min = str2.toCharArray();
		} else {
			max = str2.toCharArray();
			min = str1.toCharArray();
		}

		int[] freq = getCharacterFrequency(max);
		/*
		boolean visited[] = new boolean[freq.length];

		for (int i = 0; i < freq.length; i++) {
			visited[i] = false;
		}
		
		// Frequency of each character
		for (int i = 0; i < max.length; i++) {
			int index = Character.getNumericValue(max[i])
					- Character.getNumericValue('a');
			if (!visited[index]) {
				System.out.println("Before:Frequency of " + max[i] + " = "
						+ freq[index]);
				visited[index] = true;
			}
		}
		
		for (int i = 0; i < freq.length; i++) {
			visited[i] = false;
		}
		*/
		for (int i = 0; i < min.length; i++) {
			int index = Character.getNumericValue(min[i]) - Character.getNumericValue('a');
			if(freq[index]>0)
			{
				freq[index]--;
			}
			
		}
		/*
		for (int i = 0; i < max.length; i++) {
			int index = Character.getNumericValue(max[i])
					- Character.getNumericValue('a');
			if (!visited[index]) {
				System.out.println("After:Frequency of " + max[i] + " = "
						+ freq[index]);
				visited[index] = true;
			}
		}
		*/
		int count=0;
		for(int f: freq){
			if(f!=0){
				count = count + f;
			}
		}
		System.out.println("For strings= "+str1+" , "+str2);
		if(count>1){
			System.out.println("More than one edit required");
		}else{
			System.out.println("One edit possible");
		}
	}

	public static void main(String args[]) {
		OneEdit oe = new OneEdit();
		oe.editCount("pale","bae");
	}
}
