package chapter4_statck_and_queue;

import java.util.Scanner;

public class ReverseApp {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Reverser r=new Reverser(s.next());
		System.out.println(r.doDev());
		
	}
}
class StackC{
	
	private char[]stackArray;
	private int maxSize;
	private int top;
	
	StackC(int max){
		maxSize=max;
		top=-1;
		stackArray=new char[maxSize];
	}
	
	public char pop(){
		return stackArray[top--];
	}
	public char peek(){
		return stackArray[top];
	}
	public void push(char e){
		stackArray[++top]=e;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	public boolean isFull(){
		return top==maxSize-1;
	}
}


class Reverser{
	
	private String input;
	private String ouput;
	
	public Reverser(String input) {
		this.input=input;
	}
	
	public String doDev(){
		StackC stack=new StackC(input.length());
		for(int i=0;i<input.length();i++){
			
			stack.push(input.charAt(i));
		}
		ouput="";
		while(!stack.isEmpty()){
			ouput+=stack.pop();
		}
		return ouput;
		
	}
	
	
	
}

