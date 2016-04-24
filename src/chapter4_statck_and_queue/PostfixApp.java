package chapter4_statck_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackInt{
	private int[]stackArray;
	private int maxSize;
	private int top;
	public StackInt(int max){
		maxSize=max;
		stackArray=new int[maxSize];
		top=-1;
	}
	
	public int pop(){
		return stackArray[top--];
	}
	
	public void push(int e){
		stackArray[++top]=e;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	public boolean isFull(){
		return top==maxSize-1;
	}
	
}

class ParsePost{
	
	private StackInt mStackInt;
	private String input;
	 public ParsePost(String in) {
		input=in;
		mStackInt=new StackInt(input.length());
	}
	 
	 public int doParse(){
	
		for(int i=0;i<input.length();i++){
			char ch=input.charAt(i);
			if(ch>='0'&&ch<='9'){
				mStackInt.push((int)(ch-'0'));
			}else{
				int interAns;
				//容易出错！ 减数和被减数，除数和被除数
				int num2=mStackInt.pop();
				int num1=mStackInt.pop();
				switch (ch) {
					case '+':
						interAns=num1+num2;
					break;
					
					case '-':
						interAns=num1-num2;
						break;
					case '/':
						interAns=num1/num2;
						break;
					case '*':
						interAns=num1*num2;
						break;
					
				default:
					interAns=0;
					break;
				}// end switch
				mStackInt.push(interAns);	
			}//end else
			
			
		}//for
		return mStackInt.pop();
 
	 }
	
	
}
public class PostfixApp {
	public static void main(String[] args) throws IOException {
		
		while(true){
			String input=reasString();
			if(input.equals("")) break;
			InToPost itp=new InToPost(input);
			String s=itp.doTrans();
			System.out.println(s);
			ParsePost pp=new ParsePost(s);
			
			System.out.println("运算结果为："+pp.doParse());
			
		}
		
	}
	public static String reasString() throws IOException{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		return br.readLine();

	}
}
