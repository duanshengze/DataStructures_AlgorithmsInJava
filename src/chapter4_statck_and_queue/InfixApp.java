package chapter4_statck_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sun.net.www.content.text.plain;


class Stack{
	
	private int maxSize;
	private char[]stackArray;
	private int top;
	
	public Stack(int max) {
		this.maxSize=max;
		stackArray=new char[maxSize];
		top=-1;
	}
	public void push(char e){
		stackArray[++top]=e;
	}
	
	public char pop(){
		return stackArray[top--];
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	public boolean isFull(){
		return top==maxSize-1;
	}
	public char peekN(int n){
		return stackArray[n];
	}
	public int size(){
		return top+1;
	}
	
	
	public void displayStack(String s){
		System.out.print(s);
		System.out.print("Stack ( bottom-->top ): ");
		for(int i=0;i<size();i++){
			
			System.out.print(peekN(i)+" ");
		
			
		}
		System.out.println("");
		
	}
}



class InToPost{
	
	private Stack theStack;
	private String input;
	private String output="";
	
	public InToPost(String in){
		input=in;
		int stackSize=input.length();
		theStack=new Stack(stackSize);
	}
	
	
	public String doTrans(){
		for(int i=0;i<input.length();i++){
			char ch=input.charAt(i);
			theStack.displayStack("For "+ch+" ");
			switch (ch) {
			case '+':
			case '-':
				getOper(ch, 1);
				
				break;
			case '*':
			case '/':
				getOper(ch, 2);
				break;
			case '(':
				theStack.push(ch);
				break;
			case ')':
				getParen();
				break;
			default:
				output=output+ch;
				break;
			}//end switch
		
		}//end for
		
		while(!theStack.isEmpty()){
			
			theStack.displayStack("while ");
			output=output+theStack.pop();
		}
		theStack.displayStack("END");
		
		
		
		return output;
		
	}
	
	public void getOper(char opThis,int prec1){
		
		while(!theStack.isEmpty()){
			char opTop=theStack.pop();
			if(opTop=='('){
				theStack.push(opTop);
				break;
			}
			int prec2;
			if(opTop=='-'||opTop=='+'){
				prec2=1;	
			}else {
				prec2=2;
			}
			if(prec1>prec2){
				theStack.push(opTop);
				break;
			}else {
				output=output+opTop;
			}
			
			
		}//end while
		theStack.push(opThis);

	}
	
	public void getParen(){
		while(!theStack.isEmpty()){
			char ch=theStack.pop();
			if(ch=='('){
				break;
			}else {
				output=output+ch;
			}
		}
	}
	
	
	
	
}
public class InfixApp {
		
		public static void main(String[] args) throws IOException {
			String input;
			String output;
			while(true){
				System.out.print("Enter infix: ");
				input=getString();
				if(input.equals("")){
					break;
				}
				InToPost itp=new InToPost(input);
				output=	itp.doTrans();	
				System.out.println("Postfix is :  "+output);
				
			}
		}
		public static String getString() throws IOException{
			 
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			String s=br.readLine();
			return s;
			
		}
		
}
