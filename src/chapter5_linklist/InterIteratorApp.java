package chapter5_linklist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.management.RuntimeErrorException;

class Link10{
	public long data;
	public Link10 next;
	public Link10(long dD){
		data=dD;
		next=null;
	}
	public void displayLink(){
		System.out.print(" "+data+" ");
	}
}


class LinkList10{
	private Link10 first;
	
	public void setFirst(Link10 link){
		first=link;
	}
	
	public Link10 getFirst(){
		return first;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void displayLinkList(){
		Link10 current=first;
		System.out.print("first-->last");
		while(current!=null){
			current.displayLink();
			current=current.next;
		}
		System.out.println();
	}
	public ListIterator getIterator(){
		return new ListIterator(this);
	}
	
}
class ListIterator{
	private LinkList10 mlinkList;
	private Link10 previous;
	private Link10 current;
	public ListIterator(LinkList10 linkList) {
		mlinkList=linkList;
		reset();
	}
	
	public void reset(){
		previous=null;
		current=mlinkList.getFirst();
	}
	//假设链表非空
	public void nextLink(){
		previous=current;
		current=current.next;
	}
	public Link10 getCurrent(){
		if(mlinkList.isEmpty())return null;
		return current;
	}
	//插入当前current后面
	public void insertAfter(long dd){
		Link10 newLink10=new Link10(dd);
		if(mlinkList.isEmpty()){
			mlinkList.setFirst(newLink10);
			reset();
		}else{
			newLink10.next=current.next;
			current.next=newLink10;
			nextLink();
		}
	}
	
	public  void insertBefore(long dd){
		Link10 newLink10=new Link10(dd);
		if(previous==null){
			newLink10.next=mlinkList.getFirst();
			mlinkList.setFirst(newLink10);
			reset();
		}else {
			newLink10.next=current;
			previous.next=newLink10;
			current=newLink10;
		}
	}
	public boolean atEnd(){
		return current.next==null;
	}
	public long deleteCurrent(){
		if(mlinkList.isEmpty()) throw new RuntimeException("链表为空，无法删除");
		long result=current.data;
		if(previous==null){
			mlinkList.setFirst(current.next);
			reset();
		}else {
			previous.next=current.next;
			if(atEnd()){
				reset();
			}else {
			 current=current.next;
			}
	
		}
		return result;
		
	}
	
	
}
public class InterIteratorApp {
	public static void main(String[] args) throws IOException {
		LinkList10 theLinkList=new LinkList10();
		ListIterator iter=theLinkList.getIterator();
//		iter.insertAfter(10);
//		iter.insertAfter(20);
//		iter.insertAfter(30);
//		iter.insertBefore(100);
//		
//		theLinkList.displayLinkList();
//		iter.deleteCurrent();
//		iter.insertAfter(40);
//		theLinkList.displayLinkList();
		long value ;
		while(true){
			System.out.print("Enter first letter of show ,reset,");
			System.out.print("next, get, before,after,delete:");
			int choice=getChar();
			switch (choice) {
			case 's':
				if(!theLinkList.isEmpty()){
					theLinkList.displayLinkList();
				}else{
					System.out.println("List is Empty");
				}
				break;
			case 'r':
				iter.reset();
		
				break;
			case 'n':
				if(!theLinkList.isEmpty()&&!iter.atEnd()){
					iter.nextLink();
				}else{
					System.out.println("Cannot go to next link");
				}
				break;
			case 'g':
				if(!theLinkList.isEmpty()){
					value=iter.getCurrent().data;
					System.out.println("Returned "+value);
				}else {
					System.out.println("List is empty");
				}
				break;
			case 'b':
				System.out.print("Enter value to insert: ");
				value=getInt();
				iter.insertBefore(value);
				
				break;
			case 'a':
				System.out.print("Enter value to insert: ");
				value=getInt();
				iter.insertAfter(value);
				break;
			case 'd':
				if(!theLinkList.isEmpty()){
					value=iter.deleteCurrent();
					System.out.println("Deleted "+value);
				}else{
					System.out.println(" Cannot delete");
				}
				break;
			default:
				System.out.println("Invalid entery");
				break;
			}
			
		}
		
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException{
		String s=getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException{
		String s=getString();
		return Integer.parseInt(s);
	}
	
	

}
