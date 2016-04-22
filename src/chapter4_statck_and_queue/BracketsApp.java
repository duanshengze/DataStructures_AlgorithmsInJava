package chapter4_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BracketsApp {
	
	public static String getString() throws IOException{
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		return s;
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		String input;
		while(true){
			System.out.println("输入包含匹配符的字符串：");
//			System.out.flush();
			input=getString();
			if(input.equals("")) break;
			BracketChecker bc=new BracketChecker(input);
			bc.check();
			
		}
		
		
		
	}
	

}
class StackX{
	private char[]stackArray;
	private int maxSize;
	private int top;
	 public StackX(int max){
		 stackArray=new char[max];
		 maxSize=max;
		 top=-1;
	 }
	 
	 public char pop(){
		 return stackArray[top--];
	 }
	 public void push(char e){
		 stackArray[++top]=e;
	 }
	 public char peek(){
		 return stackArray[top];
	 }
	 public boolean isFull(){
		 return top==maxSize-1;
	 }
	 public boolean isEmpty(){
		 return top==-1;
	 }
}

class BracketChecker{
	private String input;
	public BracketChecker(String input){
		this.input=input;
	}
	  
	public void check(){
		int stackSize=input.length();
		StackX stack=new StackX(stackSize);
		for(int i=0;i<stackSize;i++){
			char ch=input.charAt(i);
			
			switch (ch) {
			case '{':
			case'[':
			case '(':
				stack.push(ch);
				break;

			case '}':
			case ']':
			case ')':
				
				if(!stack.isEmpty()){
					
					char chax=stack.pop();
					if(chax=='{'&&ch!='}'||chax=='['&&ch!=']'||chax=='('&&ch!=')'){
						
						
						System.out.println("Error: "+ch+" at "+i);
					}
					//防止 {[( )]}}这样的发生
				}else {
						System.out.println("右边括号还有预留Error: "+ch+" at "+i);
				}
				
				break;
			}// end switch
					
		}//for end
		if(!stack.isEmpty()){
			System.out.println("左边括号还有余留Error: ");
		}else {
			System.out.println("匹配成功！");
		}
	
	}
	
	
}




