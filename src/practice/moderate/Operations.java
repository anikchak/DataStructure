package practice.moderate;

public class Operations  {

	/*
	 * Calculating negate(a) - of a number
	 * Method 1: having O(n) complexity
	 */
	public int negate(int a){
		int newSign = (a<0)?1:-1;
		int newNo = 0;
		while(a!=0){
			newNo = newNo + newSign;
			a = a+newSign;
		}
		return newNo;
	}
	/*
	 * End of method 1
	 */
	/*
	 * Method 2: having O(log n) complexity
	 */
	public int negateOpti(int a){
		int newSign = (a<0)?1:-1;
		int newNo = 0, delta = newSign;
		while(a!=0){
			boolean hasDiffSign = ((a+delta)>0) != (a>0);
			if((a+delta)!= 0 && hasDiffSign){
				delta = newSign;
			}
			newNo = newNo+delta;
			a = a+delta;
			delta = delta+delta;
		}
		return newNo;
	}
	/*
	 * End of method 2
	 */
	
	public int substract(int a, int b){
		return (a+negateOpti(b));
	}
	
	public int multiplication(int a, int b){
		if(a == 0 || b == 0){
			return 0;
		}
		int min = 0, max =0;
		if(abs(a)<abs(b)){
			min = abs(a);
			max = abs(b);
		}else{
			min = abs(b);
			max = abs(a);
		}
		
		int result =0;
		while(min>0){
			result = result+max;
			min--;
		}
		if((a>0 && b<0) || (a<0 && b>0)){
			result = negateOpti(result);
		}
		
		return result;
	}
	
	public int division(int a, int b){
		int result = 0;
		if(b==0){
			throw new ArithmeticException("Divide By Zero");
		}
		int val=0;
		int absA = abs(a);
		int absB = abs(b);
		while(val+absB <= absA){
			result++;
			val = val+absB;
		}
		if((a>0 && b<0) || (a<0 && b>0)){
			result = negateOpti(result);
		}
		return result;
	}
	public int abs(int a){
		if(a>0) return a;
		else return negateOpti(a);
	}
	public static void main(String[] args) {
		Operations op = new Operations();
		System.out.println("negate = "+op.negate(5));
		System.out.println("nagate opti = "+op.negateOpti(10));
		System.out.println("Substract = "+op.substract(-10, -9));
		System.out.println("Multiply = "+op.multiplication(-19, -21));
		System.out.println("Divide = "+op.division(-10, 10));
	}

}
