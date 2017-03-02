package geekforgeeks;

public class InfixToPrefix {

	public static void infixToPrefix(String exp){
		StringBuilder sb = new StringBuilder(exp);
		sb.reverse();
		System.out.println("sb after reverse = "+sb);
		for(int i=0;i<sb.length();i++){
			if(sb.charAt(i) == '('){
				sb.replace(i, i+1, ")");
			}else if(sb.charAt(i) == ')'){
				sb.replace(i, i+1, "(");
			}
		}
		System.out.println(sb);
		String invertedPreFix = InfixToPostFix.infixToPostfix(sb.toString());
		System.out.println("After= "+new StringBuilder(invertedPreFix).reverse());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		infixToPrefix("a+b");
	}

}
