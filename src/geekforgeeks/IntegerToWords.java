package geekforgeeks;

public class IntegerToWords {


	String ones[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	String teens[] = {"","Eleven","Twelve","Thirteen","Forteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	String tens[] = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	String large[] = {"Hundred","Thousand","Lakh"};
	
	public void convert(int num){
		int count = 1;
		String result = "";
		
		if(num == 0){
			System.out.println("Zero");
			return;
		}
		//TODO For -ve numerals
		int rem = num%1000;
		int div = num/1000;
		result = convertLessThanThousand(rem);
		num = num/1000;
		while(num>0){
			rem = num%100;
			div = num/100;
			if(rem!=0){
				result = convertToWord(rem) +" "+large[count] +" "+ result;
			}
			num = num/100;
			count++;
		}
		
		System.out.println(result);
	}
	
	public String convertToWord(int n){
		if(n==0) return "";
		
		String result = "";
		while(n>0){
			int r = n%100;
			if(r>=1 && r<=9){
				result = result+ones[r];
				break;
			}else if (r>=11 && r<=19){
				result = result+teens[r%10];
				break;
			}else if((r>=20 && r<100)|| r == 10){
				result = result+tens[r/10]+" ";
				n = n%10;
			}
		}
		
		return result;
	}
	
	public String convertLessThanThousand(int n){
		if(n == 0) return "";
		
		String result = "";
		int r = n%100;
		int d = n/100;
		if(d>0){
			result = convertToWord(d)+" "+large[0];
		}
		result = result +" "+convertToWord(r);
		return result;
	}
	public static void main(String args[]){
		IntegerToWords iw = new IntegerToWords();
		iw.convert(1);
		iw.convert(9);
		iw.convert(11);
		iw.convert(19);
		iw.convert(20);
		iw.convert(100);
		iw.convert(100000);
		iw.convert(9999999);
		iw.convert(99999);
		
		//System.out.println(iw.convertLessThanThousand(10));
	}
}
