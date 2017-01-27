package stack;

public class StackTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOperation<String> op = new StackOperation<String>();
		op.push("A");
		op.push("B");
		System.out.println("Is Stack Empty="+op.isStackEmpty());
		System.out.println("Top Value = "+op.top().getElement());
		op.pop();
		System.out.println("Top Value = "+op.top().getElement());
		op.pop();
		op.pop();
		op.pop();
		System.out.println("Is Stack Empty="+op.isStackEmpty());
	}

}
