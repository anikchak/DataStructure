package practice.bitmanipulation;

public class DecimalFractionToBinary {

	public static void main(String[] args) {
	double n = 0.625,dup = n;
	if(n>1 || n<0){
		System.out.println("Error");
		return;
	}
	StringBuilder binary = new StringBuilder();
	binary.append(".");
	while(dup>0){
		if(binary.length()>32){
			System.out.println("Generated Seq = "+binary.toString());
			System.out.println("ERROR");
			break;
		}
		double val = 2*dup;
		if(val>0){
			binary.append((int)val);
			dup = val - (int)val;
			System.out.println("If:dup="+dup);
		}else{
			binary.append((int)val);
			dup = val;
			System.out.println("Else:dup="+dup);
		}
		System.out.println("Generated Binary = "+binary.toString());
	}
	
	}

}
