package chapter6_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleApp {

	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number:");
		int triangleInt=getInt();
		System.out.println("Triangle:"+triangle(triangleInt));
		

	}
	public static String getString() throws IOException{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String value=br.readLine();
		return value;
	}
	
	
	public static int getInt() throws IOException{
		String value=getString();
		return Integer.parseInt(value);
	}
	
	public static int triangle(int n){
		System.out.println("Entering: n="+n);
		if(n==1){
			System.out.println("Returning 1");
			return 1;
		}else{
			int temp=n+triangle(n-1);
			System.out.println("Returning "+temp);
			return temp;
		}
	}
}
