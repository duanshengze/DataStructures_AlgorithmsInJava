package chapter4_statck_and_queue;

class StackX{
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public StackX(int max ){
		maxSize=max;
		stackArray=new long[max];
		top=-1;
	}
	
	public void push(long e){
		stackArray[++top]=e;
	}
	
	public long pop(){
		return stackArray[top--];
	}
	
	public long peek(){
		return stackArray[top];
		
	}
	
	public boolean isEmpty(){
		return top==-1;
		
	}
	public boolean isFull(){
		return top==maxSize-1;
	}
}


public class StackApp {
	public static void main(String[] args) {
		StackX theStack=new StackX(10);
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		while (!theStack.isEmpty()) {
			long value=theStack.pop();
			System.out.print(value+" ");
			
		}
		theStack.pop();
	}
}
