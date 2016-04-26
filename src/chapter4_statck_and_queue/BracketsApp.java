package chapter4_statck_and_queue;

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
			System.out.println("杈撳叆鍖呭惈鍖归厤绗︾殑瀛楃涓诧細");
//			System.out.flush();
			input=getString();
			if(input.equals("")) break;
			BracketChecker bc=new BracketChecker(input);
			bc.check();
			
		}
		
		
		
	}
	

}
class StackC2{
	private char[]stackArray;
	private int maxSize;
	private int top;
	 public StackC2(int max){
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
		StackC2 stack=new StackC2(stackSize);
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
					//闃叉 {[( )]}}杩欐牱鐨勫彂鐢�
				}else {
						System.out.println("鍙宠竟鎷彿杩樻湁棰勭暀Error: "+ch+" at "+i);
				}
				
				break;
			}// end switch
					
		}//for end
		if(!stack.isEmpty()){
			System.out.println("宸﹁竟鎷彿杩樻湁浣欑暀Error: ");
		}else {
			System.out.println("鍖归厤鎴愬姛锛�");
		}
	
	}
	
	
}




