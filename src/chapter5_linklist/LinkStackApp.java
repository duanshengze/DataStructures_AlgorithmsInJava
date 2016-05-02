package chapter5_linklist;

import com.sun.org.apache.regexp.internal.recompile;

class Link3{
	public long dData;
	public Link3 next;
	public Link3(long dD){
		dData=dD;
	}
	public void displayLink(){
		System.out.print(" "+dData+" ");
	}
}
class LinkList3{
	private Link3 first;
	
	public LinkList3(){
		first=null;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void inserFirst(long e){
		Link3 newLink=new Link3(e);
		newLink.next=first;
		first=newLink;
	}
	
	public long deleteFirst(){
		Link3 temp=first;
		if(first!=null){
			first=first.next;
			return temp.dData;
		}
		throw new IllegalArgumentException("链表为空，无元素可以删除");
	}
	
	public void displayLinkList(){
		Link3 current=first;
		while(current!=null){
			current.displayLink();
			current=current.next;
		}
		System.out.println("");
	}

}

class Stack{
	private LinkList3 linkList3;
	public Stack(){
		linkList3=new LinkList3();
	}
	
	public void push(long e){
		linkList3.inserFirst(e);
	}
	
	public long pop(){
		return linkList3.deleteFirst();
	}
	public boolean isEmpty(){
		return linkList3.isEmpty();
	}
	
	public void displayStack(){
		System.out.print("Stack(top-->bottom)");
		linkList3.displayLinkList();
	}
	
}


public class LinkStackApp {
	public static void main(String[] args) {
		Stack stack=new Stack();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.displayStack();
		stack.pop();
		stack.pop();
	
		stack.displayStack();
	}
}
