package graphtheory.withoutusinginbuildLinkedList;

public class StackGraph {
 Object stack[] = null;
 int top = -1;
 public StackGraph(int size){
	 this.stack = new Object[size];
 }
 public void push(Object o){
	 if(top<stack.length){
		// top++;
		 stack[++top] = o;
	}else{
		 System.out.println("Stack overflow");
		 return;
	 }
 }
 
 public Object pop(){
	 if(!isStackEmpty()){
		 return stack[top--];
	 }else{
		 return null;
	 }
 }
 
 public Object top(){
	 return stack[top];
 }
 
 public boolean isStackEmpty(){
	 if(top==-1){
		 return true;
	 }
	 return false;
 }
 
	public static void main(String[] args) {
		StackGraph sg = new StackGraph(5);
		
		for(int i=0;i<5;i++){
			sg.push(i);
		}
		System.out.println("Is stack empty = "+sg.isStackEmpty());
		System.out.println("Stack top = "+(int)sg.top());
		for(int i=0;i<7;i++){
			Integer iPop = (Integer)sg.pop();
			if(iPop!=null){
				System.out.println("Popped = "+iPop);
			}else{
				System.out.println("Stack is empty");
			}
		}
	}

}
